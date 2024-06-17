package design.aeonic.watchedpot;

import design.aeonic.watchedpot.platform.Config;
import net.minecraft.resources.ResourceLocation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ServiceLoader;
import java.util.function.Consumer;

public class WatchedPot {

    public static final String MOD_ID = "watchedpot";
    public static final ResourceLocation MOD_RL = ResourceLocation.fromNamespaceAndPath(MOD_ID, MOD_ID);
    public static final Logger LOGGER = LogManager.getLogger();

    public static final Config CONFIG = loadService(Config.class);

    public static void init() {

    }

    public static void clientInit(Consumer<Runnable> taskQueue) {

    }

    private static <T> T loadService(Class<T> clazz) {
        final T loadedService = ServiceLoader.load(clazz)
                .findFirst()
                .orElseThrow(() -> new NullPointerException("Failed to load service for " + clazz.getName()));
        LOGGER.debug("Loaded {} for service {}", loadedService, clazz);
        return loadedService;
    }

}
