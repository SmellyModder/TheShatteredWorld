package com.smellysox345.TheShatteredWorld.entity.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

/**
 * ModelCreeper - Either Mojang or a mod author
 * Created using Tabula 7.0.0
 */

public class ModelShroomCreeper extends ModelBase {
    public ModelRenderer BODY;
    public ModelRenderer BLL;
    public ModelRenderer FLL;
    public ModelRenderer FRL;
    public ModelRenderer BRL;
    public ModelRenderer HEAD;
    public ModelRenderer STEMT;
    public ModelRenderer STEMLS;
    public ModelRenderer STEMRS;
    public ModelRenderer STEMB;
    public ModelRenderer SHROOMT;
    public ModelRenderer SHROOMLS;
    public ModelRenderer SHROOMRS;
    public ModelRenderer STEMB_1;

    public ModelShroomCreeper() {
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.SHROOMT = new ModelRenderer(this, 34, 0);
        this.SHROOMT.setRotationPoint(-2.0F, -1.6F, -2.5F);
        this.SHROOMT.addBox(-4.0F, -8.0F, -4.0F, 7, 3, 8, 0.0F);
        this.STEMT = new ModelRenderer(this, 24, 0);
        this.STEMT.setRotationPoint(2.5F, -3.0F, 2.4F);
        this.STEMT.addBox(-4.0F, -8.0F, -4.0F, 3, 3, 3, 0.0F);
        this.BRL = new ModelRenderer(this, 0, 16);
        this.BRL.setRotationPoint(-2.0F, 18.0F, 4.0F);
        this.BRL.addBox(-2.0F, 0.0F, -2.0F, 4, 6, 4, 0.0F);
        this.STEMRS = new ModelRenderer(this, 24, 0);
        this.STEMRS.setRotationPoint(-3.2F, 2.4F, 2.4F);
        this.STEMRS.addBox(-4.0F, -8.0F, -4.0F, 3, 3, 3, 0.0F);
        this.SHROOMLS = new ModelRenderer(this, 42, 11);
        this.SHROOMLS.setRotationPoint(2.2F, -1.0F, -1.0F);
        this.SHROOMLS.addBox(-4.0F, -8.0F, -4.0F, 4, 5, 5, 0.0F);
        this.BODY = new ModelRenderer(this, 16, 16);
        this.BODY.setRotationPoint(0.0F, 6.0F, 0.0F);
        this.BODY.addBox(-4.0F, 0.0F, -2.0F, 8, 12, 4, 0.0F);
        this.STEMB_1 = new ModelRenderer(this, 42, 21);
        this.STEMB_1.setRotationPoint(-0.9F, -1.1F, -3.1F);
        this.STEMB_1.addBox(-4.0F, -8.0F, -4.0F, 2, 5, 5, 0.0F);
        this.setRotateAngle(STEMB_1, 0.0F, 1.5707963267948966F, 0.0F);
        this.STEMLS = new ModelRenderer(this, 24, 0);
        this.STEMLS.setRotationPoint(8.0F, 2.4F, 2.8F);
        this.STEMLS.addBox(-4.0F, -8.0F, -4.0F, 3, 3, 3, 0.0F);
        this.SHROOMRS = new ModelRenderer(this, 42, 21);
        this.SHROOMRS.setRotationPoint(-1.8F, -1.0F, -1.0F);
        this.SHROOMRS.addBox(-4.0F, -8.0F, -4.0F, 2, 5, 5, 0.0F);
        this.HEAD = new ModelRenderer(this, 0, 0);
        this.HEAD.setRotationPoint(0.0F, 6.0F, 0.0F);
        this.HEAD.addBox(-4.0F, -8.0F, -4.0F, 8, 8, 8, 0.0F);
        this.FLL = new ModelRenderer(this, 0, 16);
        this.FLL.setRotationPoint(2.0F, 18.0F, -4.0F);
        this.FLL.addBox(-2.0F, 0.0F, -2.0F, 4, 6, 4, 0.0F);
        this.STEMB = new ModelRenderer(this, 24, 0);
        this.STEMB.setRotationPoint(2.5F, 2.4F, 8.1F);
        this.STEMB.addBox(-4.0F, -8.0F, -4.0F, 3, 3, 3, 0.0F);
        this.FRL = new ModelRenderer(this, 0, 16);
        this.FRL.setRotationPoint(-2.0F, 18.0F, -4.0F);
        this.FRL.addBox(-2.0F, 0.0F, -2.0F, 4, 6, 4, 0.0F);
        this.BLL = new ModelRenderer(this, 0, 16);
        this.BLL.setRotationPoint(2.0F, 18.0F, 4.0F);
        this.BLL.addBox(-2.0F, 0.0F, -2.0F, 4, 6, 4, 0.0F);
        this.STEMT.addChild(this.SHROOMT);
        this.HEAD.addChild(this.STEMT);
        this.HEAD.addChild(this.STEMRS);
        this.STEMLS.addChild(this.SHROOMLS);
        this.STEMB.addChild(this.STEMB_1);
        this.HEAD.addChild(this.STEMLS);
        this.STEMRS.addChild(this.SHROOMRS);
        this.HEAD.addChild(this.STEMB);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
        this.BRL.render(f5);
        this.BODY.render(f5);
        this.HEAD.render(f5);
        this.FLL.render(f5);
        this.FRL.render(f5);
        this.BLL.render(f5);
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
        this.HEAD.rotateAngleY = netHeadYaw * 0.017453292F;
        this.HEAD.rotateAngleX = headPitch * 0.017453292F;
        this.FLL.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
        this.FRL.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
        this.BLL.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
        this.BRL.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
    }
}
