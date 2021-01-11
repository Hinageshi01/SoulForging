package hinageshi.soulforging.item;

import hinageshi.soulforging.SoulForging;
import hinageshi.soulforging.creativetab.TabSoulForging;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;

public class ItemSoulGoldSword extends ItemSword {
    public ItemSoulGoldSword(){
        super(ItemRegistryHandler.SOUL_GOLD_TOOL_MATERIAL);
        this.setUnlocalizedName(SoulForging.MODID + ".soulGoldSword");
        this.setCreativeTab(TabSoulForging.TAB_SOUL_FORGING);
        this.setRegistryName("soul_gold_sword");
    }

    @Override
    public float getDestroySpeed(ItemStack stack, IBlockState state){
        Block block=state.getBlock();
        float speed=super.getDestroySpeed(stack,state);
        return (block == Blocks.WEB) ? speed * 10 : speed;
    }
}
