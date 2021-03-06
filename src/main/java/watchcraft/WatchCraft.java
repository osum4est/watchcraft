package watchcraft;

import api.player.model.ModelPlayerAPI;
import api.player.render.RenderPlayerAPI;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.common.MinecraftForge;
import watchcraft.block.BlockWatchmakersWorkbench;
import watchcraft.block.te.TEWatchmakersWorkbench;
import watchcraft.common.WCProxyCommon;
import watchcraft.items.band.IBand;
import watchcraft.items.band.ItemBandRubber;
import watchcraft.items.watch.ItemBasicWatchAnalog;
import watchcraft.items.watch.ItemBasicWatchDigital;
import watchcraft.network.SimplePacket;
import watchcraft.network.WCPacketHandler;
import watchcraft.player.WCModelPlayerBase;
import watchcraft.player.WCPlayerHandler;
import watchcraft.player.WCRenderPlayerBase;
import watchcraft.watch.WatchHandler;

@Mod(modid = WatchCraft.MODID, version = WatchCraft.VERSION, name = WatchCraft.NAME)
public class WatchCraft
{
    public static final String MODID = "watchcraft";
    public static final String VERSION = "1.0";
    public static final String NAME = "Watchcraft";


    public static WCPlayerHandler playerHandler;
    public static WatchHandler watchHandler;

    public static Item itemBasicWatchDigital;
    public static Item itemBasicWatchAnalog;
    public static Item itemBandRubber;

    public static Block blockWatchmakersWorkbench;

    @SidedProxy(clientSide = "watchcraft.client.WCProxyClient", serverSide = "watchcraft.common.WCProxyCommon")
    public static WCProxyCommon proxy;

    @Instance(MODID)
    public static WatchCraft instance;


    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        proxy.preInit(event);

        playerHandler = new WCPlayerHandler();
        MinecraftForge.EVENT_BUS.register(playerHandler);

        watchHandler = new WatchHandler();

        itemBasicWatchDigital = new ItemBasicWatchDigital("itemBasicWatchDigital", 1);
        GameRegistry.registerItem(itemBasicWatchDigital, itemBasicWatchDigital.getUnlocalizedName());
        itemBasicWatchAnalog = new ItemBasicWatchAnalog("itemBasicWatchAnalog", 1);
        GameRegistry.registerItem(itemBasicWatchAnalog, itemBasicWatchAnalog.getUnlocalizedName());
        itemBandRubber = new ItemBandRubber("itemBandRubber", 1);
        GameRegistry.registerItem(itemBandRubber, itemBandRubber.getUnlocalizedName());

        blockWatchmakersWorkbench = new BlockWatchmakersWorkbench("blockWatchmakersWorkbench");
        GameRegistry.registerBlock(blockWatchmakersWorkbench, blockWatchmakersWorkbench.getUnlocalizedName());
        GameRegistry.registerTileEntity(TEWatchmakersWorkbench.class, "teWatchmakersWorkbench");

        RenderPlayerAPI.register(MODID, WCRenderPlayerBase.class);
        ModelPlayerAPI.register(MODID, WCModelPlayerBase.class);
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        proxy.init(event);

        WCPacketHandler.INSTANCE.registerMessage(WCPacketHandler.class, SimplePacket.class, 0, Side.SERVER);
        new GuiHandler();
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
        proxy.postInit(event);
    }
}
