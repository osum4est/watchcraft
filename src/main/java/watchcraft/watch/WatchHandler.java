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

    boolean isWatchOpen = false;

    private GuiWatch guiWatch;

    public void openWatch()
    {
        ItemWatch watch = WCPlayerStats.getWatch(Minecraft.getMinecraft().thePlayer);
        if (watch != null) {
            if (!isWatchOpen)
                openWatchGui(watch);

            isWatchOpen = true;
        }
    }

    public void closeWatch()
    {
        if(isWatchOpen)
            closeWatchGui();

        isWatchOpen = false;
    }

    private void openWatchGui(ItemWatch watch)
    {
        System.out.println("attempting to open watch gui");
        guiWatch = watch.getGui();
        MinecraftForge.EVENT_BUS.register(guiWatch);
    }

    private void closeWatchGui()
    {
        MinecraftForge.EVENT_BUS.unregister(guiWatch);
        guiWatch = null;
    }
}
