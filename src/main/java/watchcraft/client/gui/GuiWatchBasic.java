package watchcraft.client.gui;

import cpw.mods.fml.common.eventhandler.EventPriority;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiIngame;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import org.lwjgl.opengl.GL11;
import scala.collection.parallel.ParIterableLike;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

/**
 * Created by osumf on 8/1/2015.
 */
public class GuiWatchBasic extends Gui {

    private static final ResourceLocation texture = new ResourceLocation("watchcraft", "textures/gui/watchbasic.png");

    public static boolean show = false;

    private Minecraft mc;
    private int screenX;
    private int screenY;

    public GuiWatchBasic()
    {
        initGui();
    }

    public void initGui()
    {
        mc = Minecraft.getMinecraft();
        setScreenSize();
    }

    public void drawScreen() {

        setScreenSize();
        GL11.glColor4f(1, 1, 1, .5f);
        mc.getTextureManager().bindTexture(texture);

        int posX = screenX - 83 / 2;
        int posY = screenY - 94 / 2;
        drawTexturedModalRect(posX, posY, 0, 0, 83, 94);

        String time;
        time  = LocalDateTime.now().format(DateTimeFormatter.ofPattern("h:mm"));

        GL11.glScalef(1.6f, 1.6f, 1);
        mc.fontRenderer.drawString(time, (int) ((screenX / 1.6f) - mc.fontRenderer.getStringWidth(time) / 2), (int) ((screenY - 25) / 1.6f), 0x404040);
        GL11.glScalef(.625f, .625f, 1);



        String dow = LocalDateTime.now().format(DateTimeFormatter.ofPattern("EEEE,"));
        mc.fontRenderer.drawString(dow, screenX - mc.fontRenderer.getStringWidth(dow) / 2, screenY, 0x404040);
        String month = LocalDateTime.now().format(DateTimeFormatter.ofPattern("MMMM d"));
        mc.fontRenderer.drawString(month, screenX - mc.fontRenderer.getStringWidth(month) / 2, screenY + 12, 0x404040);


        //Tessellator.instance.
        // System.getCurrentTimeMillis() and world.getWorldTime

        //rebind minecraft's texture
        mc.getTextureManager().bindTexture(Gui.icons);
        GL11.glColor4f(1, 1, 1, 1);
    }

    public void setScreenSize()
    {
        screenX = mc.displayWidth / 4;
        screenY = mc.displayHeight / 4;
    }

    @SubscribeEvent(priority = EventPriority.NORMAL)
    public void onRenderGameOverlay(RenderGameOverlayEvent event)
    {
        if (show)
            drawScreen();

    }
}
