package com.smellysox345.TheShatteredWorld.entity.render;

import com.smellysox345.TheShatteredWorld.entity.EntityNightShroom;
import com.smellysox345.TheShatteredWorld.entity.EntityShroomite;
import com.smellysox345.TheShatteredWorld.entity.model.ModelNightShroom;
import com.smellysox345.TheShatteredWorld.entity.model.ModelShroomite;
import com.smellysox345.TheShatteredWorld.util.Reference;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderNightShroom extends RenderLiving<EntityNightShroom>{

public static final ResourceLocation TEXTURES = new ResourceLocation(Reference.MOD_ID + ":textures/entity/nightshroom.png");
	
	
	public RenderNightShroom(RenderManager manager) {
		super(manager, new ModelNightShroom(), 0.5F);
		
	}
	
	protected void applyRotations(EntityNightShroom entityLiving, float p_77043_2_, float rotationYaw, float PartialTicks ) {
		
		super.applyRotations(entityLiving, p_77043_2_, rotationYaw, PartialTicks);
		
	}

	@Override
	protected ResourceLocation getEntityTexture(EntityNightShroom entity) {
		return TEXTURES;
	}
}
