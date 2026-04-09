package com.orca.momentumcombat.mixin;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.math.Vec3d;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(PlayerEntity.class)
public abstract class PlayerAttackMixin {

    @Unique
    private float lastDamageMultiplier = 1.0f;

    @ModifyVariable(
        method = "attack",
        at = @At("HEAD"),
        argsOnly = true
    )
    private Entity modifyAttackTarget(Entity target) {
        PlayerEntity player = (PlayerEntity) (Object) this;

        // Calculate movement speed
        Vec3d velocity = player.getVelocity();
        double horizontalSpeed = Math.sqrt(velocity.x * velocity.x + velocity.z * velocity.z);
        double verticalSpeed = velocity.y;

        // Determine multiplier based on movement state
        float multiplier = 1.0f;
        String multiplierSource = "";

        // Priority: Falling attack > Jumping attack > Sprint > Standing still
        if (verticalSpeed < -0.5) {
            // Falling attack - 3x damage
            multiplier = 3.0f;
            multiplierSource = "FALLING";
        } else if (verticalSpeed > 0.1 && !player.isOnGround()) {
            // Jumping attack - 1.5x damage
            multiplier = 1.5f;
            multiplierSource = "JUMPING";
        } else if (player.isSprinting() && horizontalSpeed > 0.1) {
            // Sprint hit - 1.3x damage
            multiplier = 1.3f;
            multiplierSource = "SPRINT";
        } else if (horizontalSpeed < 0.01 && player.isOnGround()) {
            // Standing still - 0.5x damage
            multiplier = 0.5f;
            multiplierSource = "STILL";
        } else {
            // Normal movement
            multiplier = 1.0f;
            multiplierSource = "NORMAL";
        }

        lastDamageMultiplier = multiplier;

        // Show damage multiplier on action bar
        String displayText = String.format("Damage: %.1fx (%s)", multiplier, multiplierSource);
        player.sendMessage(Text.literal(displayText), true);

        return target;
    }

    @ModifyVariable(
        method = "attack",
        at = @At(value = "STORE"),
        ordinal = 0
    )
    private float modifyBaseDamage(float damage) {
        return damage * lastDamageMultiplier;
    }
}
