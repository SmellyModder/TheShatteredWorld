package com.smellysox345.TheShatteredWorld.init;


import com.smellysox345.TheShatteredWorld.World.dimension.provider.SWWorldProvider;
import com.smellysox345.TheShatteredWorld.World.dimension.shattered.DimensionSW;
import com.smellysox345.TheShatteredWorld.util.Reference;

import net.minecraft.world.DimensionType;
import net.minecraftforge.common.DimensionManager;
import smellysox345.lib.Config;

public class DimensionInit {

	public static final DimensionType SW = DimensionType.register(Reference.MODID, "_sw", Config.ShatteredWorldDimId, SWWorldProvider.class, false);
	
	public static void registerDimensions() {
		
		DimensionManager.registerDimension(Config.ShatteredWorldDimId, SW);
		
	}
	
}
