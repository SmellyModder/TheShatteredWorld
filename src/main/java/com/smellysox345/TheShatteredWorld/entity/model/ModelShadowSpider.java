package com.smellysox345.TheShatteredWorld.entity.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

public class ModelShadowSpider extends ModelBase {
    public ModelRenderer MIDDLEBODY;
    public ModelRenderer FARFAR_BACK_RIGHT_LEG;
    public ModelRenderer BACK_RIGHT_LEG;
    public ModelRenderer FRONT_RIGHT_LEG;
    public ModelRenderer HEAD;
    public ModelRenderer BACK;
    public ModelRenderer FARFAR_BACK_LEFT_LEG;
    public ModelRenderer FARBACK_LEFT_LEG;
    public ModelRenderer BACK_LEFT_LEG;
    public ModelRenderer FRONT_LEFT_LEG;
    public ModelRenderer FARBACK_RIGHT_LEG;

    public ModelShadowSpider() {
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.MIDDLEBODY = new ModelRenderer(this, 0, 0);
        this.MIDDLEBODY.setRotationPoint(0.0F, 15.0F, 0.0F);
        this.MIDDLEBODY.addBox(-3.0F, -3.0F, -3.0F, 6, 6, 6, 0.0F);
        this.BACK_LEFT_LEG = new ModelRenderer(this, 18, 0);
        this.BACK_LEFT_LEG.setRotationPoint(4.0F, 15.0F, 0.0F);
        this.BACK_LEFT_LEG.addBox(-1.0F, -1.0F, -1.0F, 16, 2, 2, 0.0F);
        this.setRotateAngle(BACK_LEFT_LEG, 0.0F, 0.39269908169872414F, 0.5811946409141118F);
        this.HEAD = new ModelRenderer(this, 32, 4);
        this.HEAD.setRotationPoint(0.0F, 15.0F, -3.0F);
        this.HEAD.addBox(-4.0F, -4.0F, -8.0F, 8, 8, 8, 0.0F);
        this.FRONT_RIGHT_LEG = new ModelRenderer(this, 18, 0);
        this.FRONT_RIGHT_LEG.setRotationPoint(-3.3F, 15.0F, -1.0F);
        this.FRONT_RIGHT_LEG.addBox(-15.0F, -1.0F, -1.0F, 16, 2, 2, 0.0F);
        this.setRotateAngle(FRONT_RIGHT_LEG, 0.0F, -0.7853981633974483F, -0.7853981633974483F);
        this.FRONT_LEFT_LEG = new ModelRenderer(this, 18, 0);
        this.FRONT_LEFT_LEG.setRotationPoint(3.3F, 15.0F, -1.0F);
        this.FRONT_LEFT_LEG.addBox(-1.0F, -1.0F, -1.0F, 16, 2, 2, 0.0F);
        this.setRotateAngle(FRONT_LEFT_LEG, 0.0F, 0.7853981633974483F, 0.7853981633974483F);
        this.BACK = new ModelRenderer(this, 0, 12);
        this.BACK.setRotationPoint(0.0F, 15.0F, 9.0F);
        this.BACK.addBox(-5.0F, -4.0F, -6.0F, 10, 8, 12, 0.0F);
        this.setRotateAngle(BACK, 0.05235987755982988F, 0.0F, 0.0F);
        this.FARFAR_BACK_LEFT_LEG = new ModelRenderer(this, 18, 0);
        this.FARFAR_BACK_LEFT_LEG.setRotationPoint(3.3F, 15.0F, 2.0F);
        this.FARFAR_BACK_LEFT_LEG.addBox(-1.0F, -1.0F, -1.0F, 16, 2, 2, 0.0F);
        this.setRotateAngle(FARFAR_BACK_LEFT_LEG, 0.0F, -0.7853981633974483F, 0.7853981633974483F);
        this.BACK_RIGHT_LEG = new ModelRenderer(this, 18, 0);
        this.BACK_RIGHT_LEG.setRotationPoint(-3.3F, 15.0F, 0.0F);
        this.BACK_RIGHT_LEG.addBox(-15.0F, -1.0F, -1.0F, 16, 2, 2, 0.0F);
        this.setRotateAngle(BACK_RIGHT_LEG, 0.0F, -0.39269908169872414F, -0.5811946409141118F);
        this.FARFAR_BACK_RIGHT_LEG = new ModelRenderer(this, 18, 0);
        this.FARFAR_BACK_RIGHT_LEG.setRotationPoint(-3.3F, 15.0F, 2.0F);
        this.FARFAR_BACK_RIGHT_LEG.addBox(-15.0F, -1.0F, -1.0F, 16, 2, 2, 0.0F);
        this.setRotateAngle(FARFAR_BACK_RIGHT_LEG, 0.0F, 0.7853981633974483F, -0.7853981633974483F);
        this.FARBACK_LEFT_LEG = new ModelRenderer(this, 18, 0);
        this.FARBACK_LEFT_LEG.setRotationPoint(3.3F, 15.0F, 1.0F);
        this.FARBACK_LEFT_LEG.addBox(-1.0F, -1.0F, -1.0F, 16, 2, 2, 0.0F);
        this.setRotateAngle(FARBACK_LEFT_LEG, 0.0F, -0.39269908169872414F, 0.5811946409141118F);
        this.FARBACK_RIGHT_LEG = new ModelRenderer(this, 18, 0);
        this.FARBACK_RIGHT_LEG.setRotationPoint(-3.3F, 15.0F, 1.0F);
        this.FARBACK_RIGHT_LEG.addBox(-15.0F, -1.0F, -1.0F, 16, 2, 2, 0.0F);
        this.setRotateAngle(FARBACK_RIGHT_LEG, 0.0F, 0.39269908169872414F, -0.5811946409141118F);
    }

