package watchcraft.items.watch;

import watchcraft.client.gui.GuiWatch;
import watchcraft.client.gui.GuiWatchBasicDigital;
import watchcraft.items.WCBaseItem;

/**
 * Created by osumf on 8/1/2015.
 */
public class ItemBasicWatchDigital extends WCBaseItem implements IWatch {


    public ItemBasicWatchDigital(String name, int maxStackSize) {
        super(name, maxStackSize);
    }

    @Override
    public WatchType getWatchType() {
        return WatchType.Digital;
    }

    @Override
    public GuiWatch getGui() {
        return new GuiWatchBasicDigital();
    }
}
