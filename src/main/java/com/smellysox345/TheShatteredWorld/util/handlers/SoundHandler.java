package com.smellysox345.TheShatteredWorld.util.handlers;

import com.smellysox345.TheShatteredWorld.util.Reference;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class SoundHandler {

public static SoundEvent ENTITY_SLIMEWOLF_HURT, ENTITY_SLIMEWOLF_DEATH, ENTITY_SHROOMWIZ_HURT, ENTITY_SHROOMWIZ_LIVING, ENTITY_SHROOMWIZ_DEATH;
	
	public static void registerSounds() {
		
		//Wolf
		ENTITY_SLIMEWOLF_HURT = registerSound("entity.slimewolf.hurt");
		ENTITY_SLIMEWOLF_DEATH = registerSound("entity.slimewolf.death");
		
		//NPC
		ENTITY_SHROOMWIZ_HURT = registerSound("entity.shroomwiz.hit_shroomwiz");
		ENTITY_SHROOMWIZ_LIVING = registerSound("entity.shroomwiz.haggle_shroomwiz");
		ENTITY_SHROOMWIZ_DEATH = registerSound("entity.shroomwiz.death_shroomwiz");
		
	}
	
	public static SoundEvent registerSound(String name) {
		
		ResourceLocation location = new ResourceLocation(Reference.MOD_ID, name);
		SoundEvent event = new SoundEvent(location);
		event.setRegistryName(name);
		ForgeRegistries.SOUND_EVENTS.register(event);
		return event;
	}
}
