package com.smellysox345.TheShatteredWorld.proxy;

import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.smellysox345.TheShatteredWorld.entity.EntitySlimeWolf;
import com.smellysox345.TheShatteredWorld.entity.model.ModelSlimeWolf;
import com.smellysox345.TheShatteredWorld.entity.render.RenderSlimeWolf;
import com.smellysox345.TheShatteredWorld.util.Reference;
import com.smellysox345.TheShatteredWorld.util.handlers.RegistryHandler;
import com.smellysox345.TheShatteredWorld.util.handlers.RenderHandler;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.entity.RenderManager;

public class ClientProxy extends CommonProxy 
{

	
	@Override
	public void preInit(FMLPreInitializationEvent event)
	{
		super.preInit(event);
	}
								
	@EventHandler
	public void init(FMLInitializationEvent event)
	{
		super.init(event);
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event)
	{
		super.postInit(event);
	}
	
	
	public void registerItemRenderer(Item item, int meta, String id) {
			
			ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(item.getRegistryName(), id));
		}
	
	
	@Override
	public void registerVariantRenderer(Item item, int meta, String filename, String id) 
	{
		ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(new ResourceLocation(Reference.MOD_ID, filename), id));
	}
	
	
}
