package com.smellysox345.TheShatteredWorld.tileentity.animation;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * ModelChest - Either Mojang or a mod author
 * Created using Tabula 7.0.0
 */
@SideOnly(Side.CLIENT)
public class ModelShroomChest extends ModelBase {
    public ModelRenderer LOCK;
    public ModelRenderer TOPCHEST;
    public ModelRenderer BOTTOMCHEST;
    public ModelRenderer STEM1;
    public ModelRenderer STEM2;
    public ModelRenderer STEM3;
    public ModelRenderer STEM4;
    public ModelRenderer STEM5;
    public ModelRenderer SHROOM1;
    public ModelRenderer SHROOM2;
    public ModelRenderer SHROOM3;
    public ModelRenderer SHROOM4;
    public ModelRenderer SHROOM5;

    public ModelShroomChest() {
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.LOCK = new ModelRenderer(this, 0, 0);
        this.LOCK.setRotationPoint(8.0F, 7.0F, 15.0F);
        this.LOCK.addBox(-1.0F, -2.0F, -15.0F, 2, 4, 1, 0.0F);
        this.SHROOM5 = new ModelRenderer(this, 30, 54);
        this.SHROOM5.setRotationPoint(-1.0F, -2.0F, -1.0F);
        this.SHROOM5.addBox(0.0F, 0.0F, 0.0F, 5, 2, 5, 0.0F);
        this.BOTTOMCHEST = new ModelRenderer(this, 0, 19);
        this.BOTTOMCHEST.setRotationPoint(1.0F, 6.0F, 1.0F);
        this.BOTTOMCHEST.addBox(0.0F, 0.0F, 0.0F, 14, 10, 14, 0.0F);
        this.SHROOM3 = new ModelRenderer(this, 0, 28);
        this.SHROOM3.setRotationPoint(-0.5F, -1.0F, -0.5F);
        this.SHROOM3.addBox(0.0F, 0.0F, 0.0F, 3, 1, 3, 0.0F);
        this.STEM5 = new ModelRenderer(this, 50, 54);
        this.STEM5.setRotationPoint(8.5F, -8.0F, -13.7F);
        this.STEM5.addBox(0.0F, 0.0F, 0.0F, 3, 4, 3, 0.0F);
        this.setRotateAngle(STEM5, 0.4553564018453205F, -1.3658946726107624F, -0.22759093446006054F);
        this.SHROOM1 = new ModelRenderer(this, 0, 55);
        this.SHROOM1.setRotationPoint(-0.5F, -2.0F, -0.5F);
        this.SHROOM1.addBox(0.0F, 0.0F, 0.0F, 2, 2, 2, 0.0F);
        this.STEM2 = new ModelRenderer(this, 10, 50);
        this.STEM2.setRotationPoint(9.8F, -7.5F, -4.5F);
        this.STEM2.addBox(0.0F, 0.0F, 0.0F, 2, 3, 2, 0.0F);
        this.setRotateAngle(STEM2, 0.045553093477052F, 0.5462880558742251F, 0.5462880558742251F);
        this.STEM4 = new ModelRenderer(this, 24, 44);
        this.STEM4.setRotationPoint(11.2F, -7.1F, -9.3F);
        this.STEM4.addBox(0.0F, 0.0F, 0.0F, 1, 3, 1, 0.0F);
        this.setRotateAngle(STEM4, 0.07888888219014369F, 0.3344050846821135F, 0.27314402793711257F);
        this.SHROOM4 = new ModelRenderer(this, 22, 50);
        this.SHROOM4.setRotationPoint(-0.5F, -1.0F, -0.6F);
        this.SHROOM4.addBox(0.0F, 0.0F, 0.0F, 2, 1, 2, 0.0F);
        this.STEM1 = new ModelRenderer(this, 0, 50);
        this.STEM1.setRotationPoint(2.4F, -6.0F, -3.3F);
        this.STEM1.addBox(0.0F, 0.0F, 0.0F, 1, 3, 1, 0.0F);
        this.setRotateAngle(STEM1, 0.27314402793711257F, 0.0F, 0.0F);
        this.TOPCHEST = new ModelRenderer(this, 0, 0);
        this.TOPCHEST.setRotationPoint(1.0F, 7.0F, 15.0F);
        this.TOPCHEST.addBox(0.0F, -5.0F, -14.0F, 14, 5, 14, 0.0F);
        this.STEM3 = new ModelRenderer(this, 0, 20);
        this.STEM3.setRotationPoint(3.4F, -8.2F, -9.3F);
        this.STEM3.addBox(0.0F, 0.0F, 0.0F, 2, 4, 2, 0.0F);
        this.setRotateAngle(STEM3, -0.22759093446006054F, -1.5025539530419183F, 0.0F);
        this.SHROOM2 = new ModelRenderer(this, 5, 59);
        this.SHROOM2.setRotationPoint(-1.0F, -1.0F, -0.8F);
        this.SHROOM2.addBox(0.0F, 0.0F, 0.0F, 4, 1, 4, 0.0F);
        this.STEM5.addChild(this.SHROOM5);
        this.STEM3.addChild(this.SHROOM3);
        this.TOPCHEST.addChild(this.STEM5);
        this.STEM1.addChild(this.SHROOM1);
        this.TOPCHEST.addChild(this.STEM2);
        this.TOPCHEST.addChild(this.STEM4);
        this.STEM4.addChild(this.SHROOM4);
        this.TOPCHEST.addChild(this.STEM1);
        this.TOPCHEST.addChild(this.STEM3);
        this.STEM2.addChild(this.SHROOM2);
    }
    
    public void renderAll() {
    	this.LOCK.rotateAngleX = this.TOPCHEST.rotateAngleX;
    	this.BOTTOMCHEST.render(0.0625F);
    	this.LOCK.render(0.0625F);
    	this.TOPCHEST.render(0.0625F);
    }
    
    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
