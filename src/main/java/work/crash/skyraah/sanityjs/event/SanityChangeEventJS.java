package work.crash.skyraah.sanityjs.event;

import dev.latvian.mods.kubejs.event.EventJS;
import dev.latvian.mods.kubejs.player.PlayerEventJS;
import dev.latvian.mods.kubejs.typings.Info;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

/**
 * @author skyraah
 */
public class SanityChangeEventJS extends PlayerEventJS {
    private final float value;
    private final Player player;

    // 构造函数初始化事件
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
