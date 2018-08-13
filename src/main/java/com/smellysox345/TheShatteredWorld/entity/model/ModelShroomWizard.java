package com.smellysox345.TheShatteredWorld.entity.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

/**
 * ModelVillager - Either Mojang or a mod author
 * Created using Tabula 7.0.0
 */
public class ModelShroomWizard extends ModelBase {
    public ModelRenderer HEAD;
    public ModelRenderer RA;
    public ModelRenderer LA;
    public ModelRenderer MA;
    public ModelRenderer LL;
    public ModelRenderer BODY;
    public ModelRenderer CLOAK;
    public ModelRenderer RL;
    public ModelRenderer NOSE;
    public ModelRenderer BEARD;
    public ModelRenderer HAT_BOTTOM;
    public ModelRenderer HAT_TOP;
    public ModelRenderer STAFF;
    public ModelRenderer SBOTTOM;
    public ModelRenderer STOP;

    public ModelShroomWizard() {
        this.textureWidth = 128;
        this.textureHeight = 64;
        this.RA = new ModelRenderer(this, 44, 22);
        this.RA.setRotationPoint(0.0F, 3.0F, -1.0F);
        this.RA.addBox(-8.0F, -2.0F, -2.0F, 4, 8, 4, 0.0F);
        this.setRotateAngle(RA, -0.7499679795819634F, 0.0F, 0.0F);
        this.NOSE = new ModelRenderer(this, 24, 0);
        this.NOSE.setRotationPoint(0.0F, -2.0F, 0.0F);
        this.NOSE.addBox(-1.0F, -1.0F, -6.0F, 2, 3, 2, 0.0F);
        this.HAT_BOTTOM = new ModelRenderer(this, 50, 0);
        this.HAT_BOTTOM.setRotationPoint(-6.1F, -12.4F, -6.8F);
        this.HAT_BOTTOM.addBox(0.0F, 0.0F, 0.0F, 12, 5, 14, 0.0F);
        this.STOP = new ModelRenderer(this, 45, 0);
        this.STOP.setRotationPoint(-1.0F, -1.0F, -6.0F);
        this.STOP.addBox(0.0F, 0.0F, 0.0F, 4, 4, 4, 0.0F);
        this.STAFF = new ModelRenderer(this, 80, 38);
        this.STAFF.setRotationPoint(5.3F, 10.3F, -4.2F);
        this.STAFF.addBox(0.0F, 0.0F, 0.0F, 2, 2, 24, 0.0F);
        this.CLOAK = new ModelRenderer(this, 0, 38);
        this.CLOAK.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.CLOAK.addBox(-4.0F, 0.0F, -3.0F, 8, 20, 6, 0.5F);
        this.HAT_TOP = new ModelRenderer(this, 40, 46);
        this.HAT_TOP.setRotationPoint(-4.5F, -16.6F, -5.3F);
        this.HAT_TOP.addBox(0.0F, 0.0F, 0.0F, 9, 8, 10, 0.0F);
        this.BEARD = new ModelRenderer(this, 90, 20);
        this.BEARD.setRotationPoint(-4.6F, -7.5F, -4.5F);
        this.BEARD.addBox(0.0F, 0.0F, 0.0F, 9, 8, 9, 0.0F);
        this.BODY = new ModelRenderer(this, 16, 20);
        this.BODY.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.BODY.addBox(-4.0F, 0.0F, -3.0F, 8, 12, 6, 0.0F);
        this.LA = new ModelRenderer(this, 65, 25);
        this.LA.setRotationPoint(0.0F, 3.0F, -1.0F);
        this.LA.addBox(4.0F, -2.0F, -2.0F, 4, 15, 4, 0.0F);
        this.setRotateAngle(LA, -1.567305668290908F, 0.25254914276357954F, 0.0F);
        this.LL = new ModelRenderer(this, 0, 22);
        this.LL.mirror = true;
        this.LL.setRotationPoint(2.0F, 12.0F, 0.0F);
        this.LL.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
        this.RL = new ModelRenderer(this, 0, 22);
        this.RL.setRotationPoint(-2.0F, 12.0F, 0.0F);
        this.RL.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
        this.MA = new ModelRenderer(this, 40, 38);
        this.MA.setRotationPoint(0.0F, 3.0F, -1.0F);
        this.MA.addBox(-4.0F, 2.0F, -2.0F, 8, 4, 4, 0.0F);
        this.setRotateAngle(MA, -0.7499679795819634F, 0.0F, 0.0F);
        this.SBOTTOM = new ModelRenderer(this, 45, 0);
        this.SBOTTOM.setRotationPoint(-2.0F, -2.1F, -2.3F);
        this.SBOTTOM.addBox(0.0F, 0.0F, 0.0F, 6, 6, 3, 0.0F);
        this.HEAD = new ModelRenderer(this, 0, 0);
        this.HEAD.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.HEAD.addBox(-4.0F, -10.0F, -4.0F, 8, 10, 8, 0.0F);
        this.setRotateAngle(HEAD, 0.17453292519943295F, 0.0F, 0.0F);
        this.HEAD.addChild(this.NOSE);
        this.HEAD.addChild(this.HAT_BOTTOM);
        this.STAFF.addChild(this.STOP);
        this.LA.addChild(this.STAFF);
        this.HEAD.addChild(this.HAT_TOP);
        this.HEAD.addChild(this.BEARD);
        this.STAFF.addChild(this.SBOTTOM);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
        this.RA.render(f5);
        this.CLOAK.render(f5);
        this.BODY.render(f5);
        this.LA.render(f5);
        this.LL.render(f5);
        this.RL.render(f5);
        this.MA.render(f5);
        this.HEAD.render(f5);
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
        this.HEAD.rotateAngleX = 0.17453292519943295F;
        this.HEAD.rotateAngleX += MathHelper.sin(ageInTicks * 0.07F) * 0.05F + 0.05F;
        
        this.RL.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount * 0.5F;
        this.LL.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount * 0.5F;
        this.RL.rotateAngleY = 0.0F;
        this.LL.rotateAngleY = 0.0F;
        
        this.LA.rotateAngleX = -1.567305668290908F;
        this.LA.rotateAngleX += MathHelper.sin(ageInTicks * 0.09F) * 0.05F + 0.05F;
        this.LA.rotateAngleZ = MathHelper.sin(limbSwing * 0.2662F) * 0.2F * limbSwingAmount;
    }
}
