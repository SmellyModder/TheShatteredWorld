package com.smellysox345.TheShatteredWorld.blocks.plants;

import com.smellysox345.TheShatteredWorld.Main;
import com.smellysox345.TheShatteredWorld.init.ModBlocks;
import com.smellysox345.TheShatteredWorld.init.ModItems;
import com.smellysox345.TheShatteredWorld.util.interfaces.IHasModel;

import net.minecraft.block.BlockLog;
import net.minecraft.block.BlockRotatedPillar;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import scala.util.Random;

public class EyeTreeLog extends BlockRotatedPillar implements IHasModel {
	
	
    public EyeTreeLog(String name, Material materialIn) {
        super(materialIn);
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(Main.refractedblocks);
        setLightLevel(0.9F);
        setHarvestLevel("axe", 2);
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
