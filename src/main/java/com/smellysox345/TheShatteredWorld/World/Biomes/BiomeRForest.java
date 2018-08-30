package com.smellysox345.TheShatteredWorld.World.Biomes;

import java.util.Random;

import com.smellysox345.TheShatteredWorld.World.dimension.features.SWWorldGenClay;
import com.smellysox345.TheShatteredWorld.World.gen.WorldGenSWFlowers;
import com.smellysox345.TheShatteredWorld.World.gen.generators.tree.WorldGenOakRefracted;
import com.smellysox345.TheShatteredWorld.blocks.plants.flowers.SWFlowers;
import com.smellysox345.TheShatteredWorld.entity.EntitySlimeWolf;
import com.smellysox345.TheShatteredWorld.init.ModBlocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockFlower;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraft.world.gen.feature.WorldGenClay;
import net.minecraft.world.gen.feature.WorldGenerator;

public class BiomeRForest extends BiomeBaseShatteredWorld{

	protected static final IBlockState SAND = ModBlocks.REFRACTEDSAND_BLOCK.getDefaultState();
	
	protected static final WorldGenAbstractTree TREE =  new WorldGenOakRefracted();
	public WorldGenerator RclayGen = new SWWorldGenClay(4);
	public WorldGenSWFlowers swflowergen = new WorldGenSWFlowers(ModBlocks.R_POPPY);
	public BlockPos chunkPos;
	
	public BiomeRForest() {
		super(new BiomeProperties("Refracted Forest").setTemperature(0.8F).setRainfall(0.8F).setBaseHeight(0.2F));
	
		topBlock = Blocks.GRASS.getDefaultState();
		fillerBlock = ModBlocks.REFRACTEDSTONE_BLOCK.getDefaultState();
		
		this.decorator.clayPerChunk = -1;
		this.decorator.sandPatchesPerChunk = -1;
		this.decorator.clayGen = new SWWorldGenClay(2);
		
		this.decorator.generateFalls = false;
		
		this.spawnableCaveCreatureList.clear();
		this.spawnableCreatureList.clear();
		this.spawnableMonsterList.clear();
		
		this.spawnableCreatureList.add(new SpawnListEntry(EntitySlimeWolf.class, 10, 1, 3));
		
		this.flowers.clear();
		this.decorator.flowersPerChunk = 0;
		this.decorator.flowerGen = null;
	}
	
	@Override
	public WorldGenAbstractTree getRandomTreeFeature(Random rand) {
		
		return TREE;
	}
}
