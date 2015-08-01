package watchcraft;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.relauncher.Side;
import net.minecraftforge.common.MinecraftForge;
import watchcraft.common.WCProxyCommon;
import watchcraft.network.SimplePacket;
import watchcraft.network.WCPacketHandler;
import watchcraft.player.WCPlayerHandler;

@Mod(modid = WatchCraft.MODID, version = WatchCraft.VERSION)
public class WatchCraft
{
    public static final String MODID = "watchcraft";
    public static final String VERSION = "1.0";


    public static WCPlayerHandler playerHandler;


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
