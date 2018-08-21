package com.smellysox345.TheShatteredWorld.entity.model;

import com.smellysox345.TheShatteredWorld.entity.EntityNagrot;
import com.smellysox345.TheShatteredWorld.entity.util.AbstractNagrot;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.AbstractIllager;
import net.minecraft.entity.monster.EntityIronGolem;
import net.minecraft.util.math.MathHelper;

/**
 * ModelNagrot - SmellyModder
 * Created using Tabula 7.0.0
 */
public class ModelNagrot extends ModelBase {
    public ModelRenderer BELLY;
    public ModelRenderer CHEST;
    public ModelRenderer LEFT_LEG_BASE;
    public ModelRenderer RIGHT_LEG_BASE;
    public ModelRenderer HEART;
    public ModelRenderer TRUNK_BOTTOM;
    public ModelRenderer HEAD_BOTTOM;
    public ModelRenderer RIGHT_ARM_BASE;
    public ModelRenderer LEFT_ARM_BASE;
    public ModelRenderer HEAD_TOP;
    public ModelRenderer TRUNK_TOP;
    public ModelRenderer LEAF1;
    public ModelRenderer LEAF2;
    public ModelRenderer LEAF3;
    public ModelRenderer LEAF4;
    public ModelRenderer LEAF5;
    public ModelRenderer TOOTH1;
    public ModelRenderer TOOTH2;
    public ModelRenderer RIGHT_ARM_HANDLE;
    public ModelRenderer RIGHT_ARM_HANDLE_DOWN;
    public ModelRenderer RIGHT_ARM_LOG;
    public ModelRenderer LEFT_ARM_HANDLE;
    public ModelRenderer LEFT_ARM_HANDLE_DOWN;
    public ModelRenderer LEFT_ARM_LOG;
    public ModelRenderer EYE_OVERLAY;
    public ModelRenderer LEFT_LEG_CALF;
    public ModelRenderer LEFT_LEG_LOG;
    public ModelRenderer RIGHT_LEG_CALF;
    public ModelRenderer RIGHT_LEG_LOG;
    public ModelNagrot() {
        this.textureWidth = 256;
        this.textureHeight = 256;
        this.LEFT_ARM_LOG = new ModelRenderer(this, 0, 0);
        this.LEFT_ARM_LOG.setRotationPoint(14.0F, -3.8F, -2.5F);
        this.LEFT_ARM_LOG.addBox(-1.0F, -6.5F, -4.0F, 25, 13, 13, 0.0F);
        this.LEAF2 = new ModelRenderer(this, 0, 1);
        this.LEAF2.setRotationPoint(12.8F, 3.9F, 1.2F);
        this.LEAF2.addBox(-1.9F, 0.0F, 0.0F, 4, 7, 0, 0.0F);
        this.setRotateAngle(LEAF2, 1.3203415791337103F, 2.408554367752175F, 0.0F);
        this.TOOTH1 = new ModelRenderer(this, 0, 0);
        this.TOOTH1.setRotationPoint(-0.7F, -0.8F, -12.3F);
        this.TOOTH1.addBox(0.0F, 0.0F, 0.0F, 1, 2, 1, 0.0F);
        this.LEAF1 = new ModelRenderer(this, 0, 1);
        this.LEAF1.setRotationPoint(2.8F, 1.1F, -0.7F);
        this.LEAF1.addBox(0.0F, 0.0F, 0.0F, 4, 7, 0, 0.0F);
        this.setRotateAngle(LEAF1, 1.3203415791337103F, -2.367539130330308F, 0.0F);
        this.RIGHT_ARM_HANDLE_DOWN = new ModelRenderer(this, 140, 0);
        this.RIGHT_ARM_HANDLE_DOWN.setRotationPoint(-2.7F, -1.7F, -1.4F);
        this.RIGHT_ARM_HANDLE_DOWN.addBox(-13.6F, -7.9F, -3.8F, 14, 8, 8, 0.0F);
        this.setRotateAngle(RIGHT_ARM_HANDLE_DOWN, 0.7740535232594852F, 0.8196066167365371F, -1.1344640137963142F);
        this.LEFT_ARM_BASE = new ModelRenderer(this, 120, 110);
        this.LEFT_ARM_BASE.setRotationPoint(31.5F, 7.5F, 10.0F);
        this.LEFT_ARM_BASE.addBox(-2.0F, -4.6F, -5.0F, 8, 10, 10, 0.0F);
        this.setRotateAngle(LEFT_ARM_BASE, -0.7862708280234454F, 0.0F, -0.08726646259971647F);
        this.RIGHT_ARM_HANDLE = new ModelRenderer(this, 110, 140);
        this.RIGHT_ARM_HANDLE.setRotationPoint(-7.0F, 1.2F, 1.1F);
        this.RIGHT_ARM_HANDLE.addBox(-6.0F, -4.6F, -5.0F, 10, 8, 8, 0.0F);
        this.setRotateAngle(RIGHT_ARM_HANDLE, 0.0F, 0.0F, -0.2617993877991494F);
        this.TOOTH2 = new ModelRenderer(this, 0, 0);
        this.TOOTH2.setRotationPoint(1.9F, -1.3F, -12.3F);
        this.TOOTH2.addBox(0.0F, 0.0F, 0.0F, 1, 2, 1, 0.0F);
        this.CHEST = new ModelRenderer(this, 0, 150);
        this.CHEST.setRotationPoint(-7.0F, -12.9F, 0.0F);
        this.CHEST.addBox(0.0F, 0.0F, 0.0F, 30, 16, 20, 0.0F);
        this.setRotateAngle(CHEST, -0.22689280275926282F, 0.0F, 0.0F);
        this.TRUNK_TOP = new ModelRenderer(this, 64, 67);
        this.TRUNK_TOP.setRotationPoint(2.0F, -8.5F, 1.7F);
        this.TRUNK_TOP.addBox(0.0F, 0.0F, 0.0F, 14, 12, 14, 0.0F);
        this.LEFT_LEG_CALF = new ModelRenderer(this, 0, 87);
        this.LEFT_LEG_CALF.setRotationPoint(0.9F, 6.8F, 1.0F);
        this.LEFT_LEG_CALF.addBox(0.0F, 0.0F, 0.0F, 6, 10, 6, 0.0F);
        this.setRotateAngle(LEFT_LEG_CALF, -0.08726646259971647F, 0.0F, 0.08726646259971647F);
        this.LEFT_ARM_HANDLE = new ModelRenderer(this, 110, 140);
        this.LEFT_ARM_HANDLE.setRotationPoint(6.0F, 1.2F, 1.1F);
        this.LEFT_ARM_HANDLE.addBox(-3.0F, -4.6F, -5.0F, 10, 8, 8, 0.0F);
        this.setRotateAngle(LEFT_ARM_HANDLE, 0.0F, 0.0F, 0.2617993877991494F);
        this.RIGHT_LEG_LOG = new ModelRenderer(this, 50, 100);
        this.RIGHT_LEG_LOG.setRotationPoint(-0.6F, 3.3F, -1.7F);
        this.RIGHT_LEG_LOG.addBox(-10.0F, 0.0F, 0.0F, 10, 18, 10, 0.0F);
        this.setRotateAngle(RIGHT_LEG_LOG, 0.08726646259971647F, -0.08726646259971647F, -0.7853981633974483F);
        this.BELLY = new ModelRenderer(this, 0, 36);
        this.BELLY.setRotationPoint(-8.0F, -18.0F, -5.0F);
        this.BELLY.addBox(0.0F, 0.0F, 0.0F, 16, 20, 10, 0.0F);
        this.LEFT_LEG_LOG = new ModelRenderer(this, 50, 100);
        this.LEFT_LEG_LOG.setRotationPoint(0.1F, 3.3F, -1.7F);
        this.LEFT_LEG_LOG.addBox(0.0F, 0.0F, 0.0F, 10, 18, 10, 0.0F);
        this.setRotateAngle(LEFT_LEG_LOG, 0.08726646259971647F, 0.08726646259971647F, 0.7853981633974483F);
        this.HEART = new ModelRenderer(this, 5, 130);
        this.HEART.setRotationPoint(5.0F, 9.0F, -0.9F);
        this.HEART.addBox(0.0F, 0.0F, 0.0F, 5, 5, 1, 0.0F);
        this.EYE_OVERLAY = new ModelRenderer(this, 100, 200);
        this.EYE_OVERLAY.setRotationPoint(-7.3F, -3.7F, -10.1F);
        this.EYE_OVERLAY.addBox(0.0F, 0.0F, 0.0F, 15, 8, 0, 0.0F);
        this.HEAD_TOP = new ModelRenderer(this, 0, 198);
        this.HEAD_TOP.setRotationPoint(15.0F, 3.1F, -1.0F);
        this.HEAD_TOP.addBox(-7.4F, -3.7F, -10.0F, 15, 8, 13, 0.0F);
        this.setRotateAngle(HEAD_TOP, 0.2617993877991494F, 0.0F, 0.0F);
        this.LEAF3 = new ModelRenderer(this, 0, 1);
        this.LEAF3.setRotationPoint(13.1F, 2.2F, 12.0F);
        this.LEAF3.addBox(-1.9F, 0.0F, 0.0F, 4, 7, 0, 0.0F);
        this.setRotateAngle(LEAF3, 1.8212510744560826F, 0.8196066167365371F, 0.22759093446006054F);
        this.RIGHT_ARM_BASE = new ModelRenderer(this, 120, 110);
        this.RIGHT_ARM_BASE.setRotationPoint(-1.5F, 7.5F, 10.0F);
        this.RIGHT_ARM_BASE.addBox(-6.0F, -4.6F, -5.0F, 8, 10, 10, 0.0F);
        this.setRotateAngle(RIGHT_ARM_BASE, -0.7862708280234454F, 0.0F, 0.08726646259971647F);
        this.RIGHT_LEG_CALF = new ModelRenderer(this, 0, 88);
        this.RIGHT_LEG_CALF.setRotationPoint(0.9F, 6.8F, 1.0F);
        this.RIGHT_LEG_CALF.addBox(-6.5F, 0.0F, 0.0F, 6, 10, 6, 0.0F);
        this.setRotateAngle(RIGHT_LEG_CALF, -0.08726646259971647F, 0.0F, -0.08726646259971647F);
        this.HEAD_BOTTOM = new ModelRenderer(this, 0, 225);
        this.HEAD_BOTTOM.setRotationPoint(8.4F, 8.0F, 3.2F);
        this.HEAD_BOTTOM.addBox(-0.7F, 0.0F, -12.2F, 15, 8, 13, 0.0F);
        this.setRotateAngle(HEAD_BOTTOM, 0.2617993877991494F, 0.0F, 0.0F);
        this.LEFT_LEG_BASE = new ModelRenderer(this, 0, 104);
        this.LEFT_LEG_BASE.setRotationPoint(8.9F, 18.4F, 1.0F);
        this.LEFT_LEG_BASE.addBox(0.0F, 0.0F, 0.0F, 8, 8, 8, 0.0F);
        this.setRotateAngle(LEFT_LEG_BASE, -0.08726646259971647F, 0.0F, -0.8726646259971648F);
        this.LEAF4 = new ModelRenderer(this, 0, 1);
        this.LEAF4.setRotationPoint(1.0F, 2.2F, 12.0F);
        this.LEAF4.addBox(-1.9F, 0.0F, 0.0F, 4, 7, 0, 0.0F);
        this.setRotateAngle(LEAF4, 1.7756979809790308F, -0.5462880558742251F, -0.7285004297824331F);
        this.RIGHT_LEG_BASE = new ModelRenderer(this, 0, 104);
        this.RIGHT_LEG_BASE.mirror = true;
        this.RIGHT_LEG_BASE.setRotationPoint(5.9F, 17.4F, 1.0F);
        this.RIGHT_LEG_BASE.addBox(-6.5F, 0.0F, 0.0F, 8, 8, 8, 0.0F);
        this.setRotateAngle(RIGHT_LEG_BASE, -0.08726646259971647F, 0.0F, 0.8726646259971648F);
        this.TRUNK_BOTTOM = new ModelRenderer(this, 58, 42);
        this.TRUNK_BOTTOM.setRotationPoint(6.0F, -2.3F, 0.8F);
        this.TRUNK_BOTTOM.addBox(0.0F, 0.0F, 0.0F, 18, 8, 17, 0.0F);
        this.setRotateAngle(TRUNK_BOTTOM, 0.2617993877991494F, 0.0F, 0.0F);
        this.LEAF5 = new ModelRenderer(this, 0, 1);
        this.LEAF5.setRotationPoint(6.3F, -4.8F, 6.0F);
        this.LEAF5.addBox(0.0F, 0.0F, 0.0F, 4, 7, 0, 0.0F);
        this.setRotateAngle(LEAF5, -0.18203784098300857F, 0.8196066167365371F, 0.5462880558742251F);
        this.RIGHT_ARM_LOG = new ModelRenderer(this, 0, 0);
        this.RIGHT_ARM_LOG.setRotationPoint(-14.5F, -3.8F, -2.5F);
        this.RIGHT_ARM_LOG.addBox(-24.0F, -6.5F, -4.0F, 25, 13, 13, 0.0F);
        this.LEFT_ARM_HANDLE_DOWN = new ModelRenderer(this, 140, 0);
        this.LEFT_ARM_HANDLE_DOWN.setRotationPoint(3.7F, -1.7F, -1.0F);
        this.LEFT_ARM_HANDLE_DOWN.addBox(-0.3F, -7.9F, -3.8F, 14, 8, 8, 0.0F);
        this.setRotateAngle(LEFT_ARM_HANDLE_DOWN, 0.7740535232594852F, -0.8196066167365371F, 1.1344640137963142F);
        this.LEFT_ARM_HANDLE_DOWN.addChild(this.LEFT_ARM_LOG);
        this.TRUNK_TOP.addChild(this.LEAF2);
        this.HEAD_BOTTOM.addChild(this.TOOTH1);
        this.TRUNK_TOP.addChild(this.LEAF1);
        this.RIGHT_ARM_HANDLE.addChild(this.RIGHT_ARM_HANDLE_DOWN);
        this.CHEST.addChild(this.LEFT_ARM_BASE);
        this.RIGHT_ARM_BASE.addChild(this.RIGHT_ARM_HANDLE);
        this.HEAD_BOTTOM.addChild(this.TOOTH2);
        this.BELLY.addChild(this.CHEST);
        this.TRUNK_BOTTOM.addChild(this.TRUNK_TOP);
        this.LEFT_LEG_BASE.addChild(this.LEFT_LEG_CALF);
        this.LEFT_ARM_BASE.addChild(this.LEFT_ARM_HANDLE);
        this.RIGHT_LEG_CALF.addChild(this.RIGHT_LEG_LOG);
        this.LEFT_LEG_CALF.addChild(this.LEFT_LEG_LOG);
        this.BELLY.addChild(this.HEART);
        this.HEAD_TOP.addChild(this.EYE_OVERLAY);
        this.CHEST.addChild(this.HEAD_TOP);
        this.TRUNK_TOP.addChild(this.LEAF3);
        this.CHEST.addChild(this.RIGHT_ARM_BASE);
        this.RIGHT_LEG_BASE.addChild(this.RIGHT_LEG_CALF);
        this.CHEST.addChild(this.HEAD_BOTTOM);
        this.BELLY.addChild(this.LEFT_LEG_BASE);
        this.TRUNK_TOP.addChild(this.LEAF4);
        this.BELLY.addChild(this.RIGHT_LEG_BASE);
        this.CHEST.addChild(this.TRUNK_BOTTOM);
        this.TRUNK_TOP.addChild(this.LEAF5);
        this.RIGHT_ARM_HANDLE_DOWN.addChild(this.RIGHT_ARM_LOG);
        this.LEFT_ARM_HANDLE.addChild(this.LEFT_ARM_HANDLE_DOWN);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
        this.BELLY.render(f5);
    }

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
        
