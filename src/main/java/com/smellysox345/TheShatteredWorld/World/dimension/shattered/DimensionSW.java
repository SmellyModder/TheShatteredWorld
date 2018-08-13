package com.smellysox345.TheShatteredWorld.World.dimension.shattered;

import com.smellysox345.TheShatteredWorld.World.dimension.library.ChunkGeneratorSW;
import com.smellysox345.TheShatteredWorld.World.dimension.library.FlorusChunkGenerator;
import com.smellysox345.TheShatteredWorld.World.dimension.library.FlorusTerrainGenerator;
import com.smellysox345.TheShatteredWorld.init.BiomeInit;
import com.smellysox345.TheShatteredWorld.init.DimensionInit;

import net.minecraft.world.DimensionType;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.biome.BiomeProviderSingle;
import net.minecraft.world.gen.IChunkGenerator;

public class DimensionSW extends WorldProvider{

	
	public DimensionSW()
	{
		this.biomeProvider = new BiomeProviderSingle(BiomeInit.REFRACTED_FOREST);
		this.biomeProvider = new BiomeProviderSingle(BiomeInit.RF_SHROOM);
	}
	
	@Override
	public DimensionType getDimensionType() 
	{
		return DimensionInit.SW;
	}
	
	@Override
	public IChunkGenerator createChunkGenerator() 
	{
		return new FlorusChunkGenerator(world);
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
