package com.smellysox345.TheShatteredWorld.entity;

import com.smellysox345.TheShatteredWorld.init.ModItems;
import com.smellysox345.TheShatteredWorld.util.handlers.SoundHandler;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.IMerchant;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.ai.EntityAIWatchClosest2;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.village.MerchantRecipe;
import net.minecraft.village.MerchantRecipeList;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.VillagerRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;


public class NPCShroomWizard extends EntityVillager {
    MerchantRecipeList recipeList;

    public NPCShroomWizard(World worldIn) {
        this(worldIn, 5);
    }
    public NPCShroomWizard(World worldIn, int professionId) {
        super(worldIn, 5);
        this.setSize(0.6F, 1.95F);
        this.setProfession(5);
    }

    @Override
    protected void initEntityAI() {
        this.tasks.addTask(9, new EntityAIWatchClosest2(this, EntityPlayer.class, 3.0F, 1.0F));
        this.tasks.addTask(10, new EntityAIWatchClosest(this, EntityLiving.class, 8.0F));
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(35.0D);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.23000000417232513D);
        this.getEntityAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(200.0D);
        this.getEntityAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE).setBaseValue(200.0D);
    }

    @SideOnly(Side.CLIENT)
    public int getBrightnessForRender() {
        return 15728880;
    }

    public float getBrightness() {
        return 1.0F;
    }

    @Override
    public float getSoundVolume() {
        return 5.0F;
    }

    @Override
    public float getSoundPitch() {
        return 0.40F;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource damage) {

        return SoundHandler.ENTITY_SHROOMWIZ_HURT;

    }

    @Override
    protected SoundEvent getDeathSound() {

        return SoundHandler.ENTITY_SHROOMWIZ_DEATH;

    }

    @Override
    protected SoundEvent getAmbientSound() {

        return SoundHandler.ENTITY_SHROOMWIZ_LIVING;

    }
}
