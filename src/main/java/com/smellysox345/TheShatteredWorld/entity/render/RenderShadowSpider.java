package com.smellysox345.TheShatteredWorld.entity.render;

import com.smellysox345.TheShatteredWorld.entity.EntityShadowSpider;
import com.smellysox345.TheShatteredWorld.entity.model.ModelShadowSpider;
import com.smellysox345.TheShatteredWorld.util.Reference;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderShadowSpider extends RenderLiving<EntityShadowSpider>{

public static final ResourceLocation TEXTURES = new ResourceLocation(Reference.MODID + ":textures/entity/shadowspider.png");
	
	
	public RenderShadowSpider(RenderManager manager) {
		super(manager, new ModelShadowSpider(), 1.0F);
		
	}
	
	protected void applyRotations(EntityShadowSpider entityLiving, float p_77043_2_, float rotationYaw, float PartialTicks ) {
		
		super.applyRotations(entityLiving, p_77043_2_, rotationYaw, PartialTicks);
		
	}

	@Override
	protected ResourceLocation getEntityTexture(EntityShadowSpider entity) {
		return TEXTURES;
	}
}
