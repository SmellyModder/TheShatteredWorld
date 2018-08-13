package com.smellysox345.TheShatteredWorld.entity.model;

import com.smellysox345.TheShatteredWorld.entity.EntityShroomZombie;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.util.math.MathHelper;

/**
 * ModelZombie - Either Mojang or a mod author
 * Created using Tabula 7.0.0
 */

public class ModelShroomZombie extends ModelBase {
    public ModelRenderer RA;
    public ModelRenderer RL;
    public ModelRenderer HEAD;
    public ModelRenderer BODY;
    public ModelRenderer LA;
    public ModelRenderer LL;
    public ModelRenderer STEM11;
    public ModelRenderer MUSH13;
    public ModelRenderer STEM5;
    public ModelRenderer STEM10;
    public ModelRenderer STEM14;
    public ModelRenderer MUSH12;
    public ModelRenderer STEM6;
    public ModelRenderer STEM12;
    public ModelRenderer STEM8;
    public ModelRenderer MUSH11;
    public ModelRenderer MUSH10;
    public ModelRenderer STEM4;
    public ModelRenderer MUSH15;
    public ModelRenderer MUSH6;
    public ModelRenderer STEM7;
    public ModelRenderer MUSH5;
    public ModelRenderer STEM9;
    public ModelRenderer STEM3;
    public ModelRenderer MUSH3;
    public ModelRenderer STEM13;

