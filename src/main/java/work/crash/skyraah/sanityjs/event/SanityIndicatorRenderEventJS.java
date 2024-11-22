package work.crash.skyraah.sanityjs.event;

import com.mojang.blaze3d.vertex.PoseStack;
import dev.latvian.mods.kubejs.client.ClientEventJS;
import dev.latvian.mods.kubejs.typings.Info;
import net.minecraftforge.client.gui.overlay.ForgeGui;

public class SanityIndicatorRenderEventJS extends ClientEventJS {
    private final ForgeGui gui;
    private final PoseStack poseStack;
    private final float partialTick;
    private final int scw;
    private final int sch;

    public SanityIndicatorRenderEventJS(ForgeGui gui, PoseStack poseStack, float partialTick, int scw, int sch) {
        this.gui = gui;
        this.poseStack = poseStack;
        this.partialTick = partialTick;
        this.scw = scw;
        this.sch = sch;
    }

    @Info("get the partial tick")
    public float getPartialTick() {
        return partialTick;
    }

    @Info("get the Gui")
    public ForgeGui getGui() {
        return gui;
    }

    @Info("get the GuiGraphics, used to add your custom gui.")
    public PoseStack getGuiGraphics() {
        return poseStack;
    }

    @Info("get the screen width")
    public int getScw() {
        return scw;
    }

    @Info("get the screen height")
    public int getSch() {
        return sch;
    }
}
