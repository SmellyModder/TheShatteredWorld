package com.smellysox345.TheShatteredWorld.entity.projectiles.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.GlStateManager;
import org.lwjgl.opengl.GL11;

/**
 * Webprojectile - SmellyModder
 * Created using Tabula 7.0.0
 */
public class ModelWebProjectile extends ModelBase {
    public ModelRenderer shapeBase;
    public ModelRenderer shape1;
    public ModelRenderer shape2;
    public ModelRenderer shape3;
    public ModelRenderer shape4;

    public ModelWebProjectile() {
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.shape2 = new ModelRenderer(this, 13, 8);
        this.shape2.setRotationPoint(-0.5F, 0.0F, 0.4F);
        this.shape2.addBox(0.0F, 0.0F, 0.0F, 3, 3, 0, 0.0F);
        this.setRotateAngle(shape2, 0.0F, -2.356194490192345F, 0.0F);
        this.shapeBase = new ModelRenderer(this, 0, 0);
        this.shapeBase.setRotationPoint(-1.0F, 0.0F, -1.9F);
        this.shapeBase.addBox(0.0F, 0.0F, 0.0F, 3, 3, 3, 0.0F);
        this.shape3 = new ModelRenderer(this, 13, 8);
        this.shape3.setRotationPoint(-0.5F, 0.0F, -1.6F);
        this.shape3.addBox(0.0F, 0.0F, 0.0F, 3, 3, 0, 0.0F);
        this.setRotateAngle(shape3, 0.0F, 2.356194490192345F, 0.0F);
        this.shape4 = new ModelRenderer(this, 13, 8);
        this.shape4.setRotationPoint(3.9F, 0.0F, 3.1F);
        this.shape4.addBox(0.0F, 0.0F, 0.0F, 3, 3, 0, 0.0F);
        this.setRotateAngle(shape4, 0.0F, 2.356194490192345F, 0.0F);
        this.shape1 = new ModelRenderer(this, 13, 8);
        this.shape1.setRotationPoint(1.3F, 0.0F, -1.2F);
        this.shape1.addBox(0.0F, 0.0F, 0.0F, 3, 3, 0, 0.0F);
        this.setRotateAngle(shape1, 0.0F, 0.8196066167365371F, 0.0F);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
        GlStateManager.enableBlend();
        GlStateManager.blendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
        GlStateManager.color(1.0F, 1.0F, 1.0F, 0.8F);
        this.shape2.render(f5);
        GlStateManager.disableBlend();
        GlStateManager.enableBlend();
        GlStateManager.blendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
        GlStateManager.color(1.0F, 1.0F, 1.0F, 0.5F);
        this.shapeBase.render(f5);
        GlStateManager.disableBlend();
        GlStateManager.enableBlend();
        GlStateManager.blendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
        GlStateManager.color(1.0F, 1.0F, 1.0F, 0.8F);
        this.shape3.render(f5);
        GlStateManager.disableBlend();
        GlStateManager.enableBlend();
        GlStateManager.blendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
        GlStateManager.color(1.0F, 1.0F, 1.0F, 0.8F);
        this.shape4.render(f5);
        GlStateManager.disableBlend();
        GlStateManager.enableBlend();
        GlStateManager.blendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
        GlStateManager.color(1.0F, 1.0F, 1.0F, 0.8F);
        this.shape1.render(f5);
        GlStateManager.disableBlend();
    }

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
