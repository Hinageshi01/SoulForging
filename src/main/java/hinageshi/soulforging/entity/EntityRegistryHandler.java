package hinageshi.soulforging.entity;

import net.minecraft.entity.EnumCreatureType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.EntityEntry;
import net.minecraftforge.fml.common.registry.EntityEntryBuilder;
import net.minecraftforge.registries.IForgeRegistry;

@EventBusSubscriber
public class EntityRegistryHandler {
    public static final EntityEntry DEMENTOR =
            EntityEntryBuilder.create().entity(EntityDementor.class).id(EntityDementor.ID,0).name(EntityDementor.NAME).
                    tracker(80,3,true).egg(0x000000,0xb31212).//underpainting color, spots color
                            spawn(EnumCreatureType.MONSTER,80,4,4,EntityDementor.BIOMES).build();

    @SubscribeEvent
    public static void onRegistry(RegistryEvent.Register<EntityEntry> event){
        IForgeRegistry<EntityEntry> registry = event.getRegistry();
        registry.register(DEMENTOR);
    }
}
