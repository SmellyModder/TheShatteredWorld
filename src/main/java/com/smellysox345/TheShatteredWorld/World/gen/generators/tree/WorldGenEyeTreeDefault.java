package com.smellysox345.TheShatteredWorld.World.gen.generators.tree;

import java.util.Random;

import com.smellysox345.TheShatteredWorld.blocks.plants.EyeTreeLeavesDefault;
import com.smellysox345.TheShatteredWorld.blocks.variant.BlockSaplings;
import com.smellysox345.TheShatteredWorld.init.ModBlocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;

public class WorldGenEyeTreeDefault extends WorldGenAbstractTree{

	public static final Block LOG = ModBlocks.EYE_TREE_DEFAULT;
	public static final Block LOG_EYE = ModBlocks.EYE_TREE;
	public static final IBlockState LEAVES = ModBlocks.EYE_LEAVES_DEFAULT.getDefaultState().withProperty(EyeTreeLeavesDefault.DECAYABLE, false);
	
	public WorldGenEyeTreeDefault() {
		super(false);
	}

	@Override
	public boolean generate(World world, Random rand, BlockPos pos) {
		int x = pos.getX();
		int y = pos.getY();
		int z = pos.getZ();
		int radius = rand.nextInt(2) + 3;
		int height = rand.nextInt(radius) + 12;
		int maxRadius = 9;

		for (int xx = x - maxRadius; xx <= x + maxRadius; xx++)
			for (int zz = z - maxRadius; zz <= z + maxRadius; zz++)
				for (int yy = y + 2; yy < y + height; yy++)
					if (!world.isAirBlock(new BlockPos(xx, yy, zz)))
						return false;

		for (int yy = y; yy < y + height; ++yy) {
			if (yy % 5 == 0 && radius != 1)
				--radius;

			for (int i = radius * -1; i <= radius; ++i)
				for (int j = radius * -1; j <= radius; ++j) {
					double dSq = i * i + j * j;
					if (Math.round(Math.sqrt(dSq)) <= radius && yy <= y + height - 2)
						world.setBlockState(new BlockPos(x + i, yy, z + j), LOG.getStateFromMeta(0), 2);
					if (Math.round(Math.sqrt(dSq)) <= radius && yy >= y + height - 2)
						world.setBlockState(new BlockPos(x + i, yy, z + j), LOG_EYE.getStateFromMeta(15), 2);
					if (Math.round(Math.sqrt(dSq)) <= radius && yy == y || Math.round(Math.sqrt(dSq)) <= radius && yy == y + height - 1)
						world.setBlockState(new BlockPos(x + i, yy, z + j), LOG.getStateFromMeta(15), 2);
					
				}

			if (yy == y + height - 1) {
				createBranch(world, rand, x + radius + 1, yy - rand.nextInt(3), z, 1, false);
				createBranch(world, rand, x - radius - 1, yy - rand.nextInt(3), z, 2, false);
				createBranch(world, rand, x, yy - rand.nextInt(3), z + radius + 1, 3, false);
				createBranch(world, rand, x, yy - rand.nextInt(3), z - radius - 1, 4, false);

				createBranch(world, rand, x + radius + 1, yy - rand.nextInt(3), z + radius + 1, 5, false);
				createBranch(world, rand, x - radius - 1, yy - rand.nextInt(3), z - radius - 1, 6, false);
				createBranch(world, rand, x - radius - 1, yy - rand.nextInt(3), z + radius + 1, 7, false);
				createBranch(world, rand, x + radius + 1, yy - rand.nextInt(3), z - radius - 1, 8, false);
			}

			if (yy == y + 1) {
				createBranch(world, rand, x + radius + 1, yy - rand.nextInt(3), z, 1, true);
				createBranch(world, rand, x - radius - 1, yy - rand.nextInt(3), z, 2, true);
				createBranch(world, rand, x, yy - rand.nextInt(3), z + radius + 1, 3, true);
				createBranch(world, rand, x, yy - rand.nextInt(3), z - radius - 1, 4, true);

				createBranch(world, rand, x + radius + 1, yy - rand.nextInt(3), z + radius + 1, 5, true);
				createBranch(world, rand, x - radius - 1, yy - rand.nextInt(3), z - radius - 1, 6, true);
				createBranch(world, rand, x - radius - 1, yy - rand.nextInt(3), z + radius + 1, 7, true);
				createBranch(world, rand, x + radius + 1, yy - rand.nextInt(3), z - radius - 1, 8, true);
			}
		}

		return true;
	}

