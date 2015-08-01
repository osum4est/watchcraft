package watchcraft.client;

import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.common.MinecraftForge;
import tconstruct.client.tabs.InventoryTabVanilla;
import tconstruct.client.tabs.TabRegistry;
import watchcraft.client.tabs.InventoryTabWatchCraft;
import watchcraft.common.WCProxyCommon;

public class WCProxyClient extends WCProxyCommon{

    @Override
    public void postInit(FMLPostInitializationEvent event)
    {
        registerInventoryTabs();
    }

    public void registerInventoryTabs()
    {
        if (!Loader.isModLoaded("TConstruct") && TabRegistry.getTabList().size() < 1)
        {
            TabRegistry.registerTab(new InventoryTabVanilla());
        }

        TabRegistry.registerTab(new InventoryTabWatchCraft());

        MinecraftForge.EVENT_BUS.register(new TabRegistry());
    }
}
