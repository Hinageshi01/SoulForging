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

import static hinageshi.soulforging.item.ItemRegistryHandler.BROKEN_SOUL;

@EventBusSubscriber
public class EventHandler {
    @SubscribeEvent
    public static void onLootLoad(LootTableLoadEvent event){
        LootTable loot = event.getTable();
        if(event.getName().getResourcePath().equals("entities/zombie")) {
            LootUtils.addItemToTable(loot, BROKEN_SOUL, 1, 1, 1, 2, 4, 0, 1, "soulforging:broken_soul",
                new LootUtils.IMethod() {
                    @Override
                    public void FunctionsCallback(ArrayList<LootFunction> lootfuncs) { LootFunction looting = new LootingEnchantBonus(null, new RandomValueRange(0,1), 0);
                        lootfuncs.add(looting);
                    }
                }
            );
        }
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
                //掉落更多灵魂
            }
        }
    }
}
