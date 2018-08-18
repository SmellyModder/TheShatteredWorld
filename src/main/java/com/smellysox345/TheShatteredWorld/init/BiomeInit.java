package com.smellysox345.TheShatteredWorld.init;

import com.smellysox345.TheShatteredWorld.World.Biomes.BiomeRForest;
import com.smellysox345.TheShatteredWorld.World.Biomes.BiomeRefractedRoofedForest;
import com.smellysox345.TheShatteredWorld.World.Biomes.BiomeShroomValley;

import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeManager.BiomeEntry;
import net.minecraftforge.common.BiomeManager.BiomeType;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.registries.ForgeRegistry;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.common.BiomeManager;

public class BiomeInit {

	public static final Biome REFRACTED_FOREST = new BiomeRForest();
	
	public static final Biome RF_SHROOM = new BiomeShroomValley();
	
	public static final Biome R_ROOFED_FOREST = new BiomeRefractedRoofedForest();
	
	public static void registerBiomes() {
	
		//initBiome(REFRACTED_FOREST, "RForest", BiomeType.WARM, Type.MAGICAL, Type.FOREST);
		initBiome(RF_SHROOM, "RShroom", BiomeType.COOL, Type.MAGICAL, Type.DEAD);
		initBiome(R_ROOFED_FOREST, "RRoofedForest", BiomeType.WARM, Type.FOREST, Type.DEAD);
	}
	
	public static Biome initBiome(Biome biome, String name, BiomeType biometype, Type... types)
	{
		biome.setRegistryName(name);
		ForgeRegistries.BIOMES.register(biome);
		BiomeDictionary.addTypes(biome, types);
		BiomeManager.addBiome(biometype, new BiomeEntry(biome, 40));
		BiomeManager.addSpawnBiome(biome);
		return biome;
	}
}
