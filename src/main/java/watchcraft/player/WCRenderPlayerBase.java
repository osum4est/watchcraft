package watchcraft.player;

import akka.dispatch.sysmsg.Watch;
import api.player.render.RenderPlayerAPI;
import api.player.render.RenderPlayerBase;
import net.minecraft.entity.player.EntityPlayer;
import org.lwjgl.opengl.GL11;
import watchcraft.client.gui.GuiWatchBasicAnalog;
import watchcraft.items.watch.ItemBasicWatchAnalog;
import watchcraft.watch.WatchHandler;

import javax.vecmath.Vector3f;

/**
 * Created by osumf on 8/1/2015.
 */
public class WCRenderPlayerBase extends RenderPlayerBase {

    public static boolean txp;
    public static boolean txn;
    public static boolean typ;
    public static boolean tyn;
    public static boolean tzp;
    public static boolean tzn;
    public static boolean rxp;
    public static boolean ryp;
    public static boolean rzp;
    public static boolean rxn;
    public static boolean ryn;
    public static boolean rzn;
    public static boolean show;
    public static boolean reset;

    float tx;
    float ty;
    float tz;
    float rx;
    float ry;
    float rz;
    float angle;

    Vector3f targetArmT = new Vector3f(-.6f, .5f, -.1f);
    Vector3f targetArmR = new Vector3f(-100, -40, -20);
    Vector3f currentArmT = new Vector3f(0 ,0, 0);
    Vector3f currentArmR = new Vector3f(0, 0, 0);
    float moveSpeed = .1f;

    public WCRenderPlayerBase(RenderPlayerAPI renderPlayerAPI)
    {
        super(renderPlayerAPI);
    }


    @Override
    public void renderFirstPersonArm(EntityPlayer entityPlayer) {
        if (WatchHandler.isViewingWatch)
        {
            currentArmT = lerp(currentArmT, targetArmT, moveSpeed);
            currentArmR = lerp(currentArmR, targetArmR, moveSpeed);
        }
        else
        {
            currentArmT = lerp(currentArmT, new Vector3f(0, 0, 0), moveSpeed);
            currentArmR = lerp(currentArmR, new Vector3f(0, 0, 0), moveSpeed);
        }

        GL11.glTranslatef(currentArmT.x, currentArmT.y, currentArmT.z);
        GL11.glRotatef(currentArmR.x, 1, 0, 0);
        GL11.glRotatef(currentArmR.y, 0, 1, 0);
        GL11.glRotatef(currentArmR.z, 0, 0, 1);


        super.renderFirstPersonArm(entityPlayer);

        GL11.glScalef(.002f, .002f, .002f);
        GL11.glTranslatef(-275, 250, 0);
        GL11.glRotatef(90, 0, 1, 0);
        GL11.glRotatef(90, 0, 0, -1);
        if (WatchHandler.watch != null) {
            for (int i = 0; i < 10; i++) {
                GL11.glTranslatef(0, 0, -1);
                WatchHandler.watch.getGui().drawScreen();
            }
        }

        /*
        offsetX -0.6000001
[22:43:22] [Client thread/INFO] [STDOUT]: [watchcraft.player.WCRenderPlayerBase:renderFirstPersonArm:123]: offsetY 0.50000006
[22:43:22] [Client thread/INFO] [STDOUT]: [watchcraft.player.WCRenderPlayerBase:renderFirstPersonArm:124]: offsetZ -0.10000001
[22:43:22] [Client thread/INFO] [STDOUT]: [watchcraft.player.WCRenderPlayerBase:renderFirstPersonArm:125]: rotateX -100.0
[22:43:22] [Client thread/INFO] [STDOUT]: [watchcraft.player.WCRenderPlayerBase:renderFirstPersonArm:126]: rotateY -40.0
[22:43:22] [Client thread/INFO] [STDOUT]: [watchcraft.player.WCRenderPlayerBase:renderFirstPersonArm:127]: rotateZ -20.0

        if(txp)
        {
            tx += .05;
            show = true;
        }
        if(txn)
        {
            tx += -.05;
            show = true;
        }
        if(typ)
        {
            ty += .05;
            show = true;
        }
        if(tyn)
        {
            ty += -.05;
            show = true;
        }
        if(tzp)
        {
            tz += .05;
            show = true;
        }
        if(tzn)
        {
            tz += -.05;
            show = true;
        }
        if(rxp)
        {
            rx += 10;
            show = true;
        }
        if(ryp)
        {
            ry += 10;
            show = true;
        }
        if(rzp)
        {
            rz += 10;
            show = true;
        }
        if(rxn)
        {
            rx -= 10;
            show = true;
        }
        if(ryn)
        {
            ry -= 10;
            show = true;
        }
        if(rzn)
        {
            rz -= 10;
            show = true;
        }
        if (show)
        {
            System.out.println("offsetX " + tx);
            System.out.println("offsetY " + ty);
            System.out.println("offsetZ " + tz);
            System.out.println("rotateX " + rx);
            System.out.println("rotateY " + ry);
            System.out.println("rotateZ " + rz);

        }



        gui.onRenderGameOverlay(null);

        if (reset)
        {
            tx = 0;
            ty = 0;
            tz = 0;
            rx = 0;
            ry = 0;
            rz = 0;
        }

        txp = false;
        txn = false;
        typ = false;
        tyn = false;
        tzp = false;
        tzn = false;
        rxp = false;
        ryp = false;
        rzp = false;
        rxn = false;
        ryn = false;
        rzn = false;
        reset = false;
        show = false;
        */
    }

    public static float lerp(float start, float target, float amount)
    {
        return start + (target - start) * amount;
    }
    public static Vector3f lerp(Vector3f start, Vector3f target, float amount)
    {
        float x = start.x + (target.x - start.x) * amount;
        float y = start.y + (target.y - start.y) * amount;
        float z = start.z + (target.z - start.z) * amount;
        return new Vector3f(x, y, z);
    }
}
