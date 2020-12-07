package hinageshi.soulforging.network;

import hinageshi.soulforging.SoulForging;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class GuiSoulForgingFurnace extends GuiContainer {
    private static final ResourceLocation TEXTURE=new ResourceLocation(SoulForging.MODID+":textures/gui/container/soul_forging_furnace.png");

    public GuiSoulForgingFurnace(EntityPlayer player, World world,int x,int y,int z){
        super(new ContainerSoulForgingFurnace(player,world,x,y,z));
        this.xSize=176;
        this.ySize=176;//176*176 Gui in a 256*256 picture
    }

    @Override
    public void drawScreen(int mouseX,int mouseY,float partialTicks){
        super.drawDefaultBackground();
        super.drawScreen(mouseX,mouseY,partialTicks);
        super.renderHoveredToolTip(mouseX,mouseY);
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks,int mouseX,int mouseY){
        int left=(this.width-this.xSize)/2;
        int top=(this.height-this.ySize)/2;
        GlStateManager.color(1.0F,1.0F,1.0F,1.0F);
        this.mc.getTextureManager().bindTexture(TEXTURE);
        this.drawTexturedModalRect(left,top,0,0,this.xSize,this.ySize);
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int mouseX,int mouseY){
        String text= I18n.format("tile.soulforging.soulForgingFurnace.name");
        this.drawCenteredString(this.fontRenderer,text,this.xSize/2,6,0x00404040);
    }
}
