package com.smellysox345.TheShatteredWorld.blocks.plants;

import java.util.Random;

import com.smellysox345.TheShatteredWorld.Main;
import com.smellysox345.TheShatteredWorld.World.gen.generators.tree.WorldGenBirchRefracted;
import com.smellysox345.TheShatteredWorld.World.gen.generators.tree.WorldGenEyeTreeDefault;
import com.smellysox345.TheShatteredWorld.World.gen.generators.tree.WorldGenOakRefracted;
import com.smellysox345.TheShatteredWorld.blocks.Item.ItemBlockVariants;
import com.smellysox345.TheShatteredWorld.init.ModBlocks;
import com.smellysox345.TheShatteredWorld.init.ModItems;
import com.smellysox345.TheShatteredWorld.util.handlers.EnumHandler;
import com.smellysox345.TheShatteredWorld.util.interfaces.IHasModel;

import net.minecraft.block.BlockBush;
import net.minecraft.block.IGrowable;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenBigTree;
import net.minecraft.world.gen.feature.WorldGenTrees;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.event.terraingen.TerrainGen;

public class EyeTreeSaplingDefault extends BlockBush implements IHasModel, IGrowable{

	 public static final PropertyInteger STAGE = PropertyInteger.create("stage", 0, 1);
	 protected static final AxisAlignedBB SAPLING_AABB = new AxisAlignedBB(0.09999999403953552D, 0.0D, 0.09999999403953552D, 0.8999999761581421D, 0.800000011920929D, 0.8999999761581421D);
	
	public EyeTreeSaplingDefault(String name) 
    {
		setUnlocalizedName(name);
		setRegistryName(name);
		this.setDefaultState(this.blockState.getBaseState().withProperty(STAGE, Integer.valueOf(0)));
		setCreativeTab(Main.shatteredworldplants);
		
		ModBlocks.BLOCKS.add(this);
		ModItems.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
	}
	
	@Override
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) 
    {
    	return SAPLING_AABB;
    }
    
    @Override
    public AxisAlignedBB getCollisionBoundingBox(IBlockState blockState, IBlockAccess worldIn, BlockPos pos) 
    {
    	return NULL_AABB;
    }
    
    @Override
    public boolean isOpaqueCube(IBlockState state) 
    {
    	return false;
    }
    
    @Override
    public boolean isFullCube(IBlockState state) 
    {
    	return false;
    }
	
	
    @Override
	public void registerModels() {
		 Main.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
	}
    
    @Override
	public void grow(World worldIn, Random rand, BlockPos pos, IBlockState state) 
	{
		if(((Integer)state.getValue(STAGE)).intValue() == 0)
		{
			worldIn.setBlockState(pos, state.cycleProperty(STAGE), 4);
		}
		else
		{
			this.generateTree(worldIn, rand, pos, state);
		}
	}
	public void generateTree(World world, Random rand, BlockPos pos, IBlockState state)
	{
		if(!TerrainGen.saplingGrowTree(world, rand, pos)) return;
		WorldGenerator gen = (WorldGenerator)(rand.nextInt(10) == 0 ? new WorldGenBigTree(false) : new WorldGenTrees(false));
		boolean flag = false;
		int i = 0, j = 0;
		
		gen = new WorldGenEyeTreeDefault();
	}

	@Override
	public boolean canGrow(World worldIn, BlockPos pos, IBlockState state, boolean isClient) {
		return true;
	}

	@Override
	public boolean canUseBonemeal(World worldIn, Random rand, BlockPos pos, IBlockState state) {
		return true;
	}
}
