package design.aeonic.watchedpot.lib;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;

import java.util.List;

public interface WatchedBlockGetter {

    List<BlockPos> getWatchedBlocks();

    default boolean isWatched(BlockPos pos) {
        return getWatchedBlocks().contains(pos);
    }

}
