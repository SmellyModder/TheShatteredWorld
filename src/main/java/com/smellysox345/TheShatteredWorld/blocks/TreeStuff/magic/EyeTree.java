package com.smellysox345.TheShatteredWorld.blocks.TreeStuff.magic;

import javax.annotation.Nullable;

import com.google.common.base.Predicate;
import com.smellysox345.TheShatteredWorld.Main;
import com.smellysox345.TheShatteredWorld.blocks.Item.ItemBlockVariants;
import com.smellysox345.TheShatteredWorld.init.ModBlocks;
import com.smellysox345.TheShatteredWorld.init.ModItems;
import com.smellysox345.TheShatteredWorld.util.InterFaces.IHasModel;
import com.smellysox345.TheShatteredWorld.util.handlers.EnumHandler;

import net.minecraft.block.BlockLog;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.BlockLog.EnumAxis;
import net.minecraft.block.BlockRotatedPillar;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class EyeTree extends BlockRotatedPillar implements IHasModel{
	
	public static final PropertyEnum<EyeTree.EnumAxis> LOG_AXIS = PropertyEnum.<EyeTree.EnumAxis>create("axis", EyeTree.EnumAxis.class);
	
	public EyeTree(String name, Material materialIn) {
		super(materialIn);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(Main.refractedblocks);
		
		ModBlocks.BLOCKS.add(this);
		ModItems.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
	}
	
	public IBlockState getStateForPlacement(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer)
    {
        return this.getStateFromMeta(meta).withProperty(LOG_AXIS, EyeTree.EnumAxis.fromFacingAxis(facing.getAxis()));
    }

    public IBlockState withRotation(IBlockState state, Rotation rot)
    {
        switch (rot)
        {
            case COUNTERCLOCKWISE_90:
            case CLOCKWISE_90:

                switch ((EyeTree.EnumAxis)state.getValue(LOG_AXIS))
                {
                    case X:
                        return state.withProperty(LOG_AXIS, EyeTree.EnumAxis.Z);
                    case Z:
                        return state.withProperty(LOG_AXIS, EyeTree.EnumAxis.X);
                    default:
                        return state;
                }

            default:
                return state;
        }
    }
	
	 public static enum EnumAxis implements IStringSerializable
	    {
	        X("x"),
	        Y("y"),
	        Z("z"),
	        NONE("none");

	        private final String name;

	        private EnumAxis(String name)
	        {
	            this.name = name;
	        }

	        public String toString()
	        {
	            return this.name;
	        }

	        public static EyeTree.EnumAxis fromFacingAxis(EnumFacing.Axis axis)
	        {
	            switch (axis)
	            {
	                case X:
	                    return X;
	                case Y:
	                    return Y;
	                case Z:
	                    return Z;
	                default:
	                    return NONE;
	            }
	        }

	        public String getName()
	        {
	            return this.name;
	        }
	    }
	 
	@Override
	public void registerModels() {
		Main.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
	}

}
