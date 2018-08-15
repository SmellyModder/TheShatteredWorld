package com.smellysox345.TheShatteredWorld.items.tools;

import com.smellysox345.TheShatteredWorld.Main;
import com.smellysox345.TheShatteredWorld.init.ModItems;
import com.smellysox345.TheShatteredWorld.util.interfaces.IHasModel;

import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.Item.ToolMaterial;

public class ToolPickaxe extends ItemPickaxe implements IHasModel{

	public ToolPickaxe(String name, ToolMaterial material) 
	{ 
		super(material);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(Main.shatteredworldtools);
		ModItems.ITEMS.add(this);
	}
	
	@Override
	public void registerModels() {
		
		Main.proxy.registerItemRenderer(this, 0, "inventory");
	}

	
}
