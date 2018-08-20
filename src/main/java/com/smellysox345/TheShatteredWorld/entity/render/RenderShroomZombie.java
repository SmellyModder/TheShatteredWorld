package com.smellysox345.TheShatteredWorld.entity.render;

import com.smellysox345.TheShatteredWorld.entity.EntityShroomZombie;
import com.smellysox345.TheShatteredWorld.entity.model.ModelShroomZombie;
import com.smellysox345.TheShatteredWorld.util.Reference;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderShroomZombie extends RenderLiving<EntityShroomZombie>{

public static final ResourceLocation TEXTURES = new ResourceLocation(Reference.MODID + ":textures/entity/shroomzombie.png");
	
	
	public RenderShroomZombie(RenderManager manager) {
		super(manager, new ModelShroomZombie(), 0.5F);
		
	}
	
	protected void applyRotations(EntityShroomZombie entityLiving, float p_77043_2_, float rotationYaw, float PartialTicks ) {
		
		super.applyRotations(entityLiving, p_77043_2_, rotationYaw, PartialTicks);
		
	}

	@Override
	protected ResourceLocation getEntityTexture(EntityShroomZombie entity) {
		return TEXTURES;
	}
}
