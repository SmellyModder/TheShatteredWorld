package com.smellysox345.TheShatteredWorld.blocks.shroom;

import java.util.Random;

import com.smellysox345.TheShatteredWorld.blocks.BlockBase;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ShroomDirt extends BlockBase{

	public ShroomDirt(String name, Material material) {
		super(name, material);
		setSoundType(SoundType.GROUND);
		setHardness(0.6F);
		setResistance(0.90F);
		setHarvestLevel("shovel", 2);
	}

}
