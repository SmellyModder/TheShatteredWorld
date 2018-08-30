package com.smellysox345.TheShatteredWorld.World.gen;

import java.util.Random;

import com.smellysox345.TheShatteredWorld.blocks.plants.mushroom.DarkrumShroom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockBush;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenBushDShrooms extends WorldGenerator
{
    private final Block block;

    public WorldGenBushDShrooms(Block darkrumShroom)
    {
        this.block = darkrumShroom;
    }

    public boolean generate(World worldIn, Random rand, BlockPos position)
    {
        for (int i = 0; i < 64; ++i)
        {
            BlockPos blockpos = position.add(rand.nextInt(8) - rand.nextInt(8), rand.nextInt(4) - rand.nextInt(4), rand.nextInt(8) - rand.nextInt(8));

            if (worldIn.isAirBlock(blockpos) && (!worldIn.provider.isNether() || blockpos.getY() < worldIn.getHeight() - 1))
            {
                worldIn.setBlockState(blockpos, this.block.getDefaultState(), 2);
            }
        }

        return true;
    }

}
