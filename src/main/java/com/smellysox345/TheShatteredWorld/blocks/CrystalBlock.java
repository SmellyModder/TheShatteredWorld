package com.smellysox345.TheShatteredWorld.blocks;

import java.util.Random;

import com.smellysox345.TheShatteredWorld.init.ModItems;
import com.smellysox345.TheShatteredWorld.items.ItemBase;

import net.minecraft.block.Block;
import net.minecraft.block.BlockFire;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class CrystalBlock extends BlockBase {

	public CrystalBlock(String name, Material material) {
		super(name, material);
		setSoundType(SoundType.GLASS);
		setHardness(3.0F);
		setResistance(2.0F);
		setHarvestLevel("pickaxe", 2);
		setLightLevel(1.0F);
		this.slipperiness = 0.90F;
		setLightOpacity(1);
		
	}
	
	@Override
	public int quantityDropped(Random par1Random) {
		return 6;
	}
	
	@Override
	public Item getItemDropped(IBlockState state, Random par2Random, int par3) {
		return new ItemStack(ModItems.CRYSTAL).getItem();
	}
}