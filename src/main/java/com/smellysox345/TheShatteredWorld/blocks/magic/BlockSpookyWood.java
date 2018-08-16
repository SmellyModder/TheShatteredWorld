package com.smellysox345.TheShatteredWorld.blocks.magic;

import com.smellysox345.TheShatteredWorld.blocks.BlockBase;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class BlockSpookyWood extends BlockBase{

	public BlockSpookyWood(String name, Material material) {
		super(name, material);
		setHardness(1.0F);
		setResistance(1.0F);
		setHarvestLevel("axe", 2);
		setSoundType(SoundType.WOOD);
	}

}