	private void createBranch(World world, Random rand, int x, int y, int z, int dir, boolean root) {
		int branchLength = rand.nextInt(2) + 4;
		int meta = dir;
		for (int i = 1; i <= branchLength; ++i) {

			if (i >= 3) {
				y--;
				meta = 0;
			}

			if (dir == 1)
				if (!root) {
					world.setBlockState(new BlockPos(x + i, y, z), LOG.getStateFromMeta(meta == 0 ? 0 : 4), 2);
					if (i < branchLength)
						addHangers(world, rand, x + i, y - 1, z);
					if (i == branchLength)
						createLeaves(world, rand, x + i, y - 1, z, 1);
				} else {
					world.setBlockState(new BlockPos(x + i, y, z), LOG.getStateFromMeta(15), 2);
				}

			if (dir == 2)
				if (!root) {
					world.setBlockState(new BlockPos(x - i, y, z), LOG.getStateFromMeta(meta == 0 ? 0 : 4), 2);
					if (i < branchLength)
						addHangers(world, rand, x - i, y - 1, z);
					if (i == branchLength)
						createLeaves(world, rand, x - i, y - 1, z, 1);
				} else {
					world.setBlockState(new BlockPos(x - i, y, z), LOG.getStateFromMeta(15), 2);
				}

			if (dir == 3)
				if (!root) {
					world.setBlockState(new BlockPos(x, y, z + i), LOG.getStateFromMeta(meta == 0 ? 0 : 8), 2);
					if (i < branchLength)
						addHangers(world, rand, x, y - 1, z + i);
					if (i == branchLength)
						createLeaves(world, rand, x, y - 1, z + i, 1);
				} else {
					world.setBlockState(new BlockPos(x, y, z + i), LOG.getStateFromMeta(15), 2);
					world.setBlockState(new BlockPos(x, y - 1, z + i), LOG.getStateFromMeta(15), 2);
				}

			if (dir == 4)
				if (!root) {
					world.setBlockState(new BlockPos(x, y, z - i), LOG.getStateFromMeta(meta == 0 ? 0 : 8), 2);
					if (i < branchLength)
						addHangers(world, rand, x, y - 1, z - i);
					if (i == branchLength)
						createLeaves(world, rand, x, y - 1, z - i, 1);
				} else {
					world.setBlockState(new BlockPos(x, y, z - i), LOG.getStateFromMeta(15), 2);
					world.setBlockState(new BlockPos(x, y - 1, z - i), LOG.getStateFromMeta(15), 2);
				}

			if (dir == 5)
				if (!root) {
					world.setBlockState(new BlockPos(x + i - 1, y, z + i - 1), LOG.getStateFromMeta(meta == 0 ? 0 : 4), 2);
					if (i < branchLength)
						addHangers(world, rand, x + i - 1, y - 1, z + i - 1);
					if (i == branchLength)
						createLeaves(world, rand, x + i, y - 1, z + i, 1);
				} else {
					world.setBlockState(new BlockPos(x + i - 1, y, z + i - 1), LOG.getStateFromMeta(15), 2);
					world.setBlockState(new BlockPos(x + i - 1, y - 1, z + i - 1), LOG.getStateFromMeta(15), 2);
				}

			if (dir == 6)
				if (!root) {
					world.setBlockState(new BlockPos(x - i + 1, y, z - i + 1), LOG.getStateFromMeta(meta == 0 ? 0 : 4), 2);
					if (i < branchLength)
						addHangers(world, rand, x - i + 1, y - 1, z - i + 1);
					if (i == branchLength)
						createLeaves(world, rand, x - i, y - 1, z - i, 1);
				} else {
					world.setBlockState(new BlockPos(x - i + 1, y, z - i + 1), LOG.getStateFromMeta(15), 2);
					world.setBlockState(new BlockPos(x - i + 1, y - 1, z - i + 1), LOG.getStateFromMeta(15), 2);
				}

			if (dir == 7)
				if (!root) {
					world.setBlockState(new BlockPos(x - i + 1, y, z + i - 1), LOG.getStateFromMeta(meta == 0 ? 0 : 8), 2);
					if (i < branchLength)
						addHangers(world, rand, x - i + 1, y - 1, z + i - 1);
					if (i == branchLength)
						createLeaves(world, rand, x - i, y - 1, z + i, 1);
				} else {
					world.setBlockState(new BlockPos(x - i + 1, y, z + i - 1), LOG.getStateFromMeta(15), 2);
					world.setBlockState(new BlockPos(x - i + 1, y - 1, z + i - 1), LOG.getStateFromMeta(15), 2);
				}

			if (dir == 8)
				if (!root) {
					world.setBlockState(new BlockPos(x + i - 1, y, z - i + 1), LOG.getStateFromMeta(meta == 0 ? 0 : 8), 2);
					if (i < branchLength)
						addHangers(world, rand, x + i - 1, y - 1, z - i + 1);
					if (i == branchLength)
						createLeaves(world, rand, x + i, y - 1, z - i, 1);
				} else {
					world.setBlockState(new BlockPos(x + i - 1, y, z - i + 1), LOG.getStateFromMeta(15), 2);
					world.setBlockState(new BlockPos(x + i - 1, y - 1, z - i + 1), LOG.getStateFromMeta(15), 2);
				}
		}
	}

