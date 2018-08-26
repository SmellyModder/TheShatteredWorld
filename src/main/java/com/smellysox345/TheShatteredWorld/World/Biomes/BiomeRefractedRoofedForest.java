package com.smellysox345.TheShatteredWorld.World.Biomes;

import com.smellysox345.TheShatteredWorld.World.gen.generators.tree.WorldGenCanopyRefracted;
import com.smellysox345.TheShatteredWorld.World.gen.generators.tree.WorldGenEyeTreeDefault;
import com.smellysox345.TheShatteredWorld.util.interfaces.IBiomeMist;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.ColorizerFoliage;
import net.minecraft.world.ColorizerGrass;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.Random;

public class BiomeRefractedRoofedForest extends Biome implements IBiomeMist {

    protected static final WorldGenAbstractTree TREE = new WorldGenCanopyRefracted();
    protected static final WorldGenAbstractTree TREE2 = new WorldGenEyeTreeDefault();

    protected final float[] lightBrightnessTable = new float[16];

    public BiomeRefractedRoofedForest() {
        super(new BiomeProperties("Refracted Roofed Forest").setTemperature(3.0F).setRainfall(0.8F));

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
        return 6572850;
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

    public void addMushrooms(World p_185379_1_, Random p_185379_2_, BlockPos p_185379_3_) {

        for (int i = 0; i < 4; ++i) {
            for (int j = 0; j < 4; ++j) {
                int k = i * 4 + 1 + 8 + p_185379_2_.nextInt(3);
                int l = j * 4 + 1 + 8 + p_185379_2_.nextInt(3);
                BlockPos blockpos = p_185379_1_.getHeight(p_185379_3_.add(k, 0, l));

                if (p_185379_2_.nextInt(20) == 0 && net.minecraftforge.event.terraingen.TerrainGen.decorate(p_185379_1_, p_185379_2_, new net.minecraft.util.math.ChunkPos(p_185379_3_), blockpos, net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.BIG_SHROOM)) {
                    WorldGenAbstractTree worldgenbigmushroom = new WorldGenEyeTreeDefault();
                    worldgenbigmushroom.generate(p_185379_1_, p_185379_2_, blockpos);
                } else if (net.minecraftforge.event.terraingen.TerrainGen.decorate(p_185379_1_, p_185379_2_, new net.minecraft.util.math.ChunkPos(p_185379_3_), blockpos, net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.TREE)) {
                    WorldGenAbstractTree worldgenabstracttree = this.getRandomTreeFeature(p_185379_2_);
                    worldgenabstracttree.setDecorationDefaults();

                    if (worldgenabstracttree.generate(p_185379_1_, p_185379_2_, blockpos)) {
                        worldgenabstracttree.generateSaplings(p_185379_1_, p_185379_2_, blockpos);
                    }
                }
            }
        }
    }

    public void decorate(World worldIn, Random rand, BlockPos pos) {
        this.addMushrooms(worldIn, rand, pos);
    }

    @Override
    public float getMistDensity(int var1, int var2, int var3) {
        return 0.08F;
    }

    public int getMistColor() {
        return mistColor;
    }

    public void setMistColor(int mistColor) {
        this.mistColor = mistColor;
    }

    private int mistColor = 4266496;
    @Override
    public int getMistColour(int var1, int var2, int var3) {
        return mistColor;
    }

    @Override
    public int getMistMultiplier(int i) {
        return i;
    }

}
