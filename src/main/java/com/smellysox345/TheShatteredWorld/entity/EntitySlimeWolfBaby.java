package com.smellysox345.TheShatteredWorld.entity;

import com.smellysox345.TheShatteredWorld.util.handlers.SoundHandler;

import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

public class EntitySlimeWolfBaby extends EntityWolf{

	public EntitySlimeWolfBaby(World worldIn) {
		super(worldIn);
		this.setSize(0.3F, 0.45F);
		
	}

	
	
	@Override
	protected void applyEntityAttributes() 
	{
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(20.0D);
		this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.35D);
	}
	
	@Override 
	public EntitySlimeWolf createChild(EntityAgeable ageable) {
		
		return null;
		
	}

	@Override
	protected SoundEvent getHurtSound(DamageSource damage) {
		
		return SoundHandler.ENTITY_SLIMEWOLF_HURT;
		
	}
	

	@Override
	protected SoundEvent getDeathSound() {
		
		return SoundHandler.ENTITY_SLIMEWOLF_DEATH;
		
	}
	
	
	
	
	
}
