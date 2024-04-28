package design.aeonic.watchedpot;

import design.aeonic.watchedpot.platform.NeoForgeConfig;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.ModLoadingContext;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.javafmlmod.FMLModContainer;

@Mod(WatchedPot.MOD_ID)
public class NeoForgeWatchedPot {

    public NeoForgeWatchedPot(IEventBus modBus, FMLModContainer ctn) {
        WatchedPot.init();
        modBus.addListener((FMLClientSetupEvent event) -> WatchedPot.clientInit(event::enqueueWork));
        ctn.addConfig(new ModConfig(ModConfig.Type.SERVER, NeoForgeConfig.SERVER_SPEC, ctn));
    }

}
