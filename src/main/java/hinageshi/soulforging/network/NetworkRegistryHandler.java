package hinageshi.soulforging.network;

import hinageshi.soulforging.SoulForging;
import net.minecraftforge.fml.common.network.NetworkRegistry;

public class NetworkRegistryHandler {
    public static void register(){
        NetworkRegistry.INSTANCE.registerGuiHandler(SoulForging.MODID,new SoulForgingGuiHandler());
    }
}
