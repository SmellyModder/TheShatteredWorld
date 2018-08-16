package com.smellysox345.TheShatteredWorld.entity.model;

import com.smellysox345.TheShatteredWorld.entity.EntityFlyingEye;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.passive.EntityBat;
import net.minecraft.util.math.MathHelper;

/**
 * ModelBat - Either Mojang or a mod author
 * Created using Tabula 7.0.0
 */
public class ModelFlyingEye extends ModelBase {
    public ModelRenderer EYE;
    public ModelRenderer BODY;
    public ModelRenderer FEET;
    public ModelRenderer LEAR;
    public ModelRenderer REAR;
    public ModelRenderer LEFT_WING_B;
    public ModelRenderer RIGHT_WING_B;
    public ModelRenderer LEFT_WING_F;
    public ModelRenderer RIGHT_WING_F;

    public ModelFlyingEye() {
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.RIGHT_WING_F = new ModelRenderer(this, 24, 16);
        this.RIGHT_WING_F.mirror = true;
        this.RIGHT_WING_F.setRotationPoint(12.0F, 1.0F, 1.5F);
        this.RIGHT_WING_F.addBox(0.0F, 1.0F, 0.0F, 8, 12, 1, 0.0F);
        this.setRotateAngle(RIGHT_WING_F, 0.0F, 1.7278759594743864F, 0.0F);
        this.BODY = new ModelRenderer(this, 0, 16);
        this.BODY.setRotationPoint(0.0F, 12.0F, 0.0F);
        this.BODY.addBox(-3.0F, 4.0F, -3.0F, 6, 12, 6, 0.0F);
        this.setRotateAngle(BODY, 3.141592653589793F, 0.0F, 0.0F);
        this.LEAR = new ModelRenderer(this, 24, 0);
        this.LEAR.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.LEAR.addBox(-4.0F, -6.0F, -2.0F, 3, 4, 1, 0.0F);
        this.EYE = new ModelRenderer(this, 0, 0);
        this.EYE.setRotationPoint(0.0F, 4.0F, 0.0F);
        this.EYE.addBox(-3.0F, -3.0F, -3.0F, 6, 6, 6, 0.0F);
        this.setRotateAngle(EYE, 0.0F, 3.141592653589793F, 3.141592653589793F);
        this.RIGHT_WING_B = new ModelRenderer(this, 42, 0);
        this.RIGHT_WING_B.mirror = true;
        this.RIGHT_WING_B.setRotationPoint(3.0F, 0.0F, 3.0F);
        this.RIGHT_WING_B.addBox(2.0F, 1.0F, 1.5F, 10, 16, 1, 0.0F);
        this.setRotateAngle(RIGHT_WING_B, -0.15707963267948966F, 1.2566370614359172F, 0.0F);
        this.FEET = new ModelRenderer(this, 0, 34);
        this.FEET.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.FEET.addBox(-5.0F, 16.0F, 0.0F, 10, 6, 1, 0.0F);
        this.setRotateAngle(FEET, 3.141592653589793F, 0.0F, 0.0F);
        this.REAR = new ModelRenderer(this, 24, 0);
        this.REAR.mirror = true;
        this.REAR.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.REAR.addBox(1.0F, -6.0F, -2.0F, 3, 4, 1, 0.0F);
        this.LEFT_WING_B = new ModelRenderer(this, 42, 0);
        this.LEFT_WING_B.setRotationPoint(-3.0F, 0.0F, 3.0F);
        this.LEFT_WING_B.addBox(-12.0F, 1.0F, 1.5F, 10, 16, 1, 0.0F);
        this.setRotateAngle(LEFT_WING_B, -0.15707963267948966F, -1.2566370614359172F, 0.0F);
        this.LEFT_WING_F = new ModelRenderer(this, 24, 16);
        this.LEFT_WING_F.setRotationPoint(-12.0F, 1.0F, 1.5F);
        this.LEFT_WING_F.addBox(-8.0F, 1.0F, 0.0F, 8, 12, 1, 0.0F);
        this.setRotateAngle(LEFT_WING_F, 0.0F, -1.7278759594743864F, 0.0F);
        this.RIGHT_WING_B.addChild(this.RIGHT_WING_F);
        this.EYE.addChild(this.LEAR);
        this.BODY.addChild(this.RIGHT_WING_B);
        this.EYE.addChild(this.REAR);
        this.BODY.addChild(this.LEFT_WING_B);
        this.LEFT_WING_B.addChild(this.LEFT_WING_F);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
        this.BODY.render(f5);
        this.EYE.render(f5);
        this.FEET.render(f5);
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
        if (((EntityFlyingEye)entityIn).getIsBatHanging())
        {
            this.EYE.rotateAngleX = headPitch * 0.017453292F;
            this.EYE.rotateAngleY = (float)Math.PI - netHeadYaw * 0.017453292F;
            this.EYE.rotateAngleZ = (float)Math.PI;
            this.EYE.setRotationPoint(0.0F, 4.0F, 0.0F);
            this.RIGHT_WING_B.setRotationPoint(-3.0F, 0.0F, 3.0F);
            this.LEFT_WING_B.setRotationPoint(3.0F, 0.0F, 3.0F);
            this.BODY.rotateAngleX = (float)Math.PI;
            this.RIGHT_WING_B.rotateAngleX = -0.15707964F;
            this.RIGHT_WING_B.rotateAngleY = -((float)Math.PI * 2F / 5F);
            this.RIGHT_WING_F.rotateAngleY = -1.7278761F;
            this.LEFT_WING_B.rotateAngleX = this.RIGHT_WING_B.rotateAngleX;
            this.LEFT_WING_B.rotateAngleY = -this.RIGHT_WING_B.rotateAngleY;
            this.LEFT_WING_F.rotateAngleY = -this.RIGHT_WING_F.rotateAngleY;
        }
        else
        {
            this.EYE.rotateAngleX = headPitch * 0.017453292F;
            this.EYE.rotateAngleY = netHeadYaw * 0.017453292F;
            this.EYE.rotateAngleZ = 0.0F;
            this.EYE.setRotationPoint(0.0F, 14.0F, 0.0F);
            this.RIGHT_WING_B.setRotationPoint(0.0F, 0.0F, 0.0F);
            this.LEFT_WING_B.setRotationPoint(0.0F, 0.0F, 0.0F);
            this.BODY.rotateAngleX = ((float)Math.PI / 4F) + MathHelper.cos(ageInTicks * 0.2F) * 0.15F;
            this.BODY.rotateAngleY = 0.0F;
            this.RIGHT_WING_B.rotateAngleY = MathHelper.cos(ageInTicks * 1.3F) * (float)Math.PI * 0.25F;
            this.LEFT_WING_B.rotateAngleY = -this.RIGHT_WING_B.rotateAngleY;
            this.RIGHT_WING_F.rotateAngleY = this.RIGHT_WING_B.rotateAngleY * 0.5F;
            this.LEFT_WING_F.rotateAngleY = -this.RIGHT_WING_B.rotateAngleY * 0.5F;
        }
    }
}
