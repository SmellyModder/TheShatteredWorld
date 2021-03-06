package com.smellysox345.TheShatteredWorld.World.gen;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import com.smellysox345.TheShatteredWorld.World.Biomes.BiomeRForest;
import com.smellysox345.TheShatteredWorld.World.gen.generators.tree.WorldGenBirchRefracted;
import com.smellysox345.TheShatteredWorld.World.gen.generators.tree.WorldGenOakRefracted;
import com.smellysox345.TheShatteredWorld.init.DimensionInit;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeForest;
import net.minecraft.world.biome.BiomePlains;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class WorldGenCustomTrees implements IWorldGenerator{

	private final WorldGenerator OAK_REFRACTED = new WorldGenOakRefracted();
	private final WorldGenerator BIRCH_REFRACTED = new WorldGenBirchRefracted();
	
	
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) 
	{
		switch(world.provider.getDimension())
		{
		
		case -9:
			
			runGenerator(OAK_REFRACTED, world, random, chunkX, chunkZ, 3, -1, 0, BiomeRForest.class);
			runGenerator(BIRCH_REFRACTED, world, random, chunkX, chunkZ, 3, -1, 0, BiomeRForest.class);
			
			break;
			
		case 1:
			
			break;
			
		case 0:
			
			break;
			
		case -1:
		
		}
	}
	
	private void runGenerator(WorldGenerator generator, World world, Random random, int chunkX, int chunkZ, double chancesToSpawn, int minHeight, int maxHeight, Class<?>... classes)
	{
		if(chancesToSpawn < 1) 
		{
			if(random.nextDouble() < chancesToSpawn) chancesToSpawn = 1;
			else chancesToSpawn = 0;
		}
		
		ArrayList<Class<?>> classesList = new ArrayList<Class<?>>(Arrays.asList(classes));
		int heightDiff = maxHeight - minHeight + 1;
		for(int i = 0; i < chancesToSpawn; i++)
		{
			BlockPos pos = new BlockPos(chunkX * 16 + 10 + random.nextInt(15), minHeight + random.nextInt(heightDiff), chunkZ * 16 + 10 + random.nextInt(15));
			if(minHeight < 0) pos = world.getHeight(pos);
			Class<?> biome = world.provider.getBiomeForCoords(pos).getClass();
			if(classesList.contains(biome) || classes.length == 0) generator.generate(world, random, pos);
		}
	}
	
	public static void register() {
		GameRegistry.registerWorldGenerator(new WorldGenCustomTrees(), 0);
	}
	
	
	
	
}
