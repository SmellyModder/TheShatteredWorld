package com.smellysox345.TheShatteredWorld.World.Biomes;

import java.util.Random;

import com.smellysox345.TheShatteredWorld.World.gen.generators.tree.WorldGenEyeTreeDefault;
import com.smellysox345.TheShatteredWorld.World.gen.generators.tree.WorldGenOakRefracted;
import com.smellysox345.TheShatteredWorld.entity.EntitySlimeWolf;
import com.smellysox345.TheShatteredWorld.init.ModBlocks;

import net.minecraft.block.BlockDirt;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biome.BiomeProperties;
import net.minecraft.world.biome.Biome.SpawnListEntry;
import net.minecraft.world.chunk.ChunkPrimer;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;


public class BiomeRefractedRoofedForest extends Biome{

	public BiomeRefractedRoofedForest() {
		super(new BiomeProperties("Refracted Roofed Forest").setTemperature(0.8F).setRainfall(0.8F).setBaseHeight(0.2F).setWaterColor(8983040));
		
		this.decorator.treesPerChunk = -999;
		this.spawnableCaveCreatureList.clear();
		this.spawnableCreatureList.clear();
		this.spawnableMonsterList.clear();
		
		
		this.topBlock = Blocks.GRASS.getDefaultState();
        this.fillerBlock = Blocks.DIRT.getDefaultState();
	}
}
