package watchcraft.inventory;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import watchcraft.block.te.TEWatchmakersWorkbench;

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
                addSlotToContainer(new Slot(inventoryPlayer, row + column * 9 + 9, 48 + row * 18, 174 + column * 18));
            }
        }

        for (int column = 0; column < 9; column++)
        {
            addSlotToContainer(new Slot(inventoryPlayer, column, 48 + column * 18, 232));
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
