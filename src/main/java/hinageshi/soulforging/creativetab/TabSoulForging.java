package hinageshi.soulforging.creativetab;

import hinageshi.soulforging.item.ItemRegistryHandler;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class TabSoulForging extends CreativeTabs {
    public static final TabSoulForging TAB_SOUL_FORGING=new TabSoulForging();

    public TabSoulForging(){
        super("soulforging");
    }

    @Override
    public ItemStack getTabIconItem() {
        return new ItemStack(ItemRegistryHandler.ITEM_SOUL_GOLD);
    }

//    @Override
//    public boolean hasSearchBar(){
//        return true;
//    }
//    @Override
//    public int getSearchbarWidth(){
//        return 45;
//    }
}
