package work.crash.skyraah.sanityjs.event;

import dev.latvian.mods.kubejs.player.PlayerEventJS;
import dev.latvian.mods.kubejs.typings.Info;
import net.minecraft.world.entity.player.Player;

/**
 * @author skyraah
 */
public class SanityChangeEventJS extends PlayerEventJS {
    private final float value;
    private final Player player;

    public SanityChangeEventJS(float value, Player player) {
        this.value = value;
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
}
