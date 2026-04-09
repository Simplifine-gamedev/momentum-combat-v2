package com.orca.momentumcombat;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MomentumCombatMod implements ModInitializer {
    public static final String MOD_ID = "momentum-combat-v2";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        LOGGER.info("Momentum Combat v2 initialized! Damage now scales with movement speed.");
    }
}
