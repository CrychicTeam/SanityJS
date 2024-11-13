package work.crash.skyraah.sanityjs.mixin;

import croissantnova.sanitydim.client.GuiHandler;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraftforge.client.gui.overlay.ForgeGui;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import work.crash.skyraah.sanityjs.event.SanityEvents;
import work.crash.skyraah.sanityjs.event.SanityIndicatorRenderEventJS;


@Mixin(GuiHandler.class)
public class GuiHandlerMixin {
    @Inject(method = "renderSanityIndicator", at = @At("HEAD"), cancellable = true, remap = false)
    public void sanityJS$renderSanityIndicator(ForgeGui gui, GuiGraphics guiGraphics, float partialTick, int scw, int sch, CallbackInfo ci) {
        var renderEvent = SanityEvents.INDICATOR_RENDER.post(new SanityIndicatorRenderEventJS(gui, guiGraphics, partialTick, scw, sch));
        if (renderEvent.interruptFalse()) {
            ci.cancel();
        }
    }
}
