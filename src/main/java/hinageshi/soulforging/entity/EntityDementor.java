package hinageshi.soulforging.entity;

import hinageshi.soulforging.SoulForging;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class EntityDementor extends EntityMob {
    public static final String ID = "dementor";
    public static final String NAME = SoulForging.MODID + ".Dementor";

    public EntityDementor(World worldIn){
        super(worldIn);
        this.setSize(0.8F,0.8F);
    }

    private static class AIChangeSandToSoulSand extends EntityAIBase{
        private final EntityDementor entity;
        private AIChangeSandToSoulSand(EntityDementor entity){
            this.entity=entity;
        }

        @Override
        public void updateTask(){
            BlockPos blockPos=new BlockPos(this.entity.posX,this.entity.posY - 0.2,this.entity.posZ);
            this.entity.world.setBlockState(blockPos, Blocks.SOUL_SAND.getDefaultState());
        }

        @Override
        public boolean shouldExecute(){
            BlockPos blockPos=new BlockPos(this.entity.posX,this.entity.posY - 0.2,this.entity.posZ);
            return this.entity.world.getBlockState(blockPos).getBlock()==Blocks.SAND;
        }
    }

    @Override
    protected void initEntityAI() {
        this.tasks.addTask(0,new EntityAISwimming(this));
        this.tasks.addTask(1,new EntityAIAttackMelee(this,0.4,false));
        this.tasks.addTask(2,new EntityAIWanderAvoidWater(this,0.8));
        this.tasks.addTask(3,new AIChangeSandToSoulSand(this));
        this.tasks.addTask(4,new EntityAIWatchClosest(this, EntityPlayer.class,8.0F));
        this.tasks.addTask(5,new EntityAILookIdle(this));

        //this.targetTasks.addTask(0,new EntityAIHurtByTarget(this,false));
        this.targetTasks.addTask(0,new EntityAINearestAttackableTarget<>(this,EntityPlayer.class,true));
    }
}
