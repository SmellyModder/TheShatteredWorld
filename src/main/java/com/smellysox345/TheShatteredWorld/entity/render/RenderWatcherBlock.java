package com.smellysox345.TheShatteredWorld.entity.render;

import com.smellysox345.TheShatteredWorld.entity.EntityWatcherBlock;
import com.smellysox345.TheShatteredWorld.entity.model.ModelWatcher;
import com.smellysox345.TheShatteredWorld.util.Reference;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderWatcherBlock extends RenderLiving<EntityWatcherBlock>{

public static final ResourceLocation TEXTURES = new ResourceLocation(Reference.MODID + ":textures/entity/watcher_creature_block.png");
	
	
	public RenderWatcherBlock(RenderManager manager) {
		super(manager, new ModelWatcher(), 0.6F);
	}
	
	protected void applyRotations(EntityWatcherBlock entityLiving, float p_77043_2_, float rotationYaw, float PartialTicks ) {
		
		super.applyRotations(entityLiving, p_77043_2_, rotationYaw, PartialTicks);
		
	}

	@Override
	protected ResourceLocation getEntityTexture(EntityWatcherBlock entity) {
		return TEXTURES;
	}
}
