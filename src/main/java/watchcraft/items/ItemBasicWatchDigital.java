package watchcraft.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

/**
 * Created by osumf on 8/1/2015.
 */
public class ItemBasicWatchDigital extends ItemWatch {


    public ItemBasicWatchDigital(String name) {
        super(name);
    }

    @Override
    public WatchType getWatchType() {
        return WatchType.Digital;
    }
}
