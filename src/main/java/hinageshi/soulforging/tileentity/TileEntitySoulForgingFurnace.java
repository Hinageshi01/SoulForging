package hinageshi.soulforging.tileentity;

import hinageshi.soulforging.SoulForging;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;

import javax.annotation.Nullable;

public class TileEntitySoulForgingFurnace extends TileEntity {
    public static final String ID= SoulForging.MODID+":soul_forging_furnace";

    private final ItemStackHandler left =new ItemStackHandler(1){
        @Override
        protected void onContentsChanged(int slot){
            TileEntitySoulForgingFurnace.this.markDirty();//markDirty to save in archive
        }
    };
    private final ItemStackHandler right =new ItemStackHandler(1){
        @Override
        protected void onContentsChanged(int slot){
            TileEntitySoulForgingFurnace.this.markDirty();//markDirty to save in archive
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
        this.down.deserializeNBT(compound.getCompoundTag("Down"));
        this.side.deserializeNBT(compound.getCompoundTag("Side"));
        this.left.deserializeNBT(compound.getCompoundTag("Left"));
        this.right.deserializeNBT(compound.getCompoundTag("Right"));
        super.readFromNBT(compound);
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound compound){//serialization
        compound.setTag("Down",this.down.serializeNBT());
        compound.setTag("Side",this.side.serializeNBT());
        compound.setTag("Left",this.left.serializeNBT());
        compound.setTag("Right",this.right.serializeNBT());
        return super.writeToNBT(compound);
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
                return itemHandlerCapability.cast(this.left);
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
