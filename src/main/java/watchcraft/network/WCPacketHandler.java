package watchcraft.network;

import cpw.mods.fml.common.network.FMLIndexedMessageToMessageCodec;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraft.entity.player.EntityPlayerMP;
import watchcraft.WatchCraft;

/**
 * Created by osumf on 8/1/2015.
 */
public class WCPacketHandler implements IMessageHandler<SimplePacket, IMessage> {
    public static final SimpleNetworkWrapper INSTANCE = NetworkRegistry.INSTANCE.newSimpleChannel(WatchCraft.MODID);

    @Override
    public IMessage onMessage(SimplePacket message, MessageContext ctx) {
        EntityPlayerMP serverPlayer = ctx.getServerHandler().playerEntity;

        switch (message.value)
        {
            case 0:
                serverPlayer.openGui(WatchCraft.instance, 0, serverPlayer.worldObj, (int)serverPlayer.posX, (int)serverPlayer.posY, (int)serverPlayer.posZ);
        }

        return null;
    }
}
