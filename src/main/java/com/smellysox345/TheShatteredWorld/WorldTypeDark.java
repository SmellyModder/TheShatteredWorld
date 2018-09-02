package com.smellysox345.TheShatteredWorld;

import com.smellysox345.TheShatteredWorld.init.BiomeInit;
import net.minecraft.world.World;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.BiomeProvider;
import net.minecraft.world.biome.BiomeProviderSingle;

public class WorldTypeDark extends WorldType
{
    public void init() {
    }

    public WorldTypeDark() {
        super("Roofed Forest");

    }

    @Override
    public BiomeProvider getBiomeProvider(World world)
    {
        return new BiomeProviderSingle(BiomeInit.R_ROOFED_FOREST);
    }
}