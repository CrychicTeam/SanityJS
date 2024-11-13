package work.crash.skyraah.sanityjs.event;

import dev.latvian.mods.kubejs.client.ClientEventJS;
import dev.latvian.mods.kubejs.typings.Info;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraftforge.client.gui.overlay.ForgeGui;

public class SanityIndicatorRenderEventJS extends ClientEventJS {
    private final ForgeGui gui;
    private final GuiGraphics guiGraphics;
    private final float partialTick;
    private final int scw;
    private final int sch;

    public SanityIndicatorRenderEventJS(ForgeGui gui, GuiGraphics guiGraphics, float partialTick, int scw, int sch) {
        this.gui = gui;
        this.guiGraphics = guiGraphics;
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
    public GuiGraphics getGuiGraphics() {
        return guiGraphics;
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
