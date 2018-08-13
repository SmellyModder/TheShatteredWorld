package com.smellysox345.TheShatteredWorld.blocks.magic;

import java.util.Random;

import javax.annotation.Nullable;

import com.smellysox345.TheShatteredWorld.blocks.BlockBase;
import com.smellysox345.TheShatteredWorld.init.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ForceFieldShroom extends BlockBase {

    public ForceFieldShroom(String name, Material material) {
        super(name, material);

    }
    
    @Override
    public boolean isFullCube(IBlockState state) {
        return false;
    }

    @Override
    public boolean isOpaqueCube(IBlockState state) {
        return false;
    }
    
    @SideOnly(Side.CLIENT)
    public BlockRenderLayer getBlockLayer() {
        return BlockRenderLayer.TRANSLUCENT;
    }
    
    @Nullable
    public AxisAlignedBB getCollisionBoundingBox(IBlockState blockState, IBlockAccess worldIn, BlockPos pos)
    {
        return NULL_AABB;
    }
    
    @SideOnly(Side.CLIENT)
    @Override
	public void randomDisplayTick(IBlockState state, World world, BlockPos pos, Random random) {
		EntityPlayer entity = Minecraft.getMinecraft().player;
		int x = pos.getX();
		int y = pos.getY();
		int z = pos.getZ();
		World par1World = world;
		int par2 = x;
		int par3 = y;
		int par4 = z;
		Random par5Random = random;
		if (true)
			for (int l = 0; l < 1; ++l) {
				double d0 = (double) ((float) par2 + par5Random.nextFloat());
				double d1 = (double) ((float) par3 + par5Random.nextFloat());
				double d2 = (double) ((float) par4 + par5Random.nextFloat());
				double d3 = 0.0D;
				double d4 = 0.0D;
				double d5 = 0.0D;
				int i1 = par5Random.nextInt(2) * 2 - 1;
				d3 = ((double) par5Random.nextFloat() - 0.5D) * 0.2D;
				d4 = ((double) par5Random.nextFloat() - 0.5D) * 0.2D;
				d5 = ((double) par5Random.nextFloat() - 0.5D) * 0.2D;
				par1World.spawnParticle(EnumParticleTypes.CRIT_MAGIC, d0, d1, d2, d3, d4, d5);
			}

	}

    @SideOnly(Side.CLIENT)
    public boolean shouldSideBeRendered(IBlockState blockState, IBlockAccess blockAccess, BlockPos pos, EnumFacing side)
    {
        IBlockState iblockstate = blockAccess.getBlockState(pos.offset(side));
        Block block = iblockstate.getBlock();

        if (this == ModBlocks.SHROOM_SHIELD)
        {
            if (blockState != iblockstate)
            {
                return true;
            }

            if (block == this)
            {
                return false;
            }
        }

        return block == this ? false : super.shouldSideBeRendered(blockState, blockAccess, pos, side);
    }

    @Override
    public void onEntityCollidedWithBlock(World world, BlockPos pos, IBlockState state, Entity entity) {
        if (entity instanceof EntityPlayer) {
            return;
        }
        int Knockback = 2;
        entity.addVelocity(MathHelper.sin(entity.rotationYaw * 3.141593F / 180.0F) * Knockback * 0.1F, 0.08D, -MathHelper.cos(entity.rotationYaw * 3.141593F / 180.0F) * Knockback * 0.1F);
        entity.attackEntityFrom(DamageSource.MAGIC, 1);
    }

}
