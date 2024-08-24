package work.crash.skyraah.sanityjs.event;

import croissantnova.sanitydim.capability.SanityProvider;
import croissantnova.sanitydim.util.MathHelper;
import dev.latvian.mods.kubejs.player.PlayerEventJS;
import dev.latvian.mods.kubejs.typings.Info;
import net.minecraft.world.entity.player.Player;

import java.math.BigDecimal;
import java.math.RoundingMode;

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
    public float getValue() {
        return value;
    }

    @Info("Get the sanity value before the change")
    public float getPreviousValue() {
        return previousValue;
    }

    @Info("Set the sanity value to a specific number (0-100)")
    public void setValue(float value) {
        player.getCapability(SanityProvider.CAP).ifPresent(sanity -> {
            sanity.setSanity((100f - value) / 100f);
        });
    }

    @Info("Increase sanity")
    public void addValue(float value) {
        player.getCapability(SanityProvider.CAP).ifPresent(sanity -> {
            sanity.setSanity((sanity.getSanity() - value) / 100f);
        });
    }

    @Info("Convert a number to a value between 0 and 1")
    public float clampNorm(float value) {
        return MathHelper.clampNorm(value);
    }

    @Info("Convert the value between 0 and 1 into a readable number")
    public float unclampNorm(float normalizedValue) {
        return normalizedValue * 100f - 100f;
    }

    @Info("Truncate a number to n significant decimal places (rounding mode)")
    public float approximation(float value, int n) {
        if (n < 0) {
            throw new IllegalArgumentException("The number of decimal places must be non-negative.");
        }
        BigDecimal bd = new BigDecimal(Double.toString(value));
        bd = bd.setScale(n, RoundingMode.HALF_UP);
        return Math.abs(bd.floatValue());
    }
}
