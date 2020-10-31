package hinageshi.soulforging.item;

import hinageshi.soulforging.SoulForging;
import hinageshi.soulforging.creativetab.TabSoulForging;
import net.minecraft.item.Item;

public class ItemSoulGold extends Item {
    public ItemSoulGold(){
        this.setUnlocalizedName(SoulForging.MODID + ".soulGold");
        this.setCreativeTab(TabSoulForging.TAB_SOUL_FORGING);
        this.setRegistryName("soul_gold");
        this.setMaxStackSize(64);
    }
}
