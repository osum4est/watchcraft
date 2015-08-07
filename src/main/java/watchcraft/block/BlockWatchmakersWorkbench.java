package watchcraft.block;

import cpw.mods.fml.common.network.internal.FMLNetworkHandler;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import watchcraft.WatchCraft;
import watchcraft.block.te.TEWatchmakersWorkbench;
import watchcraft.network.SimplePacket;
import watchcraft.network.WCPacketHandler;
import watchcraft.player.WCPlayerHandler;

/**
 * Created by osumf on 8/6/2015.
 */
public class BlockWatchmakersWorkbench extends BlockContainer {

    public BlockWatchmakersWorkbench(String name)
    {
        super(Material.wood);
        setCreativeTab(CreativeTabs.tabMisc);
        setHardness(2f);
        setStepSound(Block.soundTypeWood);
        setBlockName(name);
    }

    @Override
    public TileEntity createNewTileEntity(World world, int p2) {
        return new TEWatchmakersWorkbench();
    }

    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float p_149727_7_, float p_149727_8_, float p_149727_9_) {

        if (!world.isRemote)
            FMLNetworkHandler.openGui(player, WatchCraft.instance, 1, world, x, y, z);

        return true;
    }
}
