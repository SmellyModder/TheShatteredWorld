package com.smellysox345.TheShatteredWorld.entity.render;

import com.smellysox345.TheShatteredWorld.entity.EntityArachnoShroom;
import com.smellysox345.TheShatteredWorld.entity.EntityArachnoShroomQueen;
import com.smellysox345.TheShatteredWorld.entity.model.ModelArachnoShroom;
import com.smellysox345.TheShatteredWorld.entity.model.ModelArachnoShroomQueen;
import com.smellysox345.TheShatteredWorld.util.Reference;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderArachnoShroomQueen extends RenderLiving<EntityArachnoShroomQueen>{

public static final ResourceLocation TEXTURES = new ResourceLocation(Reference.MOD_ID + ":textures/entity/arachnoshroomqueen.png");
	
	
	public RenderArachnoShroomQueen(RenderManager manager) {
		super(manager, new ModelArachnoShroomQueen(), 1.0F);
		
	}
	
	protected void applyRotations(EntityArachnoShroomQueen entityLiving, float p_77043_2_, float rotationYaw, float PartialTicks ) {
		
		super.applyRotations(entityLiving, p_77043_2_, rotationYaw, PartialTicks);
		
	}

	@Override
	protected ResourceLocation getEntityTexture(EntityArachnoShroomQueen entity) {
		return TEXTURES;
	}
}
