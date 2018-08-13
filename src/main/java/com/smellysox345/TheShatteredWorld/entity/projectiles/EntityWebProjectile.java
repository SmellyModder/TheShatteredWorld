package com.smellysox345.TheShatteredWorld.entity.projectiles;

import com.smellysox345.TheShatteredWorld.init.ModBlocks;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.init.Blocks;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class EntityWebProjectile extends EntityThrowable{

	public EntityWebProjectile(World par1World) {
		super(par1World);
	}

	public EntityWebProjectile(World par1World, EntityLivingBase par2EntityLiving) {
		super(par1World, par2EntityLiving);
	}

	@Override
	public void onUpdate() {
		super.onUpdate();
		makeTrail();
	}

	@Override
	protected float getGravityVelocity() {
		return 0.006F;
	}

	private void makeTrail() {
		for (int i = 0; i < 2; i++) {
			double dx = posX + 0.5 * (rand.nextDouble() - rand.nextDouble());
			double dy = posY + 0.5 * (rand.nextDouble() - rand.nextDouble());
			double dz = posZ + 0.5 * (rand.nextDouble() - rand.nextDouble());
			world.spawnParticle(EnumParticleTypes.FIREWORKS_SPARK, dx, dy, dz, 0.0D, 0.0D, 0.0D);
		}
	}

	@Override
	public boolean attackEntityFrom(DamageSource damagesource, float i) {
		super.attackEntityFrom(damagesource, i);
		die();
		return true;
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void handleStatusUpdate(byte id) {
		if (id == 3) {
			for (int i = 0; i < 8; ++i) {
				this.world.spawnParticle(EnumParticleTypes.CRIT_MAGIC, this.posX, this.posY, this.posZ, rand.nextGaussian() * 0.05D, rand.nextDouble() * 0.2D, rand.nextGaussian() * 0.05D);
			}
		} else {
			super.handleStatusUpdate(id);
		}
	}

	@Override
	protected void onImpact(RayTraceResult target) {
		if (!world.isRemote && target.entityHit instanceof EntityLivingBase) {
			target.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), 5);
		}

		die();
	}

	public boolean placenow = false;
	
	private void die() {
		if (!this.world.isRemote) {
			this.playSound(SoundEvents.ENTITY_LLAMA_SPIT, 1.0F, 1.0F / (rand.nextFloat() * 0.4F + 0.8F));
			this.setDead();
			this.world.setEntityState(this, (byte) 3);
			int i = (int) this.posX;
			int j = (int) this.posY;
			int k = (int) this.posZ;
			Entity entity = this;
			world.setBlockState(new BlockPos(i, j , k), ModBlocks.SHROOMWEB_BLOCK.getDefaultState(), 3);
		}
		}
	
	
	public void onDeath(DamageSource source) {
		if(placenow == true) {
		
		}
	}
}
