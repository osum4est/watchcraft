package watchcraft.player;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.common.IExtendedEntityProperties;

/**
 * Created by osumf on 8/1/2015.
 */
public class WCPlayerStats implements IExtendedEntityProperties {

    public static final String PROP_NAME = "WCPlayerStats";

    public WatchInventory watchInventory;

    public WCPlayerStats()
    {
        this.watchInventory = new WatchInventory();
    }

    @Override
    public void saveNBTData(NBTTagCompound tag) {
        watchInventory.inventory[0].writeToNBT(tag);

    }

    @Override
    public void loadNBTData(NBTTagCompound tag) {
        watchInventory.inventory[0] = ItemStack.loadItemStackFromNBT(tag);
    }

    @Override
    public void init(Entity entity, World world) {

    }

    public static WCPlayerStats get (EntityPlayer player)
    {
        return (WCPlayerStats) player.getExtendedProperties(PROP_NAME);
    }

    public static void register (EntityPlayer player)
    {
        player.registerExtendedProperties(WCPlayerStats.PROP_NAME, new WCPlayerStats());
    }
}
