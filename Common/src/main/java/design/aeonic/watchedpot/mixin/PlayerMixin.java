package design.aeonic.watchedpot.mixin;

import design.aeonic.watchedpot.lib.BlockWatcher;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import javax.annotation.Nullable;

@Mixin(Player.class)
public abstract class PlayerMixin extends Entity implements BlockWatcher {

    @Nullable
    private BlockPos watchedpot$watchedPos = null;

    public PlayerMixin(EntityType<?> type, Level level) {
        super(type, level);
    }

    @Override
    @Nullable
    public BlockPos watchedpot$getWatchedPos() {
        return watchedpot$watchedPos;
    }

    @Inject(method = "tick", at = @At("TAIL"))
    public void watchedpot$injectTick(CallbackInfo ci) {
        HitResult res = pick(16, 0, false);
        if (res instanceof BlockHitResult blockHitResult) {
            watchedpot$watchedPos = blockHitResult.getBlockPos();
        } else {
            watchedpot$watchedPos = null;
        }
    }

}
