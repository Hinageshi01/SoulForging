package hinageshi.soulforging.crafting;

import hinageshi.soulforging.item.ItemRegistryHandler;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class FurnaceRecipeRegistryHandler {
    public static void register(){
        GameRegistry.addSmelting(ItemRegistryHandler.ITEM_SOUL_BLOCK,new ItemStack(ItemRegistryHandler.ITEM_CRYSTALLIZED_SOUL),0.2F);
    }
}
