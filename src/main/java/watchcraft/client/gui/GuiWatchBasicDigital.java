package watchcraft.client.gui;

import net.minecraft.client.gui.Gui;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

import java.awt.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Created by osumf on 8/1/2015.
 */
public class GuiWatchBasicDigital extends GuiWatch {


    @Override
    public ResourceLocation getTexture() {
        return new ResourceLocation("watchcraft", "textures/gui/watchbasic.png");
    }

    @Override
    public Point getTextureDim() {
        return new Point(83, 94);
    }

    @Override
    public void drawScreen() {

        super.drawScreen();

        String time;
        time  = LocalDateTime.now().format(DateTimeFormatter.ofPattern("h:mm"));

        GL11.glScalef(1.6f, 1.6f, 1);
        mc.fontRenderer.drawString(time, (int) ((screenX / 1.6f) - mc.fontRenderer.getStringWidth(time) / 2), (int) ((screenY - 25) / 1.6f), 0x404040);
        GL11.glScalef(.625f, .625f, 1);

        String dow = LocalDateTime.now().format(DateTimeFormatter.ofPattern("EEEE,"));
        drawCenteredStringNoShadow(dow, 0, 0, 0x404040);

        String month = LocalDateTime.now().format(DateTimeFormatter.ofPattern("MMMM d"));
        drawCenteredStringNoShadow(month, 0, 12, 0x404040);
    }
}
