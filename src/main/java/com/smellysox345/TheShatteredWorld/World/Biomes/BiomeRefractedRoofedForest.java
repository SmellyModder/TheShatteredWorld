package com.smellysox345.TheShatteredWorld.World.Biomes;

import com.smellysox345.TheShatteredWorld.World.gen.generators.tree.WorldGenCanopyRefracted;
import com.smellysox345.TheShatteredWorld.World.gen.generators.tree.WorldGenEyeTreeDefault;
import com.smellysox345.TheShatteredWorld.util.interfaces.IBiomeMist;
import net.minecraft.block.BlockDoublePlant;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.ColorizerFoliage;
import net.minecraft.world.ColorizerGrass;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraft.world.gen.feature.WorldGenBigMushroom;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.Random;

public class BiomeRefractedRoofedForest extends Biome{

    protected static final WorldGenAbstractTree TREE = new WorldGenCanopyRefracted();
    protected static final WorldGenAbstractTree TREE2 = new WorldGenEyeTreeDefault();


    private static float mistDensity = 0.1F;
    private static int mistColor = 4266496;

    public BiomeRefractedRoofedForest() {
        super(new BiomeProperties("Refracted Roofed Forest").setRainfall(0.8F));

        this.decorator.treesPerChunk = 8;
        this.spawnableCaveCreatureList.clear();
        this.spawnableCreatureList.clear();
        this.spawnableMonsterList.clear();
        this.topBlock = Blocks.GRASS.getDefaultState();
        this.fillerBlock = Blocks.DIRT.getDefaultState();
    }

    @Override
    @SideOnly(Side.CLIENT)
    public int getSkyColorByTemp(float temp) {
        return 4266496;
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

    public void addRoofedTrees(World p_185379_1_, Random p_185379_2_, BlockPos p_185379_3_) {

        for (int i = 0; i < 4; ++i) {
            for (int j = 0; j < 4; ++j) {
                int k = i * 4 + 1 + 8 + p_185379_2_.nextInt(3);
                int l = j * 4 + 1 + 8 + p_185379_2_.nextInt(3);
                BlockPos blockpos = p_185379_1_.getHeight(p_185379_3_.add(k, 0, l));

                if (p_185379_2_.nextInt(20) == 0 && net.minecraftforge.event.terraingen.TerrainGen.decorate(p_185379_1_, p_185379_2_, new net.minecraft.util.math.ChunkPos(p_185379_3_), blockpos, net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.BIG_SHROOM)) {
                    WorldGenAbstractTree worldgenbigmushroom = new WorldGenCanopyRefracted();
                    worldgenbigmushroom.generate(p_185379_1_, p_185379_2_, blockpos);
                } else {
                    addWorldgenBase(p_185379_1_, p_185379_2_, p_185379_3_, blockpos);
                }
            }
        }
    }

    private void addWorldgenBase(World p_185379_1_, Random p_185379_2_, BlockPos p_185379_3_, BlockPos blockpos) {
        if (net.minecraftforge.event.terraingen.TerrainGen.decorate(p_185379_1_, p_185379_2_, new net.minecraft.util.math.ChunkPos(p_185379_3_), blockpos, net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.TREE)) {
            WorldGenAbstractTree worldgenabstracttree = this.getRandomTreeFeature(p_185379_2_);
            worldgenabstracttree.setDecorationDefaults();

            if (worldgenabstracttree.generate(p_185379_1_, p_185379_2_, blockpos)) {
                worldgenabstracttree.generateSaplings(p_185379_1_, p_185379_2_, blockpos);
            }
        }
    }

    @Override
    public void decorate(World worldIn, Random rand, BlockPos pos) {
        this.addMushrooms(worldIn, rand, pos);
        this.addRoofedTrees(worldIn, rand, pos);

        if (net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, rand, new net.minecraft.util.math.ChunkPos(pos), net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.FLOWERS)) { // no tab for patch
            int i = rand.nextInt(5) - 3;
            i += 2;
            this.addDoublePlants(worldIn, rand, pos, i);
        }
        super.decorate(worldIn, rand, pos);
    }

    public void addMushrooms(World p_185379_1_, Random p_185379_2_, BlockPos p_185379_3_) {

        for (int i = 0; i < 4; ++i) {
            for (int j = 0; j < 4; ++j) {
                int k = i * 4 + 1 + 8 + p_185379_2_.nextInt(3);
                int l = j * 4 + 1 + 8 + p_185379_2_.nextInt(3);
                BlockPos blockpos = p_185379_1_.getHeight(p_185379_3_.add(k, 0, l));

                if (p_185379_2_.nextInt(20) == 0 && net.minecraftforge.event.terraingen.TerrainGen.decorate(p_185379_1_, p_185379_2_, new net.minecraft.util.math.ChunkPos(p_185379_3_), blockpos, net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.BIG_SHROOM)) {
                    WorldGenBigMushroom worldgenbigmushroom = new WorldGenBigMushroom();
                    worldgenbigmushroom.generate(p_185379_1_, p_185379_2_, blockpos);
                } else addWorldgenBase(p_185379_1_, p_185379_2_, p_185379_3_, blockpos);
            }
        }
    }

    public void addDoublePlants(World p_185378_1_, Random p_185378_2_, BlockPos p_185378_3_, int p_185378_4_) {
        for (int i = 0; i < p_185378_4_; ++i) {
            int j = p_185378_2_.nextInt(3);

            if (j == 0) {
                DOUBLE_PLANT_GENERATOR.setPlantType(BlockDoublePlant.EnumPlantType.SYRINGA);
            } else if (j == 1) {
                DOUBLE_PLANT_GENERATOR.setPlantType(BlockDoublePlant.EnumPlantType.ROSE);
            } else if (j == 2) {
                DOUBLE_PLANT_GENERATOR.setPlantType(BlockDoublePlant.EnumPlantType.PAEONIA);
            }

            for (int k = 0; k < 5; ++k) {
                int l = p_185378_2_.nextInt(16) + 8;
                int i1 = p_185378_2_.nextInt(16) + 8;
                int j1 = p_185378_2_.nextInt(p_185378_1_.getHeight(p_185378_3_.add(l, 0, i1)).getY() + 32);

                if (DOUBLE_PLANT_GENERATOR.generate(p_185378_1_, p_185378_2_, new BlockPos(p_185378_3_.getX() + l, j1, p_185378_3_.getZ() + i1))) {
                    break;
                }
            }
        }
    }

    public static float getMistDensity() {
        return mistDensity;
    }

    public void setMistDensity(float mistDensity) {
        this.mistDensity = mistDensity;
    }

    public static int getMistColor() {
        return mistColor;
    }

    public void setMistColor(int mistColor) {
        this.mistColor = mistColor;
    }

}
