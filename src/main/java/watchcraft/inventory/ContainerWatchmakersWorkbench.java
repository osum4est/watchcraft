package watchcraft.inventory;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import watchcraft.block.te.TEWatchmakersWorkbench;
import watchcraft.items.band.IBand;
import watchcraft.items.watch.IWatch;

/**
 * Created by osumf on 8/6/2015.
 */
public class ContainerWatchmakersWorkbench extends Container {

    public InventoryPlayer inventoryPlayer;
    public TEWatchmakersWorkbench teWatchmakersWorkbench;

    public ContainerWatchmakersWorkbench(EntityPlayer player, TEWatchmakersWorkbench teWatchmakersWorkbench)
    {
        this.inventoryPlayer = player.inventory;
        this.teWatchmakersWorkbench = teWatchmakersWorkbench;


        //Player inventory
        for (int column = 0; column < 3; column++)
        {
            for (int row = 0; row < 9; row++)
            {
                addSlotToContainer(new Slot(inventoryPlayer, row + column * 9 + 9, 9 + row * 18, 84 + column * 18));
            }
        }

        for (int column = 0; column < 9; column++)
        {
            addSlotToContainer(new Slot(inventoryPlayer, column, 8 + column * 18, 142));
        }


        //Mine
        WCSlot.ISlotBlacklist watchSlot = (ItemStack i) -> { return i.getItem() instanceof IWatch; };
        addSlotToContainer(new WCSlot(teWatchmakersWorkbench, 0, 80, 8, watchSlot));

        WCSlot.ISlotBlacklist sBand = (ItemStack i) -> { return i.getItem() instanceof IBand; };
        WCSlot.ISlotBlacklist sCase = (ItemStack i) -> { return i.getItem() instanceof IWatch; };
        WCSlot.ISlotBlacklist sCrown = (ItemStack i) -> { return i.getItem() instanceof IWatch; };
        WCSlot.ISlotBlacklist sCrystal = (ItemStack i) -> { return i.getItem() instanceof IWatch; };
        WCSlot.ISlotBlacklist sMovement = (ItemStack i) -> { return i.getItem() instanceof IWatch; };
        for (int column = 0; column < 5; column++)
        {
            addSlotToContainer(new WCSlot(teWatchmakersWorkbench, 1 + column, 8 + column * 36, 40, sBand));
        }
        for (int column = 0; column < 9; column++)
        {
            addSlotToContainer(new WCSlot(teWatchmakersWorkbench, 6 + column, 8 + column * 18, 62, watchSlot));
        }
    }

    @Override
    public boolean canInteractWith(EntityPlayer p_75145_1_) {
        return true;
    }

    @Override
    public ItemStack transferStackInSlot(EntityPlayer p_82846_1_, int p_82846_2_) {
        return null;
    }
}
