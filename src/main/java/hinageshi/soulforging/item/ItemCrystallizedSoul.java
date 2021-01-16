package hinageshi.soulforging.item;

import hinageshi.soulforging.SoulForging;
import hinageshi.soulforging.creativetab.TabSoulForging;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemDye;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ItemCrystallizedSoul extends Item {
    public ItemCrystallizedSoul(){
        this.setUnlocalizedName(SoulForging.MODID + ".crystallizedSoul");
        this.setCreativeTab(TabSoulForging.TAB_SOUL_FORGING);
        this.setRegistryName("crystallized_soul");
        this.setMaxStackSize(64);
    }

    @Override
    public EnumActionResult onItemUse(EntityPlayer player, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        ItemStack itemStack = new ItemStack(this);
        ItemStack item = player.getHeldItem(hand);

        if(!player.capabilities.isCreativeMode){
            item.shrink(1);
        }
        if (!player.canPlayerEdit(pos.offset(facing), facing, itemStack)) {
            return EnumActionResult.FAIL;
        }
        else {
            if (ItemDye.applyBonemeal(itemStack, worldIn, pos, player, hand)) {
                if (!worldIn.isRemote) {
                    worldIn.playEvent(2005, pos, 0);
                }
            }
            return EnumActionResult.SUCCESS;
        }
    }
}
