package com.smellysox345.TheShatteredWorld.blocks.mobutil;

import com.smellysox345.TheShatteredWorld.World.commands.util.TP;
import com.smellysox345.TheShatteredWorld.blocks.BlockBase;
import com.smellysox345.TheShatteredWorld.entity.EntityArachnoShroomQueen;
import com.smellysox345.TheShatteredWorld.entity.EntitySlimeWolfBaby;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class SpiderQueenEgg extends BlockBase{

	public SpiderQueenEgg(String name, Material material) {
		super(name, material);
		setSoundType(SoundType.STONE);
		setHardness(100000000.0F);
		setResistance(1000000.0F);
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
	public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer entity, EnumHand hand, EnumFacing side,
			float hitX, float hitY, float hitZ) {
			int i = pos.getX();
			int j = pos.getY();
			int k = pos.getZ();
			if (true) {
			world.setBlockToAir(new BlockPos(i, j, k));
			}
			
			if (true) {
			Entity sentity = new EntityArachnoShroomQueen(world);
			if (sentity != null && !world.isRemote) {
				sentity.setLocationAndAngles(i, j, k, world.rand.nextFloat() * 360F, 0.0F);
				world.spawnEntity(sentity);
			}
		}

		return true;
	}
}
