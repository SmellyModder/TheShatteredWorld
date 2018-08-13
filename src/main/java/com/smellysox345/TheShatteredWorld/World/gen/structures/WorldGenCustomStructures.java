package com.smellysox345.TheShatteredWorld.World.gen.structures;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import com.smellysox345.TheShatteredWorld.World.Biomes.ShroomValley;
import com.smellysox345.TheShatteredWorld.World.gen.generators.WorldGenStructure;
import com.smellysox345.TheShatteredWorld.World.gen.generators.shroomGens.ShroomPatchG;
import com.smellysox345.TheShatteredWorld.World.gen.generators.shroomGens.ShroomPatchN;
import com.smellysox345.TheShatteredWorld.World.gen.generators.shroomGens.ShroomPatchP;
import com.smellysox345.TheShatteredWorld.World.gen.generators.shroomGens.ShroomPatchR;
import com.smellysox345.TheShatteredWorld.World.gen.generators.shroomGens.GrassShroom;
import com.smellysox345.TheShatteredWorld.World.gen.generators.shroomGens.PinkiShroom;
import com.smellysox345.TheShatteredWorld.World.gen.generators.shroomGens.RefractaShroom;
import com.smellysox345.TheShatteredWorld.init.BiomeInit;
import com.smellysox345.TheShatteredWorld.init.ModBlocks;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.common.BiomeManager.BiomeType;
import net.minecraftforge.fml.common.IWorldGenerator;

public class WorldGenCustomStructures implements IWorldGenerator{


	public static final WorldGenStructure SHROOM_BIG_R = new WorldGenStructure("shroom_r_n");
	
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
			
	            generateSurface(world, random, chunkX * 16, chunkZ * 16, chunkZ * 16);
	            generateSurfaceForGShrooms(world, random, chunkX * 16, chunkZ * 16, chunkZ * 16);
	            generateSurfaceForRShrooms(world, random, chunkX * 16, chunkZ * 16, chunkZ * 16);
	            generateSurfaceForPShrooms(world, random, chunkX * 16, chunkZ * 16, chunkZ * 16);
	            generateSurfaceForNShrooms(world, random, chunkX * 16, chunkZ * 16, chunkZ * 16);
	            generateSurfaceForPinkShrooms(world, random, chunkX * 16, chunkZ * 16, chunkZ * 16);
	            generateSurfaceForGrassShrooms(world, random, chunkX * 16, chunkZ * 16, chunkZ * 16);
	            generateStructure(SHROOM_BIG_R, world, random, chunkX, chunkZ, 20, ModBlocks.MYCELIUM_REFRACTED_BLOCK, ShroomValley.class);
	            
			
			break;
			
