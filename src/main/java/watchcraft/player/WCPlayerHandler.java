package watchcraft.player;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.entity.EntityEvent;

/**
 * Created by osumf on 8/1/2015.
 */
public class WCPlayerHandler {

    @SubscribeEvent
    public void onEntityConstructing(EntityEvent.EntityConstructing event)
    {
        if (event.entity instanceof EntityPlayer && WCPlayerStats.get((EntityPlayer) event.entity) == null)
        {
            WCPlayerStats.register((EntityPlayer) event.entity);
        }
    }
}
