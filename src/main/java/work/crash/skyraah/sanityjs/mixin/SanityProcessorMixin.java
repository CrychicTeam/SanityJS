package work.crash.skyraah.sanityjs.mixin;

import croissantnova.sanitydim.SanityProcessor;
import croissantnova.sanitydim.capability.ISanity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import work.crash.skyraah.sanityjs.event.SanityChangeEventJS;
import work.crash.skyraah.sanityjs.event.SanityEvents;
import work.crash.skyraah.sanityjs.util.IPlayerSanity;

@Mixin(SanityProcessor.class)
public abstract class SanityProcessorMixin {

    @Inject(method = "addSanity", at = @At("HEAD"), cancellable = true, remap = false)
    private static void sanityJS$addSanity(ISanity sanity, float value, ServerPlayer player, CallbackInfo ci) {
        var changeEvent = SanityEvents.SAN_CHANGE.post(new SanityChangeEventJS(value, ((IPlayerSanity) player).getSanity(), player));
        if (changeEvent.interruptFalse()) {
            ci.cancel();
        }
    }

// SanityTickEvent
//    @Inject(method = "tickPlayer", at = @At("HEAD"), cancellable = true, remap = false)
//    private static void sanityJS$tickPlayer(ServerPlayer player, CallbackInfo ci) {
//        var changeEvent = SanityEvents.SAN_CHANGE.post(new SanityChangeEventJS(0, ((IPlayerSanity) player).getSanity(), player));
//        if (changeEvent.interruptFalse()) {
//            ci.cancel();
//        }
//    }

    @Inject(method = "calcPassive", at = @At("TAIL"), cancellable = true, remap = false)
    private static void sanityJS$calcPassive(ServerPlayer player, ISanity sanity, CallbackInfoReturnable<Float> cir) {
        var value = cir.getReturnValue();
        var changeEvent = SanityEvents.SAN_CHANGE.post(new SanityChangeEventJS(value, ((IPlayerSanity) player).getSanity(), player));
        if (changeEvent.interruptFalse()) {
            cir.setReturnValue(0.F);
        }
    }
}