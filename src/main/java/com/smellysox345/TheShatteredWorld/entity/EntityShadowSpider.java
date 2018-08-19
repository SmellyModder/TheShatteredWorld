package com.smellysox345.TheShatteredWorld.entity;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.monster.EntitySpider;
import net.minecraft.world.World;

public class EntityShadowSpider extends EntitySpider{

	public EntityShadowSpider(World worldIn) {
		super(worldIn);
	}
	
	@Override
	protected void applyEntityAttributes() 
	{
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(21.0D);
		this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.3808678D);
		this.getEntityAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(3.5D);
	}

}
