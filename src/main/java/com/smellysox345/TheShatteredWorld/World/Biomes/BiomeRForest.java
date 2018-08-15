package com.smellysox345.TheShatteredWorld.World.Biomes;

import java.util.Random;

import com.smellysox345.TheShatteredWorld.World.gen.generators.tree.WorldGenOakRefracted;
import com.smellysox345.TheShatteredWorld.entity.EntitySlimeWolf;
import com.smellysox345.TheShatteredWorld.init.ModBlocks;

import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;

public class BiomeRForest extends Biome{

	protected static final IBlockState SAND = ModBlocks.REFRACTEDSAND_BLOCK.getDefaultState();
	
	protected static final WorldGenAbstractTree TREE =  new WorldGenOakRefracted();
	
	public BiomeRForest() {
		super(new BiomeProperties("Refracted Forest").setTemperature(0.8F).setRainfall(0.8F));
	
		topBlock = Blocks.GRASS.getDefaultState();
		fillerBlock = ModBlocks.REFRACTEDSTONE_BLOCK.getDefaultState();
		
		this.decorator.treesPerChunk = 8;
		this.decorator.clayPerChunk = 1;
		
		this.spawnableCaveCreatureList.clear();
		this.spawnableCreatureList.clear();
		this.spawnableMonsterList.clear();
		
		this.spawnableCreatureList.add(new SpawnListEntry(EntitySlimeWolf.class, 10, 1, 3));
	}
	
	@Override
	public WorldGenAbstractTree getRandomTreeFeature(Random rand) {
		
		return TREE;
	}

}
