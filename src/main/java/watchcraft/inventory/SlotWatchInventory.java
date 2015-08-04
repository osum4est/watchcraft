package watchcraft.inventory;


import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import watchcraft.items.ItemWatch;

/**
 * Created by osumf on 8/1/2015.
 */
public class SlotWatchInventory extends Slot {

    public SlotWatchInventory(IInventory inventory, int p2, int p3, int p4)
    {
        super(inventory, p2, p3, p4);
    }

    @Override
    public boolean isItemValid(ItemStack stack) {
        return stack.getItem() instanceof ItemWatch;
    }
}
