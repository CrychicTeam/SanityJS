package work.crash.skyraah.sanityjs.event;

import dev.latvian.mods.kubejs.player.PlayerEventJS;
import dev.latvian.mods.kubejs.typings.Info;
import net.minecraft.world.entity.player.Player;
import work.crash.skyraah.sanityjs.util.IMathHelper;
import work.crash.skyraah.sanityjs.util.IPlayerSanity;

/**
 * @author skyraah
 */
public class SanityChangeEventJS extends PlayerEventJS {
    private final float value;
    private final float previousValue;
    private final Player player;

    public SanityChangeEventJS(float value, float previousValue, Player player) {
        this.value = value;
        this.previousValue = previousValue;
        this.player = player;
    }

    @Override
    public Player getEntity() {
        return player;
    }

    @Info("Get the sanity value")
    public float getSanity() {
        return value;
    }

    @Info("Get the sanity value before the change")
    public float getPreviousSanity() {
        return previousValue;
    }

    @Info("Set the sanity value to a specific number (0-100)")
    public void setSanity(float value) {
        ((IPlayerSanity) player).setSanity(value);
    }

    @Info("Increase sanity")
    public void addSanity(float value) {
        ((IPlayerSanity) player).addSanity(value);
    }

    @Info("Convert a number to a value between 0 and 1")
    public float clampNorm(float value) {
        return IMathHelper.clampNorm(value);
    }

    @Info("Convert the value between 0 and 1 into a readable number")
    public float unclampNorm(float normalizedValue) {
        return IMathHelper.unclampNorm(normalizedValue);
    }

    @Info("Truncate a number to n significant decimal places (rounding mode)")
    public float approximation(float value, int n) {
        return IMathHelper.approximation(value, n);
    }
}
