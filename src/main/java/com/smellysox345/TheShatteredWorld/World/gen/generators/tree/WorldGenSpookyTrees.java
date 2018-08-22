package com.smellysox345.TheShatteredWorld.World.gen.generators.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import com.smellysox345.TheShatteredWorld.World.Biomes.BiomeRForest;
import com.smellysox345.TheShatteredWorld.World.gen.WorldGenCustomTrees;
import com.smellysox345.TheShatteredWorld.World.gen.generators.shroomGens.ShroomPatchN;
import com.smellysox345.TheShatteredWorld.init.BiomeInit;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeForest;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class WorldGenSpookyTrees implements IWorldGenerator{

	private final WorldGenerator EYE_TREE_NORMAL = new WorldGenEyeTreeDefault();
	private final WorldGenerator CANOPY = new WorldGenCanopyRefracted();
	
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) 
	{
		switch(world.provider.getDimension())
		{
		
		case 123321:
			break;
			
		case 1:
			
			break;
			
		case 0:
			
			generateSurfaceForSpookyEyeTree(world, random, chunkX * 16, chunkZ * 16, chunkZ * 16);
			
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
	
	private void generateSurfaceForSpookyEyeTree(World world, Random rand, int chunkX, int chunkZ, int chunkY) {

        WorldGenerator genNShroomType = new WorldGenEyeTreeDefault();
        final int Chance = 15;
        
        
        if (rand.nextInt(Chance) <= 1) {
        	Biome biomeBase = world.getBiome(new BlockPos(chunkX, chunkY, chunkZ));
    		if (biomeBase == BiomeInit.R_ROOFED_FOREST) {
            int randX = chunkX + rand.nextInt(16);
            int randZ = chunkZ + rand.nextInt(16);
            int groundY = getGroundFromAbove(world, randX, randZ);
            genNShroomType.generate(world, rand, new BlockPos(randX, groundY + 1, randZ));
        }
        }
    }
	

	public static int getGroundFromAbove(World world, int x, int z) {
        int y = 255;
        boolean foundGround = false;
        while (!foundGround && y-- >= 0) {
            Block blockAt = world.getBlockState(new BlockPos(x, y, z)).getBlock();

            foundGround = blockAt != Blocks.AIR && blockAt != Blocks.WATER && blockAt != Blocks.FLOWING_WATER;
            
        }
        return y;
    }
	
	public static void register() {
		GameRegistry.registerWorldGenerator(new WorldGenSpookyTrees(), 0);
	}
}