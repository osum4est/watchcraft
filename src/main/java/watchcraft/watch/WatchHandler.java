package watchcraft.watch;

import watchcraft.client.gui.GuiWatchBasic;

/**
 * Created by osumf on 8/1/2015.
 */
public class WatchHandler {

    boolean isWatchOpen = false;

    public void openWatch()
    {
        if (!isWatchOpen)
            openWatchGui();

        isWatchOpen = true;
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
