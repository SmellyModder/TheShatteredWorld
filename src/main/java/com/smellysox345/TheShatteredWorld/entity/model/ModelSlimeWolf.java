package com.smellysox345.TheShatteredWorld.entity.model;

import org.lwjgl.opengl.GL11;

import com.smellysox345.TheShatteredWorld.entity.EntitySlimeWolf;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.math.MathHelper;

/**
 * ModelWolf - Either Mojang or a mod author
 * Created using Tabula 7.0.0
 */
public class ModelSlimeWolf extends ModelBase {
    public ModelRenderer FLL;
    public ModelRenderer MainBody;
    public ModelRenderer Head;
    public ModelRenderer Body;
    public ModelRenderer BodyInner;
    public ModelRenderer BLL;
    public ModelRenderer BRL;
    public ModelRenderer FRL;
    public ModelRenderer TAIL;
    public ModelRenderer TailTip;
    public ModelRenderer TailTipO;
    
 
   

    public ModelSlimeWolf() {
    	
    	
    	
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.BLL = new ModelRenderer(this, 0, 18);
        this.BLL.setRotationPoint(0.5F, 16.0F, 7.0F);
        this.BLL.addBox(0.0F, 0.0F, -1.0F, 2, 8, 2, 0.0F);
        this.BRL = new ModelRenderer(this, 0, 18);
        this.BRL.setRotationPoint(-2.5F, 16.0F, 7.0F);
        this.BRL.addBox(0.0F, 0.0F, -1.0F, 2, 8, 2, 0.0F);
        this.TailTip = new ModelRenderer(this, 0, 0);
        this.TailTip.setRotationPoint(-1.5F, 7.8F, -0.8F);
        this.TailTip.addBox(0.0F, -0.3F, 0.0F, 2, 3, 2, 0.0F);
        this.FRL = new ModelRenderer(this, 0, 18);
        this.FRL.setRotationPoint(-2.5F, 16.0F, -4.0F);
        this.FRL.addBox(0.0F, 0.0F, -1.0F, 2, 8, 2, 0.0F);
        this.Body = new ModelRenderer(this, 18, 14);
        this.Body.setRotationPoint(0.0F, 14.0F, 2.0F);
        this.Body.addBox(-3.0F, -2.0F, -3.0F, 6, 9, 6, 0.0F);
        this.setRotateAngle(Body, 1.5707963267948966F, 0.0F, 0.0F);
        this.BodyInner = new ModelRenderer(this, 18, 14);
        this.BodyInner.setRotationPoint(0.0F, 14.0F, 2.4F);
        this.BodyInner.addBox(-3.0F, -2.0F, -3.0F, 6, 9, 6, 0.0F);
        this.setRotateAngle(BodyInner, 1.5707963267948966F, 0.0F, 0.0F);
        this.MainBody = new ModelRenderer(this, 21, 0);
        this.MainBody.setRotationPoint(-1.0F, 14.0F, -3.0F);
        this.MainBody.addBox(-3.0F, -3.0F, -3.0F, 8, 6, 7, 0.0F);
        this.setRotateAngle(MainBody, 1.5707963267948966F, 0.0F, 0.0F);
        this.Head = new ModelRenderer(this, 21, 0);
        this.Head.setRotationPoint(-0.9F, 14.0F, -3.0F);
        this.Head.addBox(-3.0F, -3.0F, -3.0F, 8, 6, 7, 0.0F);
        this.setRotateAngle(Head, 1.5707963267948966F, 0.0F, 0.0F);
        this.TAIL = new ModelRenderer(this, 37, 1);
        this.TAIL.setRotationPoint(-1.0F, 12.0F, 8.0F);
        this.TAIL.addBox(0.0F, 0.0F, -1.0F, 2, 8, 2, 0.0F);
        this.setRotateAngle(TAIL, -2.777342438698576F, 0.0F, 0.0F);
        this.FLL = new ModelRenderer(this, 0, 18);
        this.FLL.setRotationPoint(0.5F, 16.0F, -4.0F);
        this.FLL.addBox(0.0F, 0.0F, -1.0F, 2, 8, 2, 0.0F);
        this.TailTipO = new ModelRenderer(this, 0, 0);
        this.TailTipO.setRotationPoint(1.6F, 7.8F, -0.8F);
        this.TailTipO.addBox(0.0F, -0.3F, 0.0F, 2, 3, 2, 0.0F);
        this.TAIL.addChild(this.TailTip);
        this.TAIL.addChild(this.TailTipO);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
    	
    	 GlStateManager.enableBlend();
         GlStateManager.blendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
         GlStateManager.color(1.0F, 1.0F, 1.0F, 0.9F);
         this.FLL.render(f5);
         GlStateManager.disableBlend();
         GlStateManager.enableBlend();
         GlStateManager.blendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
         GlStateManager.color(1.0F, 1.0F, 1.0F, 0.9F);
         this.BRL.render(f5);
         GlStateManager.disableBlend();
         GlStateManager.enableBlend();
         GlStateManager.blendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
         GlStateManager.color(1.0F, 1.0F, 1.0F, 0.9F);
         this.TAIL.render(f5);
         GlStateManager.disableBlend();
         GlStateManager.enableBlend();
         GlStateManager.blendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
         GlStateManager.color(1.0F, 1.0F, 1.0F, 0.9F);
         this.Body.render(f5);
         GlStateManager.disableBlend();
         GlStateManager.pushMatrix();
         GlStateManager.translate(this.MainBody.offsetX, this.MainBody.offsetY, this.MainBody.offsetZ);
         GlStateManager.translate(this.MainBody.rotationPointX * f5, this.MainBody.rotationPointY * f5, this.MainBody.rotationPointZ * f5);
         GlStateManager.scale(0.88D, 0.97D, 0.97D);
         GlStateManager.translate(-this.MainBody.offsetX, -this.MainBody.offsetY, -this.MainBody.offsetZ);
         GlStateManager.translate(-this.MainBody.rotationPointX * f5, -this.MainBody.rotationPointY * f5, -this.MainBody.rotationPointZ * f5);
         GlStateManager.enableBlend();
         GlStateManager.blendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
         GlStateManager.color(1.0F, 1.0F, 1.0F, 0.8F);
         this.MainBody.render(f5);
         GlStateManager.popMatrix();
         GlStateManager.enableBlend();
         GlStateManager.blendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
         GlStateManager.color(1.0F, 1.0F, 1.0F, 0.9F);
         this.FRL.render(f5);
         GlStateManager.disableBlend();
         GlStateManager.pushMatrix();
         GlStateManager.translate(this.Head.offsetX, this.Head.offsetY, this.Head.offsetZ);
         GlStateManager.translate(this.Head.rotationPointX * f5, this.Head.rotationPointY * f5, this.Head.rotationPointZ * f5);
         GlStateManager.scale(0.8D, 0.8D, 0.8D);
         GlStateManager.translate(-this.Head.offsetX, -this.Head.offsetY, -this.Head.offsetZ);
         GlStateManager.translate(-this.Head.rotationPointX * f5, -this.Head.rotationPointY * f5, -this.Head.rotationPointZ * f5);
         GlStateManager.enableBlend();
         GlStateManager.blendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
         GlStateManager.color(1.0F, 1.0F, 1.0F, 0.9F);
         this.Head.render(f5);
         GlStateManager.disableBlend();
         GlStateManager.popMatrix();
         GlStateManager.enableBlend();
         GlStateManager.blendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
         GlStateManager.color(1.0F, 1.0F, 1.0F, 0.9F);
         this.BLL.render(f5);
         GlStateManager.disableBlend();
         GlStateManager.pushMatrix();
         GlStateManager.translate(this.BodyInner.offsetX, this.BodyInner.offsetY, this.BodyInner.offsetZ);
         GlStateManager.translate(this.BodyInner.rotationPointX * f5, this.BodyInner.rotationPointY * f5, this.BodyInner.rotationPointZ * f5);
         GlStateManager.scale(0.7D, 0.8D, 0.7D);
         GlStateManager.translate(-this.BodyInner.offsetX, -this.BodyInner.offsetY, -this.BodyInner.offsetZ);
         GlStateManager.translate(-this.BodyInner.rotationPointX * f5, -this.BodyInner.rotationPointY * f5, -this.BodyInner.rotationPointZ * f5);
         this.BodyInner.render(f5);
         GlStateManager.popMatrix();
    }

    
    public void setLivingAnimations(EntityLivingBase entitylivingbaseIn, float limbSwing, float limbSwingAmount, float partialTickTime)
    {
    	 EntitySlimeWolf slimewolf = (EntitySlimeWolf)entitylivingbaseIn;
    	 
    	 if (slimewolf.isSitting())
         {
             
             this.Body.setRotationPoint(0.0F, 18.0F, 0.0F);
             this.Body.rotateAngleX = ((float)Math.PI / 4F);
             this.TAIL.setRotationPoint(-1.0F, 21.0F, 6.0F);
             this.FRL.setRotationPoint(-2.5F, 22.0F, 2.0F);
             this.FRL.rotateAngleX = ((float)Math.PI * 3F / 2F);
             this.BRL.setRotationPoint(0.5F, 22.0F, 2.0F);
             this.BRL.rotateAngleX = ((float)Math.PI * 3F / 2F);
             this.FLL.rotateAngleX = 5.811947F;
             this.FLL.setRotationPoint(-2.49F, 17.0F, -4.0F);
             this.BLL.rotateAngleX = 5.811947F;
             this.BLL.setRotationPoint(0.51F, 17.0F, -4.0F);
             this.BodyInner.setRotationPoint(0.0F, 18.0F, 0.0F);
             this.BodyInner.rotateAngleX = ((float)Math.PI / 4F);
             
         }else {
             
                 this.MainBody.setRotationPoint(-1.0F, 14.0F, -3.0F);
                 this.MainBody.rotateAngleX = ((float)Math.PI / 2F);
                 this.Body.setRotationPoint(0.0F, 14.0F, 2.0F);
                 this.Body.rotateAngleX = ((float)Math.PI / 2F);
                 this.BodyInner.setRotationPoint(0.0F, 14.0F, 2.0F);
                 this.BodyInner.rotateAngleX = ((float)Math.PI / 2F);
                 this.TAIL.setRotationPoint(-1.0F, 12.0F, 8.0F);
                 this.FRL.setRotationPoint(-2.5F, 16.0F, -4.0F);
                 this.BRL.setRotationPoint(-2.5F, 16.0F, 7.0F);
                 this.FLL.setRotationPoint(0.5F, 16.0F, -4.0F);
                 this.BLL.setRotationPoint(0.5F, 16.0F, 7.0F);
                 this.FRL.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
                 this.BRL.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
                 this.FLL.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
                 this.BLL.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
             }
    	 
    	 this.MainBody.rotateAngleZ = slimewolf.getInterestedAngle(partialTickTime) + slimewolf.getShakeAngle(partialTickTime, 0.0F);
    	 this.Head.rotateAngleZ = slimewolf.getInterestedAngle(partialTickTime) + slimewolf.getShakeAngle(partialTickTime, 0.0F);
    }
    
    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
    
    @Override
    public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) 
    {
    	this.FLL.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
    	this.BLL.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
    	this.FRL.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
    	this.BRL.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
    	
    	//Tail Moving
    	this.TAIL.rotateAngleZ = MathHelper.cos(limbSwing * 0.2662F) * 0.6F * limbSwingAmount;
    	
    	this.MainBody.rotateAngleY = netHeadYaw * 0.017453292F;
    	this.Head.rotateAngleY = netHeadYaw * 0.017453292F;
    
    }
}
