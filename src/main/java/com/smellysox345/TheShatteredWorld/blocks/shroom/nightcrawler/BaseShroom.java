package com.smellysox345.TheShatteredWorld.blocks.shroom.nightcrawler;

import com.smellysox345.TheShatteredWorld.Main;
import com.smellysox345.TheShatteredWorld.blocks.BlockBase;
import com.smellysox345.TheShatteredWorld.util.InterFaces.IHasModel;
import com.smellysox345.TheShatteredWorld.util.handlers.EnumHandler;

import net.minecraft.block.BlockLog;
import net.minecraft.block.SoundType;
import net.minecraft.block.BlockLog.EnumAxis;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.MobEffects;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BaseShroom extends BlockBase
{
	public static final AxisAlignedBB NIGHT_CRAWLER_SHROOM_AABB = new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 1.0D, 1.0D);
	
	public BaseShroom(String name, Material material) 
	{
		super(name, material);
		setSoundType(SoundType.SNOW);
		setHardness(1.0F);
		setResistance(1.0F);
		setHarvestLevel("axe", 2);
		setLightLevel(0.75F);
		setLightOpacity(0);
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
	
	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos )
	{
		return NIGHT_CRAWLER_SHROOM_AABB;
	}
}
