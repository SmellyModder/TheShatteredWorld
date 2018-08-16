package com.smellysox345.TheShatteredWorld.entity;

import java.util.Calendar;

import javax.annotation.Nullable;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IEntityLivingData;
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
import net.minecraft.entity.monster.EntityIronGolem;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.passive.EntityAmbientCreature;
import net.minecraft.entity.passive.EntityBat;
import net.minecraft.entity.passive.EntityRabbit;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.datafix.DataFixer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeDesert;


public class EntityFlyingEye extends EntityMob{
	
	private static final DataParameter<Byte> HANGING = EntityDataManager.<Byte>createKey(EntityFlyingEye.class, DataSerializers.BYTE);
	private static final DataParameter<Integer> VARIANT = EntityDataManager.<Integer>createKey(EntityFlyingEye.class, DataSerializers.VARINT);
	
    private BlockPos spawnPosition;
    
    public EntityFlyingEye(World worldIn)
    {
        super(worldIn);
        this.setSize(0.5F, 1.0F);
        this.setIsBatHanging(true);
    }
    
    @Nullable
    public IEntityLivingData onInitialSpawn(DifficultyInstance difficulty, @Nullable IEntityLivingData livingdata)
    {
        this.setVariant(this.rand.nextInt(5));
        return super.onInitialSpawn(difficulty, livingdata);
    }
    
    public int getVariant()
    {
        return MathHelper.clamp(((Integer)this.dataManager.get(VARIANT)).intValue(), 0, 4);
    }

    public void setVariant(int p_191997_1_)
    {
        this.dataManager.set(VARIANT, Integer.valueOf(p_191997_1_));
    }

    protected void entityInit()
    {
        super.entityInit();
        this.dataManager.register(HANGING, Byte.valueOf((byte)0));
        this.dataManager.register(VARIANT, Integer.valueOf(0));
    }
    
    @Override
	protected void initEntityAI()
    {
        this.tasks.addTask(3, new EntityAILeapAtTarget(this, 0.4F));
        this.tasks.addTask(3, new EntityFlyingEye.AIEyeAttack(this));
        this.targetTasks.addTask(2, new EntityAIHurtByTarget(this, false, new Class[0]));
        this.targetTasks.addTask(1, new EntityFlyingEye.AIEyeTarget(this, EntityPlayer.class));
        this.targetTasks.addTask(3, new EntityFlyingEye.AIEyeTarget(this, EntityBat.class));
    }

    /**
     * Returns the volume for the sounds this mob makes.
     */
    protected float getSoundVolume()
    {
        return 0.1F;
    }

    /**
     * Gets the pitch of living sounds in living entities.
     */
    protected float getSoundPitch()
    {
        return super.getSoundPitch() * 0.0090F;
    }

    @Nullable
    public SoundEvent getAmbientSound()
    {
        return this.getIsBatHanging() && this.rand.nextInt(4) != 0 ? null : SoundEvents.ENTITY_BAT_AMBIENT;
    }

    protected SoundEvent getHurtSound(DamageSource damageSourceIn)
    {
        return SoundEvents.ENTITY_BAT_HURT;
    }

    protected SoundEvent getDeathSound()
    {
        return SoundEvents.ENTITY_BAT_DEATH;
    }

    /**
     * Returns true if this entity should push and be pushed by other entities when colliding.
     */
    public boolean canBePushed()
    {
        return false;
    }

    protected void collideWithEntity(Entity entityIn)
    {
    }

