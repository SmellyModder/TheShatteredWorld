package com.smellysox345.TheShatteredWorld.entity.render;

import com.smellysox345.TheShatteredWorld.entity.EntitySlimeWolf;
import com.smellysox345.TheShatteredWorld.entity.model.ModelSlimeWolf;
import com.smellysox345.TheShatteredWorld.util.Reference;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.layers.LayerWolfCollar;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;

@SideOnly(Side.CLIENT)
public class RenderSlimeWolf extends RenderLiving<EntitySlimeWolf>{

	public static final ResourceLocation TEXTURES = new ResourceLocation(Reference.MOD_ID + ":textures/entity/slimewolf.png");
	
	
	public RenderSlimeWolf(RenderManager manager) {
		super(manager, new ModelSlimeWolf(), 0.5F);
	}
	
	protected void applyRotations(EntitySlimeWolf entityLiving, float p_77043_2_, float rotationYaw, float PartialTicks ) {
		
		super.applyRotations(entityLiving, p_77043_2_, rotationYaw, PartialTicks);
		
	}

	@Override
	protected ResourceLocation getEntityTexture(EntitySlimeWolf entity) {
		// TODO Auto-generated method stub
		return TEXTURES;
	}
	
}
