package com.smellysox345.TheShatteredWorld.init;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModRecipes {

	public static void init() {
		GameRegistry.addSmelting(ModItems.CORRUPTEDBEEF, new ItemStack(ModItems.CORRUPTEDCOOKEDBEEF, 1), 1.1F);
		GameRegistry.addSmelting(ModItems.CORRUPTEDPIGBEEF, new ItemStack(ModItems.CORRUPTEDCOOKEDPORKCHOP, 1), 1.1F);
	}
}
