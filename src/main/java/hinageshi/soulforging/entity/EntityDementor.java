package hinageshi.soulforging.entity;

import hinageshi.soulforging.SoulForging;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.IAttributeInstance;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.World;

import java.util.UUID;

public class EntityDementor extends EntityMob {
    public static final String ID = "dementor";
    public static final String NAME = SoulForging.MODID + ".Dementor";
    private static final UUID SPEED_BOOST =UUID.fromString("e0b89eca-304c-460c-a19b-fcde3b5944ba");

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
        this.tasks.addTask(1,new EntityAIAttackMelee(this,1.0,false));
        this.tasks.addTask(2,new EntityAIWanderAvoidWater(this,0.8));
        this.tasks.addTask(3,new AIChangeSandToSoulSand(this));
        this.tasks.addTask(4,new EntityAIWatchClosest(this, EntityPlayer.class,8.0F));
        this.tasks.addTask(5,new EntityAILookIdle(this));

        //this.targetTasks.addTask(0,new EntityAIHurtByTarget(this,false));//Only attack when hurt by target
        this.targetTasks.addTask(0,new EntityAINearestAttackableTarget<>(this,EntityPlayer.class,true));//Initiative attack
    }

    @Override
    protected void applyEntityAttributes(){
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(25.0);
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(3.0);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.3);
    }

    @Override
    public void setAttackTarget(EntityLivingBase entity){
        super.setAttackTarget(entity);
        IAttributeInstance attribute=this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED);
        if(entity==null){
            attribute.removeModifier(SPEED_BOOST);
        }
        else if(attribute.getModifier(SPEED_BOOST)!=null){
            attribute.applyModifier(new AttributeModifier(SPEED_BOOST,"Speed boost",0.5,2).setSaved(false));//not save to archive
        }
    }

    @Override
    public IEntityLivingData onInitialSpawn(DifficultyInstance difficulty,IEntityLivingData data){
        IAttributeInstance attribute=this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH);
        attribute.applyModifier(new AttributeModifier("Health boost",this.rand.nextInt(6),0));
        return super.onInitialSpawn(difficulty,data);
    }
}