	public void createLeaves(World world, Random rand, int x, int y, int z, int radius) {
		int height = 3;
		for (int xx = x - radius; xx <= x + radius; xx++)
			for (int zz = z - radius; zz <= z + radius; zz++)
				for (int yy = y; yy > y - height; yy--) {
					double dSq = Math.pow(xx - x, 2.0D) + Math.pow(zz - z, 2.0D) + Math.pow(yy - y, 2.0D);
					if (Math.round(Math.sqrt(dSq)) <= radius)
						if (Math.round(Math.sqrt(dSq)) == 0)
							world.setBlockState(new BlockPos(xx, yy, zz), LOG.getStateFromMeta(0), 2);
						else
							world.setBlockState(new BlockPos(xx, yy, zz), LEAVES, 2);
					if (Math.round(Math.sqrt(dSq)) == 0) {
						world.setBlockState(new BlockPos(xx, yy - 2, zz), LEAVES, 2);
						addHangers(world, rand, xx, yy - 3, zz);
					}
				}
	}
	
	public void createEyes(World world, Random rand, int x, int y, int z, int radius) {
		int height = 5;
		for (int xx = x - radius; xx <= x + radius; xx++)
			for (int zz = z - radius; zz <= z + radius; zz++)
				for (int yy = y; yy > y + height; yy--) {
					double dSq = Math.pow(xx - x, 2.0D) + Math.pow(zz - z, 2.0D) + Math.pow(yy - y, 2.0D);
					if (Math.round(Math.sqrt(dSq)) <= radius)
						if (Math.round(Math.sqrt(dSq)) == 0)
							world.setBlockState(new BlockPos(xx, yy, zz), LOG_EYE.getStateFromMeta(0), 2);
				}
	}
	

	public void addHangers(World world, Random rand, int x, int y, int z) {

		if (rand.nextInt(4) != 0) {
			int length = rand.nextInt(13) + 4;
			for (int yy = y; yy > y - length; --yy)
				if (world.isAirBlock(new BlockPos(x, yy, z)))
					world.setBlockState(new BlockPos(x, yy, z), ModBlocks.EYE_LEAVES_DEFAULT.getDefaultState().withProperty(EyeTreeLeavesDefault.DECAYABLE, false), 2);
				else
					break;
		}
	}
}
