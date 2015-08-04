package watchcraft.client;

import cpw.mods.fml.client.registry.ClientRegistry;
import net.minecraft.client.settings.KeyBinding;
import org.lwjgl.input.Keyboard;

/**
 * Created by osumf on 8/1/2015.
 */
public class KeyBindings {

    public static KeyBinding viewWatch;

    public static KeyBinding txp;
    public static KeyBinding txn;
    public static KeyBinding typ;
    public static KeyBinding tyn;
    public static KeyBinding tzp;
    public static KeyBinding tzn;
    public static KeyBinding rxp;
    public static KeyBinding ryp;
    public static KeyBinding rzp;
    public static KeyBinding rxn;
    public static KeyBinding ryn;
    public static KeyBinding rzn;
    public static KeyBinding reset;

    public static void init()
    {
        viewWatch = new KeyBinding("key.viewWatch", Keyboard.KEY_F, "key.categories.watchcraft");
        ClientRegistry.registerKeyBinding(viewWatch);

        txp = new KeyBinding("key.txp1", Keyboard.KEY_1, "key.categories.watchcraft");
        txn = new KeyBinding("key.txp2", Keyboard.KEY_2, "key.categories.watchcraft");
        typ = new KeyBinding("key.txp3", Keyboard.KEY_3, "key.categories.watchcraft");
        tyn = new KeyBinding("key.txp4", Keyboard.KEY_4, "key.categories.watchcraft");
        tzp = new KeyBinding("key.txp5", Keyboard.KEY_5, "key.categories.watchcraft");
        tzn = new KeyBinding("key.txp6", Keyboard.KEY_6, "key.categories.watchcraft");
        rxp = new KeyBinding("key.txp7", Keyboard.KEY_7, "key.categories.watchcraft");
        ryp = new KeyBinding("key.txp8", Keyboard.KEY_8, "key.categories.watchcraft");
        rzp = new KeyBinding("key.txp9", Keyboard.KEY_9, "key.categories.watchcraft");
        rxn = new KeyBinding("key.txp99", Keyboard.KEY_U, "key.categories.watchcraft");
        ryn = new KeyBinding("key.txp999", Keyboard.KEY_I, "key.categories.watchcraft");
        rzn = new KeyBinding("key.txp99967", Keyboard.KEY_O, "key.categories.watchcraft");
        reset = new KeyBinding("key.tx543345p", Keyboard.KEY_R, "key.categories.watchcraft");
        ClientRegistry.registerKeyBinding(txp);
        ClientRegistry.registerKeyBinding(txn);
        ClientRegistry.registerKeyBinding(typ);
        ClientRegistry.registerKeyBinding(tyn);
        ClientRegistry.registerKeyBinding(tzp);
        ClientRegistry.registerKeyBinding(tzn);
        ClientRegistry.registerKeyBinding(rxp);
        ClientRegistry.registerKeyBinding(ryp);
        ClientRegistry.registerKeyBinding(rzp);
        ClientRegistry.registerKeyBinding(rxn);
        ClientRegistry.registerKeyBinding(ryn);
        ClientRegistry.registerKeyBinding(rzn);
        ClientRegistry.registerKeyBinding(reset);
    }
}
