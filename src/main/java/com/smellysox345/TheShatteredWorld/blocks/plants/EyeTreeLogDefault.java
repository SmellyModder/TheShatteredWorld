package com.smellysox345.TheShatteredWorld.blocks.plants;

import com.smellysox345.TheShatteredWorld.Main;
import com.smellysox345.TheShatteredWorld.init.ModBlocks;
import com.smellysox345.TheShatteredWorld.init.ModItems;
import com.smellysox345.TheShatteredWorld.util.interfaces.IHasModel;

import net.minecraft.block.BlockRotatedPillar;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.EnumFacing;

	public class EyeTreeLogDefault extends BlockRotatedPillar implements IHasModel {
		
		
	    public EyeTreeLogDefault(String name, Material materialIn) {
	        super(materialIn);
	        setUnlocalizedName(name);
	        setRegistryName(name);
	        setCreativeTab(Main.refractedblocks);
	        setHarvestLevel("axe", 1);
	        setHardness(2.0F);
	        ModBlocks.BLOCKS.add(this);
	        ModItems.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
	        this.setDefaultState(this.getDefaultState().withProperty(AXIS, EnumFacing.Axis.Y));
	    }

	    @Override
	    public void registerModels() {
	        Main.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
	    }
}
