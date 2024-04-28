package design.aeonic.watchedpot.lib;

import design.aeonic.watchedpot.WatchedPot;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

public final class WatchedPotTags {

    public static final class Blocks {

        public static final TagKey<Block> WHITELIST = TagKey.create(BuiltInRegistries.BLOCK.key(), new ResourceLocation(WatchedPot.MOD_ID, "whitelist"));
        public static final TagKey<Block> BLACKLIST = TagKey.create(BuiltInRegistries.BLOCK.key(), new ResourceLocation(WatchedPot.MOD_ID, "blacklist"));

    }

}
