package com.smellysox345.TheShatteredWorld.init;

import com.smellysox345.TheShatteredWorld.Main;
import com.smellysox345.TheShatteredWorld.entity.EntityArachnoShroom;
import com.smellysox345.TheShatteredWorld.entity.EntityArachnoShroomQueen;
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
import com.smellysox345.TheShatteredWorld.entity.projectiles.EntityWebProjectileEgg;
import com.smellysox345.TheShatteredWorld.util.Reference;

import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.EntityRegistry;

public class EntityInit {

	public static void registerEntities() {
		
		//Wolf
		registerEntity("slimewolf", EntitySlimeWolf.class, Reference.ENTITY_SLIMEWOLF, 50, 7326320, 17920);
		registerEntity("slimewolfbaby", EntitySlimeWolfBaby.class, Reference.ENTITY_SLIMEWOLF_BABY, 50, 7326320, 17920);
		
		//Zombie
		
		
		//Shroom Mobs
		registerEntity("shroomite", EntityShroomite.class, Reference.ENTITY_SHROOMITE, 50, 4649, 16375471);
		registerEntity("nightshroom", EntityNightShroom.class, Reference.ENTITY_NIGHTSHROOM, 50, 4649, 1572908);
		registerEntity("arachnoshroom", EntityArachnoShroom.class, Reference.ENTITY_ARACHNOSHROOM, 50, 4649, 18799);
		registerEntity("shroomskeleton", EntityShroomSkeleton.class, Reference.ENTITY_SHROOMSKELETON, 50, 4649, 3750986);
		registerEntity("shroomcreeper", EntityShroomCreeper.class, Reference.ENTITY_SHROOMCREEPER, 50, 4649, 13864);
		registerEntity("shroomzombie", EntityShroomZombie.class, Reference.ENTITY_SHROOM_ZOMBIE, 50, 4649, 5909);
		registerEntity("arachnoshroomqueen", EntityArachnoShroomQueen.class, Reference.ENTITY_ARACHNOSHROOMQUEEN, 50, 4649, 5909);
		
		//Dark Mobs
		registerEntity("turnedvillager", EntityTurnedVillager.class, Reference.ENTITY_TURNED_VILLAGER, 50, 4649, 5909);
	
	}
	
	//Registers stuff that has no egg
	public static void registerEntities2() {
		
		registerEntity2("webprojectile", EntityWebProjectile.class , Reference.ENTITY_ARACHNOSHROOM_WEB, 50);
		registerEntity2("webprojectileegg", EntityWebProjectileEgg.class , Reference.ENTITY_ARACHNOSHROOM_EGG, 50);
		
		//Questers
		registerEntity2("shroom_wizard", NPCShroomWizard.class , Reference.ENTITY_SHROOM_WIZ, 50);
	}
	
	private static void registerEntity2(String entityName, Class<? extends Entity> entityClass, int id, int range) {
		
		
		EntityRegistry.registerModEntity(new ResourceLocation(Reference.MOD_ID + ":" + entityName), entityClass, entityName, id, Main.instance, range, 1, true);
		
		
	}
	
	
	private static void registerEntity(String name, Class<? extends Entity> entity, int id, int range, int color1, int color2) {
		
		
		EntityRegistry.registerModEntity(new ResourceLocation(Reference.MOD_ID + ":" + name), entity, name, id, Main.instance, range, 1, true, color1, color2);
		
		
	}
}
