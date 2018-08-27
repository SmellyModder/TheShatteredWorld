package com.smellysox345.TheShatteredWorld.World.dimension.shattered;

import com.smellysox345.TheShatteredWorld.World.dimension.library.ChunkGeneratorSW;
import com.smellysox345.TheShatteredWorld.World.dimension.library.FlorusChunkGenerator;
import com.smellysox345.TheShatteredWorld.World.dimension.library.FlorusTerrainGenerator;
import com.smellysox345.TheShatteredWorld.World.dimension.provider.ShatteredWorldProvider;
import com.smellysox345.TheShatteredWorld.init.BiomeInit;
import com.smellysox345.TheShatteredWorld.init.DimensionInit;

import net.minecraft.world.DimensionType;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.biome.BiomeProviderSingle;
import net.minecraft.world.gen.IChunkGenerator;
import smellysox345.lib.Config;

public class DimensionSW extends ShatteredWorldProvider{

	
	public DimensionSW()
	{
		this.biomeProvider = new BiomeProviderSingle(BiomeInit.RF_SHROOM);
		this.biomeProvider = new BiomeProviderSingle(BiomeInit.R_ROOFED_FOREST);
	}
	@Override
	public boolean canRespawnHere() 
	{
		return false;
	}
	
	@Override
	public boolean isSurfaceWorld() 
	{
		return false;
	}
}
