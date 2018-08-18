package com.smellysox345.TheShatteredWorld.entity.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

/**
 * EyeCrawler - SmellyModder
 * Created using Tabula 7.0.0
 */
public class ModelWatcher extends ModelBase {
    public ModelRenderer BLOCK;
    public ModelRenderer FLLEG;
    public ModelRenderer FRLEG;
    public ModelRenderer BRLEG;
    public ModelRenderer BLLEG;
    public ModelRenderer ROOT1;
    public ModelRenderer ROOT2;
    public ModelRenderer ROOT3;
    public ModelRenderer ROOT4;

    public ModelWatcher() {
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.BLOCK = new ModelRenderer(this, 0, 28);
        this.BLOCK.setRotationPoint(-8.0F, 6.0F, -8.0F);
        this.BLOCK.addBox(0.0F, 0.0F, 0.0F, 16, 16, 16, 0.0F);
        this.ROOT4 = new ModelRenderer(this, 2, 0);
        this.ROOT4.setRotationPoint(5.1F, 4.9F, -3.8F);
        this.ROOT4.addBox(0.0F, 0.0F, 0.0F, 4, 2, 2, 0.0F);
        this.setRotateAngle(ROOT4, 0.0F, 0.0F, 1.593485607070823F);
        this.BLLEG = new ModelRenderer(this, 2, 0);
        this.BLLEG.setRotationPoint(7.6F, 20.9F, 6.0F);
        this.BLLEG.addBox(0.0F, 0.0F, 0.0F, 4, 2, 2, 0.0F);
        this.setRotateAngle(BLLEG, 0.0F, -0.5410520681182421F, 0.3141592653589793F);
        this.FLLEG = new ModelRenderer(this, 2, 0);
        this.FLLEG.mirror = true;
        this.FLLEG.setRotationPoint(7.6F, 20.5F, -6.0F);
        this.FLLEG.addBox(0.0F, 0.0F, 0.0F, 4, 2, 2, 0.0F);
        this.setRotateAngle(FLLEG, 0.0F, 0.5462880558742251F, 0.3141592653589793F);
        this.BRLEG = new ModelRenderer(this, 2, 0);
        this.BRLEG.mirror = true;
        this.BRLEG.setRotationPoint(7.6F, 20.1F, -10.2F);
        this.BRLEG.addBox(-25.0F, -3.1F, 6.8F, 4, 2, 2, 0.0F);
        this.setRotateAngle(BRLEG, 0.0F, 0.5410520681182421F, -0.2617993877991494F);
        this.ROOT1 = new ModelRenderer(this, 2, 0);
        this.ROOT1.setRotationPoint(0.0F, 7.5F, 0.0F);
        this.ROOT1.addBox(0.0F, 0.0F, 0.0F, 4, 2, 2, 0.0F);
        this.setRotateAngle(ROOT1, 0.0F, 0.0F, -1.5481070465189704F);
        this.ROOT3 = new ModelRenderer(this, 2, 0);
        this.ROOT3.setRotationPoint(-6.0F, 8.9F, 0.9F);
        this.ROOT3.addBox(0.0F, 0.0F, 0.0F, 4, 2, 2, 0.0F);
        this.setRotateAngle(ROOT3, 0.0F, 0.0F, -1.5481070465189704F);
        this.FRLEG = new ModelRenderer(this, 2, 0);
        this.FRLEG.setRotationPoint(7.6F, 20.5F, -6.0F);
        this.FRLEG.addBox(-16.3F, -3.7F, 6.8F, 4, 2, 2, 0.0F);
        this.setRotateAngle(FRLEG, 0.0F, -0.5410520681182421F, -0.2617993877991494F);
        this.ROOT2 = new ModelRenderer(this, 2, 0);
        this.ROOT2.setRotationPoint(3.0F, 8.5F, 3.0F);
        this.ROOT2.addBox(0.0F, 0.0F, 0.0F, 4, 2, 2, 0.0F);
        this.setRotateAngle(ROOT2, 0.0F, 0.0F, -1.5481070465189704F);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
        this.BLOCK.render(f5);
        this.ROOT4.render(f5);
        this.BLLEG.render(f5);
        this.FLLEG.render(f5);
        this.BRLEG.render(f5);
        this.ROOT1.render(f5);
        this.ROOT3.render(f5);
        this.FRLEG.render(f5);
        this.ROOT2.render(f5);
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
