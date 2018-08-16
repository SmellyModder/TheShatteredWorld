package com.smellysox345.TheShatteredWorld.potion;

import com.smellysox345.TheShatteredWorld.Main;
import com.smellysox345.TheShatteredWorld.init.ModBlocks;
import com.smellysox345.TheShatteredWorld.init.ModItems;

import net.minecraft.init.Items;
import net.minecraft.init.PotionTypes;
import net.minecraft.item.Item;
import net.minecraft.potion.PotionEffect;
import net.minecraft.potion.PotionHelper;
import net.minecraft.potion.PotionType;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class PotionTypeRegistry extends PotionType{
	

	public static final PotionType D = new PotionType("deformation", new PotionEffect[] {new PotionEffect(Main.DEFORMATION_POTION, 2400)}).setRegistryName("Deformation");
	public static final PotionType SHROOM_BOUNCE = new PotionType("shroom_bounce", new PotionEffect[] {new PotionEffect(Main.BOUNCE_POTION, 2650)}).setRegistryName("shroom_bounce");
	
	public static void registerPotionTypes() {
		ForgeRegistries.POTION_TYPES.register(D);
		ForgeRegistries.POTION_TYPES.register(SHROOM_BOUNCE);
	}
}
