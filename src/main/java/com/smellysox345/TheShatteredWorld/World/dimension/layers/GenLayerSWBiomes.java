package com.smellysox345.TheShatteredWorld.World.dimension.layers;

import com.smellysox345.TheShatteredWorld.init.BiomeInit;

import net.minecraft.init.Biomes;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;

public class GenLayerSWBiomes extends GenLayer {

	protected Biome[] allowedBiomes = {BiomeInit.R_ROOFED_FOREST, BiomeInit.REFRACTED_FOREST, BiomeInit.RF_SHROOM};

	public GenLayerSWBiomes(long seed, GenLayer genlayer) {
		super(seed);
		parent = genlayer;
	}

	public GenLayerSWBiomes(long seed) {
		super(seed);
	}

	@Override
	public int[] getInts(int x, int z, int width, int depth)
	{
		int[] dest = IntCache.getIntCache(width*depth);

		for (int dz=0; dz<depth; dz++)
			for (int dx=0; dx<width; dx++)
			{
				initChunkSeed(dx+x, dz+z);
				dest[dx+dz*width] = Biome.getIdForBiome(allowedBiomes[nextInt(allowedBiomes.length)]);
			}
		return dest;
	}

}
