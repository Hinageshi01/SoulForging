package hinageshi.soulforging.network;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class SoulForgingGuiHandler implements IGuiHandler {
    public static final int SOUL_FORGING_FURNACE=1;

    @Override
    public Object getServerGuiElement(int id, EntityPlayer player, World world,int x,int y,int z){
        if(id==SOUL_FORGING_FURNACE){
            return new ContainerSoulForgingFurnace(player,world,x,y,z);
        }
        return null;
    }

    @Override
    public Object getClientGuiElement(int id,EntityPlayer player,World world,int x,int y,int z){
        if(id==SOUL_FORGING_FURNACE){
            return new GuiSoulForgingFurnace(player,world,x,y,z);
        }
        return null;
    }
}
