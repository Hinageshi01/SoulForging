package hinageshi.soulforging.client.renderer;

import hinageshi.soulforging.SoulForging;
import hinageshi.soulforging.client.model.ModelDementor;
import hinageshi.soulforging.entity.EntityDementor;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.Entity;

public class RenderDementor extends RenderLiving {
    private static final ResourceLocation ENTITY_DEMENTOR_TEXTURE = new ResourceLocation(
            SoulForging.MODID + ":textures/entity/" + EntityDementor.ID + "/" + EntityDementor.ID + ".png");

    public RenderDementor(RenderManager manager){
        super(manager,new ModelDementor(),0.6F);
    }

    @Override
    protected ResourceLocation getEntityTexture(Entity entity){
        return ENTITY_DEMENTOR_TEXTURE;
    }
}
