package design.aeonic.watchedpot;

import design.aeonic.watchedpot.platform.ForgeConfig;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(WatchedPot.MOD_ID)
@Mod.EventBusSubscriber(modid = WatchedPot.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ForgeWatchedPot {

    public ForgeWatchedPot(FMLJavaModLoadingContext context) {
        WatchedPot.init();
        context.registerConfig(ModConfig.Type.SERVER, ForgeConfig.SERVER_SPEC);
    }

}
