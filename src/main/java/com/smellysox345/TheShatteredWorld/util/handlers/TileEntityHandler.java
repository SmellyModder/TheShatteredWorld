package com.smellysox345.TheShatteredWorld.util.handlers;

import com.smellysox345.TheShatteredWorld.tileentity.TileEntityShroomChest;
import com.smellysox345.TheShatteredWorld.util.Reference;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class TileEntityHandler {

	public static void registerTileEntities() {
		GameRegistry.registerTileEntity(TileEntityShroomChest.class, new ResourceLocation(Reference.MOD_ID + ":shroom_chest"));
	}
}
