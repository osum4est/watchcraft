package watchcraft.watch;

import net.minecraft.client.Minecraft;
import watchcraft.client.gui.GuiWatchBasic;
import watchcraft.items.ItemWatch;
import watchcraft.player.WCPlayerStats;

/**
 * Created by osumf on 8/1/2015.
 */
public class WatchHandler {

    boolean isWatchOpen = false;

    public void openWatch()
    {
        if (WCPlayerStats.getWatch(Minecraft.getMinecraft().thePlayer) != null) {
            if (!isWatchOpen)
                openWatchGui();

            isWatchOpen = true;
        }
    }

    public void closeWatch()
    {
        if(isWatchOpen)
            closeWatchGui();

        isWatchOpen = false;
    }

    private void openWatchGui()
    {
        System.out.println("attempting to open watch gui");
        GuiWatchBasic.show = true;
    }

    private void closeWatchGui()
    {
        GuiWatchBasic.show = false;
    }
}
