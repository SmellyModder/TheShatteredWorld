package com.smellysox345.TheShatteredWorld.World.gen.structures;

import com.smellysox345.TheShatteredWorld.World.Biomes.BiomeRefractedRoofedForest;
import com.smellysox345.TheShatteredWorld.World.Biomes.BiomeShroomValley;
import com.smellysox345.TheShatteredWorld.World.gen.generators.WorldGenStructure;
import com.smellysox345.TheShatteredWorld.World.gen.generators.shroomGens.*;
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
import net.minecraftforge.fml.common.IWorldGenerator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class WorldGenCustomStructures implements IWorldGenerator {


    public static final WorldGenStructure SHROOM_BIG_R = new WorldGenStructure("shroom_r_n");

    private static int calculateGenerationHeight(World world, int x, int z, Block topBlock) {
        int y = world.getHeight();
        boolean foundGround = false;

        while (!foundGround && y-- >= 0) {
            Block block = world.getBlockState(new BlockPos(x, y, z)).getBlock();
            foundGround = block == topBlock;
        }

        return y;
    }

    public static int getGroundFromAbove(World world, int x, int z) {
        int y = 255;
        boolean foundGround = false;
        while (!foundGround && y-- >= 0) {
            Block blockAt = world.getBlockState(new BlockPos(x, y, z)).getBlock();

            foundGround = blockAt != Blocks.AIR && blockAt != Blocks.WATER && blockAt != Blocks.FLOWING_WATER && blockAt != ModBlocks.REFRACTA_SHROOM && blockAt != ModBlocks.NIGHTCRAWLERSHROOM_BLOCK && blockAt != ModBlocks.PINKI_SHROOM;

        }
        return y;
    }

    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
        BlockPos blockPos = new BlockPos(chunkX * 16, 0, chunkZ * 16);
        if (world.provider.getBiomeForCoords(blockPos).equals(BiomeInit.R_ROOFED_FOREST)) {
            generateSurfaceForGrassShrooms(world, random, chunkX * 16, chunkZ * 16, chunkZ * 16);
            generateSurfaceForRShrooms(world, random, chunkX * 16, chunkZ * 16, chunkZ * 16);
        }
        switch (world.provider.getDimension()) {
            case -9:
            	
            	generateSurface(world, random, chunkX * 16, chunkZ * 16, chunkZ * 16);
                generateSurfaceForGShrooms(world, random, chunkX * 16, chunkZ * 16, chunkZ * 16);
                generateSurfaceForRShrooms(world, random, chunkX * 16, chunkZ * 16, chunkZ * 16);
                generateSurfaceForPShrooms(world, random, chunkX * 16, chunkZ * 16, chunkZ * 16);
                generateSurfaceForNShrooms(world, random, chunkX * 16, chunkZ * 16, chunkZ * 16);
                generateSurfaceForPinkShrooms(world, random, chunkX * 16, chunkZ * 16, chunkZ * 16);
                generateSurfaceForGrassShrooms(world, random, chunkX * 16, chunkZ * 16, chunkZ * 16);
                generateStructure(SHROOM_BIG_R, world, random, chunkX, chunkZ, 20, ModBlocks.MYCELIUM_REFRACTED_BLOCK, BiomeShroomValley.class);
                break;

            case 1:

                break;

            case 0:

                


                break;

            case -1:

        }
    }

    private void generateStructure(WorldGenerator generator, World world, Random random, int chunkX, int chunkZ, int chance, Block topBlock, Class<?>... classes) {
        baseStructureGen(generator, world, random, chunkX, chunkZ, chance, topBlock, classes);
    }

    private void baseStructureGen(WorldGenerator generator, World world, Random random, int chunkX, int chunkZ, int chance, Block topBlock, Class<?>[] classes) {
        ArrayList<Class<?>> classesList = new ArrayList<Class<?>>(Arrays.asList(classes));

        int x = (chunkX * 16) + random.nextInt(15) + 8;
        int z = (chunkZ * 16) + random.nextInt(15) + 8;
        int y = calculateGenerationHeight(world, x, z, topBlock);
        BlockPos pos = new BlockPos(x, y, z);

        Class<?> biome = world.provider.getBiomeForCoords(pos).getClass();

        if (world.getWorldType() != WorldType.FLAT) {
            if (classesList.contains(biome)) {
                if (random.nextInt(chance) == 0) {
                    generator.generate(world, random, pos);
                }
            }
        }
    }

    private void runGenerator(WorldGenerator generator, World world, Random random, int chunkX, int chunkZ, int chance, Block topBlock, Class<?>... classes) {
        baseStructureGen(generator, world, random, chunkX, chunkZ, chance, topBlock, classes);
    }

    private void generateSurface(World world, Random rand, int chunkX, int chunkZ, int chunkY) {

        WorldGenerator genFire = new RefractaShroom();
        final int FireChance = 4;


        genBase2(world, rand, chunkX, chunkZ, chunkY, genFire, FireChance);
    }

    private void genBase2(World world, Random rand, int chunkX, int chunkZ, int chunkY, WorldGenerator genFire, int fireChance) {
        if (rand.nextInt(fireChance) <= 1) {
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


        genBase2(world, rand, chunkX, chunkZ, chunkY, genFire, FireChance);
    }

    private void generateSurfaceForGrassShrooms(World world, Random rand, int chunkX, int chunkZ, int chunkY) {

        WorldGenerator genFire = new GrassShroom();
        final int FireChance = 5;


        genBase2(world, rand, chunkX, chunkZ, chunkY, genFire, FireChance);
    }

    private void generateSurfaceForGShrooms(World world, Random rand, int chunkX, int chunkZ, int chunkY) {

        WorldGenerator genGrassShroomType = new ShroomPatchG();
        final int Chance = 6;


        genBase2(world, rand, chunkX, chunkZ, chunkY, genGrassShroomType, Chance);
    }

    private void generateSurfaceForRShrooms(World world, Random rand, int chunkX, int chunkZ, int chunkY) {

        WorldGenerator genRShroomType = new ShroomPatchR();
        final int Chance = 6;


        genBase2(world, rand, chunkX, chunkZ, chunkY, genRShroomType, Chance);
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


        genBase2(world, rand, chunkX, chunkZ, chunkY, genNShroomType, Chance);
    }
}
