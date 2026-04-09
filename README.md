# Momentum Combat v2

A Minecraft Fabric mod that makes combat dynamic by scaling damage based on your movement. Stop standing still in fights - your mobility matters!

## Features

This mod modifies player attack damage based on movement state:

| Movement State | Damage Multiplier |
|----------------|-------------------|
| Standing Still | 0.5x |
| Normal Movement | 1.0x |
| Sprinting | 1.3x |
| Jumping | 1.5x |
| Falling | 3.0x |

### Actionbar Display

The mod shows your current damage multiplier on the actionbar whenever you attack, so you always know how much bonus (or penalty) you're getting.

## Mechanics

### Standing Still (0.5x)
If you attack while standing completely still on the ground, you deal reduced damage. Keep moving in combat!

### Normal Movement (1.0x)
Regular walking speed gives you standard damage.

### Sprint Attack (1.3x)
Sprint into combat for a 30% damage bonus. Great for initiating fights.

### Jump Attack (1.5x)
Jump and strike for critical hit-style damage. Time your jumps for maximum effectiveness.

### Falling Attack (3x)
The ultimate attack - fall from height and strike for massive damage! Perfect for ambushes from above or finishing off enemies with a devastating plunge attack.

## Requirements

- Minecraft 1.21.1
- Fabric Loader 0.16.0 or later
- Fabric API

## Installation

1. Install [Fabric Loader](https://fabricmc.net/use/installer/) for Minecraft 1.21.1
2. Download and install [Fabric API](https://modrinth.com/mod/fabric-api)
3. Download `momentum-combat-v2-1.0.0.jar` from the releases
4. Place the JAR file in your `.minecraft/mods` folder
5. Launch Minecraft with the Fabric profile

## Building from Source

```bash
git clone https://github.com/Simplifine-gamedev/momentum-combat-v2.git
cd momentum-combat-v2
./gradlew build
```

The built JAR will be in `build/libs/`.

## Combat Tips

- **Don't stand still** - Always keep moving during combat to avoid the damage penalty
- **Use the terrain** - Find high ground and drop down on enemies for 3x damage
- **Sprint in** - Start fights with a sprint attack for the initial damage boost
- **Jump combos** - Mix jump attacks into your combat rotation for consistent 1.5x hits
- **Chain mobility** - Sprint, jump, and even fall to maximize your damage output

## License

MIT License

## Author

ali77sina
