package watchcraft.network;

import cpw.mods.fml.common.network.simpleimpl.IMessage;
import io.netty.buffer.ByteBuf;

/**
 * Created by osumf on 8/1/2015.
 */
public class SimplePacket implements IMessage {

    public SimplePacket(){}

    public int value;
    public SimplePacket(int value)
    {
        this.value = value;
    }

    @Override
    public void fromBytes(ByteBuf buf) {
        value = buf.readInt();
    }

    @Override
    public void toBytes(ByteBuf buf) {
        buf.writeInt(value);
    }
}
