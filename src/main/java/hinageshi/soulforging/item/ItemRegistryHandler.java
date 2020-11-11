package hinageshi.soulforging.item;

import hinageshi.soulforging.SoulForging;
import hinageshi.soulforging.block.BlockRegistryHandler;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.event.RegistryEvent.Register;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.registries.IForgeRegistry;

@EventBusSubscriber
public class ItemRegistryHandler {
    public static final Item.ToolMaterial SOUL_TOOL_MATERIAL= EnumHelper.addToolMaterial("SOUL",2,131,4.0F,1.0F, 5);
    public static final ItemSoulPickaxe SOUL_PICKAXE=new ItemSoulPickaxe();

    public static final ItemArmor.ArmorMaterial SOUL_GOLD_ARMOR_MATERIAL=EnumHelper.addArmorMaterial("SOUL_GOLD", SoulForging.MODID + ":soul_gold",43,new int[] {4,7,9,4},9, SoundEvents.ITEM_ARMOR_EQUIP_GOLD,3);
    public static final ItemSoulGoldArmor SOUL_GOLD_BOOTS=new ItemSoulGoldArmor(EntityEquipmentSlot.FEET);
    public static final ItemSoulGoldArmor SOUL_GOLD_LEGGINGS=new ItemSoulGoldArmor(EntityEquipmentSlot.LEGS);
    public static final ItemSoulGoldArmor SOUL_GOLD_CHESTPLATE=new ItemSoulGoldArmor(EntityEquipmentSlot.CHEST);
    public static final ItemSoulGoldArmor SOUL_GOLD_HELMET=new ItemSoulGoldArmor(EntityEquipmentSlot.HEAD);

    public static final ItemBlock ITEM_SOUL_BLOCK=withRegistryName(new ItemBlock(BlockRegistryHandler.BLOCK_SOUL_BLOCK));

    public static final ItemBrokenSoul BROKEN_SOUL=new ItemBrokenSoul();
    public static final ItemInnocentSoul INNOCENT_SOUL=new ItemInnocentSoul();
    public static final ItemSoulGold SOUL_GOLD=new ItemSoulGold();

    private static ItemBlock withRegistryName(ItemBlock item){
        item.setRegistryName(item.getBlock().getRegistryName());
        return item;
    }

    @SubscribeEvent
    public static void onRegistry(Register<Item> event){
        IForgeRegistry<Item> registry=event.getRegistry();
        registry.register(BROKEN_SOUL);
        registry.register(ITEM_SOUL_BLOCK);
        registry.register(SOUL_PICKAXE);
        registry.register(SOUL_GOLD_BOOTS);
        registry.register(SOUL_GOLD_LEGGINGS);
        registry.register(SOUL_GOLD_CHESTPLATE);
        registry.register(SOUL_GOLD_HELMET);
        registry.register(SOUL_GOLD);
        registry.register(INNOCENT_SOUL);
    }

    @SideOnly(Side.CLIENT)
    private static void registerModel(Item item){
        ModelResourceLocation modelResourceLocation=new ModelResourceLocation(item.getRegistryName(),"inventory");
        ModelLoader.setCustomModelResourceLocation(item,0,modelResourceLocation);
    }

    @SubscribeEvent
    @SideOnly(Side.CLIENT)
    public static void onModelRegistry(ModelRegistryEvent event) {
        registerModel(BROKEN_SOUL);
        registerModel(ITEM_SOUL_BLOCK);
        registerModel(SOUL_PICKAXE);
        registerModel(SOUL_GOLD_BOOTS);
        registerModel(SOUL_GOLD_LEGGINGS);
        registerModel(SOUL_GOLD_CHESTPLATE);
        registerModel(SOUL_GOLD_HELMET);
        registerModel(SOUL_GOLD);
        registerModel(INNOCENT_SOUL);
    }
}
