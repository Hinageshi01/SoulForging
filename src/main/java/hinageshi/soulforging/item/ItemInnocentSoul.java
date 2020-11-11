package hinageshi.soulforging.item;

import hinageshi.soulforging.SoulForging;
import hinageshi.soulforging.creativetab.TabSoulForging;
import net.minecraft.item.Item;

public class ItemInnocentSoul extends Item {
    public ItemInnocentSoul(){
        this.setUnlocalizedName(SoulForging.MODID + ".innocentSoul");
        this.setCreativeTab(TabSoulForging.TAB_SOUL_FORGING);
        this.setRegistryName("innocent_soul");
        this.setMaxStackSize(64);
    }
}
