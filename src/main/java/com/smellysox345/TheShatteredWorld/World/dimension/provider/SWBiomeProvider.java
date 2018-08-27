package com.smellysox345.TheShatteredWorld.World.dimension.provider;

import java.util.Arrays;

import com.smellysox345.TheShatteredWorld.World.dimension.layers.GenLayerSWStabilize;
import com.smellysox345.TheShatteredWorld.World.dimension.layers.LayerGenSW;
import com.smellysox345.TheShatteredWorld.init.BiomeInit;

import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeProvider;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.GenLayerSmooth;
import net.minecraft.world.gen.layer.GenLayerVoronoiZoom;
import net.minecraft.world.gen.layer.GenLayerZoom;

public class SWBiomeProvider extends BiomeProvider{

	private final SWBiomeCache mapCache;
	private GenLayer genBiomes;
	private GenLayer biomeIndexLayer;

	public SWBiomeProvider(World world) {
		getBiomesToSpawnIn().clear();
		getBiomesToSpawnIn().add(BiomeInit.R_ROOFED_FOREST);
		getBiomesToSpawnIn().add(BiomeInit.RF_SHROOM);
		getBiomesToSpawnIn().add(BiomeInit.REFRACTED_FOREST);
		makeLayers(world.getSeed());
		mapCache = new SWBiomeCache(this, 512, true);
	}

	private void makeLayers(long seed) {
		GenLayer biomes = new LayerGenSW(1L);

		biomes = new GenLayerZoom(1000L, biomes);
		biomes = new GenLayerZoom(1001, biomes);

		biomes = new GenLayerSWStabilize(700L, biomes);

		biomes = new GenLayerZoom(1002, biomes);
		biomes = new GenLayerZoom(1003, biomes);
		biomes = new GenLayerZoom(1004, biomes);
		biomes = new GenLayerZoom(1005, biomes);

		// do "voronoi" zoom
		GenLayer genlayervoronoizoom = new GenLayerVoronoiZoom(10L, biomes);

		biomes.initWorldGenSeed(seed);
		genlayervoronoizoom.initWorldGenSeed(seed);

		genBiomes = biomes;
		biomeIndexLayer = genlayervoronoizoom;
	}

	@Override
	public Biome[] getBiomesForGeneration(Biome[] biomes, int x, int z, int width, int height) {
		return getBiomesForGeneration(biomes, x, z, width, height, true);
	}

	public Biome[] getBiomesForGeneration(Biome[] biomes, int x, int z, int width, int height, boolean useCache) {
		// for grid-centred magic maps, get from map cache
		if (useCache && mapCache.isGridAligned(x, z, width, height)) {
			Biome[] cached = mapCache.getBiomes(x, z);
			return Arrays.copyOf(cached, cached.length);
		}
		return super.getBiomesForGeneration(biomes, x, z, width, height);
	}

	@Override
	public void cleanupCache() {
		mapCache.cleanup();
		super.cleanupCache();
	}
}
