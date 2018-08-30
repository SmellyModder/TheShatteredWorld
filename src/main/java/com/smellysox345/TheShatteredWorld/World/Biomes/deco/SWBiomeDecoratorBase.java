package com.smellysox345.TheShatteredWorld.World.Biomes.deco;

import java.util.Random;

import com.smellysox345.TheShatteredWorld.World.gen.WorldGenBushDShrooms;
import com.smellysox345.TheShatteredWorld.init.ModBlocks;

import net.minecraft.block.BlockFlower;
import net.minecraft.block.BlockStone;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.ChunkGeneratorSettings;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraft.world.gen.feature.WorldGenBigMushroom;
import net.minecraft.world.gen.feature.WorldGenBush;
import net.minecraft.world.gen.feature.WorldGenCactus;
import net.minecraft.world.gen.feature.WorldGenClay;
import net.minecraft.world.gen.feature.WorldGenDeadBush;
import net.minecraft.world.gen.feature.WorldGenFlowers;
import net.minecraft.world.gen.feature.WorldGenLiquids;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenPumpkin;
import net.minecraft.world.gen.feature.WorldGenReed;
import net.minecraft.world.gen.feature.WorldGenSand;
import net.minecraft.world.gen.feature.WorldGenWaterlily;
import net.minecraft.world.gen.feature.WorldGenerator;

public abstract class SWBiomeDecoratorBase {

	protected World world;
	protected Random rand;
	protected int x, z;
	protected int xx, yy, zz, attempt;
	private boolean isDecorating = false;

	protected SWBiomeDecoratorBase() {
	}

	public final void populate(World world, Random rand, int x, int z) {
		this.world = world;
		this.rand = rand;
		this.x = x;
		this.z = z;
		populate();
	}

	public final void decorate(World world, Random rand, int x, int z) {
		if (isDecorating)
			throw new RuntimeException("Already decorating Erebus!");
		isDecorating = true;
		this.world = world;
		this.rand = rand;
		this.x = x;
		this.z = z;

		decorate();

		isDecorating = false;
	}

	protected void populate() {
	}

	protected void decorate() {
	}

	public static class BiomeDecoratorEmpty extends SWBiomeDecoratorBase {
	}
}
