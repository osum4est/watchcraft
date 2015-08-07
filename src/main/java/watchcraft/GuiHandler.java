package watchcraft;

import cpw.mods.fml.common.network.IGuiHandler;
import cpw.mods.fml.common.network.NetworkRegistry;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import watchcraft.block.te.TEWatchmakersWorkbench;
import watchcraft.client.gui.GuiWatchInventory;
import watchcraft.client.gui.GuiWatchmakersWorkbench;
import watchcraft.inventory.ContainerWatchInventory;
import watchcraft.inventory.ContainerWatchmakersWorkbench;
import watchcraft.player.WCPlayerStats;

/**
 * Created by osumf on 8/1/2015.
 */
public class GuiHandler implements IGuiHandler {

    public GuiHandler()
    {
        NetworkRegistry.INSTANCE.registerGuiHandler(WatchCraft.instance, this);
    }

    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {

        WCPlayerStats stats = WCPlayerStats.get(player);

        switch (ID)
        {
            case 0:
                System.out.println("Opening conatiner on server");
                return new ContainerWatchInventory(player, stats.watchInventory);
            case 1:
                TileEntity te = world.getTileEntity(x, y, z);
                if (te != null && te instanceof TEWatchmakersWorkbench)
                    return new ContainerWatchmakersWorkbench(player, (TEWatchmakersWorkbench)te);
        }

        return null;
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {

        WCPlayerStats stats = WCPlayerStats.get(player);

        System.out.println("Recieved client gui packet with id: " + ID);

        switch (ID)
        {
            case 0:
                return new GuiWatchInventory(player, stats.watchInventory);
            case 1:
                TileEntity te = world.getTileEntity(x, y, z);
                if (te != null && te instanceof TEWatchmakersWorkbench)
                    return new GuiWatchmakersWorkbench(player.inventory, (TEWatchmakersWorkbench)te);
        }

        return null;
    }
}
