package com.smellysox345.TheShatteredWorld.blocks.plants;

import java.util.Random;

import javax.annotation.Nullable;

import com.smellysox345.TheShatteredWorld.Main;
import com.smellysox345.TheShatteredWorld.blocks.BlockBase;
import com.smellysox345.TheShatteredWorld.init.ModBlocks;

import net.minecraft.block.BlockDirt;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ShroomPlantBase extends BlockBase implements IPlantable{
	
 protected static final AxisAlignedBB SHROOM_COLLISION_AABBTWO = new AxisAlignedBB(0.30000001192092896D, 0.0D, 0.30000001192092896D, 0.699999988079071D, 0.4000000059604645D, 0.699999988079071D);
 
	public ShroomPlantBase(String name, Material material) {
		super(name, material);
		setSoundType(SoundType.GROUND);
		setHardness(0.0F);
		setResistance(0.1F);
		setLightLevel(0.75F);
		setCreativeTab(Main.shatteredworldplants);
	}
	
	public boolean isOpaqueCube(IBlockState state)
    {
        return false;
    }

    @Nullable
    public AxisAlignedBB getCollisionBoundingBox(IBlockState blockState, IBlockAccess worldIn, BlockPos pos)
    {
        return NULL_AABB;
    }
    
    @SideOnly(Side.CLIENT)
    public AxisAlignedBB getSelectedBoundingBox(IBlockState state, World worldIn, BlockPos pos)
    {
        return SHROOM_COLLISION_AABBTWO.offset(pos);
    }

    public boolean isFullCube(IBlockState state)
    {
        return false;
    }

    @SideOnly(Side.CLIENT)
    public BlockRenderLayer getBlockLayer()
    {
        return BlockRenderLayer.TRANSLUCENT;
    }
    
    public BlockFaceShape getBlockFaceShape(IBlockAccess worldIn, IBlockState state, BlockPos pos, EnumFacing face)
    {
        return BlockFaceShape.UNDEFINED;
    }
    
    public boolean canPlaceBlockAt(World worldIn, BlockPos pos)
    {
        return super.canPlaceBlockAt(worldIn, pos) && this.canBlockStay(worldIn, pos, this.getDefaultState());
    }
	
	public boolean canBlockStay(World worldIn, BlockPos pos, IBlockState state)
    {
        if (pos.getY() >= 0 && pos.getY() < 256)
        {
            IBlockState iblockstate = worldIn.getBlockState(pos.down());

            if (iblockstate.getBlock() == Blocks.MYCELIUM)
            {
                return true;
            }
            else if (iblockstate.getBlock() == Blocks.DIRT && iblockstate.getValue(BlockDirt.VARIANT) == BlockDirt.DirtType.PODZOL)
            {
                return true;
            }
            else if (iblockstate.getBlock() == ModBlocks.MYCELIUM_REFRACTED_BLOCK)
            {
                return true;
            }
            else
            {
                return worldIn.getLight(pos) < 13 && iblockstate.getBlock().canSustainPlant(iblockstate, worldIn, pos.down(), 				net.minecraft.util.EnumFacing.UP, this);
            }
        }
        else
        {
            return false;
        }
    }
	
	@Override
    public net.minecraftforge.common.EnumPlantType getPlantType(net.minecraft.world.IBlockAccess world, BlockPos pos)
    {
        return net.minecraftforge.common.EnumPlantType.Cave;
    }

	@Override
	public IBlockState getPlant(IBlockAccess world, BlockPos pos) {
		return getDefaultState();
	}
    
    @Override
    public int quantityDropped(Random par1Random) {
	return 1;
    }

}
