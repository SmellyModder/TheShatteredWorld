package com.smellysox345.TheShatteredWorld.World.Biomes;

import java.util.Random;

import com.smellysox345.TheShatteredWorld.World.gen.generators.tree.WorldGenEyeTreeDefault;
import com.smellysox345.TheShatteredWorld.World.gen.generators.tree.WorldGenOakRefracted;
import com.smellysox345.TheShatteredWorld.entity.EntitySlimeWolf;
import com.smellysox345.TheShatteredWorld.init.ModBlocks;

import net.minecraft.init.Blocks;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biome.BiomeProperties;
import net.minecraft.world.biome.Biome.SpawnListEntry;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;

public class BiomeRefractedRoofedForest extends Biome{

	public BiomeRefractedRoofedForest(BiomeProperties properties) {
		super(properties);
		
	}
	
	public BiomeRefractedRoofedForest() {
		super(new BiomeProperties("Refracted Roofed Forest").setTemperature(0.8F).setRainfall(0.8F));
	
		topBlock = Blocks.GRASS.getDefaultState();
		fillerBlock = ModBlocks.REFRACTEDSTONE_BLOCK.getDefaultState();
		
		this.decorator.treesPerChunk = 0;
		this.spawnableCaveCreatureList.clear();
		this.spawnableCreatureList.clear();
		this.spawnableMonsterList.clear();
		
	}
}
