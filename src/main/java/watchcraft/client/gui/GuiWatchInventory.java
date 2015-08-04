package watchcraft.client.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.InventoryEffectRenderer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;
import tconstruct.client.tabs.TabRegistry;
import watchcraft.client.tabs.InventoryTabWatchCraft;
import watchcraft.inventory.ContainerWatchInventory;
import watchcraft.player.WatchInventory;

/**
 * Created by osumf on 7/31/2015.
 */
public class GuiWatchInventory extends InventoryEffectRenderer {

    private static final ResourceLocation texture = new ResourceLocation("watchcraft", "textures/gui/watchinventory.png");

    public GuiWatchInventory(EntityPlayer entityPlayer, WatchInventory holder)
    {
        super(new ContainerWatchInventory(entityPlayer, holder));
    }

    @Override
    public void initGui() {
        super.initGui();

        int cornerX = guiLeft;
        int cornerY = guiTop;
        this.buttonList.clear();

        TabRegistry.updateTabValues(cornerX, cornerY, InventoryTabWatchCraft.class);
        TabRegistry.addTabsToList(this.buttonList);
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float p_146976_1_, int p_146976_2_, int p_146976_3_) {
        GL11.glColor4f(1, 1, 1, 1);
        Minecraft.getMinecraft().getTextureManager().bindTexture(texture);
        drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
    }
}
