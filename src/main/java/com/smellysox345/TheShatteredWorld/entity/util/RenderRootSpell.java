package com.smellysox345.TheShatteredWorld.entity.util;

import com.smellysox345.TheShatteredWorld.entity.EntityArachnoShroom;
import com.smellysox345.TheShatteredWorld.entity.model.ModelArachnoShroom;
import com.smellysox345.TheShatteredWorld.entity.util.model.ModelRootSpell;
import com.smellysox345.TheShatteredWorld.util.Reference;

import net.minecraft.client.model.ModelEvokerFangs;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.projectile.EntityEvokerFangs;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderRootSpell extends Render<EntityRootSpell>{

public static final ResourceLocation TEXTURES = new ResourceLocation(Reference.MODID + ":textures/entity/root_spell.png");
private final ModelRootSpell model = new ModelRootSpell();
	
	public RenderRootSpell(RenderManager manager) {
		super(manager);
	}
	
	public void doRender(EntityRootSpell entity, double x, double y, double z, float entityYaw, float partialTicks)
    {
        float f = entity.getAnimationProgress(partialTicks);

        if (f != 0.0F)
        {
            float f1 = 2.0F;

            if (f > 0.9F)
            {
                f1 = (float)((double)f1 * ((1.0D - (double)f) / 0.10000000149011612D));
            }

            GlStateManager.pushMatrix();
            GlStateManager.disableCull();
            GlStateManager.enableAlpha();
            this.bindEntityTexture(entity);
            GlStateManager.translate((float)x, (float)y, (float)z);
            GlStateManager.rotate(90.0F - entity.rotationYaw, 0.0F, 1.0F, 0.0F);
            GlStateManager.scale(-f1, -f1, f1);
            float f2 = 0.03125F;
            GlStateManager.translate(0.0F, -0.626F, 0.0F);
            this.model.render(entity, f, 0.0F, 0.0F, entity.rotationYaw, entity.rotationPitch, 0.03125F);
            GlStateManager.popMatrix();
            GlStateManager.enableCull();
            super.doRender(entity, x, y, z, entityYaw, partialTicks);
        }
    }

	@Override
	protected ResourceLocation getEntityTexture(EntityRootSpell entity) {
		return TEXTURES;
	}
}
