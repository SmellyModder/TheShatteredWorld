package com.smellysox345.TheShatteredWorld.entity.render;

import com.smellysox345.TheShatteredWorld.entity.EntityShroomSkeleton;
import com.smellysox345.TheShatteredWorld.entity.model.ModelShroomSkeleton;
import com.smellysox345.TheShatteredWorld.util.Reference;

import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.layers.LayerBipedArmor;
import net.minecraft.client.renderer.entity.layers.LayerHeldItem;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderShroomSkeleton extends RenderLiving<EntityShroomSkeleton>{
	
public static final ResourceLocation TEXTURES = new ResourceLocation(Reference.MODID + ":textures/entity/shroomskeleton.png");
	
	
	public RenderShroomSkeleton(RenderManager manager) {
		super(manager, new ModelShroomSkeleton(), 0.5F);
		 this.addLayer(new LayerHeldItem(this));
		 this.addLayer(new LayerBipedArmor(this));
	}
	
	protected void applyRotations(EntityShroomSkeleton entityLiving, float p_77043_2_, float rotationYaw, float PartialTicks ) {
		
		super.applyRotations(entityLiving, p_77043_2_, rotationYaw, PartialTicks);
		
	}
	
	public void transformHeldFull3DItemLayer()
    {
        GlStateManager.translate(0.09375F, 0.1875F, 0.0F);
    }

	@Override
	protected ResourceLocation getEntityTexture(EntityShroomSkeleton entity) {
		return TEXTURES;
	}
	
}
