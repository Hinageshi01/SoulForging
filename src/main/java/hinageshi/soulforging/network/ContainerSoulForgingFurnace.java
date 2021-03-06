package hinageshi.soulforging.network;

import hinageshi.soulforging.tileentity.TileEntitySoulForgingFurnace;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IContainerListener;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
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

    private int compressorProgress=0;

    public int getCompressorProgress(){
        return this.compressorProgress;
    }

    public ContainerSoulForgingFurnace(EntityPlayer player,World world,int x,int y,int z){
        this.world=world;
        this.pos=new BlockPos(x,y,z);

        TileEntity tileEntity=world.getTileEntity(this.pos);
        Capability<IItemHandler> itemHandlerCapability= CapabilityItemHandler.ITEM_HANDLER_CAPABILITY;

        this.left=tileEntity.getCapability(itemHandlerCapability, EnumFacing.WEST);
        this.right=tileEntity.getCapability(itemHandlerCapability, EnumFacing.EAST);
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
    public void detectAndSendChanges(){//Send progress bar data to client from server
        super.detectAndSendChanges();
        TileEntity tileEntity=this.world.getTileEntity(this.pos);
        if(tileEntity instanceof TileEntitySoulForgingFurnace){
            int compressorProgress=((TileEntitySoulForgingFurnace) tileEntity).getCompressorProgress();
            if(compressorProgress != this.compressorProgress){
                this.compressorProgress=compressorProgress;
                for(IContainerListener listener : this.listeners){
                    listener.sendWindowProperty(this,0,compressorProgress);
                }
            }
        }
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void updateProgressBar(int id,int data){//Get progress bar data from server
        if(id == 0){
            this.compressorProgress=data;
        }
    }

    @Override
    public ItemStack transferStackInSlot(EntityPlayer player,int index){
        return ItemStack.EMPTY;
    }

    @Override
    public boolean canInteractWith(EntityPlayer player){
        return player.world.equals(this.world)&&player.getDistanceSq(this.pos)<=64.0;
    }
}
