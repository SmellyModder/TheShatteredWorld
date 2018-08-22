package com.smellysox345.TheShatteredWorld.World.Biomes;

import java.util.Random;

import com.smellysox345.TheShatteredWorld.World.gen.generators.tree.WorldGenCanopyRefracted;
import com.smellysox345.TheShatteredWorld.World.gen.generators.tree.WorldGenEyeTreeDefault;
import com.smellysox345.TheShatteredWorld.World.gen.generators.tree.WorldGenOakRefracted;
import com.smellysox345.TheShatteredWorld.entity.EntitySlimeWolf;
import com.smellysox345.TheShatteredWorld.init.ModBlocks;

import net.minecraft.block.BlockDirt;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.ColorizerFoliage;
import net.minecraft.world.ColorizerGrass;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeForest;
import net.minecraft.world.biome.Biome.BiomeProperties;
import net.minecraft.world.biome.Biome.SpawnListEntry;
import net.minecraft.world.chunk.ChunkPrimer;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraft.world.gen.feature.WorldGenBigMushroom;

public class BiomeRefractedRoofedForest extends Biome{

	protected static final WorldGenAbstractTree TREE =  new WorldGenCanopyRefracted();
	protected static final WorldGenAbstractTree TREE2 =  new WorldGenEyeTreeDefault();
	
	public BiomeRefractedRoofedForest() {
		super(new BiomeProperties("Refracted Roofed Forest").setTemperature(0.8F).setRainfall(0.8F).setBaseHeight(0.2F).setWaterColor(8983040));
		
		this.decorator.treesPerChunk = 8;
		this.spawnableCaveCreatureList.clear();
		this.spawnableCreatureList.clear();
		this.spawnableMonsterList.clear();
		
		
		this.topBlock = Blocks.GRASS.getDefaultState();
        this.fillerBlock = Blocks.DIRT.getDefaultState();
	}
	
	@Override
	public WorldGenAbstractTree getRandomTreeFeature(Random rand) {
		
		return TREE;
	}
	
	@Override
	public int getGrassColorAtPos(BlockPos pos) {
		double var1 = (double) MathHelper.clamp(this.getTemperature(pos), 1.0F, 1.0F);
		double var3 = (double) MathHelper.clamp(this.getRainfall(), 0.0F, 1.0F);
		return ((ColorizerGrass.getGrassColor(var1, var3) & 0xFEFEFE) + 0x1E0E4E) / 2;
	}

	@Override
	public int getFoliageColorAtPos(BlockPos pos) {
		double var1 = (double) MathHelper.clamp(this.getTemperature(pos), 0.0F, 1.0F);
		double var3 = (double) MathHelper.clamp(this.getRainfall(), 0.0F, 1.0F);
		return ((ColorizerFoliage.getFoliageColor(var1, var3) & 0xFEFEFE) + 0x1E0E4E) / 2;
	}
	
	public void addMushrooms(World p_185379_1_, Random p_185379_2_, BlockPos p_185379_3_)
    {

        for (int i = 0; i < 4; ++i)
        {
            for (int j = 0; j < 4; ++j)
            {
                int k = i * 4 + 1 + 8 + p_185379_2_.nextInt(3);
                int l = j * 4 + 1 + 8 + p_185379_2_.nextInt(3);
                BlockPos blockpos = p_185379_1_.getHeight(p_185379_3_.add(k, 0, l));

                if (p_185379_2_.nextInt(20) == 0 && net.minecraftforge.event.terraingen.TerrainGen.decorate(p_185379_1_, p_185379_2_, new net.minecraft.util.math.ChunkPos(p_185379_3_), blockpos, net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.BIG_SHROOM))
                {
                	WorldGenAbstractTree worldgenbigmushroom = new WorldGenEyeTreeDefault();
                    worldgenbigmushroom.generate(p_185379_1_, p_185379_2_, blockpos);
                }
                else if (net.minecraftforge.event.terraingen.TerrainGen.decorate(p_185379_1_, p_185379_2_, new net.minecraft.util.math.ChunkPos(p_185379_3_), blockpos, net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.TREE))
                {
                    WorldGenAbstractTree worldgenabstracttree = this.getRandomTreeFeature(p_185379_2_);
                    worldgenabstracttree.setDecorationDefaults();

                    if (worldgenabstracttree.generate(p_185379_1_, p_185379_2_, blockpos))
                    {
                        worldgenabstracttree.generateSaplings(p_185379_1_, p_185379_2_, blockpos);
                    }
                }
            }
        }
    }
	
	public void decorate(World worldIn, Random rand, BlockPos pos)
	{
        this.addMushrooms(worldIn, rand, pos);
    }

}