    public void setLivingAnimations(EntityLivingBase entitylivingbaseIn, float limbSwing, float limbSwingAmount, float partialTickTime)
    {
    	EntityNagrot entitynagrot = (EntityNagrot)entitylivingbaseIn;
        int i = entitynagrot.getAttackTimer();
        
        
        if (i > 0)
        {
            this.RIGHT_ARM_BASE.rotateAngleX = -2.0F + 1.5F * this.triangleWave((float)i - partialTickTime, 10.0F);
            this.LEFT_ARM_BASE.rotateAngleX = -2.0F + 1.5F * this.triangleWave((float)i - partialTickTime, 10.0F);
            this.HEAD_TOP.rotateAngleX = -0.4517993877991494F;
            this.HEAD_BOTTOM.rotateAngleX = 0.4617993877991494F;
        }
        else
        {
            this.RIGHT_ARM_BASE.rotateAngleX = -0.7862708280234454F * -limbSwingAmount - 0.60F;
            this.LEFT_ARM_BASE.rotateAngleX = -0.7862708280234454F * -limbSwingAmount  - 0.60F;
            this.LEFT_LEG_BASE.rotateAngleX = -1.5F * this.triangleWave(limbSwing, 13.0F) * limbSwingAmount;
            this.RIGHT_LEG_BASE.rotateAngleX = 1.5F * this.triangleWave(limbSwing, 13.0F) * limbSwingAmount;
            this.LEFT_LEG_BASE.rotateAngleY = 0.0F;
            this.RIGHT_ARM_BASE.rotateAngleY = 0.0F;
            this.HEAD_TOP.rotateAngleX = 0.2617993877991494F;
            this.HEAD_BOTTOM.rotateAngleX = 0.2617993877991494F;
        }
        
    }
    
    public void setRotationAngles(EntityLivingBase entitylivingbaseIn) {
    	
    	AbstractNagrot.IPose abstractillager$illagerarmpose = ((AbstractNagrot)entitylivingbaseIn).getArmPose();
    	if (abstractillager$illagerarmpose == AbstractNagrot.IPose.SPELL)
        {
    		this.HEAD_TOP.rotateAngleX = -0.4517993877991494F;
            this.HEAD_BOTTOM.rotateAngleX = 0.4617993877991494F;
        }
    	else if(abstractillager$illagerarmpose == AbstractNagrot.IPose.DEFAULT) {
    		this.HEAD_TOP.rotateAngleX = 0.2617993877991494F;
            this.HEAD_BOTTOM.rotateAngleX =  0.2617993877991494F;
    	}
    }
    
    private float triangleWave(float p_78172_1_, float p_78172_2_)
    {
        return (Math.abs(p_78172_1_ % p_78172_2_ - p_78172_2_ * 0.5F) - p_78172_2_ * 0.25F) / (p_78172_2_ * 0.25F);
    }
}
