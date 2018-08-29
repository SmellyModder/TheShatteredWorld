package com.smellysox345.TheShatteredWorld.blocks.plants.flowers;

import java.util.Collection;

import javax.annotation.Nullable;

import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;
import com.smellysox345.TheShatteredWorld.Main;
import com.smellysox345.TheShatteredWorld.init.ModBlocks;
import com.smellysox345.TheShatteredWorld.init.ModItems;
import com.smellysox345.TheShatteredWorld.util.interfaces.IHasModel;

import net.minecraft.block.Block;
import net.minecraft.block.BlockBush;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

public class SWFlowers extends BlockBush implements IHasModel{

	public SWFlowers(String name, Material material) {
        super(material);
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(Main.shatteredworldplants);
		
        ModBlocks.BLOCKS.add(this);
        ModItems.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
    }
	
	public Block.EnumOffsetType getOffsetType()
	{
	        return Block.EnumOffsetType.XZ;
	}

    @Override
    public void registerModels() {
        Main.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
    }
}