    public ModelShroomZombie() {
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.LA = new ModelRenderer(this, 40, 16);
        this.LA.mirror = true;
        this.LA.setRotationPoint(5.0F, 2.0F, 0.0F);
        this.LA.addBox(-1.0F, -2.0F, -2.0F, 4, 12, 4, 0.0F);
        this.setRotateAngle(LA, -1.4264575976549656F, 0.10000736613927509F, -0.0010471975511965976F);
        this.STEM3 = new ModelRenderer(this, 32, 0);
        this.STEM3.setRotationPoint(1.1F, 2.0F, 1.7F);
        this.STEM3.addBox(0.0F, 0.0F, 0.0F, 1, 1, 2, 0.0F);
        this.setRotateAngle(STEM3, 0.0F, 0.40980330836826856F, 0.0F);
        this.MUSH15 = new ModelRenderer(this, 47, 36);
        this.MUSH15.setRotationPoint(-6.5F, -6.2F, 0.0F);
        this.MUSH15.addBox(0.0F, -1.8F, 0.0F, 2, 3, 3, 0.0F);
        this.setRotateAngle(MUSH15, 0.0F, 0.0F, 0.31869712141416456F);
        this.MUSH13 = new ModelRenderer(this, 49, 0);
        this.MUSH13.setRotationPoint(3.70F, 1.30F, -3.20F);
        this.MUSH13.addBox(0.0F, -1.8F, 0.0F, 2, 3, 3, 0.0F);
        this.setRotateAngle(MUSH13, -0.045553093477052F, 0.27314402793711257F, -0.27314402793711257F);
        this.LL = new ModelRenderer(this, 0, 16);
        this.LL.mirror = true;
        this.LL.setRotationPoint(1.9F, 12.0F, 0.1F);
        this.LL.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
        this.BODY = new ModelRenderer(this, 16, 16);
        this.BODY.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.BODY.addBox(-4.0F, 0.0F, -2.0F, 8, 12, 4, 0.0F);
        this.MUSH6 = new ModelRenderer(this, 47, 37);
        this.MUSH6.setRotationPoint(0.2F, -9.7F, -0.5F);
        this.MUSH6.addBox(0.0F, -1.8F, 0.0F, 3, 2, 3, 0.0F);
        this.setRotateAngle(MUSH6, 0.0F, 0.0F, 0.36425021489121656F);
        this.STEM10 = new ModelRenderer(this, 32, 0);
        this.STEM10.setRotationPoint(3.1F, -2.9F, -1.3F);
        this.STEM10.addBox(0.0F, -1.8F, 0.0F, 2, 2, 2, 0.0F);
        this.setRotateAngle(STEM10, 0.0F, 0.40980330836826856F, 0.0F);
        this.STEM7 = new ModelRenderer(this, 36, 0);
        this.STEM7.setRotationPoint(-3.7F, -7.2F, -2.4F);
        this.STEM7.addBox(0.0F, -1.8F, 0.0F, 1, 1, 1, 0.0F);
        this.setRotateAngle(STEM7, 0.18203784098300857F, 0.0F, 0.0F);
        this.MUSH12 = new ModelRenderer(this, 49, 8);
        this.MUSH12.setRotationPoint(-5.90F, 8.0F, -2.80F);
        this.MUSH12.addBox(0.0F, -1.8F, 0.0F, 2, 3, 3, 0.0F);
        this.setRotateAngle(MUSH12, 0.05550147021341968F, -0.045553093477052F, 0.3269001688985379F);
        this.STEM12 = new ModelRenderer(this, 33, 0);
        this.STEM12.setRotationPoint(-4.0F, 9.0F, -2.3F);
        this.STEM12.addBox(0.0F, -1.8F, 0.0F, 3, 2, 2, 0.0F);
        this.setRotateAngle(STEM12, 0.0F, -0.2998475654926258F, 0.18203784098300857F);
        this.STEM11 = new ModelRenderer(this, 33, 0);
        this.STEM11.setRotationPoint(-5.9F, -2.7F, -2.9F);
        this.STEM11.addBox(0.0F, -1.8F, 0.0F, 3, 2, 2, 0.0F);
        this.setRotateAngle(STEM11, 0.0F, 0.31869712141416456F, 0.0F);
        this.MUSH11 = new ModelRenderer(this, 49, 0);
        this.MUSH11.setRotationPoint(-7.9F, -3.3F, -2.8F);
        this.MUSH11.addBox(0.0F, -1.8F, 0.0F, 2, 3, 3, 0.0F);
        this.setRotateAngle(MUSH11, 0.0F, 0.31869712141416456F, 0.0F);
        this.STEM5 = new ModelRenderer(this, 34, 0);
        this.STEM5.setRotationPoint(-3.0F, -4.2F, 2.8F);
        this.STEM5.addBox(0.0F, -1.8F, 0.0F, 2, 2, 2, 0.0F);
        this.setRotateAngle(STEM5, 0.0F, -0.22759093446006054F, 0.0F);
        this.MUSH5 = new ModelRenderer(this, 49, 0);
        this.MUSH5.setRotationPoint(-4.3F, -4.5F, 6.6F);
        this.MUSH5.addBox(0.0F, -1.8F, 0.0F, 2, 3, 3, 0.0F);
        this.setRotateAngle(MUSH5, 0.0F, 1.3203415791337103F, 0.0F);
        this.STEM8 = new ModelRenderer(this, 34, 0);
        this.STEM8.setRotationPoint(-3.0F, -5.7F, -4.3F);
        this.STEM8.addBox(0.0F, -1.8F, 0.0F, 1, 1, 1, 0.0F);
        this.setRotateAngle(STEM8, 0.0F, -0.045553093477052F, 0.18203784098300857F);
        this.STEM13 = new ModelRenderer(this, 33, 0);
        this.STEM13.setRotationPoint(2.1F, 1.3F, -2.3F);
        this.STEM13.addBox(0.0F, -1.8F, 0.0F, 2, 2, 2, 0.0F);
        this.setRotateAngle(STEM13, -0.045553093477052F, 0.40980330836826856F, 0.18203784098300857F);
        this.RA = new ModelRenderer(this, 40, 16);
        this.RA.setRotationPoint(-5.0F, 2.0F, 0.0F);
        this.RA.addBox(-3.0F, -2.0F, -2.0F, 4, 12, 4, 0.0F);
        this.setRotateAngle(RA, -1.3660692055359616F, -0.10000736613927509F, 0.0010471975511965976F);
        this.STEM14 = new ModelRenderer(this, 32, 0);
        this.STEM14.setRotationPoint(-4.9F, -5.0F, 0.5F);
        this.STEM14.addBox(0.0F, -1.8F, 0.0F, 2, 2, 2, 0.0F);
        this.setRotateAngle(STEM14, 0.0F, 0.0F, 0.31869712141416456F);
        this.STEM6 = new ModelRenderer(this, 34, 0);
        this.STEM6.setRotationPoint(0.0F, -7.6F, 0.0F);
        this.STEM6.addBox(0.0F, -1.8F, 0.0F, 2, 2, 2, 0.0F);
        this.setRotateAngle(STEM6, 0.0F, 0.0F, 0.36425021489121656F);
        this.STEM4 = new ModelRenderer(this, 34, 0);
        this.STEM4.setRotationPoint(1.1F, -4.8F, 3.5F);
        this.STEM4.addBox(0.0F, -1.8F, 0.0F, 1, 1, 1, 0.0F);
        this.setRotateAngle(STEM4, 0.0F, 0.0F, 0.31869712141416456F);
        this.RL = new ModelRenderer(this, 0, 16);
        this.RL.setRotationPoint(-1.9F, 12.0F, 0.1F);
        this.RL.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
        this.HEAD = new ModelRenderer(this, 0, 0);
        this.HEAD.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.HEAD.addBox(-4.0F, -8.0F, -4.0F, 8, 8, 8, 0.0F);
        this.MUSH10 = new ModelRenderer(this, 49, 8);
        this.MUSH10.setRotationPoint(4.7F, -3.3F, -2.4F);
        this.MUSH10.addBox(0.0F, -1.8F, 0.0F, 2, 3, 3, 0.0F);
        this.setRotateAngle(MUSH10, 0.0F, 0.40980330836826856F, 0.0F);
        this.MUSH3 = new ModelRenderer(this, 51, 10);
        this.MUSH3.setRotationPoint(1.2F, 1.6F, 3.5F);
        this.MUSH3.addBox(0.0F, 0.0F, 0.0F, 2, 2, 2, 0.0F);
        this.setRotateAngle(MUSH3, 0.0F, 0.40980330836826856F, 0.0F);
        this.STEM9 = new ModelRenderer(this, 33, 0);
        this.STEM9.setRotationPoint(1.7F, -3.7F, -4.7F);
        this.STEM9.addBox(0.0F, -1.8F, 0.0F, 2, 2, 2, 0.0F);
        this.setRotateAngle(STEM9, 0.0F, 0.0F, 0.18203784098300857F);
        this.BODY.addChild(this.STEM3);
        this.BODY.addChild(this.MUSH3);
        this.HEAD.addChild(this.MUSH15);
        this.HEAD.addChild(this.MUSH6);
        this.HEAD.addChild(this.STEM6);
        this.HEAD.addChild(this.STEM7);
        this.RA.addChild(this.STEM12);
        this.RA.addChild(this.MUSH12);
        this.HEAD.addChild(this.MUSH11);
        this.HEAD.addChild(this.MUSH5);
        this.HEAD.addChild(this.STEM8);
        this.HEAD.addChild(this.STEM11);
        this.HEAD.addChild(this.STEM5);
        this.HEAD.addChild(this.STEM14);
        this.LA.addChild(this.STEM13);
        this.LA.addChild(this.MUSH13);
        this.HEAD.addChild(this.STEM4);
        this.HEAD.addChild(this.MUSH10);
        this.HEAD.addChild(this.STEM10);
        this.BODY.addChild(this.MUSH3);
        this.HEAD.addChild(this.STEM9);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
        this.LA.render(f5);
        this.LL.render(f5);
        this.BODY.render(f5);
        this.RA.render(f5);
        this.RL.render(f5);
        this.HEAD.render(f5);
    }

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
    
