package watchcraft.items.band;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import watchcraft.items.WCBaseItem;

import java.util.List;

/**
 * Created by osumf on 8/9/2015.
 */

// Not a rubber band, a band made of rubber

public class ItemBandRubber extends WCBaseItem implements IBand {
    public ItemBandRubber(String name, int maxStackSize) {
        super(name, maxStackSize);
    }

    @Override
    public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean par4) {
        list.add("No, not a rubber band, it's a band made of rubber");
    }
}