    @Override
    public void render(Entity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) { 
    	this.setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale, entityIn);
        this.MIDDLEBODY.render(scale);
        this.BACK.render(scale);
        this.FARBACK_RIGHT_LEG.render(scale);
        this.BACK_LEFT_LEG.render(scale);
        this.FARBACK_LEFT_LEG.render(scale);
        this.FARFAR_BACK_LEFT_LEG.render(scale);
        this.HEAD.render(scale);
        this.FRONT_LEFT_LEG.render(scale);
        this.FARFAR_BACK_RIGHT_LEG.render(scale);
        this.FRONT_RIGHT_LEG.render(scale);
        this.BACK_RIGHT_LEG.render(scale);
    }
    
    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
    
    public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn)
    {
       	this.HEAD.rotateAngleY = netHeadYaw * 0.0097453292F;
        this.HEAD.rotateAngleX = headPitch * 0.0097453292F;
        float f = ((float)Math.PI / 2F);
        this.FRONT_LEFT_LEG.rotateAngleZ = 0.7853981633974483F;
        this.FRONT_RIGHT_LEG.rotateAngleZ = -0.7853981633974483F;
        this.BACK_LEFT_LEG.rotateAngleZ = 0.5811946409141118F;
        this.BACK_RIGHT_LEG.rotateAngleZ = -0.5811946409141118F;
        this.FARBACK_LEFT_LEG.rotateAngleZ = 0.5811946409141118F;
        this.FARBACK_RIGHT_LEG.rotateAngleZ = -0.5811946409141118F;
        this.FARFAR_BACK_LEFT_LEG.rotateAngleZ = 0.5811946409141118F;
        this.FARFAR_BACK_RIGHT_LEG.rotateAngleZ = -0.5811946409141118F;
        float f1 = -0.0F;
        float f2 = 0.3926991F;
        float f20 = MathHelper.sin(this.swingProgress * (float)Math.PI);
        float f21 = MathHelper.sin((1.0F - (1.0F - this.swingProgress) * (1.0F - this.swingProgress)) * (float)Math.PI);
        this.FRONT_LEFT_LEG.rotateAngleY = ((float)Math.PI / 4F);
        this.FRONT_RIGHT_LEG.rotateAngleY = -((float)Math.PI / 4F);
        this.BACK_LEFT_LEG.rotateAngleY = 0.3926991F;
        this.BACK_RIGHT_LEG.rotateAngleY = -0.3926991F;
        this.FARBACK_LEFT_LEG.rotateAngleY = -0.3926991F;
        this.FARBACK_RIGHT_LEG.rotateAngleY = 0.3926991F;
        this.FARFAR_BACK_LEFT_LEG.rotateAngleY = -((float)Math.PI / 4F);
        this.FARFAR_BACK_RIGHT_LEG.rotateAngleY = ((float)Math.PI / 4F);
        float f3 = -(MathHelper.cos(limbSwing * 0.6662F * 2.0F + 0.0F) * 0.4F) * limbSwingAmount;
        float f4 = -(MathHelper.cos(limbSwing * 0.6662F * 2.0F + (float)Math.PI) * 0.4F) * limbSwingAmount;
        float f5 = -(MathHelper.cos(limbSwing * 0.6662F * 2.0F + ((float)Math.PI / 2F)) * 0.4F) * limbSwingAmount;
        float f6 = -(MathHelper.cos(limbSwing * 0.6662F * 2.0F + ((float)Math.PI * 3F / 2F)) * 0.4F) * limbSwingAmount;
        float f7 = Math.abs(MathHelper.sin(limbSwing * 0.6662F + 0.0F) * 0.4F) * limbSwingAmount;
        float f8 = Math.abs(MathHelper.sin(limbSwing * 0.6662F + (float)Math.PI) * 0.4F) * limbSwingAmount;
        float f9 = Math.abs(MathHelper.sin(limbSwing * 0.6662F + ((float)Math.PI / 2F)) * 0.4F) * limbSwingAmount;
        float f10 = Math.abs(MathHelper.sin(limbSwing * 0.6662F + ((float)Math.PI * 3F / 2F)) * 0.4F) * limbSwingAmount;
        this.FRONT_LEFT_LEG.rotateAngleY += f3;
        this.FRONT_RIGHT_LEG.rotateAngleY += -f3;
        this.BACK_LEFT_LEG.rotateAngleY += f4;
        this.BACK_RIGHT_LEG.rotateAngleY += -f4;
        this.FARBACK_LEFT_LEG.rotateAngleY += f5;
        this.FARBACK_RIGHT_LEG.rotateAngleY += -f5;
        this.FARFAR_BACK_LEFT_LEG.rotateAngleY += f6;
        this.FARFAR_BACK_RIGHT_LEG.rotateAngleY += -f6;
        this.FRONT_LEFT_LEG.rotateAngleZ += f7;
        this.FRONT_RIGHT_LEG.rotateAngleZ += -f7;
        this.BACK_LEFT_LEG.rotateAngleZ += f8;
        this.BACK_RIGHT_LEG.rotateAngleZ += -f8;
        this.FARBACK_LEFT_LEG.rotateAngleZ += f9;
        this.FARBACK_RIGHT_LEG.rotateAngleZ += -f9;
        this.FARFAR_BACK_LEFT_LEG.rotateAngleZ += f10;
        this.FARFAR_BACK_RIGHT_LEG.rotateAngleZ += -f10;
    }
}
