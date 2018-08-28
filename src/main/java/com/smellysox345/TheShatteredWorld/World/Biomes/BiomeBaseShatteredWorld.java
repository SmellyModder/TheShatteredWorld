package com.smellysox345.TheShatteredWorld.World.Biomes;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.feature.WorldGenBigMushroom;
import net.minecraft.world.gen.feature.WorldGenBirchTree;

public class BiomeBaseShatteredWorld extends Biome{

	public BiomeBaseShatteredWorld(BiomeProperties props) {
		super(props);
	}

	@Override
	public float getSpawningChance() {
		return 0.11F;
	}
	
	public boolean doesPlayerHaveRequiredAchievement(EntityPlayer player) {
		return true;
	}
}
