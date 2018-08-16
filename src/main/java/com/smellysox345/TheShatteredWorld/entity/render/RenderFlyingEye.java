package com.smellysox345.TheShatteredWorld.entity.render;

import com.smellysox345.TheShatteredWorld.entity.EntityFlyingEye;
import com.smellysox345.TheShatteredWorld.entity.EntityShroomite;
import com.smellysox345.TheShatteredWorld.entity.model.ModelFlyingEye;
import com.smellysox345.TheShatteredWorld.entity.model.ModelShroomite;
import com.smellysox345.TheShatteredWorld.util.Reference;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.passive.EntityParrot;
import net.minecraft.entity.passive.EntityRabbit;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderFlyingEye extends RenderLiving<EntityFlyingEye>{

	public static final ResourceLocation[] TEXTURES = new ResourceLocation[] {new ResourceLocation(Reference.MOD_ID + ":textures/entity/flying_eye_b.png"), new ResourceLocation(Reference.MOD_ID + ":textures/entity/flying_eye.png"), new ResourceLocation(Reference.MOD_ID + ":textures/entity/flying_eye_p.png"), new ResourceLocation(Reference.MOD_ID + ":textures/entity/flying_eye_g.png"), new ResourceLocation(Reference.MOD_ID + ":textures/entity/flying_eye_y.png")};
	
	public RenderFlyingEye(RenderManager manager) {
		super(manager, new ModelFlyingEye(), 0.3F);
		
	}
	
	protected void applyRotations(EntityFlyingEye entityLiving, float p_77043_2_, float rotationYaw, float PartialTicks ) {
		
		super.applyRotations(entityLiving, p_77043_2_, rotationYaw, PartialTicks);
		
	}

	@Override
	protected ResourceLocation getEntityTexture(EntityFlyingEye entity)
    {
        return TEXTURES[entity.getVariant()];
    }
}