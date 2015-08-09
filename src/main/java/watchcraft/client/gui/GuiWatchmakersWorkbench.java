package watchcraft.client.gui;

import cpw.mods.fml.client.GuiScrollingList;
import cpw.mods.fml.client.config.GuiSlider;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;
import watchcraft.block.te.TEWatchmakersWorkbench;
import watchcraft.inventory.ContainerWatchmakersWorkbench;

/**
 * Created by osumf on 8/6/2015.
 */
public class GuiWatchmakersWorkbench extends GuiContainer {

    public static final ResourceLocation texture = new ResourceLocation("watchcraft", "textures/gui/watchmakersworkbench.png");

    GuiSlider slider;
    GuiScrollingList list;

    public GuiWatchmakersWorkbench(InventoryPlayer player, TEWatchmakersWorkbench teWatchmakersWorkbench)
    {
        super(new ContainerWatchmakersWorkbench(player.player, teWatchmakersWorkbench));

        xSize = 176;
        ySize = 166;
    }

    @Override
    public void initGui() {
        super.initGui();
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float p_146976_1_, int p_146976_2_, int p_146976_3_) {
        GL11.glColor4f(1, 1, 1, 1);

        mc.getTextureManager().bindTexture(texture);
        drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
    }
}
