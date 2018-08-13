package com.smellysox345.TheShatteredWorld.entity;

import javax.annotation.Nullable;

import com.smellysox345.TheShatteredWorld.init.ModItems;

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILeapAtTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWanderAvoidWater;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.AbstractSkeleton;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.entity.projectile.EntitySpectralArrow;
import net.minecraft.entity.projectile.EntityTippedArrow;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.datafix.DataFixer;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.World;
import net.minecraft.world.storage.loot.LootTableList;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class EntityShroomSkeleton extends AbstractSkeleton{

	 public EntityShroomSkeleton(World world)
	    {
	        super(world);
	    }

	    public static void registerFixesSkeleton(DataFixer fixer)
	    {
	        EntityLiving.registerFixesMob(fixer, EntityShroomSkeleton.class);
	    }
	    
	    @Override
	    protected void setEquipmentBasedOnDifficulty(DifficultyInstance difficulty)
	    {
	        super.setEquipmentBasedOnDifficulty(difficulty);
	        this.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(Items.BOW));
	    }

	    @Nullable
	    protected ResourceLocation getLootTable()
	    {
	        return LootTableList.ENTITIES_SKELETON;
	    }

	    protected SoundEvent getAmbientSound()
	    {
	        return SoundEvents.ENTITY_SKELETON_AMBIENT;
	    }

	    protected SoundEvent getHurtSound(DamageSource damageSourceIn)
	    {
	        return SoundEvents.ENTITY_SKELETON_HURT;
	    }

	    protected SoundEvent getDeathSound()
	    {
	        return SoundEvents.ENTITY_SKELETON_DEATH;
	    }

	    protected SoundEvent getStepSound()
	    {
	        return SoundEvents.ENTITY_SKELETON_STEP;
	    }

	    /**
	     * Called when the mob's health reaches 0.
	     */
	    public void onDeath(DamageSource cause)
	    {
	        super.onDeath(cause);

	        if (cause.getTrueSource() instanceof EntityCreeper)
	        {
	            EntityCreeper entitycreeper = (EntityCreeper)cause.getTrueSource();

	            if (entitycreeper.getPowered() && entitycreeper.ableToCauseSkullDrop())
	            {
	                entitycreeper.incrementDroppedSkulls();
	                this.entityDropItem(new ItemStack(Items.SKULL, 1, 0), 0.0F);
	            }
	        }
	    }

	    protected EntityArrow getArrow(float p_190726_1_)
	    {
	        ItemStack itemstack = this.getItemStackFromSlot(EntityEquipmentSlot.OFFHAND);

	        if (itemstack.getItem() == Items.SPECTRAL_ARROW)
	        {
	            EntitySpectralArrow entityspectralarrow = new EntitySpectralArrow(this.world, this);
	            entityspectralarrow.setEnchantmentEffectsFromEntity(this, p_190726_1_);
	            return entityspectralarrow;
	        }
	        else
	        {
	            EntityArrow entityarrow = super.getArrow(p_190726_1_);

	            if (itemstack.getItem() == Items.TIPPED_ARROW && entityarrow instanceof EntityTippedArrow)
	            {
	                ((EntityTippedArrow)entityarrow).setPotionEffect(itemstack);
	            }

	            return entityarrow;
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
}
