package com.smellysox345.TheShatteredWorld.potion;

import com.smellysox345.TheShatteredWorld.util.Reference;

import net.minecraft.client.Minecraft;
import net.minecraft.potion.Potion;
import net.minecraft.util.ResourceLocation;


public class Deformation extends Potion{
	
	public Deformation() {
		super(true, 14155775);
		setPotionName("effect.deformation");
		setIconIndex(0, 0);
		setRegistryName(new ResourceLocation(Reference.MODID + ":" + "deformation"));
		
	}
	
	@Override
	public boolean hasStatusIcon() {
		Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation(Reference.MODID, "textures/gui/container/potion_effect.png"));
		return true;
	} 

}
