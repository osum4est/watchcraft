package watchcraft.client.tabs;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import watchcraft.WatchCraft;

/**
 * Created by osumf on 8/8/2015.
 */
public class WCCreativeTab extends CreativeTabs {

    public static final CreativeTabs tabWC = new WCCreativeTab();

    public WCCreativeTab()
    {
        super(WatchCraft.MODID);
    }
    
    @Override
    public Item getTabIconItem() {
        return WatchCraft.itemBasicWatchAnalog;
    }
}
