package com.smellysox345.TheShatteredWorld.entity;

import com.smellysox345.TheShatteredWorld.entity.projectiles.EntityWebProjectile;
import com.smellysox345.TheShatteredWorld.entity.projectiles.EntityWebProjectileEgg;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackMelee;
import net.minecraft.entity.ai.EntityAIAttackRanged;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILeapAtTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWanderAvoidWater;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.monster.EntityIronGolem;
import net.minecraft.entity.monster.EntitySpider;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.BossInfo;
import net.minecraft.world.BossInfoServer;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class EntityArachnoShroomQueen extends EntitySpider implements IRangedAttackMob{
	
	
	private final BossInfoServer bossInfo = (BossInfoServer)(new BossInfoServer(this.getDisplayName(), BossInfo.Color.BLUE, BossInfo.Overlay.PROGRESS)).setDarkenSky(true);
	
	public static int AI_SHOOT_AMOUNT = 3;
	public static int AI_MELEE_AMOUNT = 3;
	
	public EntityArachnoShroomQueen(World worldIn) {
		super(worldIn);
		this.setSize(3.1F, 2.1F);
		this.experienceValue = 345;
	}
	
	@Override
	protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(280.0D);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.35000001192092896D);
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(9.0D);
        this.getEntityAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(13.0D);
        this.getEntityAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE).setBaseValue(0.5D);
    }
	
	@Override
	protected void initEntityAI()
    {
        this.tasks.addTask(1, new EntityAISwimming(this));
        this.tasks.addTask(3, new EntityAILeapAtTarget(this, 0.4F));
        this.tasks.addTask(5, new EntityAIWanderAvoidWater(this, 0.8D));
        this.tasks.addTask(AI_MELEE_AMOUNT, new EntityArachnoShroomQueen.AISpiderAttack(this));
        this.tasks.addTask(6, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
        this.tasks.addTask(6, new EntityAILookIdle(this));
        this.tasks.addTask(3, new EntityAIAttackRanged(this, 1, 30, 55));
        this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false, new Class[0]));
        this.targetTasks.addTask(2, new EntityArachnoShroomQueen.AISpiderTarget(this, EntityPlayer.class));
        this.targetTasks.addTask(3, new EntityArachnoShroomQueen.AISpiderTarget(this, EntityIronGolem.class));
    }
	
	@Override
	public void onDeath(DamageSource source) {
		super.onDeath(source);
		int i = (int) this.posX;
		int j = (int) this.posY;
		int k = (int) this.posZ;
		Entity entity = this;

		if (true) {
			Entity sentity = new EntityXPOrb(world);
			if (sentity != null && !world.isRemote) {
				sentity.setLocationAndAngles(i, j, k, world.rand.nextFloat() * 360F, 0.0F);
				world.spawnEntity(sentity);
			}
		}

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
	public void addTrackingPlayer(EntityPlayerMP player) {
		super.addTrackingPlayer(player);
		this.bossInfo.addPlayer(player);
	}

	@Override
	public void removeTrackingPlayer(EntityPlayerMP player) {
		super.removeTrackingPlayer(player);
		this.bossInfo.removePlayer(player);
	}

	@Override
	public void onUpdate() {
		super.onUpdate();
		this.bossInfo.setPercent(this.getHealth() / this.getMaxHealth());
	}
	
	static class AISpiderAttack extends EntityAIAttackMelee
    {
        public AISpiderAttack(EntityArachnoShroomQueen spider)
        {
            super(spider, 1.0D, true);
        }

        /**
         * Returns whether an in-progress EntityAIBase should continue executing
         */
        public boolean shouldContinueExecuting()
        {
            float f = this.attacker.getBrightness();

            if (f >= 0.0F && this.attacker.getRNG().nextInt(100) == 0)
            {
                this.attacker.setAttackTarget((EntityLivingBase)null);
                AI_MELEE_AMOUNT = 5;
                return false;
            }
            else
            {
                return super.shouldContinueExecuting();
            }
        }

        protected double getAttackReachSqr(EntityLivingBase attackTarget)
        {
            return (double)(5.5F + attackTarget.width);
        }
    }

	static class AISpiderTarget<T extends EntityLivingBase> extends EntityAINearestAttackableTarget<T>
    {
        public AISpiderTarget(EntityArachnoShroomQueen spider, Class<T> classTarget)
        {
            super(spider, classTarget, true);
        }

        /**
         * Returns whether the EntityAIBase should begin execution.
         */
        public boolean shouldExecute()
        {
            float f = this.taskOwner.getBrightness();
            return f >= 0.5F ? false : super.shouldExecute();
        }
    }
	
	@Override
	public float getEyeHeight()
	{
	        return 0.85F;
	}
	
	@Override
	public void attackEntityWithRangedAttack(EntityLivingBase target, float p_82196_2_) {
		EntityThrowable projectile = new EntityWebProjectileEgg(this.world, this);
		playSound(SoundEvents.ENTITY_LLAMA_SPIT, 1.0F, 1.0F / (this.getRNG().nextFloat() * 0.4F + 0.8F));
		double tx = target.posX - this.posX;
		double ty = target.posY + target.getEyeHeight() + 2.100000023841858D - projectile.posY;
		double tz = target.posZ - this.posZ;
		float heightOffset = MathHelper.sqrt(tx * tx + tz * tz) * 0.2F;
		projectile.shoot(tx, ty + heightOffset, tz, 0.6F, 6.0F);
		this.world.spawnEntity(projectile);
	}

	@Override
	public void setSwingingArms(boolean swingingArms) {
		
	}
}
