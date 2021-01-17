package hinageshi.soulforging.item;

import hinageshi.soulforging.SoulForging;
import hinageshi.soulforging.creativetab.TabSoulForging;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class ItemInnocentSoul extends ItemFood {
    public ItemInnocentSoul() {
        super(8,0.8F,false);
        this.setPotionEffect(new PotionEffect(MobEffects.WITHER,160,2), 1F);
        this.setAlwaysEdible();
        this.setUnlocalizedName(SoulForging.MODID + ".innocentSoul");
        this.setCreativeTab(TabSoulForging.TAB_SOUL_FORGING);
        this.setRegistryName("innocent_soul");
        this.setMaxStackSize(64);
    }

    @Override
    public void onFoodEaten(ItemStack stack, World worldIn, EntityPlayer player) {
        if (!worldIn.isRemote) {
            player.addPotionEffect(new PotionEffect(MobEffects.NAUSEA, 110, 1));
            player.addExperience(20);
        }
        super.onFoodEaten(stack, worldIn, player);
    }
}
