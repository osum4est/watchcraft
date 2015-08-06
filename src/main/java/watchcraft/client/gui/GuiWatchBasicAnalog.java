package watchcraft.client.gui;

import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

import java.awt.*;
import java.time.LocalDateTime;

/**
 * Created by osumf on 8/4/2015.
 */
public class GuiWatchBasicAnalog extends GuiWatch {



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
        drawWatchHand(28, WatchHand.Second, 28, 2, 0xFF4545);
        drawWatchHand(28, WatchHand.Minute, 25, 4, 0x404040);
        drawWatchHand(28, WatchHand.Hour, 15, 4, 0x404040);
    }

    public void drawTimeNumbers(int radius)
    {
        drawCenteredStringNoShadow("12", 0, -radius, 0x404040);
        drawCenteredStringNoShadow("1", (int)(ONEHALF * radius), (int)(ROOTTHREEOVERTWO * -radius), 0x404040);
        drawCenteredStringNoShadow("2", (int)(ROOTTHREEOVERTWO * radius), (int)(ONEHALF * -radius), 0x404040);
        drawCenteredStringNoShadow("3", radius, 0, 0x404040);
        drawCenteredStringNoShadow("5", (int)(ONEHALF * radius), (int)(ROOTTHREEOVERTWO * radius), 0x404040);
        drawCenteredStringNoShadow("4", (int)(ROOTTHREEOVERTWO * radius), (int)(ONEHALF * radius), 0x404040);
        drawCenteredStringNoShadow("6", 0, radius, 0x404040);
        drawCenteredStringNoShadow("7", (int)(ONEHALF * -radius), (int)(ROOTTHREEOVERTWO * radius), 0x404040);
        drawCenteredStringNoShadow("8", (int)(ROOTTHREEOVERTWO * -radius), (int)(ONEHALF * radius), 0x404040);
        drawCenteredStringNoShadow("9", -radius, 0, 0x404040);
        drawCenteredStringNoShadow("11", (int) (ONEHALF * -radius), (int) (ROOTTHREEOVERTWO * -radius), 0x404040);
        drawCenteredStringNoShadow("10", (int) (ROOTTHREEOVERTWO * -radius), (int) (ONEHALF * -radius), 0x404040);
    }

    enum WatchHand {
        Hour,
        Minute,
        Second
    }
    public void drawWatchHand(int radius, WatchHand type, int length, int width, int color) {

        LocalDateTime time = LocalDateTime.now();

        float second = time.getSecond();
        float minute = time.getMinute() + second / 60;
        float hour = time.getHour() + minute / 60;

        float percent = 0f;

        switch (type)
        {
            case Hour:
                percent = hour / 12;
                break;
            case Minute:
                percent = minute / 60;
                break;
            case Second:
                percent = second / 60;
                break;
        }

        float angle = percent * 360 - 90;

        double x;
        double y;

        x = Math.cos(Math.toRadians(angle)) * length;
        y = Math.sin(Math.toRadians(angle)) * length;

        if (angle > 180)
            x *= 1f;
        if (angle > 270 || angle < 90)
            y *= 1f;



        //System.out.println("x: " + x);
        //System.out.println("y: " + y);

        drawLine(0, 0, (int)x, (int)y, width, color);

//        mc.getTextureManager().bindTexture(pixel);
//        Tessellator t = Tessellator.instance;
//        t.startDrawing(GL11.GL_LINES);
//        GL11.glLineWidth(50);
//        GL11.glTranslated(0, 0, 0);
//        t.setColorOpaque_F(1f, 1f, 1f);
//        t.addVertex(0, 0, 0);
//        t.addVertex(100, 100, 0);
//        t.draw();
    }
}
