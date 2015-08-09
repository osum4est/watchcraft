package watchcraft.client;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.InputEvent;
import net.minecraft.client.Minecraft;
import watchcraft.WatchCraft;
import watchcraft.player.WCModelPlayerBase;
import watchcraft.player.WCPlayerStats;
import watchcraft.player.WCRenderPlayerBase;
import watchcraft.watch.WatchHandler;

/**
 * Created by osumf on 8/1/2015.
 */
public class KeyInputHandler {
    @SubscribeEvent
    public void onKeyInput(InputEvent.KeyInputEvent event)
    {
        if(KeyBindings.viewWatch.getIsKeyPressed())
        {
            //System.out.println("Viewing watch...");
            //if (Minecraft.getMinecraft().thePlayer.getExtendedProperties(WCPlayerStats.PROP_NAME).)
            WatchHandler.isViewingWatch = true;
        }
        else
        {
            //System.out.println("Stopped viewing watch...");
            WatchHandler.isViewingWatch = false;
        }



        if(KeyBindings.txp.isPressed())
        {
            WCRenderPlayerBase.txp = true;
        }
        if(KeyBindings.txn.isPressed())
        {
            WCRenderPlayerBase.txn = true;
        }
        if(KeyBindings.typ.isPressed())
        {
            WCRenderPlayerBase.typ = true;
        }
        if(KeyBindings.tyn.isPressed())
        {
            WCRenderPlayerBase.tyn = true;
        }
        if(KeyBindings.tzp.isPressed())
        {
            WCRenderPlayerBase.tzp = true;
        }
        if(KeyBindings.tzn.isPressed())
        {
            WCRenderPlayerBase.tzn = true;
        }
        if(KeyBindings.rxp.isPressed())
        {
            WCRenderPlayerBase.rxp = true;
        }
        if(KeyBindings.ryp.isPressed())
        {
            WCRenderPlayerBase.ryp = true;
        }
        if(KeyBindings.rzp.isPressed())
        {
            WCRenderPlayerBase.rzp = true;
        }
        if(KeyBindings.rxn.isPressed())
        {
            WCRenderPlayerBase.rxn = true;
        }
        if(KeyBindings.ryn.isPressed())
        {
            WCRenderPlayerBase.ryn = true;
        }
        if(KeyBindings.rzn.isPressed())
        {
            WCRenderPlayerBase.rzn = true;
        }
        if(KeyBindings.reset.isPressed())
        {
            WCRenderPlayerBase.reset = true;
        }
    }
}
