package watchcraft.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import watchcraft.client.gui.GuiWatch;

/**
 * Created by osumf on 8/3/2015.
 */
public abstract class ItemWatch extends Item {
    public abstract WatchType getWatchType();

    public ItemWatch(String name)
    {
        setMaxStackSize(1);
        setCreativeTab(CreativeTabs.tabMisc);
        setUnlocalizedName(name);
        setTextureName("watchcraft:" + name);
    }

    public abstract GuiWatch getGui();
}
