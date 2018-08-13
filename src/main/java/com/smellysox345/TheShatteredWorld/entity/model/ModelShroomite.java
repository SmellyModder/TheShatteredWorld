package com.smellysox345.TheShatteredWorld.entity.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.math.MathHelper;

import com.smellysox345.TheShatteredWorld.entity.EntityShroomite;
import net.minecraft.client.renderer.GlStateManager;
import org.lwjgl.opengl.GL11;

/**
 * LivingShroom - SmellyModder
 * Created using Tabula 7.0.0
 */
public class ModelShroomite extends ModelBase {
    public ModelRenderer BOTTOMSHROOM;
    public ModelRenderer MIDDLESHROOM;
    public ModelRenderer TOPSHROOM;
    public ModelRenderer TIP;

    public ModelShroomite() {
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.TOPSHROOM = new ModelRenderer(this, 0, 0);
        this.TOPSHROOM.setRotationPoint(0.55F, -3.7F, 1.4F);
        this.TOPSHROOM.addBox(0.0F, 0.0F, 0.0F, 4, 4, 4, 0.0F);
        this.setRotateAngle(TOPSHROOM, -0.22759093446006054F, 0.0F, 0.0F);
        this.MIDDLESHROOM = new ModelRenderer(this, 18, 0);
        this.MIDDLESHROOM.setRotationPoint(-2.55F, 12.9F, -1.6F);
        this.MIDDLESHROOM.addBox(0.0F, 0.0F, 0.0F, 5, 5, 5, 0.0F);
        this.setRotateAngle(MIDDLESHROOM, -0.22759093446006054F, 0.0F, 0.0F);
        this.TIP = new ModelRenderer(this, 32, 12);
        this.TIP.setRotationPoint(-1.95F, -5.1F, -1.9F);
        this.TIP.addBox(0.0F, 0.0F, 0.0F, 8, 6, 8, 0.0F);
        this.setRotateAngle(TIP, -0.045553093477052F, 0.0F, 0.0F);
        this.BOTTOMSHROOM = new ModelRenderer(this, 40, 0);
        this.BOTTOMSHROOM.setRotationPoint(-3.1F, 17.9F, -3.0F);
        this.BOTTOMSHROOM.addBox(0.0F, 0.0F, 0.0F, 6, 6, 6, 0.0F);
        this.MIDDLESHROOM.addChild(this.TOPSHROOM);
        this.TOPSHROOM.addChild(this.TIP);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
        this.MIDDLESHROOM.render(f5);
        GlStateManager.pushMatrix();
        GlStateManager.translate(this.BOTTOMSHROOM.offsetX, this.BOTTOMSHROOM.offsetY, this.BOTTOMSHROOM.offsetZ);
        GlStateManager.translate(this.BOTTOMSHROOM.rotationPointX * f5, this.BOTTOMSHROOM.rotationPointY * f5, this.BOTTOMSHROOM.rotationPointZ * f5);
        GlStateManager.scale(1.0D, 1.05D, 1.0D);
        GlStateManager.translate(-this.BOTTOMSHROOM.offsetX, -this.BOTTOMSHROOM.offsetY, -this.BOTTOMSHROOM.offsetZ);
        GlStateManager.translate(-this.BOTTOMSHROOM.rotationPointX * f5, -this.BOTTOMSHROOM.rotationPointY * f5, -this.BOTTOMSHROOM.rotationPointZ * f5);
        this.BOTTOMSHROOM.render(f5);
        GlStateManager.popMatrix();
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
    	this.BOTTOMSHROOM.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 0.4F * limbSwingAmount;
    	
    }
    
    public void setLivingAnimations(EntityLivingBase entitylivingbaseIn, float limbSwing, float limbSwingAmount, float partialTickTime)
    {
    	
    }
}
