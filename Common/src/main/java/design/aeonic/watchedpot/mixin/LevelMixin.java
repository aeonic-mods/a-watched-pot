package design.aeonic.watchedpot.mixin;

import design.aeonic.watchedpot.lib.BlockWatcher;
import design.aeonic.watchedpot.lib.WatchedBlockGetter;
import design.aeonic.watchedpot.lib.WatchedTickingBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
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

    @Nullable List<BlockPos> watchedpot$watchedBlocks = null;

    @Shadow @Final @Mutable protected List<TickingBlockEntity> blockEntityTickers;
    @Shadow private boolean tickingBlockEntities;
    @Shadow @Final private List<TickingBlockEntity> pendingBlockEntityTickers;

    @Override
    public List<BlockPos> watchedpot$getWatchedBlocks() {
        return watchedpot$watchedBlocks == null ? new ArrayList<>() : watchedpot$watchedBlocks;
    }

    @SuppressWarnings("ConstantValue") // this is mixin land
    @Inject(method = "addBlockEntityTicker", at = @At("HEAD"), cancellable = true)
    public void watchedpot$injectAddBlockEntityTicker(TickingBlockEntity tickingBlockEntity, CallbackInfo ci) {
        if (!(((Object) this) instanceof ServerLevel level)) return;
        (tickingBlockEntities ? pendingBlockEntityTickers : blockEntityTickers).add(new WatchedTickingBlockEntity(level, tickingBlockEntity));
        if (ci.isCancellable()) ci.cancel();
    }

    @Inject(method = "tickBlockEntities", at = @At("HEAD"))
    public void watchedpot$injectTickBlockEntitiesHead(CallbackInfo ci) {
        watchedpot$watchedBlocks = players().stream().filter(player -> player instanceof BlockWatcher).map(player -> ((BlockWatcher) player).watchedpot$getWatchedPos()).toList();
    }

}
