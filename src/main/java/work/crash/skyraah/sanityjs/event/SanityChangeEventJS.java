package work.crash.skyraah.sanityjs.event;

import dev.latvian.mods.kubejs.player.PlayerEventJS;
import dev.latvian.mods.kubejs.typings.Info;
import dev.latvian.mods.rhino.util.HideFromJS;
import net.minecraft.world.entity.player.Player;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @author skyraah
 */
public class SanityChangeEventJS extends PlayerEventJS {
    private final float value;
    private final Player player;

    public SanityChangeEventJS(float value, Player player) {
        this.value = unclampNorm(value);
        this.player = player;
    }

    @Override
    public Player getEntity() {
        return player;
    }

    @Info("get sanity value")
    public float getValue() {
        return value;
    }

    @HideFromJS
    public static float unclampNorm(float normalizedValue) {
        return normalizedValue * 100f - 100f;
    }

    public static double approximation(double value, int n) {
        if (n < 0) {
            throw new IllegalArgumentException("The number of decimal places must be non-negative.");
        }

        BigDecimal bd = new BigDecimal(Double.toString(value));
        bd = bd.setScale(n, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }
}
