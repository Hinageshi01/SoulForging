package hinageshi.soulforging.tileentity;

import hinageshi.soulforging.SoulForging;
import hinageshi.soulforging.item.ItemRegistryHandler;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;

import javax.annotation.Nullable;

public class TileEntitySoulForgingFurnace extends TileEntity implements ITickable {
    public static final String ID= SoulForging.MODID+":soul_forging_furnace";
    private int compressorProgress=0;

    public int getCompressorProgress(){
        return this.compressorProgress;
    }

    private final ItemStackHandler left =new ItemStackHandler(1){
        @Override
        protected void onContentsChanged(int slot){
            TileEntitySoulForgingFurnace.this.markDirty();//markDirty to save in archive
        }
    };
    private final ItemStackHandler right =new ItemStackHandler(1){
        @Override
        protected void onContentsChanged(int slot){
            TileEntitySoulForgingFurnace.this.markDirty();
        }
    };
    private final ItemStackHandler side=new ItemStackHandler(1){
        @Override
        protected void onContentsChanged(int slot){
            TileEntitySoulForgingFurnace.this.markDirty();
        }
    };
    private final ItemStackHandler down=new ItemStackHandler(1){
        @Override
        protected void onContentsChanged(int slot){
            TileEntitySoulForgingFurnace.this.markDirty();
        }
    };

    @Override
    public void readFromNBT(NBTTagCompound compound){//deserialization
        this.compressorProgress=compound.getInteger("Progress");
        this.down.deserializeNBT(compound.getCompoundTag("Down"));
        this.side.deserializeNBT(compound.getCompoundTag("Side"));
        this.left.deserializeNBT(compound.getCompoundTag("Left"));
        this.right.deserializeNBT(compound.getCompoundTag("Right"));
        super.readFromNBT(compound);
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound compound){//serialization
        compound.setInteger("Progress",this.compressorProgress);
        compound.setTag("Down",this.down.serializeNBT());
        compound.setTag("Side",this.side.serializeNBT());
        compound.setTag("Left",this.left.serializeNBT());
        compound.setTag("Right",this.right.serializeNBT());
        return super.writeToNBT(compound);
    }

    @Override
    public void update(){
        Item coal= Items.COAL;
        boolean canExtractInput=coal.equals(this.down.extractItem(0,1,true).getItem());
        if(canExtractInput){
            if(this.compressorProgress % 20 == 0){//Each 20 ticks
                Item soul= ItemRegistryHandler.ITEM_PURE_SOUL;
                boolean canExtractSoul=soul.equals(this.left.extractItem(0,1,true).getItem());
                if(canExtractSoul){
                    this.left.extractItem(0,1,false);
                    this.compressorProgress += 1;
                }
            }
            else {
                this.compressorProgress += 1;
                if(this.compressorProgress >= 240){
                    ItemStack soulGold=new ItemStack(ItemRegistryHandler.ITEM_SOUL_GOLD);
                    boolean canInsertSoulGold=this.side.insertItem(0,soulGold,true).isEmpty();
                    if(canInsertSoulGold){
                        this.side.insertItem(0,soulGold,false);
                        this.right.extractItem(0,1,false);
                        this.down.extractItem(0,1,false);
                        this.compressorProgress = 0;
                    }
                    else {
                        this.compressorProgress -= 1;
                    }
                }
                else {
                    this.markDirty();
                }
            }
        }
        else if(this.compressorProgress > 0){
            this.compressorProgress = 0;
            this.markDirty();
        }
    }

    @Override
    public boolean hasCapability(Capability<?> capability, @Nullable EnumFacing facing){
        Capability<IItemHandler> itemHandlerCapability= CapabilityItemHandler.ITEM_HANDLER_CAPABILITY;
        return itemHandlerCapability.equals(capability) || super.hasCapability(capability,facing);
    }

    @Override
    public <T> T getCapability(Capability<T> capability,@Nullable EnumFacing facing){
        Capability<IItemHandler> itemHandlerCapability=CapabilityItemHandler.ITEM_HANDLER_CAPABILITY;
        if(itemHandlerCapability.equals(capability)){
            if(EnumFacing.WEST.equals(facing)){
                return itemHandlerCapability.cast(this.left);//The direction of item slot's interaction
            }
            if(EnumFacing.EAST.equals(facing)){
                return itemHandlerCapability.cast(this.right);
            }
            if(EnumFacing.DOWN.equals(facing)){
                return itemHandlerCapability.cast(this.side);
            }
            return itemHandlerCapability.cast(this.down);
        }
        return super.getCapability(capability,facing);
    }
}
