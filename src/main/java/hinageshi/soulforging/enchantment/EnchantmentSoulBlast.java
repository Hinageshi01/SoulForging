package hinageshi.soulforging.enchantment;

import hinageshi.soulforging.SoulForging;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnumEnchantmentType;
import net.minecraft.inventory.EntityEquipmentSlot;

public class EnchantmentSoulBlast extends Enchantment {
    public EnchantmentSoulBlast(){
        super(Rarity.RARE, EnumEnchantmentType.WEAPON,new EntityEquipmentSlot[] {EntityEquipmentSlot.MAINHAND});
        this.setName(SoulForging.MODID + ".soulBlast");
        this.setRegistryName("soulBlast");
    }

    @Override
    public int getMaxLevel(){
        return 3;
    }

    @Override
    public int getMinEnchantability(int enchantmentLevel){
        return 16 + enchantmentLevel * 5;
    }

    @Override
    public int getMaxEnchantability(int enchantmentLevel){
        return 21 + enchantmentLevel * 5;
    }
}
