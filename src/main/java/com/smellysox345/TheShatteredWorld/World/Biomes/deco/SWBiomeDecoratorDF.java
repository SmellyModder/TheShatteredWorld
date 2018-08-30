package com.smellysox345.TheShatteredWorld.World.Biomes.deco;

import java.util.Random;

import com.smellysox345.TheShatteredWorld.World.gen.SWWorldGenBigMushroomDark;
import com.smellysox345.TheShatteredWorld.World.gen.WorldGenBushDShrooms;
import com.smellysox345.TheShatteredWorld.init.ModBlocks;

import net.minecraft.block.Block;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class SWBiomeDecoratorDF extends SWBiomeDecoratorBase {


	World world;
	BlockPos pos;
	Random random;
	private final SWWorldGenBigMushroomDark worldgenbigmushroom = new SWWorldGenBigMushroomDark();
	
	public static final Block[] MUSHROOMS = { ModBlocks.DARK_BROWN_MUSHROOM_BLOCK, ModBlocks.DARK_RED_MUSHROOM_BLOCK};

	@Override
	public void decorate() {

		for (attempt = 0; attempt < 10; attempt++) {
			int length = rand.nextInt(5) + 4;
			int baseRadius = rand.nextInt(3) + 2;
			byte direction = (byte) rand.nextInt(2);
			xx = x + 16;
			yy = rand.nextInt(118);
			zz = z + 16;
			BlockPos pos = new BlockPos(xx, yy, zz);
		}


		for (attempt = 0; attempt < 400; attempt++) {
			int r = rand.nextInt(100);
			if (r < 16)
            worldgenbigmushroom.generate(world, random, pos);
		}
		}
}
