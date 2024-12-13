package design.aeonic.watchedpot.lib;

import design.aeonic.watchedpot.WatchedPot;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.TickingBlockEntity;

public record WatchedTickingBlockEntity(ServerLevel level, TickingBlockEntity ticker) implements TickingBlockEntity {

    @Override
    public void tick() {
        if (shouldTick()) ticker.tick();
    }

    public boolean shouldTick() {
        boolean affected = WatchedPot.CONFIG.getUseWhitelist(level) ?
                level.getBlockState(getPos()).is(WatchedPotTags.Blocks.WHITELIST) :
                !level.getBlockState(getPos()).is(WatchedPotTags.Blocks.BLACKLIST);
        if (!affected) return true;

        boolean invert = WatchedPot.CONFIG.getInvertBehavior(level);
        return (!invert ^ ((WatchedBlockGetter) level).isWatched(getPos()));
    }

    @Override
    public boolean isRemoved() {
        return ticker.isRemoved();
    }

    @Override
    public BlockPos getPos() {
        return ticker.getPos();
    }

    @Override
    public String getType() {
        return ticker.getType();
    }

}
