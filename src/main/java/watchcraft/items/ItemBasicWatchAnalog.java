package watchcraft.items;

import watchcraft.client.gui.GuiWatch;
import watchcraft.client.gui.GuiWatchBasicAnalog;

/**
 * Created by osumf on 8/3/2015.
 */
public class ItemBasicWatchAnalog extends ItemWatch{

    public ItemBasicWatchAnalog(String name) {
        super(name);
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
