package watchcraft.inventory;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import watchcraft.items.watch.IWatch;
import watchcraft.player.WatchInventory;

/**
 * Created by osumf on 8/1/2015.
 */
public class ContainerWatchInventory extends Container {
    public InventoryPlayer inventoryPlayer;
    public WatchInventory watchInventory;

    public ContainerWatchInventory(EntityPlayer player, WatchInventory watchInventory)
    {
        this.inventoryPlayer = player.inventory;
        this.watchInventory = watchInventory;


        //Player inventory
        for (int column = 0; column < 3; column++)
        {
            for (int row = 0; row < 9; row++)
            {
                addSlotToContainer(new Slot(inventoryPlayer, row + column * 9 + 9, 8 + row * 18, 84 + column * 18));
            }
        }

        for (int column = 0; column < 9; column++)
        {
            addSlotToContainer(new Slot(inventoryPlayer, column, 8 + column * 18, 142));
        }

        //Watch inventory
        WCSlot.ISlotBlacklist watchSlot = (ItemStack i) -> { return i.getItem() instanceof IWatch; };
        addSlotToContainer(new WCSlot(watchInventory, 0, 80, 35, watchSlot));
    }

    @Override
    public boolean canInteractWith(EntityPlayer player) {
        return true;
    }

    @Override
    public ItemStack transferStackInSlot(EntityPlayer p_82846_1_, int p_82846_2_) {
        return null;
    }
}
