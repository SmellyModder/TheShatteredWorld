package com.smellysox345.TheShatteredWorld.items;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemGlinting extends ItemBase{

	public ItemGlinting(String name) {
		super(name);
		}
	
	@Override
	public int getItemEnchantability() {
		return 0;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public boolean hasEffect(ItemStack par1ItemStack) {
		return true;
	}
	
	}

