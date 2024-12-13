package design.aeonic.watchedpot.platform;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.Level;

public interface Config {

    boolean getUseWhitelist(ServerLevel level);

    boolean getInvertBehavior(ServerLevel level);

}
