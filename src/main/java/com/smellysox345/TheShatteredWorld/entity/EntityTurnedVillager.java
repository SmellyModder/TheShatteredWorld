package com.smellysox345.TheShatteredWorld.entity;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.monster.EntityVindicator;
import net.minecraft.world.World;

public class EntityTurnedVillager extends EntityVindicator{

	public EntityTurnedVillager(World worldIn) {
		super(worldIn);
		
	}

	@Override
	protected void applyEntityAttributes() 
	{
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(27.0D);
		this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.35D);
		this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(5.0D);
		 this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(13.0D);
	}
}
