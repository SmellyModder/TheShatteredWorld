package com.smellysox345.TheShatteredWorld.blocks.mobutil;

import java.util.Random;

import com.smellysox345.TheShatteredWorld.blocks.BlockBase;
import com.smellysox345.TheShatteredWorld.entity.EntityArachnoShroom;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;


public class BlockSpiderSack extends BlockBase{

	public BlockSpiderSack(String name, Material material) {
		super(name, material);
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
	public void onBlockAdded(World world, BlockPos pos, IBlockState state) {
		int i = pos.getX();
		int j = pos.getY();
		int k = pos.getZ();
		world.scheduleUpdate(new BlockPos(i, j, k), this, this.tickRate(world));

	}
	
	@Override
	public void updateTick(World world, BlockPos pos, IBlockState state, Random random) {
		int i = pos.getX();
		int j = pos.getY();
		int k = pos.getZ();
		EntityPlayer entity;

		if (true) {
			world.setBlockToAir(new BlockPos(i, j, k));
		}

		if (true) {
			Entity sentity = new EntityArachnoShroom(world);
			if (sentity != null && !world.isRemote) {
				sentity.setLocationAndAngles(i, j, k, world.rand.nextFloat() * 360F, 0.0F);
				world.spawnEntity(sentity);
			}
		}

		world.scheduleUpdate(new BlockPos(i, j, k), this, this.tickRate(world));
	}

}
