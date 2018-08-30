package com.smellysox345.TheShatteredWorld.World.gen;

import java.util.Random;

import com.smellysox345.TheShatteredWorld.blocks.plants.flowers.SWFlowers;

import net.minecraft.block.Block;
import net.minecraft.block.BlockFlower;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenSWFlowers extends WorldGenerator
{
    private Block flower;
    private IBlockState state;

    public WorldGenSWFlowers(Block rPoppy)
    {
        this.setGeneratedBlock(rPoppy);
    }

    public void setGeneratedBlock(Block flowerIn)
    {
        this.flower = flowerIn;
        this.state = flowerIn.getDefaultState();
    }

    public boolean generate(World worldIn, Random rand, BlockPos position)
    {
        for (int i = 0; i < 64; ++i)
        {
            BlockPos blockpos = position.add(rand.nextInt(8) - rand.nextInt(8), rand.nextInt(4) - rand.nextInt(4), rand.nextInt(8) - rand.nextInt(8));

            if (worldIn.isAirBlock(blockpos) && (!worldIn.provider.isNether() || blockpos.getY() < 255))
            {
                worldIn.setBlockState(blockpos, this.state, 2);
            }
        }

        return true;
    }

}
