package watchcraft.items.watch;

import watchcraft.client.gui.GuiWatch;
import watchcraft.items.WCBaseItem;

/**
 * Created by osumf on 8/3/2015.
 */
public interface IWatch {
    WatchType getWatchType();

    GuiWatch getGui();
}
