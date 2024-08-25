package work.crash.skyraah.sanityjs.util;

import croissantnova.sanitydim.util.MathHelper;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @author skyraah
 */
public class IMathHelper extends MathHelper {
    public static float unclampNorm(float normalizedValue) {
        return normalizedValue * 100f - 100f;
    }
    public static float approximation(float value, int n) {
        if (n < 0) {
            throw new IllegalArgumentException("The number of decimal places must be non-negative.");
        }
        BigDecimal bd = new BigDecimal(Double.toString(value));
        bd = bd.setScale(n, RoundingMode.HALF_UP);
        return Math.abs(bd.floatValue());
    }
}
