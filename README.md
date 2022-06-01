![A Watched Pot Logo](https://raw.githubusercontent.com/aeonic-mods/a-watched-pot/assets/img/logo.png)

A watched pot never boils. A watched furnace never... ticks?

**A Watched Pot** is a fully configurable mod for both Forge and Fabric/Quilt that either stops blocks from ticking when they're looked at or restricts them to only tick when they *are* looked at, based on a block tag. 

Requires [Fabric API](https://www.curseforge.com/minecraft/mc-mods/fabric-api) on Fabric/Quilt.

Get the mod:
* [On Curseforge](https://www.curseforge.com/minecraft/mc-mods/a-watched-pot)
* [On Modrinth](https://modrinth.com/mod/watched-pot)

## Usage

**On Forge**, A Watched Pot can be configured through Forge's normal server configuration systems. There are currently two configuration options:
* The mod can use either a whitelist or a blacklist, which can be toggled via the `use_whitelist` option. If the option is enabled, only blocks in the `watchedpot:whitelist` block tag will be affected. If it's disabled (which it is by default), all blocks will be affected *except those in the `watchedpot:blacklist` tag*.
* The mod's behavior can be inverted via the `invert_behavior` option. If enabled, only blocks that are looked at will tick (of those affected); if disabled, all blocks will tick *unless* they are looked at.

By default, both options are set to false - that is, no block will tick while a player is looking at it. 

To recap:
* `use_whitelist=true, invert_behavior=false` - blocks in the whitelist tag will not tick if they are looked at; all other blocks remain unchanged.
* `use_whitelist=false, invert_behavior=false` - all blocks will not tick if they are looked at, unless they are in the blacklist tag (in which case they remain unchanged).
* `use_whitelist=true, invert_behavior=true` - blocks in the whitelist tag will only tick if they are looked at; all other blocks remain unchanged.
* `use_whitelist=false, invert_behavior=true` - all blocks will only tick if they are looked at, unless they are in the blacklist tag (in which case, again, they remain unchanged).

**On Fabric**, the same options can be set via gamerules (`watchedpot_useWhitelist` and `watchedpot_invertBehavior`) to avoid an extra config dependency. This is unfortunately not quite as robust but it keeps the mod lightweight on both platforms. If you need to set default values (such as for a modpack) you can emulate that behavior with KubeJS and its [GameRulesJS](https://kubejs.com/wiki/kubejs/GameRulesJS/), setting the values you need whenever necessary.