package design.aeonic.watchedpot.platform;

import net.fabricmc.fabric.api.gamerule.v1.GameRuleFactory;
import net.fabricmc.fabric.api.gamerule.v1.GameRuleRegistry;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.Level;

public class FabricConfig implements Config {

    public static final GameRules.Key<GameRules.BooleanValue> USE_WHITELIST = GameRuleRegistry.register("watchedpot_useWhitelist", GameRules.Category.UPDATES, GameRuleFactory.createBooleanRule(false));
    public static final GameRules.Key<GameRules.BooleanValue> INVERT_BEHAVIOR = GameRuleRegistry.register("watchedpot_invertBehavior", GameRules.Category.UPDATES, GameRuleFactory.createBooleanRule(false));

    @Override
    public boolean getUseWhitelist(Level level) {
        return level.getGameRules().getBoolean(USE_WHITELIST);
    }

    @Override
    public boolean getInvertBehavior(Level level) {
        return level.getGameRules().getBoolean(INVERT_BEHAVIOR);
    }
}
