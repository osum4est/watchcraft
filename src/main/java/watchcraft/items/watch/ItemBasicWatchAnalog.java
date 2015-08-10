package watchcraft.items.watch;

import watchcraft.client.gui.GuiWatch;
import watchcraft.client.gui.GuiWatchBasicAnalog;
import watchcraft.items.WCBaseItem;

/**
 * Created by osumf on 8/3/2015.
 */
public class ItemBasicWatchAnalog extends WCBaseItem implements IWatch {

    public ItemBasicWatchAnalog(String name, int maxStackSize) {
        super(name, maxStackSize);
    }

    @Override
    public WatchType getWatchType() {
        return WatchType.Analog;
    }

    @Override
    public GuiWatch getGui() {
        return new GuiWatchBasicAnalog();
    }
}
