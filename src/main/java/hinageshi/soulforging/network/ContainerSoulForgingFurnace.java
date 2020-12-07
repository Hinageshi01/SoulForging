package hinageshi.soulforging.network;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;

public class ContainerSoulForgingFurnace extends Container {
    private final World world;
    private final BlockPos pos;

    private final IItemHandler left;
    private final IItemHandler right;
    private final IItemHandler side;
    private final IItemHandler down;

    public ContainerSoulForgingFurnace(EntityPlayer player,World world,int x,int y,int z){
        this.world=world;
        this.pos=new BlockPos(x,y,z);

        TileEntity tileEntity=world.getTileEntity(this.pos);
        Capability<IItemHandler> itemHandlerCapability= CapabilityItemHandler.ITEM_HANDLER_CAPABILITY;

        this.left =tileEntity.getCapability(itemHandlerCapability, EnumFacing.WEST);
        this.right =tileEntity.getCapability(itemHandlerCapability, EnumFacing.EAST);
        this.side=tileEntity.getCapability(itemHandlerCapability, EnumFacing.DOWN);
        this.down=tileEntity.getCapability(itemHandlerCapability, EnumFacing.UP);

        InventoryPlayer inventoryPlayer=player.inventory;
        this.addSlotToContainer(new SlotItemHandler(this.left,0,27,20));
        this.addSlotToContainer(new SlotItemHandler(this.right,0,59,20));
        this.addSlotToContainer(new SlotItemHandler(this.down,0,43,54));
        this.addSlotToContainer(new SlotItemHandler(this.side,0,129,36));
        int[] range=new int[] {0,1,2,3,4,5,6,7,8};
        for(int i : range){//Draw player's backpack
            this.addSlotToContainer(new Slot(inventoryPlayer,i + 0,8 + 18 * i,142));
            this.addSlotToContainer(new Slot(inventoryPlayer,i + 9,8 + 18 * i,84));
            this.addSlotToContainer(new Slot(inventoryPlayer,i + 18,8 + 18 * i,102));
            this.addSlotToContainer(new Slot(inventoryPlayer,i + 27,8 + 18 * i,120));
        }
    }

    @Override
    public ItemStack transferStackInSlot(EntityPlayer playerIn,int index){
        return ItemStack.EMPTY;
    }

    @Override
    public boolean canInteractWith(EntityPlayer playerIn){
        return playerIn.world.equals(this.world)&&playerIn.getDistanceSq(this.pos)<=64.0;
    }
}
