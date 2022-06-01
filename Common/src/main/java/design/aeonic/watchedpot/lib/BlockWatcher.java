package design.aeonic.watchedpot.lib;

import net.minecraft.core.BlockPos;

import javax.annotation.Nullable;

public interface BlockWatcher {

    @Nullable
    BlockPos getWatchedPos();

}
