package com.smellysox345.TheShatteredWorld.World.dimension.layers;

import java.util.Arrays;
import java.util.List;

import com.google.common.base.Supplier;
import com.smellysox345.TheShatteredWorld.init.BiomeInit;

import net.minecraft.block.Block;
import net.minecraft.init.Biomes;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;
import com.smellysox345.TheShatteredWorld.init.BiomeInit;

public class GenLayerSWBiomes extends GenLayer {

	private static final int RARE_BIOME_CHANCE = 15;

	protected static final List<Supplier<Biome>> commonBiomes = Arrays.asList(
			() -> BiomeInit.RF_SHROOM,
			() -> BiomeInit.REFRACTED_FOREST,
			() -> BiomeInit.R_ROOFED_FOREST
	);
	protected static final List<Supplier<Biome>> rareBiomes = Arrays.asList(
			() -> BiomeInit.SW_TAIGA,
			() -> BiomeInit.SW_TAIGAM,
			() -> BiomeInit.SW_TAIGAMP
	);

	public GenLayerSWBiomes(long l, GenLayer genlayer) {
		super(l);
		parent = genlayer;
	}

	public GenLayerSWBiomes(long l) {
		super(l);
	}

	@Override
	public int[] getInts(int x, int z, int width, int depth) {

		int dest[] = IntCache.getIntCache(width * depth);

		for (int dz = 0; dz < depth; dz++) {
			for (int dx = 0; dx < width; dx++) {
				initChunkSeed(dx + x, dz + z);
				if (nextInt(RARE_BIOME_CHANCE) == 0) {
					// make rare biome
					dest[dx + dz * width] = Biome.getIdForBiome(getRandomBiome(rareBiomes));
				} else {
					// make common biome
					dest[dx + dz * width] = Biome.getIdForBiome(getRandomBiome(commonBiomes));
				}
			}
		}

//		for (int i = 0; i < width * depth; i++)
//		{
//			if (dest[i] < 0 || dest[i] > TFBiomeBase.fireSwamp.biomeID)
//			{
//				System.err.printf("Made a bad ID, %d at %d, %d while generating\n", dest[i], x, z);
//			}
//		}

		return dest;
	}

	private Biome getRandomBiome(List<Supplier<Biome>> biomes) {
		return biomes.get(nextInt(biomes.size())).get();
	}
}
