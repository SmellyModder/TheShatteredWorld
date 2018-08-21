package com.smellysox345.TheShatteredWorld.items.magic;

import com.smellysox345.TheShatteredWorld.Main;
import com.smellysox345.TheShatteredWorld.items.ItemBase;

public class ItemLanternOfLight extends ItemBase{

	public ItemLanternOfLight(String name) {
		super(name);
		this.maxStackSize = 1;
		this.setNoRepair();
		this.isEnchantable(null);
		this.setCreativeTab(Main.shatteredworldtools);
	}

}
