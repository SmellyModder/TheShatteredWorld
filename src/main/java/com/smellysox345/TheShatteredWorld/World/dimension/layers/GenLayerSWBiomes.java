package com.smellysox345.TheShatteredWorld.World.dimension.layers;

import com.smellysox345.TheShatteredWorld.init.BiomeInit;

import net.minecraft.block.Block;
import net.minecraft.init.Biomes;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;

public class GenLayerSWBiomes extends GenLayer {

	protected Biome[] allowedBiomes = {BiomeInit.REFRACTED_FOREST, BiomeInit.RF_SHROOM,BiomeInit.R_ROOFED_FOREST};
	protected Biome[] allowedRareBiomes = {};

	public GenLayerSWBiomes(long seed) {
		super(seed);
	}

	public GenLayerSWBiomes(long seed, GenLayer genlayer) {
		super(seed);
		this.parent = genlayer;
	}

	@Override
	public int[] getInts(int x, int z, int width, int depth) {
		int[] dest = IntCache.getIntCache(width * depth);
		for (int dz = 0; dz < depth; dz++) {
			for (int dx = 0; dx < width; dx++) {
				this.initChunkSeed(dx + x, dz + z);
				dest[(dx + dz * width)] = Biome.getIdForBiome(this.allowedBiomes[nextInt(this.allowedBiomes.length)]);
			}
		}
		return dest;
	}

	// helpers
	public static Block getBlock(IBlockAccess world, int i, int j, int k) {
	return world.getBlockState(new BlockPos(i, j, k)).getBlock();
	}

}
