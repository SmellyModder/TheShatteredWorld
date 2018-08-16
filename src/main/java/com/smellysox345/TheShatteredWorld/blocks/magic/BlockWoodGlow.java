package com.smellysox345.TheShatteredWorld.blocks.magic;

import com.smellysox345.TheShatteredWorld.blocks.BlockBase;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class BlockWoodGlow extends BlockBase{

	public BlockWoodGlow(String name, Material material) {
		super(name, material);
		setHardness(1.5F);
		setResistance(1.0F);
		setLightLevel(0.75F);
		setHarvestLevel("axe", 2);
		setSoundType(SoundType.WOOD);
	}

}