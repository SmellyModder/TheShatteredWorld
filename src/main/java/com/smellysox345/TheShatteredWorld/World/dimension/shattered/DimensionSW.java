package com.smellysox345.TheShatteredWorld.World.dimension.shattered;

import com.smellysox345.TheShatteredWorld.World.dimension.library.ChunkGeneratorSW;
import com.smellysox345.TheShatteredWorld.World.dimension.library.ChunkGeneratorShatteredWorld;
import com.smellysox345.TheShatteredWorld.World.dimension.library.FlorusChunkGenerator;
import com.smellysox345.TheShatteredWorld.World.dimension.library.FlorusTerrainGenerator;
import com.smellysox345.TheShatteredWorld.World.dimension.provider.SWBiomeProvider;
import com.smellysox345.TheShatteredWorld.init.BiomeInit;
import com.smellysox345.TheShatteredWorld.init.DimensionInit;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.DimensionType;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.biome.BiomeProviderSingle;
import net.minecraft.world.gen.IChunkGenerator;
import smellysox345.lib.Config;

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
	public IChunkGenerator createChunkGenerator() {
		return new ChunkGeneratorShatteredWorld(this.world, this.world.getSeed() - 14175);
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
