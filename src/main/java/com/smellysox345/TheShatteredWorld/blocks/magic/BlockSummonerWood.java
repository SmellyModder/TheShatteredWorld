package com.smellysox345.TheShatteredWorld.blocks.magic;

import com.smellysox345.TheShatteredWorld.blocks.BlockBase;
import com.smellysox345.TheShatteredWorld.entity.EntityWatcherBlock;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockSummonerWood extends BlockBase{

	public BlockSummonerWood(String name, Material material) {
		super(name, material);
		setHardness(1.5F);
		setResistance(1.0F);
		setLightLevel(0.75F);
		setHarvestLevel("axe", 2);
		setSoundType(SoundType.WOOD);
	}
}