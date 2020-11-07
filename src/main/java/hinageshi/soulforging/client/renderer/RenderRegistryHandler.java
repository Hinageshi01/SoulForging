package hinageshi.soulforging.client.renderer;

import hinageshi.soulforging.entity.EntityDementor;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

public class RenderRegistryHandler {
    public static void register(){
        RenderingRegistry.registerEntityRenderingHandler(EntityDementor.class,RenderDementor::new);
    }
}
