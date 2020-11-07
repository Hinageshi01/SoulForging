package hinageshi.soulforging.entity;

import hinageshi.soulforging.SoulForging;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.world.World;

public class EntityDementor extends EntityMob {
    public static final String ID = "dementor";
    public static final String NAME = SoulForging.MODID + ".Dementor";

    public EntityDementor(World worldIn){
        super(worldIn);
        this.setSize(0.8F,0.8F);
    }
}
