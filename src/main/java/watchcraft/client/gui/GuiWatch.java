package watchcraft.client.gui;

import cpw.mods.fml.common.eventhandler.EventPriority;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import org.lwjgl.opengl.GL11;

import java.awt.*;

/**
 * Created by osumf on 8/4/2015.
 */
public abstract class GuiWatch extends Gui {

    public static final double ONEHALF = .5D;
    public static final double ROOTTHREEOVERTWO = .866D;

    public ResourceLocation texture;

    public Minecraft mc;
    public int screenX;
    public int screenY;

    public int textureWidth;
    public int textureHeight;

    public GuiWatch()
    {

        texture = getTexture();
        mc = Minecraft.getMinecraft();

        Point p = getTextureDim();
        textureWidth = p.x;
        textureHeight = p.y;

        setScreenSize();
    }

    public abstract ResourceLocation getTexture();
    public abstract Point getTextureDim();

    public void drawScreen()
    {
        setScreenSize();

        GL11.glColor4f(1, 1, 1, .5f);
        mc.getTextureManager().bindTexture(texture);

        int posX = screenX - textureWidth / 2;
        int posY = screenY - textureHeight / 2;
        drawTexturedModalRect(posX, posY, 0, 0, textureWidth, textureHeight);
    }

    public void setScreenSize()
    {
        screenX = mc.displayWidth / 4;
        screenY = mc.displayHeight / 4;
    }

    public void drawLine(int x1, int y1, int x2, int y2, float width, int color)
    {
        Tessellator t = Tessellator.instance;
        t.startDrawing(GL11.GL_LINES);
        GL11.glLineWidth(width);
        GL11.glTranslated(0, 0, 0);
        t.setColorOpaque_I(color);
        t.addVertex(screenX + x1, screenY + y1, 0);
        t.addVertex(screenX + x2, screenY + y2, 0);
        t.draw();
    }

    public void drawCenteredStringNoShadow(String string, int x, int y, int color)
    {
        mc.fontRenderer.drawString(string, (screenX - mc.fontRenderer.getStringWidth(string) / 2) + x, (screenY - mc.fontRenderer.FONT_HEIGHT / 2) + y, color);
    }

    @SubscribeEvent(priority = EventPriority.NORMAL)
    public void onRenderGameOverlay(RenderGameOverlayEvent event)
    {
        drawScreen();
        mc.getTextureManager().bindTexture(Gui.icons);
        GL11.glColor4f(1, 1, 1, 1);
    }

    
}
