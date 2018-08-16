package com.smellysox345.TheShatteredWorld.entity.render;

import com.smellysox345.TheShatteredWorld.entity.EntityFlyingEye;
import com.smellysox345.TheShatteredWorld.entity.EntityShroomite;
import com.smellysox345.TheShatteredWorld.entity.model.ModelFlyingEye;
import com.smellysox345.TheShatteredWorld.entity.model.ModelShroomite;
import com.smellysox345.TheShatteredWorld.util.Reference;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.passive.EntityRabbit;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderFlyingEye extends RenderLiving<EntityFlyingEye>{

	public static final ResourceLocation TEXTURES = new ResourceLocation(Reference.MOD_ID + ":textures/entity/flying_eye.png");
	public static final ResourceLocation TEXTURES_G = new ResourceLocation(Reference.MOD_ID + ":textures/entity/flying_eye_g.png");
	public static final ResourceLocation TEXTURES_B = new ResourceLocation(Reference.MOD_ID + ":textures/entity/flying_eye_b.png");
	public static final ResourceLocation TEXTURES_P = new ResourceLocation(Reference.MOD_ID + ":textures/entity/flying_eye_p.png");
	
	public RenderFlyingEye(RenderManager manager) {
		super(manager, new ModelFlyingEye(), 0.3F);
		
	}
	
	protected void applyRotations(EntityFlyingEye entityLiving, float p_77043_2_, float rotationYaw, float PartialTicks ) {
		
		super.applyRotations(entityLiving, p_77043_2_, rotationYaw, PartialTicks);
		
	}

	protected ResourceLocation getEntityTexture(EntityFlyingEye entity)
    {
        String s = TextFormatting.getTextWithoutFormattingCodes(entity.getName());

        if (s != null && "Toast".equals(s))
        {
            return TEXTURES;
        }
        else
        {
            switch (entity.getEyeType())
            {
                case 0:
                default:
                    return TEXTURES;
                case 1:
                    return TEXTURES_G;
                case 2:
                    return TEXTURES_B;
                case 3:
                    return TEXTURES_P;
                case 4:
                    return TEXTURES;
                case 5:
                    return TEXTURES_G;
            }
        }
    }
}