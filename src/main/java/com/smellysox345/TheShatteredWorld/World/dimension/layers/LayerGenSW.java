package com.smellysox345.TheShatteredWorld.World.dimension.layers;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;
import com.smellysox345.TheShatteredWorld.init.BiomeInit;

public class LayerGenSW extends GenLayer{

	private static final int RARE_BIOME_CHANCE = 12;

	protected static final List<Supplier<Biome>> commonBiomes = Arrays.asList(
			() -> BiomeInit.RF_SHROOM
	);
	protected static final List<Supplier<Biome>> rareBiomes = Arrays.asList(
			() -> BiomeInit.R_ROOFED_FOREST
	);

	public LayerGenSW(long l, GenLayer genlayer) {
		super(l);
		parent = genlayer;
	}

	public LayerGenSW(long l) {
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
		return dest;
	}

	private Biome getRandomBiome(List<Supplier<Biome>> biomes) {
		return biomes.get(nextInt(biomes.size())).get();
	}
}
