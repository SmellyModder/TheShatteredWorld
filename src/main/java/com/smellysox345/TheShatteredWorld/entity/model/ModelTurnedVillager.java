package com.smellysox345.TheShatteredWorld.entity.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import net.minecraft.client.renderer.GlStateManager;
import org.lwjgl.opengl.GL11;

/**
 * ModelVillager - Either Mojang or a mod author
 * Created using Tabula 7.0.0
 */
public class ModelTurnedVillager extends ModelBase {
    public ModelRenderer Skull;
    public ModelRenderer Arm_left;
    public ModelRenderer Arm_right;
    public ModelRenderer Leg_Right;
    public ModelRenderer Body_TopLayer;
    public ModelRenderer Leg_Left;
    public ModelRenderer Spike;
    public ModelRenderer Spike_1;
    public ModelRenderer Skull_Inner;
    public ModelRenderer Mouth_Right;
    public ModelRenderer Mouth_Right_1;
    public ModelRenderer Arm;
    public ModelRenderer Arm_1;
    public ModelRenderer Arm_2;
    public ModelRenderer Arm_3;
    public ModelRenderer Body_Inner;
    public ModelRenderer Spine;

    public ModelTurnedVillager() {
        this.textureWidth = 128;
        this.textureHeight = 128;
        this.Arm_right = new ModelRenderer(this, 44, 22);
        this.Arm_right.setRotationPoint(1.2F, 2.9F, -5.3F);
        this.Arm_right.addBox(4.0F, -2.0F, -2.0F, 4, 8, 4, 0.0F);
        this.setRotateAngle(Arm_right, -0.7499679795819634F, -0.9560913642424937F, -0.136659280431156F);
        this.Body_Inner = new ModelRenderer(this, 16, 20);
        this.Body_Inner.setRotationPoint(0.5F, 0.0F, 0.3F);
        this.Body_Inner.addBox(-4.0F, 0.0F, -3.0F, 7, 11, 5, 0.0F);
        this.Spine = new ModelRenderer(this, 0, 0);
        this.Spine.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Spine.addBox(0.0F, 0.0F, 0.0F, 1, 1, 1, 0.0F);
        this.Skull = new ModelRenderer(this, 0, 0);
        this.Skull.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Skull.addBox(-4.0F, -10.0F, -4.0F, 8, 10, 8, 0.0F);
        this.setRotateAngle(Skull, 0.31869712141416456F, 0.0F, 0.0F);
        this.Arm_1 = new ModelRenderer(this, 33, 8);
        this.Arm_1.setRotationPoint(0.1F, -0.1F, 5.5F);
        this.Arm_1.addBox(0.0F, 0.0F, 0.0F, 2, 2, 6, 0.0F);
        this.setRotateAngle(Arm_1, 0.0F, 0.6373942428283291F, 0.0F);
        this.Leg_Left = new ModelRenderer(this, 0, 22);
        this.Leg_Left.setRotationPoint(-2.0F, 12.0F, 0.0F);
        this.Leg_Left.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
        this.Spike = new ModelRenderer(this, 37, 0);
        this.Spike.setRotationPoint(1.0F, -5.2F, -5.7F);
        this.Spike.addBox(0.0F, 0.0F, 0.0F, 1, 1, 3, 0.0F);
        this.setRotateAngle(Spike, -0.562345084992573F, 0.0F, 0.0F);
        this.Skull_Inner = new ModelRenderer(this, 53, -1);
        this.Skull_Inner.setRotationPoint(-3.9F, -9.2F, -3.3F);
        this.Skull_Inner.addBox(0.0F, 0.0F, 0.0F, 7, 9, 7, 0.0F);
        this.Mouth_Right_1 = new ModelRenderer(this, 31, 52);
        this.Mouth_Right_1.setRotationPoint(-2.1F, -2.80F, -3.0F);
        this.Mouth_Right_1.addBox(0.0F, 0.0F, 0.0F, 4, 3, 1, 0.0F);
        this.setRotateAngle(Mouth_Right_1, 0.0F, 0.6981317007977318F, 0.0F);
        this.Mouth_Right = new ModelRenderer(this, 31, 52);
        this.Mouth_Right.setRotationPoint(2.1F, -2.80F, -7.5F);
        this.Mouth_Right.addBox(0.0F, 0.0F, 0.0F, 4, 3, 1, 0.0F);
        this.setRotateAngle(Mouth_Right, 0.0F, 0.6981317007977318F, -3.141592653589793F);
        this.Arm_3 = new ModelRenderer(this, 33, 8);
        this.Arm_3.setRotationPoint(0.1F, -0.1F, 4.8F);
        this.Arm_3.addBox(0.0F, 0.0F, 0.0F, 2, 2, 6, 0.0F);
        this.setRotateAngle(Arm_3, -0.045553093477052F, -0.5918411493512771F, 0.0F);
        this.Arm_left = new ModelRenderer(this, 44, 22);
        this.Arm_left.setRotationPoint(0.4F, 3.1F, -4.5F);
        this.Arm_left.addBox(-8.0F, -2.0F, -2.0F, 4, 8, 4, 0.0F);
        this.setRotateAngle(Arm_left, -0.8196066167365371F, 0.6373942428283291F, 0.0F);
        this.Body_TopLayer = new ModelRenderer(this, 0, 38);
        this.Body_TopLayer.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Body_TopLayer.addBox(-4.0F, 0.0F, -3.0F, 8, 18, 6, 0.5F);
        this.Leg_Right = new ModelRenderer(this, 0, 22);
        this.Leg_Right.mirror = true;
        this.Leg_Right.setRotationPoint(2.0F, 12.0F, 0.0F);
        this.Leg_Right.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
        this.Spike_1 = new ModelRenderer(this, 37, 0);
        this.Spike_1.setRotationPoint(-2.1F, -5.2F, -5.7F);
        this.Spike_1.addBox(0.0F, 0.0F, 0.0F, 1, 1, 3, 0.0F);
        this.setRotateAngle(Spike_1, -0.562345084992573F, 0.0F, 0.0F);
        this.Arm_2 = new ModelRenderer(this, 33, 8);
        this.Arm_2.setRotationPoint(5.1F, 5.9F, 0.5F);
        this.Arm_2.addBox(0.0F, 0.0F, 0.0F, 2, 2, 6, 0.0F);
        this.setRotateAngle(Arm_2, -1.6390387005478748F, 0.0F, 0.0F);
        this.Arm = new ModelRenderer(this, 33, 8);
        this.Arm.setRotationPoint(-6.6F, 5.9F, 0.5F);
        this.Arm.addBox(0.0F, 0.0F, 0.0F, 2, 2, 6, 0.0F);
        this.setRotateAngle(Arm, -1.6390387005478748F, 0.0F, 0.0F);
        this.Body_TopLayer.addChild(this.Body_Inner);
        this.Body_Inner.addChild(this.Spine);
        this.Arm.addChild(this.Arm_1);
        this.Skull.addChild(this.Spike);
        this.Skull.addChild(this.Skull_Inner);
        this.Skull.addChild(this.Mouth_Right_1);
        this.Skull.addChild(this.Mouth_Right);
        this.Arm_2.addChild(this.Arm_3);
        this.Skull.addChild(this.Spike_1);
        this.Arm_right.addChild(this.Arm_2);
        this.Arm_left.addChild(this.Arm);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
        this.Arm_right.render(f5);
        this.Skull.render(f5);
        this.Leg_Left.render(f5);
        this.Arm_left.render(f5);
        this.Body_TopLayer.render(f5);
        this.Leg_Right.render(f5);
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
        this.Skull.rotateAngleY = netHeadYaw * 0.017453292F;
        this.Skull.rotateAngleX = headPitch * 0.017453292F;
        this.Leg_Left.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.2F * limbSwingAmount;
        this.Leg_Right.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.2F * limbSwingAmount;
        
        this.Arm_left.rotateAngleX = -0.8196066167365371F;
        this.Arm_left.rotateAngleX += MathHelper.sin(ageInTicks * 0.09F) * 0.05F + 0.05F;
        this.Arm_left.rotateAngleZ = MathHelper.sin(limbSwing * 0.2662F) * 0.2F * limbSwingAmount;
        
        this.Arm_right.rotateAngleX = -0.7499679795819634F;
        this.Arm_right.rotateAngleX += MathHelper.sin(ageInTicks * 0.09F) * 0.05F + 0.05F;
        this.Arm_right.rotateAngleZ = MathHelper.sin(limbSwing * 0.2662F) * 0.2F * limbSwingAmount;
        
        this.Mouth_Right.rotateAngleY = 0.6981317007977318F; 
        this.Mouth_Right.rotateAngleZ = 3.141592653589793F;
        this.Mouth_Right.rotateAngleY += MathHelper.sin(ageInTicks * 0.09F) * 0.05F + 0.05F;
        this.Mouth_Right.rotateAngleZ = MathHelper.sin(limbSwing * 0.2662F) * 0.2F * limbSwingAmount;
        
        this.Mouth_Right_1.rotateAngleY = 0.6981317007977318F;
        this.Mouth_Right_1.rotateAngleZ = -3.141592653589793F;
        this.Mouth_Right_1.rotateAngleY += MathHelper.sin(ageInTicks * 0.09F) * 0.05F + 0.05F;
        this.Mouth_Right_1.rotateAngleY = MathHelper.sin(limbSwing * 0.2662F) * 0.2F * limbSwingAmount;
    }
}
