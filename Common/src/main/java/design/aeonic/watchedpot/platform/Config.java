package design.aeonic.watchedpot.platform;

import net.minecraft.world.level.Level;

public interface Config {

    boolean getUseWhitelist(Level level);

    boolean getInvertBehavior(Level level);

}