		case -1:
			
		}
	}
	
	private void generateStructure(WorldGenerator generator, World world, Random random, int chunkX, int chunkZ, int chance, Block topBlock, Class<?>... classes)
	{
		ArrayList<Class<?>> classesList = new ArrayList<Class<?>>(Arrays.asList(classes));
		
		int x = (chunkX * 16) + random.nextInt(15) + 8;
		int z = (chunkZ * 16) + random.nextInt(15) + 8;
		int y = calculateGenerationHeight(world, x, z, topBlock);
		BlockPos pos = new BlockPos(x,y,z);
		
		Class<?> biome = world.provider.getBiomeForCoords(pos).getClass();
		
		if(world.getWorldType() != WorldType.FLAT)
		{
			if(classesList.contains(biome))
			{
				if(random.nextInt(chance) == 0)
				{
					generator.generate(world, random, pos);
				}
			}
		}
	}
	
	private void runGenerator(WorldGenerator generator, World world, Random random, int chunkX, int chunkZ, int chance, Block topBlock, Class<?>... classes)
	{
		ArrayList<Class<?>> classesList = new ArrayList<Class<?>>(Arrays.asList(classes));
		
		int x = (chunkX * 16) + random.nextInt(15) + 8;
		int z = (chunkZ * 16) + random.nextInt(15) + 8;
		int y = calculateGenerationHeight(world, x, z, topBlock);
		BlockPos pos = new BlockPos(x,y,z);
		
		Class<?> biome = world.provider.getBiomeForCoords(pos).getClass();
		
		if(world.getWorldType() != WorldType.FLAT)
		{
			if(classesList.contains(biome))
			{
				if(random.nextInt(chance) == 0)
				{
					generator.generate(world, random, pos);
				}
			}
		}
	}
	
	private static int calculateGenerationHeight(World world, int x, int z, Block topBlock)
	{
		int y = world.getHeight();
		boolean foundGround = false;
		
		while(!foundGround && y-- >= 0)
		{
			Block block = world.getBlockState(new BlockPos(x,y,z)).getBlock();
			foundGround = block == topBlock;
		}
		
		return y;
	}
	
	private void generateSurface(World world, Random rand, int chunkX, int chunkZ, int chunkY) {

        WorldGenerator genFire = new RefractaShroom();
        final int FireChance = 4;
        
        
        if (rand.nextInt(FireChance) <= 1) {
        	Biome biomeBase = world.getBiome(new BlockPos(chunkX, chunkY, chunkZ));
    		if (biomeBase == BiomeInit.RF_SHROOM) {
            int randX = chunkX + rand.nextInt(16);
            int randZ = chunkZ + rand.nextInt(16);
            int groundY = getGroundFromAbove(world, randX, randZ);
            genFire.generate(world, rand, new BlockPos(randX, groundY + 1, randZ));
        }
        }
    }
	
	private void generateSurfaceForPinkShrooms(World world, Random rand, int chunkX, int chunkZ, int chunkY) {

        WorldGenerator genFire = new PinkiShroom();
        final int FireChance = 4;
        
        
        if (rand.nextInt(FireChance) <= 1) {
        	Biome biomeBase = world.getBiome(new BlockPos(chunkX, chunkY, chunkZ));
    		if (biomeBase == BiomeInit.RF_SHROOM) {
            int randX = chunkX + rand.nextInt(16);
            int randZ = chunkZ + rand.nextInt(16);
            int groundY = getGroundFromAbove(world, randX, randZ);
            genFire.generate(world, rand, new BlockPos(randX, groundY + 1, randZ));
        }
        }
    }
	
	private void generateSurfaceForGrassShrooms(World world, Random rand, int chunkX, int chunkZ, int chunkY) {

        WorldGenerator genFire = new GrassShroom();
        final int FireChance = 5;
        
        
        if (rand.nextInt(FireChance) <= 1) {
        	Biome biomeBase = world.getBiome(new BlockPos(chunkX, chunkY, chunkZ));
    		if (biomeBase == BiomeInit.RF_SHROOM) {
            int randX = chunkX + rand.nextInt(16);
            int randZ = chunkZ + rand.nextInt(16);
            int groundY = getGroundFromAbove(world, randX, randZ);
            genFire.generate(world, rand, new BlockPos(randX, groundY + 1, randZ));
        }
        }
    }
	
	private void generateSurfaceForGShrooms(World world, Random rand, int chunkX, int chunkZ, int chunkY) {

        WorldGenerator genGrassShroomType = new ShroomPatchG();
        final int Chance = 6;
        
        
        if (rand.nextInt(Chance) <= 1) {
        	Biome biomeBase = world.getBiome(new BlockPos(chunkX, chunkY, chunkZ));
    		if (biomeBase == BiomeInit.RF_SHROOM) {
            int randX = chunkX + rand.nextInt(16);
            int randZ = chunkZ + rand.nextInt(16);
            int groundY = getGroundFromAbove(world, randX, randZ);
            genGrassShroomType.generate(world, rand, new BlockPos(randX, groundY + 1, randZ));
        }
        }
    }
	
	private void generateSurfaceForRShrooms(World world, Random rand, int chunkX, int chunkZ, int chunkY) {

        WorldGenerator genRShroomType = new ShroomPatchR();
        final int Chance = 6;
        
        
        if (rand.nextInt(Chance) <= 1) {
        	Biome biomeBase = world.getBiome(new BlockPos(chunkX, chunkY, chunkZ));
    		if (biomeBase == BiomeInit.RF_SHROOM) {
            int randX = chunkX + rand.nextInt(16);
            int randZ = chunkZ + rand.nextInt(16);
            int groundY = getGroundFromAbove(world, randX, randZ);
            genRShroomType.generate(world, rand, new BlockPos(randX, groundY + 1, randZ));
        }
        }
    }
	
	private void generateSurfaceForPShrooms(World world, Random rand, int chunkX, int chunkZ, int chunkY) {

        WorldGenerator genPShroomType = new ShroomPatchP();
        final int Chance = 5;
        
        
        if (rand.nextInt(Chance) <= 1) {
        	Biome biomeBase = world.getBiome(new BlockPos(chunkX, chunkY, chunkZ));
    		if (biomeBase == BiomeInit.RF_SHROOM) {
            int randX = chunkX + rand.nextInt(14);
            int randZ = chunkZ + rand.nextInt(14);
            int groundY = getGroundFromAbove(world, randX, randZ);
            genPShroomType.generate(world, rand, new BlockPos(randX, groundY + 1, randZ));
        }
        }
    }
	
	private void generateSurfaceForNShrooms(World world, Random rand, int chunkX, int chunkZ, int chunkY) {

        WorldGenerator genNShroomType = new ShroomPatchN();
        final int Chance = 6;
        
        
        if (rand.nextInt(Chance) <= 1) {
        	Biome biomeBase = world.getBiome(new BlockPos(chunkX, chunkY, chunkZ));
    		if (biomeBase == BiomeInit.RF_SHROOM) {
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
}