    protected void collideWithNearbyEntities()
    {
    }

    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(8.0D);
        this.getEntityAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(4.0D);
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(3.0D);
    }

    public boolean getIsBatHanging()
    {
        return (((Byte)this.dataManager.get(HANGING)).byteValue() & 1) != 0;
    }

    public void setIsBatHanging(boolean isHanging)
    {
        byte b0 = ((Byte)this.dataManager.get(HANGING)).byteValue();

        if (isHanging)
        {
            this.dataManager.set(HANGING, Byte.valueOf((byte)(b0 | 1)));
        }
        else
        {
            this.dataManager.set(HANGING, Byte.valueOf((byte)(b0 & -2)));
        }
    }

    /**
     * Called to update the entity's position/logic.
     */
    public void onUpdate()
    {
        super.onUpdate();
        makeTrail();
        if (this.getIsBatHanging())
        {
            this.motionX = 0.0D;
            this.motionY = 0.0D;
            this.motionZ = 0.0D;
            this.posY = (double)MathHelper.floor(this.posY) + 1.0D - (double)this.height;
        }
        else
        {
            this.motionY *= 0.6000000238418579D;
        }
    }
    
    private void makeTrail() {
		for (int i = 0; i < 2; i++) {
			double dx = posX + 0.5 * (rand.nextDouble() - rand.nextDouble());
			double dy = posY + 0.5 * (rand.nextDouble() - rand.nextDouble());
			double dz = posZ + 0.5 * (rand.nextDouble() - rand.nextDouble());
			world.spawnParticle(EnumParticleTypes.REDSTONE, dx, dy, dz, 0.0D, 0.0D, 0.0D);
		}
	}

    protected void updateAITasks()
    {
        super.updateAITasks();
        BlockPos blockpos = new BlockPos(this);
        BlockPos blockpos1 = blockpos.up();

        if (this.getIsBatHanging())
        {
            if (this.world.getBlockState(blockpos1).isNormalCube())
            {
                if (this.rand.nextInt(200) == 0)
                {
                    this.rotationYawHead = (float)this.rand.nextInt(360);
                }

                if (this.world.getNearestPlayerNotCreative(this, 4.0D) != null)
                {
                    this.setIsBatHanging(false);
                    this.world.playEvent((EntityPlayer)null, 1025, blockpos, 0);
                }
            }
            else
            {
                this.setIsBatHanging(false);
                this.world.playEvent((EntityPlayer)null, 1025, blockpos, 0);
            }
        }
        else
        {
            if (this.spawnPosition != null && (!this.world.isAirBlock(this.spawnPosition) || this.spawnPosition.getY() < 1))
            {
                this.spawnPosition = null;
            }

            if (this.spawnPosition == null || this.rand.nextInt(30) == 0 || this.spawnPosition.distanceSq((double)((int)this.posX), (double)((int)this.posY), (double)((int)this.posZ)) < 4.0D)
            {
                this.spawnPosition = new BlockPos((int)this.posX + this.rand.nextInt(7) - this.rand.nextInt(7), (int)this.posY + this.rand.nextInt(6) - 2, (int)this.posZ + this.rand.nextInt(7) - this.rand.nextInt(7));
            }

            double d0 = (double)this.spawnPosition.getX() + 0.5D - this.posX;
            double d1 = (double)this.spawnPosition.getY() + 0.1D - this.posY;
            double d2 = (double)this.spawnPosition.getZ() + 0.5D - this.posZ;
            this.motionX += (Math.signum(d0) * 0.5D - this.motionX) * 0.10000000149011612D;
            this.motionY += (Math.signum(d1) * 0.699999988079071D - this.motionY) * 0.10000000149011612D;
            this.motionZ += (Math.signum(d2) * 0.5D - this.motionZ) * 0.10000000149011612D;
            float f = (float)(MathHelper.atan2(this.motionZ, this.motionX) * (180D / Math.PI)) - 90.0F;
            float f1 = MathHelper.wrapDegrees(f - this.rotationYaw);
            this.moveForward = 0.5F;
            this.rotationYaw += f1;

            if (this.rand.nextInt(100) == 0 && this.world.getBlockState(blockpos1).isNormalCube())
            {
                this.setIsBatHanging(true);
            }
        }
    }

    protected boolean canTriggerWalking()
    {
        return false;
    }

    public void fall(float distance, float damageMultiplier)
    {
    }

    protected void updateFallState(double y, boolean onGroundIn, IBlockState state, BlockPos pos)
    {
    }

    /**
     * Return whether this entity should NOT trigger a pressure plate or a tripwire.
     */
    public boolean doesEntityNotTriggerPressurePlate()
    {
        return true;
    }

    /**
     * Called when the entity is attacked.
     */
    public boolean attackEntityFrom(DamageSource source, float amount)
    {
        if (this.isEntityInvulnerable(source))
        {
            return false;
        }
        else
        {
            if (!this.world.isRemote && this.getIsBatHanging())
            {
                this.setIsBatHanging(false);
            }

            return super.attackEntityFrom(source, amount);
        }
    }

    public static void registerFixesBat(DataFixer fixer)
    {
        EntityLiving.registerFixesMob(fixer, EntityFlyingEye.class);
    }
    
    
    public void writeEntityToNBT(NBTTagCompound compound)
    {
        super.writeEntityToNBT(compound);
        compound.setByte("EyeFlags", ((Byte)this.dataManager.get(HANGING)).byteValue());
        compound.setInteger("Variant", this.getVariant());
    }

    
    public void readEntityFromNBT(NBTTagCompound compound)
    {
        super.readEntityFromNBT(compound);
        this.dataManager.set(HANGING, Byte.valueOf(compound.getByte("EyeFlags")));
        this.setVariant(compound.getInteger("Variant"));
    }
    
    public float getEyeHeight()
    {
        return this.height / 1.0F;
    }
    
    
    static class AIEyeAttack extends EntityAIAttackMelee
    {
        public AIEyeAttack(EntityFlyingEye spider)
        {
            super(spider, 1.0D, true);
        }

        public boolean shouldContinueExecuting()
        {
            float f = this.attacker.getBrightness();

            if (f >= 0.4F && this.attacker.getRNG().nextInt(100) == 0)
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
            return (double)(4.1F + attackTarget.width);
        }
    }

	static class AIEyeTarget<T extends EntityLivingBase> extends EntityAINearestAttackableTarget<T>
    {
        public AIEyeTarget(EntityFlyingEye spider, Class<T> classTarget)
        {
            super(spider, classTarget, true);
        }

        public boolean shouldExecute()
        {
            float f = this.taskOwner.getBrightness();
            return f >= 0.1F ? false : super.shouldExecute();
        }
    }
}
