package hinageshi.soulforging.item;

import hinageshi.soulforging.SoulForging;
import hinageshi.soulforging.creativetab.TabSoulForging;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;

public class ItemSoulGoldArmor extends ItemArmor {
    public ItemSoulGoldArmor(EntityEquipmentSlot equipmentSlot){
        super(ItemRegistryHandler.SOUL_GOLD_ARMOR_MATERIAL,0,equipmentSlot);
        this.setUnlocalizedName(SoulForging.MODID + ".soulGoldArmor." + equipmentSlot.getName());
        this.setRegistryName("soul_gold_armor_" + equipmentSlot.getName());
        this.setCreativeTab(TabSoulForging.TAB_SOUL_FORGING);
    }
}
