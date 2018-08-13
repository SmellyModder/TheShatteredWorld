package com.smellysox345.TheShatteredWorld.entity;

import com.smellysox345.TheShatteredWorld.util.handlers.SoundHandler;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

public class EntitySlimeWolf extends EntityWolf{

	public EntitySlimeWolf(World worldIn) {
		super(worldIn);
		this.setSize(0.6F, 0.85F);
		
	}
	
	@Override
	protected void applyEntityAttributes() 
	{
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(40.0D);
		this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.35D);
	}
	
	@Override 
	public EntitySlimeWolfBaby createChild(EntityAgeable ageable) {
		
		return new EntitySlimeWolfBaby(world);
		
	}

	@Override
	protected SoundEvent getHurtSound(DamageSource damage) {
		
		return SoundHandler.ENTITY_SLIMEWOLF_HURT;
		
	}
	

	@Override
	protected SoundEvent getDeathSound() {
		
		return SoundHandler.ENTITY_SLIMEWOLF_DEATH;
		
	}
	
	
	@Override
	public void onDeath(DamageSource source) {
		super.onDeath(source);
		int x = (int) this.posX;
		int y = (int) this.posY;
		int z = (int) this.posZ;
		Entity entity = this;

		if (true) {
			Entity sentity = new EntitySlimeWolfBaby(world);
			Entity sentity2 = new EntitySlimeWolfBaby(world);
			if (sentity != null && !world.isRemote) {
				sentity.setLocationAndAngles(posX, posY, posZ, world.rand.nextFloat() * 360F, 0.0F);
				world.spawnEntity(sentity);
				
				sentity2.setLocationAndAngles(posX, posY, posZ, world.rand.nextFloat() * 360F, 0.0F);
				world.spawnEntity(sentity2);
			}
		}

	}
}
