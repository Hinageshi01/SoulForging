package hinageshi.soulforging.villager;

import hinageshi.soulforging.SoulForging;
import hinageshi.soulforging.block.BlockRegistryHandler;
import hinageshi.soulforging.item.ItemRegistryHandler;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.VillagerRegistry.VillagerCareer;
import net.minecraftforge.fml.common.registry.VillagerRegistry.VillagerProfession;
import net.minecraftforge.registries.IForgeRegistry;

@EventBusSubscriber
public class VillagerRegistryHandler {
    public static final VillagerProfession FERRYMAN =
        new VillagerProfession(SoulForging.MODID + ":ferryman",
            SoulForging.MODID + ":textures/entity/villager/ferryman.png",
            SoulForging.MODID + ":textures/entity/zombie_villager/zombie_ferryman.png");
    public static final VillagerCareer FERRYMAN_CAREER =
        new VillagerCareer(FERRYMAN,SoulForging.MODID + ".ferryman");

    @SubscribeEvent
    public static void onRegistry(RegistryEvent.Register<VillagerProfession> event){
        IForgeRegistry<VillagerProfession> registry = event.getRegistry();
        FERRYMAN_CAREER.addTrade(1,
            new EntityVillager.EmeraldForItems(ItemRegistryHandler.ITEM_BROKEN_SOUL,
                new EntityVillager.PriceInfo(30,46)),
            new EntityVillager.ListEnchantedItemForEmeralds(Item.getItemFromBlock(BlockRegistryHandler.BLOCK_SOUL_BLOCK),
                new EntityVillager.PriceInfo(1, 2))
        );
        FERRYMAN_CAREER.addTrade(2,
            new EntityVillager.EmeraldForItems(ItemRegistryHandler.ITEM_CRYSTALLIZED_SOUL,
                new EntityVillager.PriceInfo(16,22)),
            new EntityVillager.EmeraldForItems(ItemRegistryHandler.ITEM_PURE_SOUL,
                new EntityVillager.PriceInfo(14,25))
        );
        registry.register(FERRYMAN);
    }
}
