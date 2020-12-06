package hinageshi.soulforging.block;

import hinageshi.soulforging.SoulForging;
import hinageshi.soulforging.creativetab.TabSoulForging;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockSoulForgingFurnace extends Block {
    private static final IProperty<EnumFacing> FACING = PropertyDirection.create("facing",EnumFacing.Plane.HORIZONTAL);

    public BlockSoulForgingFurnace(){
        super(Material.ROCK);
        this.setUnlocalizedName(SoulForging.MODID+".soulForgingFurnace");
        this.setCreativeTab(TabSoulForging.TAB_SOUL_FORGING);
        this.setRegistryName("soul_forging_furnace");
        this.setHarvestLevel("pickaxe",1);
        this.setHardness(3.5F);
        this.setDefaultState(this.blockState.getBaseState().withProperty(FACING,EnumFacing.NORTH));
    }

    @Override
    protected BlockStateContainer createBlockState(){
        return new BlockStateContainer(this,FACING);
    }

    @Override
    public int getMetaFromState(IBlockState state){
        return state.getValue(FACING).getHorizontalIndex();
    }

    @Override
    public IBlockState getStateFromMeta(int meta){
        return this.getDefaultState().withProperty(FACING,EnumFacing.getHorizontal(meta));
    }

    @Override
    public IBlockState getStateForPlacement(World world, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer, EnumHand hand){
        return this.getDefaultState().withProperty(FACING,placer.getHorizontalFacing().getOpposite());
    }

    @Override
    public IBlockState withRotation(IBlockState state, Rotation rotation){
        return state.withProperty(FACING,rotation.rotate(state.getValue(FACING)));
    }

    @Override
    public IBlockState withMirror(IBlockState state, Mirror mirror){
        return state.withProperty(FACING,mirror.mirror(state.getValue(FACING)));
    }
}
