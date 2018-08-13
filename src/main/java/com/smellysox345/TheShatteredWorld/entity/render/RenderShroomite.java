package com.smellysox345.TheShatteredWorld.entity.render;

import com.smellysox345.TheShatteredWorld.entity.EntityShroomZombie;
import com.smellysox345.TheShatteredWorld.entity.EntityShroomite;
import com.smellysox345.TheShatteredWorld.entity.model.ModelShroomZombie;
import com.smellysox345.TheShatteredWorld.entity.model.ModelShroomite;
import com.smellysox345.TheShatteredWorld.util.Reference;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderShroomite extends RenderLiving<EntityShroomite>{

public static final ResourceLocation TEXTURES = new ResourceLocation(Reference.MOD_ID + ":textures/entity/shroomite.png");
	
	
	public RenderShroomite(RenderManager manager) {
		super(manager, new ModelShroomite(), 0.5F);
		
	}
	
	protected void applyRotations(EntityShroomite entityLiving, float p_77043_2_, float rotationYaw, float PartialTicks ) {
		
		super.applyRotations(entityLiving, p_77043_2_, rotationYaw, PartialTicks);
		
	}

	@Override
	protected ResourceLocation getEntityTexture(EntityShroomite entity) {
		return TEXTURES;
	}
}