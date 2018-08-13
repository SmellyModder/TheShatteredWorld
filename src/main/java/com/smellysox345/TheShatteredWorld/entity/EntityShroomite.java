package com.smellysox345.TheShatteredWorld.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackMelee;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILeapAtTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWanderAvoidWater;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.ai.EntityJumpHelper;
import net.minecraft.entity.ai.EntityMoveHelper;
import net.minecraft.entity.monster.EntityIronGolem;
import net.minecraft.entity.monster.EntitySlime;
import net.minecraft.entity.monster.EntitySpider;
import net.minecraft.entity.passive.EntityRabbit;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.pathfinding.Path;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;


public class EntityShroomite extends EntitySpider{
	
	private int jumpTicks;
	private int jumpDuration;
	
	public boolean hasJumped = false;

	public EntityShroomite(World worldIn) {
		super(worldIn);
		this.setSize(0.7F, 1.0F);
	    this.setMovementSpeed(0.1D);
	    this.jumpHelper = new EntityShroomite.JumpHelper(this);
	}
	
	@Override
	protected void applyEntityAttributes() 
	{
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(9.0D);
		this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.29D);
	}
	
	@Override
	protected void initEntityAI()
    {
        this.tasks.addTask(1, new EntityAISwimming(this));
        this.tasks.addTask(3, new EntityAILeapAtTarget(this, 0.4F));
        this.tasks.addTask(4, new EntityShroomite.AIShroomiteAttack(this));
        this.targetTasks.addTask(2, new EntityShroomite.AIShroomiteTarget(this, EntityPlayer.class));
        this.tasks.addTask(5, new EntityAIWanderAvoidWater(this, 0.8D));
        this.tasks.addTask(6, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
        this.tasks.addTask(6, new EntityAILookIdle(this));
        this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false, new Class[0]));
    }
	
	@Override
	protected void entityInit()
    {
        super.entityInit();
    }
	
	
	protected void jump()
	    {
	        super.jump();
	        double d0 = this.moveHelper.getSpeed();

	        if (d0 > 0.0D)
	        {
	            double d1 = this.motionX * this.motionX + this.motionZ * this.motionZ;

	            if (d1 < 0.010000000000000002D)
	            {
	                this.moveRelative(0.0F, 0.0F, 1.5F, 0.4F);
	            }
	        }

	        if (!this.world.isRemote)
	        {
	            this.world.setEntityState(this, (byte)1);
	        }
	    }
	
	protected float getJumpUpwardsMotion()
    {
        if (!this.collidedHorizontally && (!this.moveHelper.isUpdating() || this.moveHelper.getY() <= this.posY + 0.5D))
        {
            Path path = this.navigator.getPath();

            if (path != null && path.getCurrentPathIndex() < path.getCurrentPathLength())
            {
                Vec3d vec3d = path.getPosition(this);

                if (vec3d.y > this.posY + 0.5D)
                {
                    return 0.5F;
                }
            }

            return this.moveHelper.getSpeed() <= 0.6D ? 0.2F : 0.3F;
        }
        else
        {
            return 0.5F;
        }
    }
	
	 public void startJumping()
	    {
	        this.setJumping(true);
	        this.jumpDuration = 10;
	        this.jumpTicks = 0;
	    }
	 
    public class JumpHelper extends EntityJumpHelper
    {
        private final EntityShroomite shroomite;
        private boolean canJump;

        public JumpHelper(EntityShroomite shroom)
        {
            super(shroom);
            this.shroomite = shroom;
        }

        public boolean getIsJumping()
        {
            return this.isJumping;
        }

        public boolean canJump()
        {
            return this.canJump;
        }

        public void setCanJump(boolean canJumpIn)
        {
            this.canJump = canJumpIn;
        }

        /**
         * Called to actually make the entity jump if isJumping is true.
         */
        public void doJump()
        {
            if (this.isJumping)
            {
                this.shroomite.startJumping();
                this.isJumping = false;
                hasJumped = true;
            }
        }
    }
    
	public void setMovementSpeed(double newSpeed)
    {
        this.getNavigator().setSpeed(newSpeed);
        this.moveHelper.setMoveTo(this.moveHelper.getX(), this.moveHelper.getY(), this.moveHelper.getZ(), newSpeed);
    }
	
	
	static class AIShroomiteAttack extends EntityAIAttackMelee
    {

		public AIShroomiteAttack(EntityShroomite shroomite)
        {
            super(shroomite, 1.0D, true);
        }
		
		
		
		 
        public boolean shouldContinueExecuting()
        {
            float f = this.attacker.getBrightness();

            if (f >= 0.5F && this.attacker.getRNG().nextInt(100) == 0)
            {
                this.attacker.setAttackTarget((EntityLivingBase)null);
                return false;
            }
            else
            {
                return super.shouldContinueExecuting();
            }
        }

        protected double getAttackReachSqr(EntityLivingBase attackTarget)
        {
            return (double)(4.0F + attackTarget.width);
        }
    }
	
	
	 static class AIShroomiteTarget<T extends EntityLivingBase> extends EntityAINearestAttackableTarget<T>
     {
         public AIShroomiteTarget(EntityShroomite shroomite, Class<T> classTarget)
         {
             super(shroomite, classTarget, true);
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
}
