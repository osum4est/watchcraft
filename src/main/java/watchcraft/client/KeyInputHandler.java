package watchcraft.client;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.InputEvent;
import net.minecraft.client.Minecraft;
import watchcraft.WatchCraft;
import watchcraft.player.WCModelPlayerBase;
import watchcraft.player.WCPlayerStats;
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
            WCModelPlayerBase.isViewingWatch = true;
        }
        else
        {
            //System.out.println("Stopped viewing watch...");
            WCModelPlayerBase.isViewingWatch = false;
        }



        if(KeyBindings.txp.isPressed())
        {
            WCModelPlayerBase.txp = true;
        }
        if(KeyBindings.txn.isPressed())
        {
            WCModelPlayerBase.txn = true;
        }
        if(KeyBindings.typ.isPressed())
        {
            WCModelPlayerBase.typ = true;
        }
        if(KeyBindings.tyn.isPressed())
        {
            WCModelPlayerBase.tyn = true;
        }
        if(KeyBindings.tzp.isPressed())
        {
            WCModelPlayerBase.tzp = true;
        }
        if(KeyBindings.tzn.isPressed())
        {
            WCModelPlayerBase.tzn = true;
        }
        if(KeyBindings.rxp.isPressed())
        {
            WCModelPlayerBase.rxp = true;
        }
        if(KeyBindings.ryp.isPressed())
        {
            WCModelPlayerBase.ryp = true;
        }
        if(KeyBindings.rzp.isPressed())
        {
            WCModelPlayerBase.rzp = true;
        }
        if(KeyBindings.rxn.isPressed())
        {
            WCModelPlayerBase.rxn = true;
        }
        if(KeyBindings.ryn.isPressed())
        {
            WCModelPlayerBase.ryn = true;
        }
        if(KeyBindings.rzn.isPressed())
        {
            WCModelPlayerBase.rzn = true;
        }
        if(KeyBindings.reset.isPressed())
        {
            WCModelPlayerBase.reset = true;
        }
    }
}
