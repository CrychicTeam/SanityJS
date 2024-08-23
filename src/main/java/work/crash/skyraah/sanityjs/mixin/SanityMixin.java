package work.crash.skyraah.sanityjs.mixin;

import croissantnova.sanitydim.capability.Sanity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import work.crash.skyraah.sanityjs.event.SanityChangeEventJS;

@Mixin(Sanity.class)
public abstract  class SanityMixin {

    @Inject(method = "setSanity", at = @At("HEAD"), remap = false)
    private void onSetSanity(float value, CallbackInfo ci) {
        // 获取当前的 sanity 值
        float oldSanity = ((Sanity)(Object)this).getSanity();

        // 比较新旧 sanity 值，如果有变化，触发事件
        if (value != oldSanity) {
            // 触发 KubeJS 的事件
            sanityJS$triggerSanityChangeEvent(oldSanity, value, "setSanity");
        }
    }

    @Inject(method = "setPassiveIncrease", at = @At("HEAD"), remap = false)
    private void onSetPassiveIncrease(float value, CallbackInfo ci) {
        // 获取当前的被动增加值
        float oldPassive = ((Sanity)(Object)this).getPassiveIncrease();

        // 比较新旧的被动增加值，如果有变化，触发事件
        if (value != oldPassive) {
            // 触发 KubeJS 的事件
            sanityJS$triggerSanityChangeEvent(oldPassive, value, "setPassiveIncrease");
        }
    }

    @Unique
    private void sanityJS$triggerSanityChangeEvent(float oldValue, float newValue, String type) {
        SanityChangeEventJS event = new SanityChangeEventJS(oldValue, newValue, type);
    }
}
