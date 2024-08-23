package work.crash.skyraah.sanityjs.event;

import dev.latvian.mods.kubejs.event.EventJS;
import net.minecraft.world.level.Level;

public class SanityChangeEventJS extends EventJS {
    private final float oldValue;
    private final float newValue;
    private final String type;

    // 构造函数初始化事件
    public SanityChangeEventJS(float oldValue, float newValue, String type) {
        this.oldValue = oldValue;
        this.newValue = newValue;
        this.type = type;
    }

    // 提供对外访问的 getter 方法
    public float getOldValue() {
        return oldValue;
    }

    public float getNewValue() {
        return newValue;
    }

    public String getType() {
        return type;
    }
}
