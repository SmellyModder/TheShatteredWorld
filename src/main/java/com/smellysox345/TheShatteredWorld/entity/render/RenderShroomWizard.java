package com.smellysox345.TheShatteredWorld.entity.render;

import com.smellysox345.TheShatteredWorld.entity.EntityShroomSkeleton;
import com.smellysox345.TheShatteredWorld.entity.NPCShroomWizard;
import com.smellysox345.TheShatteredWorld.entity.model.ModelShroomSkeleton;
import com.smellysox345.TheShatteredWorld.entity.model.ModelShroomWizard;
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
public class RenderShroomWizard extends RenderLiving<NPCShroomWizard>{
	
public static final ResourceLocation TEXTURES = new ResourceLocation(Reference.MOD_ID + ":textures/entity/shroom_wizard.png");
	
	
	public RenderShroomWizard(RenderManager manager) {
		super(manager, new ModelShroomWizard(), 0.5F);
	}
	
	protected void applyRotations(NPCShroomWizard entityLiving, float p_77043_2_, float rotationYaw, float PartialTicks ) {
		
		super.applyRotations(entityLiving, p_77043_2_, rotationYaw, PartialTicks);
		
	}

	@Override
	protected ResourceLocation getEntityTexture(NPCShroomWizard entity) {
		return TEXTURES;
	}
	
}
