package com.smellysox345.TheShatteredWorld.init;

import com.smellysox345.TheShatteredWorld.World.Biomes.BiomeRForest;
import com.smellysox345.TheShatteredWorld.World.Biomes.BiomeRefractedRoofedForest;
import com.smellysox345.TheShatteredWorld.World.Biomes.BiomeSWTaiga;
import com.smellysox345.TheShatteredWorld.World.Biomes.BiomeShroomValley;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeTaiga;
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
	
	public static final Biome SW_TAIGA = new BiomeSWTaiga(BiomeSWTaiga.Type.NORMAL, new Biome.BiomeProperties("SWTaiga"));
	public static final Biome SW_TAIGAM = new BiomeSWTaiga(BiomeSWTaiga.Type.MEGA, new Biome.BiomeProperties("SWTaiga"));
	public static final Biome SW_TAIGAMP = new BiomeSWTaiga(BiomeSWTaiga.Type.MEGA_SPRUCE, new Biome.BiomeProperties("SWTaiga"));
	
	public static void registerBiomes() {
	
		initBiome(REFRACTED_FOREST, "RForest", BiomeType.WARM, Type.MAGICAL, Type.FOREST);
		initBiome(RF_SHROOM, "RShroom", BiomeType.COOL, Type.MAGICAL, Type.DEAD);
		initBiome(R_ROOFED_FOREST, "RRoofedForest", BiomeType.WARM, Type.FOREST, Type.DEAD);
		initBiome(SW_TAIGA, "RTaiga", BiomeType.ICY, Type.CONIFEROUS, Type.COLD);
		initBiome(SW_TAIGAM, "RTaigaM", BiomeType.ICY, Type.FOREST, Type.COLD);
		initBiome(SW_TAIGAMP, "RTaigaMP", BiomeType.ICY, Type.FOREST, Type.COLD);
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
	
	static int gen = 1;
	
	 public static void addBiomes() {
		 if(gen == 1) {
			  addBiome(R_ROOFED_FOREST);
		 }
	 }
	
	private static Biome addBiome(Biome biome) {
        BiomeManager.addSpawnBiome(biome);
        return biome;
    }
}
