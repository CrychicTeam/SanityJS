package work.crash.skyraah.sanityjs.mixin;

import croissantnova.sanitydim.SanityProcessor;
import croissantnova.sanitydim.capability.ISanity;
import net.minecraft.server.level.ServerPlayer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import work.crash.skyraah.sanityjs.event.SanityChangeEventJS;
import work.crash.skyraah.sanityjs.event.SanityEvents;

/**
 * @author skyraah
 */
@Mixin(SanityProcessor.class)
public abstract class SanityProcessorMixin {
    @Inject(method = "addSanity", at = @At("HEAD"), remap = false)
    private static void onSanityChange(ISanity sanity, float value, ServerPlayer player, CallbackInfo ci) {
        SanityEvents.SAN_CHANGE.post(new SanityChangeEventJS(value, player));
    }
}
