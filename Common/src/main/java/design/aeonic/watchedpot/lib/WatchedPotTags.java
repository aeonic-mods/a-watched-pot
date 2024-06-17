package design.aeonic.watchedpot.lib;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

import static design.aeonic.watchedpot.WatchedPot.MOD_RL;

public final class WatchedPotTags {

    public static final class Blocks {

        public static final TagKey<Block> WHITELIST = TagKey.create(BuiltInRegistries.BLOCK.key(), MOD_RL.withPath("whitelist"));
        public static final TagKey<Block> BLACKLIST = TagKey.create(BuiltInRegistries.BLOCK.key(), MOD_RL.withPath("blacklist"));

    }

}
