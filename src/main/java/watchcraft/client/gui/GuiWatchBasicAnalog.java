package watchcraft.client.gui;

import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

import java.awt.*;

/**
 * Created by osumf on 8/4/2015.
 */
public class GuiWatchBasicAnalog extends GuiWatch {

    ResourceLocation pixel = new ResourceLocation("watchcraft", "texture/gui/pixel.png");

    @Override
    public ResourceLocation getTexture() {
        return new ResourceLocation("watchcraft", "textures/gui/watchbasicround.png");
    }

    @Override
    public Point getTextureDim() {
        return new Point(90, 90);
    }

    @Override
    public void drawScreen() {
        super.drawScreen();
        mc.getTextureManager().bindTexture(pixel);
        drawTimeNumbers(28);
    }

    public void drawTimeNumbers(int radius)
    {
        drawCenteredStringNoShadow("12", 0, -radius, 0x404040);
        drawCenteredStringNoShadow("1", (int)(ONEHALF * radius), (int)(ROOTTHREEOVERTWO * -radius), 0x404040);
        drawCenteredStringNoShadow("2", (int)(ROOTTHREEOVERTWO * radius), (int)(ONEHALF * -radius), 0x404040);
        drawCenteredStringNoShadow("3", radius, 0, 0x404040);
        drawCenteredStringNoShadow("4", (int)(ONEHALF * radius), (int)(ROOTTHREEOVERTWO * radius), 0x404040);
        drawCenteredStringNoShadow("5", (int)(ROOTTHREEOVERTWO * radius), (int)(ONEHALF * radius), 0x404040);
        drawCenteredStringNoShadow("6", 0, radius, 0x404040);
        drawCenteredStringNoShadow("7", (int)(ONEHALF * -radius), (int)(ROOTTHREEOVERTWO * radius), 0x404040);
        drawCenteredStringNoShadow("8", (int)(ROOTTHREEOVERTWO * -radius), (int)(ONEHALF * radius), 0x404040);
        drawCenteredStringNoShadow("9", -radius, 0, 0x404040);
        drawCenteredStringNoShadow("10", (int)(ONEHALF * -radius), (int)(ROOTTHREEOVERTWO * -radius), 0x404040);
        drawCenteredStringNoShadow("11", (int)(ROOTTHREEOVERTWO * -radius), (int)(ONEHALF * -radius), 0x404040);
    }
}
