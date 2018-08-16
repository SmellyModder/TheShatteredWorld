package com.smellysox345.TheShatteredWorld.util.handlers;

import com.smellysox345.TheShatteredWorld.entity.EntityArachnoShroom;
import com.smellysox345.TheShatteredWorld.entity.EntityArachnoShroomQueen;
import com.smellysox345.TheShatteredWorld.entity.EntityFlyingEye;
import com.smellysox345.TheShatteredWorld.entity.EntityNightShroom;
import com.smellysox345.TheShatteredWorld.entity.EntityShroomCreeper;
import com.smellysox345.TheShatteredWorld.entity.EntityShroomSkeleton;
import com.smellysox345.TheShatteredWorld.entity.EntityShroomZombie;
import com.smellysox345.TheShatteredWorld.entity.EntityShroomite;
import com.smellysox345.TheShatteredWorld.entity.EntitySlimeWolf;
import com.smellysox345.TheShatteredWorld.entity.EntitySlimeWolfBaby;
import com.smellysox345.TheShatteredWorld.entity.EntityTurnedVillager;
import com.smellysox345.TheShatteredWorld.entity.NPCShroomWizard;
import com.smellysox345.TheShatteredWorld.entity.projectiles.EntityWebProjectile;
import com.smellysox345.TheShatteredWorld.entity.projectiles.render.RenderWebProjectile;
import com.smellysox345.TheShatteredWorld.entity.render.RenderArachnoShroom;
import com.smellysox345.TheShatteredWorld.entity.render.RenderArachnoShroomQueen;
import com.smellysox345.TheShatteredWorld.entity.render.RenderFlyingEye;
import com.smellysox345.TheShatteredWorld.entity.render.RenderNightShroom;
import com.smellysox345.TheShatteredWorld.entity.render.RenderShroomCreeper;
import com.smellysox345.TheShatteredWorld.entity.render.RenderShroomSkeleton;
import com.smellysox345.TheShatteredWorld.entity.render.RenderShroomWizard;
import com.smellysox345.TheShatteredWorld.entity.render.RenderShroomZombie;
import com.smellysox345.TheShatteredWorld.entity.render.RenderShroomite;
import com.smellysox345.TheShatteredWorld.entity.render.RenderSlimeWolf;
import com.smellysox345.TheShatteredWorld.entity.render.RenderSlimeWolfBaby;
import com.smellysox345.TheShatteredWorld.entity.render.RenderTurnedVillager;
import com.smellysox345.TheShatteredWorld.init.EntityInit;

import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

public class RenderHandler {

	public static void registerEntityRenders() {
		
		RenderingRegistry.registerEntityRenderingHandler(EntitySlimeWolf.class, new IRenderFactory<EntitySlimeWolf>()
		{
			
			@Override
			public Render<? super EntitySlimeWolf> createRenderFor(RenderManager manager){
				
				return new RenderSlimeWolf(manager);
				
			}
			
		});
		
		RenderingRegistry.registerEntityRenderingHandler(EntitySlimeWolfBaby.class, new IRenderFactory<EntitySlimeWolfBaby>()
		{
			
			@Override
			public Render<? super EntitySlimeWolfBaby> createRenderFor(RenderManager manager){
				
				return new RenderSlimeWolfBaby(manager);
				
			}
			
		});
		
		RenderingRegistry.registerEntityRenderingHandler(EntityShroomZombie.class, new IRenderFactory<EntityShroomZombie>()
		{
			
			@Override
			public Render<? super EntityShroomZombie> createRenderFor(RenderManager manager){
				
				return new RenderShroomZombie(manager);
				
			}
			
		});
		
		RenderingRegistry.registerEntityRenderingHandler(EntityShroomite.class, new IRenderFactory<EntityShroomite>()
		{
			
			@Override
			public Render<? super EntityShroomite> createRenderFor(RenderManager manager){
				
				return new RenderShroomite(manager);
				
			}
			
		});
		
		RenderingRegistry.registerEntityRenderingHandler(EntityNightShroom.class, new IRenderFactory<EntityNightShroom>()
		{
			
			@Override
			public Render<? super EntityNightShroom> createRenderFor(RenderManager manager){
				
				return new RenderNightShroom(manager);
				
			}
			
		});
		
		RenderingRegistry.registerEntityRenderingHandler(EntityArachnoShroom.class, new IRenderFactory<EntityArachnoShroom>()
		{
			
			@Override
			public Render<? super EntityArachnoShroom> createRenderFor(RenderManager manager){
				
				return new RenderArachnoShroom(manager);
				
			}
			
		});
		
		RenderingRegistry.registerEntityRenderingHandler(EntityWebProjectile.class, new IRenderFactory<EntityWebProjectile>()
		{
			
			@Override
			public Render<? super EntityWebProjectile> createRenderFor(RenderManager manager){
				
				return new RenderWebProjectile(manager);
				
			}
			
		});
		
		RenderingRegistry.registerEntityRenderingHandler(EntityShroomSkeleton.class, new IRenderFactory<EntityShroomSkeleton>()
		{
			
			@Override
			public Render<? super EntityShroomSkeleton> createRenderFor(RenderManager manager){
				
				return new RenderShroomSkeleton(manager);
				
			}
			
		});
		
		RenderingRegistry.registerEntityRenderingHandler(EntityShroomCreeper.class, new IRenderFactory<EntityShroomCreeper>()
		{
			
			@Override
			public Render<? super EntityShroomCreeper> createRenderFor(RenderManager manager){
				
				return new RenderShroomCreeper(manager);
				
			}
			
		});
		
		RenderingRegistry.registerEntityRenderingHandler(EntityArachnoShroomQueen.class, new IRenderFactory<EntityArachnoShroomQueen>()
		{
			
			@Override
			public Render<? super EntityArachnoShroomQueen> createRenderFor(RenderManager manager){
				
				return new RenderArachnoShroomQueen(manager);
				
			}
			
		});
		
		RenderingRegistry.registerEntityRenderingHandler(EntityTurnedVillager.class, new IRenderFactory<EntityTurnedVillager>()
		{
			
			@Override
			public Render<? super EntityTurnedVillager> createRenderFor(RenderManager manager){
				
				return new RenderTurnedVillager(manager);
				
			}
			
		});
		
		RenderingRegistry.registerEntityRenderingHandler(NPCShroomWizard.class, new IRenderFactory<NPCShroomWizard>()
		{
			
			@Override
			public Render<? super NPCShroomWizard> createRenderFor(RenderManager manager){
				
				return new RenderShroomWizard(manager);
				
			}
			
		});
		
		RenderingRegistry.registerEntityRenderingHandler(EntityFlyingEye.class, new IRenderFactory<EntityFlyingEye>()
		{
			
			@Override
			public Render<? super EntityFlyingEye> createRenderFor(RenderManager manager){
				
				return new RenderFlyingEye(manager);
				
			}
			
		});
	}
	
	
	
}
