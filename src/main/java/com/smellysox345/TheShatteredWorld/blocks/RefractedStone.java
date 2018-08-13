package com.smellysox345.TheShatteredWorld.blocks;

import java.util.Random;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class RefractedStone extends BlockBase{

	public RefractedStone(String name, Material material) {
		super(name, material);
		setSoundType(SoundType.STONE);
		setHardness(1.7F);
		setResistance(0.9F);
		setHarvestLevel("pickaxe", 2);
		setLightLevel(0.1F);
		setLightOpacity(0);
		
	}
}