    public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn)
    {
        super.setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scaleFactor, entityIn);
        boolean flag = entityIn instanceof EntityZombie && ((EntityZombie)entityIn).isArmsRaised();
        float f = MathHelper.sin(this.swingProgress * (float)Math.PI);
        float f1 = MathHelper.sin((1.0F - (1.0F - this.swingProgress) * (1.0F - this.swingProgress)) * (float)Math.PI);
        this.RA.rotateAngleZ = 0.0F;
        this.LA.rotateAngleZ = 0.0F;
        this.RA.rotateAngleY = -(0.1F - f * 0.6F);
        this.LA.rotateAngleY = 0.1F - f * 0.6F;
        float f2 = -(float)Math.PI / (flag ? 1.5F : 2.25F);
        this.RA.rotateAngleX = f2;
        this.LA.rotateAngleX = f2;
        this.RA.rotateAngleX += f * 1.2F - f1 * 0.4F;
        this.LA.rotateAngleX += f * 1.2F - f1 * 0.4F;
        this.RA.rotateAngleZ += MathHelper.cos(ageInTicks * 0.09F) * 0.05F + 0.05F;
        this.LA.rotateAngleZ -= MathHelper.cos(ageInTicks * 0.09F) * 0.05F + 0.05F;
        this.LA.rotateAngleX += MathHelper.sin(ageInTicks * 0.067F) * 0.05F;
        this.LA.rotateAngleX -= MathHelper.sin(ageInTicks * 0.067F) * 0.05F;
        

    	this.HEAD.rotateAngleY = netHeadYaw * 0.017453292F;
    	this.LL.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
    	this.RL.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
        
    }
}
