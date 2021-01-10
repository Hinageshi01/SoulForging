package hinageshi.soulforging.event;

import hinageshi.soulforging.enchantment.EnchantmentRegistryHandler;
import hinageshi.soulforging.uitl.LootUtils;

import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.storage.loot.LootTable;
import net.minecraft.world.storage.loot.RandomValueRange;
import net.minecraft.world.storage.loot.functions.LootFunction;
import net.minecraft.world.storage.loot.functions.LootingEnchantBonus;
import net.minecraftforge.event.LootTableLoadEvent;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.ArrayList;

import static hinageshi.soulforging.item.ItemRegistryHandler.ITEM_BROKEN_SOUL;
import static hinageshi.soulforging.item.ItemRegistryHandler.ITEM_INNOCENT_SOUL;

@EventBusSubscriber
public class EventHandler {
    private static void addItemToEntityTable(LootTableLoadEvent event,LootTable loot,String entityName,boolean isMob){
        if(event.getName().getResourcePath().equals("entities/" + entityName)) {
            if(isMob){
                LootUtils.addItemToTable(loot, ITEM_BROKEN_SOUL, 1, 1, 1, 1, 3, 0, 1, "soulforging:broken_soul", new LootUtils.IMethod() {
                        @Override
                        public void FunctionsCallback(ArrayList<LootFunction> lootfuncs) {
                            LootFunction looting= new LootingEnchantBonus(null, new RandomValueRange(0,1),0);
                            lootfuncs.add(looting);
                        }
                    }
                );
            }
            else {
                LootUtils.addItemToTable(loot, ITEM_INNOCENT_SOUL, 1, 1, 1, 1, 3, 0, 1, "soulforging:innocent_soul", new LootUtils.IMethod() {
                        @Override
                        public void FunctionsCallback(ArrayList<LootFunction> lootfuncs) {
                            LootFunction looting= new LootingEnchantBonus(null, new RandomValueRange(1,3),0);
                            lootfuncs.add(looting);
                        }
                    }
                );
            }
        }
    }

    @SubscribeEvent
    public static void onLootLoad(LootTableLoadEvent event){
        LootTable loot = event.getTable();
        addItemToEntityTable(event,loot,"chicken",false);
        addItemToEntityTable(event,loot,"cow",false);
        addItemToEntityTable(event,loot,"iron_golem",false);
        addItemToEntityTable(event,loot,"pig",false);
        addItemToEntityTable(event,loot,"sheep",false);
        addItemToEntityTable(event,loot,"snowman",false);
        addItemToEntityTable(event,loot,"villager",false);
        addItemToEntityTable(event,loot,"wolf",false);

        addItemToEntityTable(event,loot,"blaze",true);
        addItemToEntityTable(event,loot,"creeper",true);
        addItemToEntityTable(event,loot,"enderman",true);
        addItemToEntityTable(event,loot,"ghast",true);
        addItemToEntityTable(event,loot,"silverfish",true);
        addItemToEntityTable(event,loot,"skeleton",true);
        addItemToEntityTable(event,loot,"slime",true);
        addItemToEntityTable(event,loot,"spider",true);
        addItemToEntityTable(event,loot,"witch",true);
        addItemToEntityTable(event,loot,"zombie",true);

        //Specially handle BOSS's drop
        if(event.getName().getResourcePath().equals("entities/elder_guardian"))
            LootUtils.addItemToTable(loot, ITEM_BROKEN_SOUL, 1, 1, 1, 1, 3, 0, 1, "soulforging:broken_soul");
        if(event.getName().getResourcePath().equals("entities/ender_dragon"))
            LootUtils.addItemToTable(loot, ITEM_BROKEN_SOUL, 1, 1, 1, 1, 3, 0, 1, "soulforging:broken_soul");
    }

    @SubscribeEvent
    @SideOnly(Side.CLIENT)
    public static void onPlayerJoin(EntityJoinWorldEvent event){
        Entity entity=event.getEntity();
        if(entity instanceof EntityPlayer){
            String message="Welcome to SoulForging.";
            TextComponentString text=new TextComponentString(message);
            entity.sendMessage(text);
        }
    }

    @SubscribeEvent
    public static void onLivingDeath(LivingDeathEvent event){
        Entity source =event.getSource().getImmediateSource();
        if(source instanceof EntityPlayer && !source.world.isRemote){
            EntityPlayer player=(EntityPlayer) source;
            ItemStack heldItemMainhand=player.getHeldItemMainhand();
            int level= EnchantmentHelper.getEnchantmentLevel(EnchantmentRegistryHandler.SOUL_HARVEST,heldItemMainhand);
            Entity target=event.getEntity();
            if(level > 0){
                //DO SOMETHING
            }
        }
    }
}
