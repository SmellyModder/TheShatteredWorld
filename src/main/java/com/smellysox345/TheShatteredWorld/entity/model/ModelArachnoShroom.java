package com.smellysox345.TheShatteredWorld.entity.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

/**
 * ModelSpider - Either Mojang or a mod author
 * Created using Tabula 7.0.0
 */

public class ModelArachnoShroom extends ModelBase {
    public ModelRenderer HEAD;
    public ModelRenderer MIDDLEBODY;
    public ModelRenderer FRONTRIGHTARM;
    public ModelRenderer BACKLEFTARM;
    public ModelRenderer FRONTLEFTLEG;
    public ModelRenderer BACKRIGHTLEG;
    public ModelRenderer FARBACKLEFTARM;
    public ModelRenderer FARBACKRIGHTARM;
    public ModelRenderer FARFARBACKRIGHTARM;
    public ModelRenderer FARFARBACKLEFTARM;
    public ModelRenderer LEFTMANDIBLE;
    public ModelRenderer RIGHTMANDIBLE;
    public ModelRenderer BACK;
    public ModelRenderer SPINNER2;
    public ModelRenderer SPINNER;

    public ModelArachnoShroom() {
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.MIDDLEBODY = new ModelRenderer(this, 4, 0);
        this.MIDDLEBODY.setRotationPoint(-2.1F, 15.0F, 0.0F);
        this.MIDDLEBODY.addBox(-3.0F, -3.0F, -3.0F, 10, 8, 6, 0.0F);
        this.setRotateAngle(MIDDLEBODY, 0.022863813201125717F, 0.0F, 0.0F);
        this.BACK = new ModelRenderer(this, 24, 13);
        this.BACK.setRotationPoint(-1.0F, -3.8F, 6.2F);
        this.BACK.addBox(-3.0F, -3.0F, -3.0F, 12, 11, 8, 0.0F);
        this.setRotateAngle(BACK, -0.9105382707654417F, 0.0F, 0.0F);
        this.FARBACKRIGHTARM = new ModelRenderer(this, 0, 16);
        this.FARBACKRIGHTARM.setRotationPoint(-4.7F, 20.1F, 2.9F);
        this.FARBACKRIGHTARM.addBox(-9.0F, -3.0F, -3.0F, 12, 2, 2, 0.0F);
        this.setRotateAngle(FARBACKRIGHTARM, 0.0F, 0.3913028182971287F, -0.5811946409141118F);
        this.BACKLEFTARM = new ModelRenderer(this, 0, 16);
        this.BACKLEFTARM.setRotationPoint(6.0F, 21.1F, 0.0F);
        this.BACKLEFTARM.addBox(-3.0F, -3.0F, -3.0F, 12, 2, 2, 0.0F);
        this.setRotateAngle(BACKLEFTARM, 0.0F, 0.3839724354387525F, 0.5811946409141118F);
        this.FARBACKLEFTARM = new ModelRenderer(this, 0, 16);
        this.FARBACKLEFTARM.setRotationPoint(4.7F, 20.1F, 2.9F);
        this.FARBACKLEFTARM.addBox(-3.0F, -3.0F, -3.0F, 12, 2, 2, 0.0F);
        this.setRotateAngle(FARBACKLEFTARM, 0.0F, -0.3913028182971287F, 0.5811946409141118F);
        this.FARFARBACKLEFTARM = new ModelRenderer(this, 0, 16);
        this.FARFARBACKLEFTARM.setRotationPoint(4.3F, 20.0F, 3.2F);
        this.FARFARBACKLEFTARM.addBox(-3.0F, -3.0F, -3.0F, 12, 2, 2, 0.0F);
        this.setRotateAngle(FARFARBACKLEFTARM, 0.0F, -0.7853981633974483F, 0.5811946409141118F);
        this.SPINNER = new ModelRenderer(this, 0, 0);
        this.SPINNER.setRotationPoint(7.6F, -2.0F, -3.9F);
        this.SPINNER.addBox(-3.0F, -3.0F, -3.0F, 2, 2, 2, 0.0F);
        this.setRotateAngle(SPINNER, -1.593485607070823F, 0.0F, 0.0F);
        this.LEFTMANDIBLE = new ModelRenderer(this, 36, 0);
        this.LEFTMANDIBLE.setRotationPoint(0.0F, 5.0F, -0.9F);
        this.LEFTMANDIBLE.addBox(-4.0F, -4.0F, -8.0F, 1, 1, 1, 0.0F);
        this.HEAD = new ModelRenderer(this, 36, 0);
        this.HEAD.setRotationPoint(0.0F, 16.7F, -0.4F);
        this.HEAD.addBox(-4.0F, -4.0F, -8.0F, 8, 6, 6, 0.0F);
        this.FRONTLEFTLEG = new ModelRenderer(this, 0, 16);
        this.FRONTLEFTLEG.setRotationPoint(6.0F, 21.1F, -1.9F);
        this.FRONTLEFTLEG.addBox(-3.0F, -3.0F, -3.0F, 12, 2, 2, 0.0F);
        this.setRotateAngle(FRONTLEFTLEG, 0.0F, 0.7927285462558246F, 0.7853981633974483F);
        this.FARFARBACKRIGHTARM = new ModelRenderer(this, 0, 16);
        this.FARFARBACKRIGHTARM.setRotationPoint(-3.4F, 20.1F, 3.2F);
        this.FARFARBACKRIGHTARM.addBox(-9.0F, -3.0F, -3.0F, 12, 2, 2, 0.0F);
        this.setRotateAngle(FARFARBACKRIGHTARM, 0.0F, 0.7853981633974483F, -0.5811946409141118F);
        this.FRONTRIGHTARM = new ModelRenderer(this, 0, 16);
        this.FRONTRIGHTARM.setRotationPoint(-6.0F, 21.1F, -1.9F);
        this.FRONTRIGHTARM.addBox(-9.0F, -3.0F, -3.0F, 12, 2, 2, 0.0F);
        this.setRotateAngle(FRONTRIGHTARM, 0.0F, -0.7853981633974483F, -0.7853981633974483F);
        this.RIGHTMANDIBLE = new ModelRenderer(this, 36, 0);
        this.RIGHTMANDIBLE.setRotationPoint(7.0F, 5.0F, -0.9F);
        this.RIGHTMANDIBLE.addBox(-4.0F, -4.0F, -8.0F, 1, 1, 1, 0.0F);
        this.BACKRIGHTLEG = new ModelRenderer(this, 0, 16);
        this.BACKRIGHTLEG.setRotationPoint(-6.0F, 21.1F, 0.0F);
        this.BACKRIGHTLEG.addBox(-9.0F, -3.0F, -3.0F, 12, 2, 2, 0.0F);
        this.setRotateAngle(BACKRIGHTLEG, 0.0F, -0.3839724354387525F, -0.5811946409141118F);
        this.SPINNER2 = new ModelRenderer(this, 0, 0);
        this.SPINNER2.setRotationPoint(2.3F, -2.0F, -3.9F);
        this.SPINNER2.addBox(-3.0F, -3.0F, -3.0F, 2, 2, 2, 0.0F);
        this.setRotateAngle(SPINNER2, -1.593485607070823F, 0.0F, 0.0F);
        this.MIDDLEBODY.addChild(this.BACK);
        this.BACK.addChild(this.SPINNER);
        this.HEAD.addChild(this.LEFTMANDIBLE);
        this.HEAD.addChild(this.RIGHTMANDIBLE);
        this.BACK.addChild(this.SPINNER2);
    }

