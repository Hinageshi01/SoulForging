package hinageshi.soulforging.enchantment;

import net.minecraft.enchantment.Enchantment;
import net.minecraftforge.event.RegistryEvent.Register;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;

@EventBusSubscriber
public class EnchantmentRegistryHandler {
    public static final EnchantmentSoulSteal SOUL_STEAL =new EnchantmentSoulSteal();

    @SubscribeEvent
    public static void onRegistry(Register<Enchantment> event){
        IForgeRegistry<Enchantment> registry=event.getRegistry();
        registry.register(SOUL_STEAL);
    }
}
