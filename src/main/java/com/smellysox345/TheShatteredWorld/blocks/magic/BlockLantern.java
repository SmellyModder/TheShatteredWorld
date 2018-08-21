package com.smellysox345.TheShatteredWorld.blocks.magic;

import java.util.Random;

import com.smellysox345.TheShatteredWorld.Main;
import com.smellysox345.TheShatteredWorld.blocks.BlockBase;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockLantern extends BlockBase{

	public BlockLantern(String name, Material material) {
		super(name, material);
		setLightOpacity(1);
		setCreativeTab(Main.shatteredworldtools);
		setLightLevel(2.5F);
		setResistance(450.0F);
		setHardness(0.0F);
	}
	
	@Override
	public boolean isOpaqueCube(IBlockState state) {
		return false;
	}
	
	@Override
	public boolean isFullCube(IBlockState state) {
		
		return false;
	}
	@Override
	public float getAmbientOcclusionLightValue(IBlockState state) {
		return 1.0F;
	}
	
	@Override
	public BlockRenderLayer getBlockLayer() 
	{
		return BlockRenderLayer.CUTOUT;
	}
	
	 @SideOnly(Side.CLIENT)
	    public void randomDisplayTick(IBlockState stateIn, World worldIn, BlockPos pos, Random rand)
	    {
	        if (rand.nextInt(24) == 0)
	        {
	            worldIn.playSound((double)((float)pos.getX() + 0.5F), (double)((float)pos.getY() + 0.5F), (double)((float)pos.getZ() + 0.5F), SoundEvents.BLOCK_FIRE_AMBIENT, SoundCategory.BLOCKS, 1.0F + rand.nextFloat(), rand.nextFloat() * 0.4F + 0.3F, false);
	        }
	    }
}
