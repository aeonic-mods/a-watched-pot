package design.aeonic.watchedpot.mixin;

import design.aeonic.watchedpot.lib.BlockWatcher;
import design.aeonic.watchedpot.lib.WatchedBlockGetter;
import design.aeonic.watchedpot.lib.WatchedTickingBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.util.profiling.ProfilerFiller;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.entity.TickingBlockEntity;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

@Mixin(Level.class)
public abstract class LevelMixin implements LevelAccessor, WatchedBlockGetter {

    @Nullable List<BlockPos> watchedBlocks = null;

    @Shadow @Final @Mutable protected List<TickingBlockEntity> blockEntityTickers;
    @Shadow public abstract ProfilerFiller getProfiler();
    @Shadow private boolean tickingBlockEntities;
    @Shadow @Final private List<TickingBlockEntity> pendingBlockEntityTickers;

    @Override
    public List<BlockPos> getWatchedBlocks() {
        return watchedBlocks == null ? new ArrayList<>() : watchedBlocks;
    }

    @Inject(method = "addBlockEntityTicker", at = @At("HEAD"), cancellable = true)
    public void injectAddBlockEntityTicker(TickingBlockEntity tickingBlockEntity, CallbackInfo ci) {
        (tickingBlockEntities ? pendingBlockEntityTickers : blockEntityTickers).add(new WatchedTickingBlockEntity((Level) ((Object) this), tickingBlockEntity));
        if (ci.isCancellable()) ci.cancel();
    }

    @Inject(method = "tickBlockEntities", at = @At("HEAD"))
    public void injectTickBlockEntitiesHead(CallbackInfo ci) {
        watchedBlocks = players().stream().filter(player -> player instanceof BlockWatcher).map(player -> ((BlockWatcher) player).getWatchedPos()).toList();
    }

}
