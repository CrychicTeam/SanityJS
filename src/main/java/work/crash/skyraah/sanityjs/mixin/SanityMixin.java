package work.crash.skyraah.sanityjs.mixin;

import croissantnova.sanitydim.capability.Sanity;
import net.minecraft.world.entity.player.Player;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import work.crash.skyraah.sanityjs.event.SanityChangeEventJS;
import work.crash.skyraah.sanityjs.event.SanityEvents;

/**
 * @author skyraah
 */
@Mixin(Sanity.class)
public abstract  class SanityMixin {
    /*@Unique
    private Player sanityJS$player;

    @Inject(method = "setSanity", at = @At("HEAD"), remap = false)
    private void onSetSanity(float value, CallbackInfo ci) {
        // 获取当前的 sanity 值
        float oldSanity = ((Sanity)(Object)this).getSanity();

        // 比较新旧 sanity 值，如果有变化，触发事件
        if (value != oldSanity) {
            // 触发 KubeJS 的事件
            sanityJS$triggerSanityChangeEvent(oldSanity, value, "setSanity", sanityJS$player);
        }
    }

    @Inject(method = "setPassiveIncrease", at = @At("HEAD"), remap = false)
    private void onSetPassiveIncrease(float value, CallbackInfo ci) {
        // 获取当前的被动增加值
        float oldPassive = ((Sanity)(Object)this).getPassiveIncrease();

        // 比较新旧的被动增加值，如果有变化，触发事件
        if (value != oldPassive) {
            // 触发 KubeJS 的事件
            sanityJS$triggerSanityChangeEvent(oldPassive, value, "setPassiveIncrease", sanityJS$player);
        }
    }

    @Unique
    private void sanityJS$triggerSanityChangeEvent(float oldValue, float newValue, String type, Player player) {
        SanityEvents.SAN_CHANGE.post(new SanityChangeEventJS(oldValue, newValue, type, player));
    }

    @Unique
    public Player getSanityJS$player() {
        return sanityJS$player;
    }

    @Unique
    public void setSanityJS$player(Player sanityJS$player) {
        this.sanityJS$player = sanityJS$player;
    }*/

}
