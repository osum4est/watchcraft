package watchcraft.watch;

import net.minecraft.client.Minecraft;
import net.minecraftforge.common.MinecraftForge;
import watchcraft.client.gui.GuiWatch;
import watchcraft.items.ItemWatch;
import watchcraft.player.WCPlayerStats;

/**
 * Created by osumf on 8/1/2015.
 */
public class WatchHandler {


    public static boolean isViewingWatch;
    public static ItemWatch watch = null;

    //boolean isWatchOpen = false;

    //private GuiWatch guiWatch;

//    public void openWatch()
//    {
//        ItemWatch watch = WCPlayerStats.getWatch(Minecraft.getMinecraft().thePlayer);
//        if (watch != null) {
//            if (!isWatchOpen)
//                openWatchGui(watch);
//
//            isWatchOpen = true;
//        }
//    }

    public void updateWornWatch()
    {
        wearWatch(WCPlayerStats.getWatch(Minecraft.getMinecraft().thePlayer));
    }

    public void wearWatch(ItemWatch watch)
    {
        if (watch == null)
            System.out.println("Watch is null");
        WatchHandler.watch = watch;
    }

//    public void closeWatch()
//    {
//        if(isWatchOpen)
//            closeWatchGui();
//
//        isWatchOpen = false;
//    }
//
//    private void openWatchGui(ItemWatch watch)
//    {
//        System.out.println("attempting to open watch gui");
//        guiWatch = watch.getGui();
//        MinecraftForge.EVENT_BUS.register(guiWatch);
//    }
//
//    private void closeWatchGui()
//    {
//        MinecraftForge.EVENT_BUS.unregister(guiWatch);
//        guiWatch = null;
//    }
}
