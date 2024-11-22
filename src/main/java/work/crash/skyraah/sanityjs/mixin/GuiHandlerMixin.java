package work.crash.skyraah.sanityjs.mixin;

import com.mojang.blaze3d.vertex.PoseStack;
import croissantnova.sanitydim.client.GuiHandler;
import net.minecraftforge.client.gui.overlay.ForgeGui;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import work.crash.skyraah.sanityjs.event.SanityEvents;
import work.crash.skyraah.sanityjs.event.SanityIndicatorRenderEventJS;

/**
 * @author M1hono
 * This calss is for all rendering stuff of Sanity.
 */
@Mixin(GuiHandler.class)
public class GuiHandlerMixin {
    @Inject(method = "renderSanityIndicator", at = @At("HEAD"), cancellable = true, remap = false)
    public void sanityJS$renderSanityIndicator(ForgeGui gui, PoseStack poseStack, float partialTicks, int scw, int sch, CallbackInfo ci) {
        var renderEvent = SanityEvents.INDICATOR_RENDER.post(new SanityIndicatorRenderEventJS(gui, poseStack, partialTicks, scw, sch));
        if (renderEvent.interruptFalse()) {
            ci.cancel();
        }
    }
}
