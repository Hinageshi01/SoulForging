package hinageshi.soulforging.item;

import hinageshi.soulforging.SoulForging;
import hinageshi.soulforging.block.BlockRegistryHandler;
import hinageshi.soulforging.creativetab.TabSoulForging;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;

public class ItemSoulPickaxe extends ItemPickaxe {
    public ItemSoulPickaxe(){
        super(ItemRegistryHandler.SOUL_TOOL_MATERIAL);
        this.setUnlocalizedName(SoulForging.MODID + ".soulPickaxe");
        this.setCreativeTab(TabSoulForging.TAB_SOUL_FORGING);
        this.setRegistryName("soul_pickaxe");
    }

    @Override
    public float getDestroySpeed(ItemStack stack, IBlockState state){
        Block block=state.getBlock();
        float speed=super.getDestroySpeed(stack,state);
        return (block == Blocks.SOUL_SAND || block == BlockRegistryHandler.BLOCK_SOUL_BLOCK) ? speed * 10 : speed;
    }
}
