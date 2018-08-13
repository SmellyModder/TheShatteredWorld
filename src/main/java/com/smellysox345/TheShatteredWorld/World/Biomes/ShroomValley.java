package com.smellysox345.TheShatteredWorld.World.Biomes;

import java.util.Random;

import com.smellysox345.TheShatteredWorld.World.gen.generators.WorldGenOakRefracted;
import com.smellysox345.TheShatteredWorld.World.gen.generators.WorldGenStructure;
import com.smellysox345.TheShatteredWorld.World.gen.structures.WorldGenCustomStructures;
import com.smellysox345.TheShatteredWorld.entity.EntityArachnoShroom;
import com.smellysox345.TheShatteredWorld.entity.EntityNightShroom;
import com.smellysox345.TheShatteredWorld.entity.EntityShroomCreeper;
import com.smellysox345.TheShatteredWorld.entity.EntityShroomSkeleton;
import com.smellysox345.TheShatteredWorld.entity.EntityShroomZombie;
import com.smellysox345.TheShatteredWorld.entity.EntityShroomite;
import com.smellysox345.TheShatteredWorld.entity.EntitySlimeWolf;
import com.smellysox345.TheShatteredWorld.init.ModBlocks;

import net.minecraft.block.BlockBush;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biome.BiomeProperties;
import net.minecraft.world.biome.Biome.SpawnListEntry;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraft.world.gen.feature.WorldGenBush;
import net.minecraft.world.gen.feature.WorldGenMegaJungle;
import net.minecraft.world.gen.feature.WorldGenShrub;
import net.minecraft.world.gen.feature.WorldGenTrees;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;


public class ShroomValley extends Biome{
	
	
	public ShroomValley() {
		super(new BiomeProperties("Refracted Mushroom").setTemperature(0.8F).setRainfall(0.8F).setBaseHeight(0.15F).setHeightVariation(0.2F).setWaterColor(165));
	
		
		topBlock = ModBlocks.MYCELIUM_REFRACTED_BLOCK.getDefaultState();
		fillerBlock = ModBlocks.MYCELIUM_DIRT_BLOCK.getDefaultState();
		
		this.decorator.mushroomsPerChunk = 1;
		
		this.spawnableCaveCreatureList.clear();
		this.spawnableCreatureList.clear();
		this.spawnableMonsterList.clear();
		
		this.spawnableMonsterList.add(new SpawnListEntry(EntityArachnoShroom.class, 5, 1, 3));
		this.spawnableCreatureList.add(new SpawnListEntry(EntityShroomite.class, 7, 1, 3));
		this.spawnableMonsterList.add(new SpawnListEntry(EntityNightShroom.class, 2, 1, 3));
		this.spawnableMonsterList.add(new SpawnListEntry(EntityShroomCreeper.class, 3, 1, 3));
		this.spawnableMonsterList.add(new SpawnListEntry(EntityShroomZombie.class, 3, 1, 3));
		this.spawnableMonsterList.add(new SpawnListEntry(EntityShroomSkeleton.class, 3, 1, 3));
	}
}
