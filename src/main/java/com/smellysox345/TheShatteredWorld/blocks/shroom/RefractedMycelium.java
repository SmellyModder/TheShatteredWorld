package com.smellysox345.TheShatteredWorld.blocks.shroom;

import java.util.Random;

import com.smellysox345.TheShatteredWorld.blocks.BlockBase;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class RefractedMycelium extends BlockBase{

	public RefractedMycelium(String name, Material material) {
		super(name, material);
		setSoundType(SoundType.GROUND);
		setHardness(0.6F);
		setResistance(0.95F);
		setHarvestLevel("shovel", 2);
		setLightLevel(0.85F);
		this.slipperiness = 0.80F;
	}

	@SideOnly(Side.CLIENT)
    public void randomDisplayTick(IBlockState stateIn, World worldIn, BlockPos pos, Random rand)
    {
        super.randomDisplayTick(stateIn, worldIn, pos, rand);

        if (rand.nextInt(10) == 0)
        {
            worldIn.spawnParticle(EnumParticleTypes.TOWN_AURA, (double)((float)pos.getX() + rand.nextFloat()), (double)((float)pos.getY() + 1.1F), (double)((float)pos.getZ() + rand.nextFloat()), 0.0D, 0.0D, 0.0D);
        }
    }
}
