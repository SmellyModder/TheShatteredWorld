package com.smellysox345.TheShatteredWorld.blocks;

import java.util.Random;

import com.smellysox345.TheShatteredWorld.Main;
import com.smellysox345.TheShatteredWorld.init.ModBlocks;
import com.smellysox345.TheShatteredWorld.init.ModItems;
import com.smellysox345.TheShatteredWorld.util.interfaces.IHasModel;

import net.minecraft.block.BlockFalling;
import net.minecraft.block.BlockSand;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;

public class RefractedSandBlock extends BlockFalling implements IHasModel{


	public RefractedSandBlock(String name, Material material) {
		super(material);
		setUnlocalizedName(name);
		setRegistryName(name);
		setSoundType(SoundType.SAND);
		setHardness(0.7F);
		setResistance(0.9F);
		setHarvestLevel("spade", 1);
		setLightLevel(0.0F);
		setLightOpacity(0);
		setCreativeTab(Main.refractedblocks);
		
		
		ModBlocks.BLOCKS.add(this);
		ModItems.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
	}
	
	@Override
	public void registerModels() {
		Main.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
	}
	
	public int	qauntityDropped(Random rand) {
		return 1;
}
	
}
