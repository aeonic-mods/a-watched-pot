package design.aeonic.watchedpot;

import design.aeonic.watchedpot.platform.ForgeConfig;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(WatchedPot.MOD_ID)
@Mod.EventBusSubscriber(modid = WatchedPot.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ForgeWatchedPot {

    public ForgeWatchedPot() {
        WatchedPot.init();
        FMLJavaModLoadingContext.get().getModEventBus().addListener((FMLClientSetupEvent event) -> WatchedPot.clientInit(event::enqueueWork));
        ModLoadingContext.get().registerConfig(ModConfig.Type.SERVER, ForgeConfig.SERVER_SPEC);
    }

}
