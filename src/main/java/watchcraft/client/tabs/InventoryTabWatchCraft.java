package watchcraft.client.tabs;

import cpw.mods.fml.common.network.internal.FMLNetworkHandler;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import tconstruct.client.tabs.AbstractTab;
import watchcraft.WatchCraft;
import watchcraft.network.SimplePacket;
import watchcraft.network.WCPacketHandler;

/**
 * Created by osumf on 7/31/2015.
 */
public class InventoryTabWatchCraft extends AbstractTab {

    public InventoryTabWatchCraft()
    {
        super(0, 0, 0, new ItemStack(WatchCraft.itemBasicWatch));
    }

    @Override
    public void onTabClicked() {
        EntityPlayer player = Minecraft.getMinecraft().thePlayer;
        WCPacketHandler.INSTANCE.sendToServer(new SimplePacket(0));

    }

    @Override
    public boolean shouldAddToList() {
        return true;
    }
}
