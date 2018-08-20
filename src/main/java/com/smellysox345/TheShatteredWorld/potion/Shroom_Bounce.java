package com.smellysox345.TheShatteredWorld.potion;

import com.smellysox345.TheShatteredWorld.util.Reference;

import net.minecraft.client.Minecraft;
import net.minecraft.potion.Potion;
import net.minecraft.util.ResourceLocation;

public class Shroom_Bounce extends Potion{
	
	public Shroom_Bounce() {
		super(true, 3801212);
		setPotionName("effect.deformation");
		setIconIndex(1, 0);
		setRegistryName(new ResourceLocation(Reference.MODID + ":" + "shroom_bounce"));
		
	}
	
	@Override
	public boolean hasStatusIcon() {
		Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation(Reference.MODID, "textures/gui/container/potion_effect.png"));
		return true;
	} 

}
