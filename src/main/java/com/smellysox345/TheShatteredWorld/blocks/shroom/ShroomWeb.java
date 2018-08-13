package com.smellysox345.TheShatteredWorld.blocks.shroom;

import java.util.Random;

import javax.annotation.Nullable;

import com.smellysox345.TheShatteredWorld.blocks.BlockBase;
import com.smellysox345.TheShatteredWorld.init.ModItems;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.init.MobEffects;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.stats.StatList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.IShearable;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;


public class ShroomWeb extends BlockBase implements IShearable{

	public ShroomWeb(String name, Material material) {
		super(name, material);
		setSoundType(SoundType.CLOTH);
		setHarvestLevel("shear", 1);
		setHardness(0.9F);
		setResistance(2.0F);
		setLightLevel(0.65F);
		setLightOpacity(14);
		
	}
	
	public void onEntityCollidedWithBlock(World worldIn, BlockPos pos, IBlockState state, Entity entityIn)
    {
		int i = pos.getX();
		int j = pos.getY();
		int k = pos.getZ();
        entityIn.setInWeb();
        if (true) {
			if (entityIn instanceof EntityLivingBase)
				((EntityLivingBase) entityIn).addPotionEffect(new PotionEffect(MobEffects.SLOWNESS, 190, 1));
		}
    }
	
	   public boolean isOpaqueCube(IBlockState state)
	    {
	        return false;
	    }

	    @Nullable
	    public AxisAlignedBB getCollisionBoundingBox(IBlockState blockState, IBlockAccess worldIn, BlockPos pos)
	    {
	        return NULL_AABB;
	    }

	    public boolean isFullCube(IBlockState state)
	    {
	        return false;
	    }
	
	    @SideOnly(Side.CLIENT)
	    public BlockRenderLayer getBlockLayer()
	    {
	        return BlockRenderLayer.CUTOUT;
	    }
	    
	    public BlockFaceShape getBlockFaceShape(IBlockAccess worldIn, IBlockState state, BlockPos pos, EnumFacing face)
	    {
	        return BlockFaceShape.UNDEFINED;
	    }
	    
	    public Item getItemDropped(IBlockState state, Random rand, int fortune)
	    {
	        return ModItems.R_STRING;
	    }

	    protected boolean canSilkHarvest()
	    {
	        return true;
	    }
	    
	    public void harvestBlock(World worldIn, EntityPlayer player, BlockPos pos, IBlockState state, @Nullable TileEntity te, ItemStack stack)
	    {
	        if (!worldIn.isRemote && stack.getItem() == Items.SHEARS)
	        {
	            player.addStat(StatList.getBlockStats(this));
	            spawnAsEntity(worldIn, pos, new ItemStack(Item.getItemFromBlock(this), 1));
	        }
	        else
	        {
	            super.harvestBlock(worldIn, player, pos, state, te, stack);
	        }
	    }
	    
	    @Override public boolean isShearable(ItemStack item, IBlockAccess world, BlockPos pos) { return true; }
	    @Override
	    public java.util.List<ItemStack> onSheared(ItemStack item, IBlockAccess world, BlockPos pos, int fortune) {
	        return com.google.common.collect.Lists.newArrayList(new ItemStack(Item.getItemFromBlock(this)));
	    }
}
