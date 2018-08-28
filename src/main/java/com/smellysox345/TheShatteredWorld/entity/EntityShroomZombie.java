package com.smellysox345.TheShatteredWorld.entity;

import com.smellysox345.TheShatteredWorld.util.handlers.SoundHandler;

import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.EnumSkyBlock;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class EntityShroomZombie extends EntityZombie{

	public EntityShroomZombie(World worldIn) {
		super(worldIn);
		this.setSize(0.6F, 1.95F);
	}
	
	@Override
	protected void applyEntityAttributes() 
	{
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(22.0D);
		this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.21D);
	}
	
	public EntityShroomZombie createChild(EntityAgeable ageable) {
		
		return new EntityShroomZombie(world);
		
	}

	@Override
	protected SoundEvent getHurtSound(DamageSource damage) {
		
		return SoundHandler.ENTITY_SLIMEWOLF_HURT;
		
	}
	

	@Override
	protected SoundEvent getDeathSound() {
		
		return SoundHandler.ENTITY_SLIMEWOLF_DEATH;
		
	}
	
	@SideOnly(Side.CLIENT)
	 public int getBrightnessForRender()
	 {
	        return 15728880;
	 }

	    /**
	     * Gets how bright this entity is.
	     */
	    public float getBrightness()
	    {
	        return 0.0F;
	    }
	 
	@Override
	public boolean getCanSpawnHere()
	{
	        return this.world.getDifficulty() != EnumDifficulty.PEACEFUL && this.isValidLightLevel2() && super.getCanSpawnHere();
	}
	
	 protected boolean isValidLightLevel2()
	    {
	        BlockPos blockpos = new BlockPos(this.posX, this.getEntityBoundingBox().minY, this.posZ);

	        if (this.world.getLightFor(EnumSkyBlock.SKY, blockpos) > this.rand.nextInt(32))
	        {
	            return false;
	        }
	        else
	        {
	            int i = this.world.getLightFromNeighbors(blockpos);

	            if (this.world.isThundering())
	            {
	                int j = this.world.getSkylightSubtracted();
	                this.world.setSkylightSubtracted(10);
	                i = this.world.getLightFromNeighbors(blockpos);
	                this.world.setSkylightSubtracted(j);
	            }

	            return i <= this.rand.nextInt(8);
	        }
	    }
}
