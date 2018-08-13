package com.smellysox345.TheShatteredWorld.entity.render;

import com.smellysox345.TheShatteredWorld.entity.EntityShroomCreeper;
import com.smellysox345.TheShatteredWorld.entity.EntityShroomite;
import com.smellysox345.TheShatteredWorld.entity.model.ModelShroomCreeper;
import com.smellysox345.TheShatteredWorld.entity.model.ModelShroomite;
import com.smellysox345.TheShatteredWorld.util.Reference;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.layers.LayerCreeperCharge;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderShroomCreeper extends RenderLiving<EntityShroomCreeper>{

public static final ResourceLocation TEXTURES = new ResourceLocation(Reference.MOD_ID + ":textures/entity/shroomcreeper.png");
	
	
	public RenderShroomCreeper(RenderManager manager) {
		super(manager, new ModelShroomCreeper(), 0.5F);
	}
	
	protected void preRenderCallback(EntityShroomCreeper entitylivingbaseIn, float partialTickTime)
    {
        float f = entitylivingbaseIn.getCreeperFlashIntensity(partialTickTime);
        float f1 = 1.0F + MathHelper.sin(f * 100.0F) * f * 0.01F;
        f = MathHelper.clamp(f, 0.0F, 1.0F);
        f = f * f;
        f = f * f;
        float f2 = (1.0F + f * 0.4F) * f1;
        float f3 = (1.0F + f * 0.1F) / f1;
        GlStateManager.scale(f2, f3, f2);
    }
	
	protected void applyRotations(EntityShroomCreeper entityLiving, float p_77043_2_, float rotationYaw, float PartialTicks ) {
		
		super.applyRotations(entityLiving, p_77043_2_, rotationYaw, PartialTicks);
		
	}

	@Override
	protected ResourceLocation getEntityTexture(EntityShroomCreeper entity) {
		return TEXTURES;
	}

}