    @Override
    public void render(Entity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) { 
    	this.setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale, entityIn);
        this.MIDDLEBODY.render(scale);
        this.FARBACKRIGHTARM.render(scale);
        this.BACKLEFTARM.render(scale);
        this.FARBACKLEFTARM.render(scale);
        this.FARFARBACKLEFTARM.render(scale);
        this.HEAD.render(scale);
        this.FRONTLEFTLEG.render(scale);
        this.FARFARBACKRIGHTARM.render(scale);
        this.FRONTRIGHTARM.render(scale);
        this.BACKRIGHTLEG.render(scale);
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
    	this.HEAD.rotateAngleY = netHeadYaw * 0.0097453292F;
        this.HEAD.rotateAngleX = headPitch * 0.0097453292F;
        float f = ((float)Math.PI / 2F);
        this.FRONTLEFTLEG.rotateAngleZ = 0.7853981633974483F;
        this.FRONTRIGHTARM.rotateAngleZ = -0.7853981633974483F;
        this.BACKLEFTARM.rotateAngleZ = 0.5811946409141118F;
        this.BACKRIGHTLEG.rotateAngleZ = -0.5811946409141118F;
        this.FARBACKLEFTARM.rotateAngleZ = 0.5811946409141118F;
        this.FARBACKRIGHTARM.rotateAngleZ = -0.5811946409141118F;
        this.FARFARBACKLEFTARM.rotateAngleZ = 0.5811946409141118F;
        this.FARFARBACKRIGHTARM.rotateAngleZ = -0.5811946409141118F;
        float f1 = -0.0F;
        float f2 = 0.3926991F;
        float f20 = MathHelper.sin(this.swingProgress * (float)Math.PI);
        float f21 = MathHelper.sin((1.0F - (1.0F - this.swingProgress) * (1.0F - this.swingProgress)) * (float)Math.PI);
        this.FRONTLEFTLEG.rotateAngleY = ((float)Math.PI / 4F);
        this.FRONTRIGHTARM.rotateAngleY = -((float)Math.PI / 4F);
        this.BACKLEFTARM.rotateAngleY = 0.3926991F;
        this.BACKRIGHTLEG.rotateAngleY = -0.3926991F;
        this.FARBACKLEFTARM.rotateAngleY = -0.3926991F;
        this.FARBACKRIGHTARM.rotateAngleY = 0.3926991F;
        this.FARFARBACKLEFTARM.rotateAngleY = -((float)Math.PI / 4F);
        this.FARFARBACKRIGHTARM.rotateAngleY = ((float)Math.PI / 4F);
        float f3 = -(MathHelper.cos(limbSwing * 0.6662F * 2.0F + 0.0F) * 0.4F) * limbSwingAmount;
        float f4 = -(MathHelper.cos(limbSwing * 0.6662F * 2.0F + (float)Math.PI) * 0.4F) * limbSwingAmount;
        float f5 = -(MathHelper.cos(limbSwing * 0.6662F * 2.0F + ((float)Math.PI / 2F)) * 0.4F) * limbSwingAmount;
        float f6 = -(MathHelper.cos(limbSwing * 0.6662F * 2.0F + ((float)Math.PI * 3F / 2F)) * 0.4F) * limbSwingAmount;
        float f7 = Math.abs(MathHelper.sin(limbSwing * 0.6662F + 0.0F) * 0.4F) * limbSwingAmount;
        float f8 = Math.abs(MathHelper.sin(limbSwing * 0.6662F + (float)Math.PI) * 0.4F) * limbSwingAmount;
        float f9 = Math.abs(MathHelper.sin(limbSwing * 0.6662F + ((float)Math.PI / 2F)) * 0.4F) * limbSwingAmount;
        float f10 = Math.abs(MathHelper.sin(limbSwing * 0.6662F + ((float)Math.PI * 3F / 2F)) * 0.4F) * limbSwingAmount;
        this.FRONTLEFTLEG.rotateAngleY += f3;
        this.FRONTRIGHTARM.rotateAngleY += -f3;
        this.BACKLEFTARM.rotateAngleY += f4;
        this.BACKRIGHTLEG.rotateAngleY += -f4;
        this.FARBACKLEFTARM.rotateAngleY += f5;
        this.FARBACKRIGHTARM.rotateAngleY += -f5;
        this.FARFARBACKLEFTARM.rotateAngleY += f6;
        this.FARFARBACKRIGHTARM.rotateAngleY += -f6;
        this.FRONTLEFTLEG.rotateAngleZ += f7;
        this.FRONTRIGHTARM.rotateAngleZ += -f7;
        this.BACKLEFTARM.rotateAngleZ += f8;
        this.BACKRIGHTLEG.rotateAngleZ += -f8;
        this.FARBACKLEFTARM.rotateAngleZ += f9;
        this.FARBACKRIGHTARM.rotateAngleZ += -f9;
        this.FARFARBACKLEFTARM.rotateAngleZ += f10;
        this.FARFARBACKRIGHTARM.rotateAngleZ += -f10;
        this.BACK.rotateAngleX = -0.9105382707654417F;
        this.BACK.rotateAngleX += MathHelper.sin(ageInTicks * 0.09F) * 0.05F + 0.05F;
        this.BACK.rotateAngleZ = MathHelper.cos(limbSwing * 0.2662F) * 0.2F * limbSwingAmount;
    }
}
