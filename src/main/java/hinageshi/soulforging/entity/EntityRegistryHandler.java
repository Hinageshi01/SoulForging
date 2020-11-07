package hinageshi.soulforging.entity;

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
                    tracker(80,3,true).build();

    @SubscribeEvent
    public static void onRegistry(RegistryEvent.Register<EntityEntry> event){
        IForgeRegistry<EntityEntry> registry = event.getRegistry();
        registry.register(DEMENTOR);
    }
}
