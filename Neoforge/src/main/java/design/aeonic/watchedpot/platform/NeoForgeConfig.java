package design.aeonic.watchedpot.platform;

import net.minecraft.world.level.Level;
import net.neoforged.neoforge.common.ModConfigSpec;

public class NeoForgeConfig implements Config {

    public static final ModConfigSpec SERVER_SPEC;

    public static ModConfigSpec.BooleanValue USE_WHITELIST;
    public static ModConfigSpec.BooleanValue INVERT_BEHAVIOR;

    static {
        ModConfigSpec.Builder builder = new ModConfigSpec.Builder();

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
