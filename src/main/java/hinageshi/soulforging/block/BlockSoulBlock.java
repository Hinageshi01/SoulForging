package hinageshi.soulforging.block;

import hinageshi.soulforging.SoulForging;
import hinageshi.soulforging.creativetab.TabSoulForging;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockSoulBlock extends Block {
    public BlockSoulBlock(){
        super(Material.ROCK);
        this.setUnlocalizedName(SoulForging.MODID + ".soulBlock");
        this.setCreativeTab(TabSoulForging.TAB_SOUL_FORGING);
        this.setRegistryName("soul_block");
        this.setHarvestLevel("pickaxe",1);
        this.setHardness(0.5F);
        this.setLightLevel(1F);
    }
}
