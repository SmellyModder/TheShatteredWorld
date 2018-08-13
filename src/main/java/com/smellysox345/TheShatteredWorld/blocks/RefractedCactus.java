package com.smellysox345.TheShatteredWorld.blocks;

import com.smellysox345.TheShatteredWorld.Main;
import com.smellysox345.TheShatteredWorld.init.ModBlocks;
import com.smellysox345.TheShatteredWorld.util.InterFaces.IHasModel;

import net.minecraft.block.Block;
import net.minecraft.block.BlockCactus;
import net.minecraft.block.BlockDoublePlant.EnumPlantType;
import net.minecraft.block.BlockReed;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.MobEffects;
import net.minecraft.item.Item;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.IPlantable;

public class RefractedCactus extends BlockBase implements IHasModel
{
	public static final AxisAlignedBB REFRACTED_CACTUS_AABB = new AxisAlignedBB(0.1875D, 0, 0.1875D, 0.9125D, 0.925D, 0.9125D );
	public RefractedCactus(String name, Material material) 
	{
		super(name, material);
		setSoundType(SoundType.PLANT);
		setHardness(3.0F);
		setResistance(2.0F);
		setHarvestLevel("axe", 2);
		setLightLevel(0.0F);
		setLightOpacity(1);
		setCreativeTab(Main.shatteredworldplants);
	}
	
	
	@Override
	public boolean isOpaqueCube(IBlockState state) {
		return false;
	}
	
	@Override
	public boolean isFullCube(IBlockState state) {
		
		return false;
	}
	
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
		return REFRACTED_CACTUS_AABB;
		
	}
	
	
	@Override
	public void onEntityCollidedWithBlock(World world, BlockPos pos, IBlockState state, Entity entity) {
		int i = pos.getX();
		int j = pos.getY();
		int k = pos.getZ();
		if (true) {
			if (entity instanceof EntityLivingBase)
				((EntityLivingBase) entity).addPotionEffect(new PotionEffect(MobEffects.NAUSEA, 190, 1));
		}

	}

	
}
