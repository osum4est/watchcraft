package watchcraft.player;

import api.player.model.ModelPlayerAPI;
import api.player.model.ModelPlayerBase;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;
import watchcraft.WatchCraft;

/**
 * Created by osumf on 8/1/2015.
 */
public class WCModelPlayerBase extends ModelPlayerBase {

    public static boolean isViewingWatch;

    public static float offsetX = -.4f;
    public static float offsetY = .3f;
    public static float offsetZ = -.2f;
    public static float rotateX = -1.5f;
    public static float rotateY = -.3f;
    public static float rotateZ = .5f;


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
    public static boolean reset;
    public static boolean show = true;

    public WCModelPlayerBase(ModelPlayerAPI modelPlayerAPI)
    {
        super(modelPlayerAPI);

        //modelPlayer.bipedRightArm.addBox(10, 10, 10, 50, 50, 50);
    }

    float moveSpeed = .1f;
    @Override
    public void setRotationAngles(float v, float v1, float v2, float v3, float v4, float v5, Entity entity) {

        if (Minecraft.getMinecraft().gameSettings.thirdPersonView == 0) {
            if (isViewingWatch) {
                modelPlayer.bipedRightArm.offsetX = lerp(modelPlayer.bipedRightArm.offsetX, offsetX, moveSpeed);
                modelPlayer.bipedRightArm.offsetY = lerp(modelPlayer.bipedRightArm.offsetY, offsetY, moveSpeed);
                modelPlayer.bipedRightArm.offsetZ = lerp(modelPlayer.bipedRightArm.offsetZ, offsetZ, moveSpeed);
                modelPlayer.bipedRightArm.rotateAngleX = lerp(modelPlayer.bipedRightArm.rotateAngleX, rotateX, moveSpeed);
                modelPlayer.bipedRightArm.rotateAngleY = lerp(modelPlayer.bipedRightArm.rotateAngleY, rotateY, moveSpeed);
                modelPlayer.bipedRightArm.rotateAngleZ = lerp(modelPlayer.bipedRightArm.rotateAngleZ, rotateZ, moveSpeed);

                if (offsetX - lerp(modelPlayer.bipedRightArm.offsetX, offsetX, moveSpeed) < .075f && offsetX - lerp(modelPlayer.bipedRightArm.offsetX, offsetX, moveSpeed) > -.075f)
                {
                    WatchCraft.watchHandler.openWatch();
                }
                else
                {
                    WatchCraft.watchHandler.closeWatch();
                }

            } else {
                modelPlayer.bipedRightArm.offsetX = lerp(modelPlayer.bipedRightArm.offsetX, 0, moveSpeed);
                modelPlayer.bipedRightArm.offsetY = lerp(modelPlayer.bipedRightArm.offsetY, 0, moveSpeed);
                modelPlayer.bipedRightArm.offsetZ = lerp(modelPlayer.bipedRightArm.offsetZ, 0, moveSpeed);
                modelPlayer.bipedRightArm.rotateAngleX = lerp(modelPlayer.bipedRightArm.rotateAngleX, 0, moveSpeed);
                modelPlayer.bipedRightArm.rotateAngleY = lerp(modelPlayer.bipedRightArm.rotateAngleY, 0, moveSpeed);
                modelPlayer.bipedRightArm.rotateAngleZ = lerp(modelPlayer.bipedRightArm.rotateAngleZ, 0, moveSpeed);
                WatchCraft.watchHandler.closeWatch();
            }
        }
        else
            super.setRotationAngles(v, v1, v2, v3, v4, v5, entity);
    }



    /*
    @Override
    public void setRotationAngles(float legSwing, float legYaw, float ticksExistedPartial, float v3, float v4, float v5, Entity entity) {



        super.setRotationAngles(legSwing, legYaw, ticksExistedPartial, v3, v4, v5, entity);

        [21:10:23] [Client thread/INFO] [STDOUT]: [watchcraft.player.WCModelPlayerBase:setRotationAngles:134]: offsetX -0.4
[21:10:23] [Client thread/INFO] [STDOUT]: [watchcraft.player.WCModelPlayerBase:setRotationAngles:135]: offsetY 0.3
[21:10:23] [Client thread/INFO] [STDOUT]: [watchcraft.player.WCModelPlayerBase:setRotationAngles:136]: offsetZ -0.20000002
[21:10:23] [Client thread/INFO] [STDOUT]: [watchcraft.player.WCModelPlayerBase:setRotationAngles:137]: rotateX -1.6000001
[21:10:23] [Client thread/INFO] [STDOUT]: [watchcraft.player.WCModelPlayerBase:setRotationAngles:138]: rotateY -0.3
[21:10:23] [Client thread/INFO] [STDOUT]: [watchcraft.player.WCModelPlayerBase:setRotationAngles:139]: rotateZ 0.4999999




        if(txp)
        {
            modelPlayer.bipedRightArm.offsetX += .1;
            show = true;
        }
        if(txn)
        {
            modelPlayer.bipedRightArm.offsetX -= .1;
            show = true;
        }
        if(typ)
        {
            modelPlayer.bipedRightArm.offsetY += .1;
            show = true;
        }
        if(tyn)
        {
            modelPlayer.bipedRightArm.offsetY -= .1;
            show = true;
        }
        if(tzp)
        {
            modelPlayer.bipedRightArm.offsetZ += .1;
            show = true;
        }
        if(tzn)
        {
            modelPlayer.bipedRightArm.offsetZ -= .1;
            show = true;
        }
        if(rxp)
        {
            modelPlayer.bipedRightArm.rotateAngleX += .1;
            show = true;
        }
        if(ryp)
        {
            modelPlayer.bipedRightArm.rotateAngleY += .1;
            show = true;
        }
        if(rzp)
        {
            modelPlayer.bipedRightArm.rotateAngleZ += .1;
            show = true;
        }
        if(rxn)
        {
            modelPlayer.bipedRightArm.rotateAngleX -= .1;
            show = true;
        }
        if(ryn)
        {
            modelPlayer.bipedRightArm.rotateAngleY -= .1;
            show = true;
        }
        if(rzn)
        {
            modelPlayer.bipedRightArm.rotateAngleZ -= .1;
            show = true;
        }


        if (show)
        {
            System.out.println("offsetX " + modelPlayer.bipedRightArm.offsetX);
            System.out.println("offsetY " + modelPlayer.bipedRightArm.offsetY);
            System.out.println("offsetZ " + modelPlayer.bipedRightArm.offsetZ);
            System.out.println("rotateX " + modelPlayer.bipedRightArm.rotateAngleX);
            System.out.println("rotateY " + modelPlayer.bipedRightArm.rotateAngleY);
            System.out.println("rotateZ " + modelPlayer.bipedRightArm.rotateAngleZ);

        }

        if (reset)
        {
            modelPlayer.bipedRightArm.offsetX = 0;
            modelPlayer.bipedRightArm.offsetY = 0;
            modelPlayer.bipedRightArm.offsetZ = 0;
            modelPlayer.bipedRightArm.rotateAngleX = 0;
            modelPlayer.bipedRightArm.rotateAngleY = 0;
            modelPlayer.bipedRightArm.rotateAngleZ = 0;
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


    }
    */

    public static float lerp(float start, float target, float amount)
    {
        return start + (target - start) * amount;
    }
}
