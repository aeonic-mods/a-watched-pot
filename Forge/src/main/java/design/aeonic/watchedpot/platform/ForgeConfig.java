package design.aeonic.watchedpot.platform;

import net.minecraft.world.level.Level;
import net.minecraftforge.common.ForgeConfigSpec;

public class ForgeConfig implements Config {

    public static final ForgeConfigSpec SERVER_SPEC;

    public static ForgeConfigSpec.BooleanValue USE_WHITELIST;
    public static ForgeConfigSpec.BooleanValue INVERT_BEHAVIOR;

    static {
        ForgeConfigSpec.Builder builder = new ForgeConfigSpec.Builder();

        USE_WHITELIST = builder.comment("If enabled, only blocks in the whitelist tag will be affected; if disabled, all blocks will be affected except those in the blacklist tag.").define("use_whitelist", false);
        INVERT_BEHAVIOR = builder.comment("If enabled, behavior will be inverted: affected blocks will only tick when looked at.").define("invert_behavior", false);

        SERVER_SPEC = builder.build();
    }

    @Override
    public boolean getUseWhitelist(Level unused) {
        return USE_WHITELIST.get();
    }

    @Override
    public boolean getInvertBehavior(Level unused) {
        return INVERT_BEHAVIOR.get();
    }

}
