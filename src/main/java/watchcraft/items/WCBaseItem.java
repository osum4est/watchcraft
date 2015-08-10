package watchcraft.items;

import net.minecraft.item.Item;
import watchcraft.client.tabs.WCCreativeTab;

/**
 * Created by osumf on 8/8/2015.
 */
public class WCBaseItem extends Item {

    public WCBaseItem(String name, int maxStackSize)
    {
        setCreativeTab(WCCreativeTab.tabWC);
        setUnlocalizedName(name);
        setTextureName("watchcraft:" + name);
        setMaxStackSize(maxStackSize);
    }
}
