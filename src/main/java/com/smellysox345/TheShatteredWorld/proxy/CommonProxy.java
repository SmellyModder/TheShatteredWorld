package com.smellysox345.TheShatteredWorld.proxy;

import com.smellysox345.TheShatteredWorld.util.handlers.RegistryHandler;

import net.minecraft.item.Item;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class CommonProxy 
{
	public void registerItemRenderer(Item item, int meta, String id) {}
	public void registerVariantRenderer(Item item, int meta, String filename, String id) {}
	
	
	public void preInit(FMLPreInitializationEvent event)
	{
		RegistryHandler.preInitRegistries();
	}
								
	
	public void init(FMLInitializationEvent event)
	{
	}
	
	
	public void postInit(FMLPostInitializationEvent event)
	{
	}
	
}
