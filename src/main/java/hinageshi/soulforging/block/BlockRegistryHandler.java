package hinageshi.soulforging.block;

import net.minecraft.block.Block;
import net.minecraftforge.event.RegistryEvent.Register;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;

@Mod.EventBusSubscriber
public class BlockRegistryHandler {
    public static final BlockSoulBlock BLOCK_SOUL_BLOCK=new BlockSoulBlock();

    @SubscribeEvent
    public static void onRegistry(Register<Block> event){
        IForgeRegistry<Block> registry=event.getRegistry();
        registry.register(BLOCK_SOUL_BLOCK);
    }
}
