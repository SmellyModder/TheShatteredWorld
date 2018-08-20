package com.smellysox345.TheShatteredWorld.entity.render;

import com.smellysox345.TheShatteredWorld.entity.EntitySlimeWolfBaby;
import com.smellysox345.TheShatteredWorld.entity.model.ModelSlimeWolfBaby;
import com.smellysox345.TheShatteredWorld.util.Reference;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderSlimeWolfBaby extends RenderLiving<EntitySlimeWolfBaby>{
	
public static final ResourceLocation TEXTURES = new ResourceLocation(Reference.MODID + ":textures/entity/slimewolfbaby.png");
	
	
	public RenderSlimeWolfBaby(RenderManager manager) {
		super(manager, new ModelSlimeWolfBaby(), 0.5F);
		
	}
	
	


	protected void applyRotations(EntitySlimeWolfBaby entityLiving, float p_77043_2_, float rotationYaw, float PartialTicks ) {
		
		super.applyRotations(entityLiving, p_77043_2_, rotationYaw, PartialTicks);
		
	}

	@Override
	protected ResourceLocation getEntityTexture(EntitySlimeWolfBaby entity) {
		return TEXTURES;
	}
	

}
