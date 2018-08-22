package com.smellysox345.TheShatteredWorld.entity.render;

import com.smellysox345.TheShatteredWorld.entity.EntityArachnoShroom;
import com.smellysox345.TheShatteredWorld.entity.EntityNagrot;
import com.smellysox345.TheShatteredWorld.entity.model.ModelArachnoShroom;
import com.smellysox345.TheShatteredWorld.entity.model.ModelNagrot;
import com.smellysox345.TheShatteredWorld.util.Reference;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderNagrot extends RenderLiving<EntityNagrot>{

public static final ResourceLocation TEXTURES = new ResourceLocation(Reference.MODID + ":textures/entity/nagrot.png");
	
	
	public RenderNagrot(RenderManager manager) {
		super(manager, new ModelNagrot(), 2.5F);
		
	}
	
	protected void applyRotations(EntityNagrot entityLiving, float p_77043_2_, float rotationYaw, float PartialTicks ) {
		
		super.applyRotations(entityLiving, p_77043_2_, rotationYaw, PartialTicks);
		
	}

	@Override
	protected ResourceLocation getEntityTexture(EntityNagrot entity) {
		return TEXTURES;
	}
}