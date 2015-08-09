package watchcraft.inventory;


import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import watchcraft.items.ItemWatch;

/**
 * Created by osumf on 8/1/2015.
 */
public class WCSlot extends Slot {

    public interface ISlotBlacklist {
        boolean isWCItemValid(ItemStack itemStack);
    }

    ISlotBlacklist blacklist;

    public WCSlot(IInventory inventory, int id, int x, int y, ISlotBlacklist blacklist)
    {
        super(inventory, id, x, y);
        this.blacklist = blacklist;
    }

    @Override
    public boolean isItemValid(ItemStack itemStack) {
        return blacklist.isWCItemValid(itemStack);
    }
}
