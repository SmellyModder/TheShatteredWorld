package com.smellysox345.TheShatteredWorld.World.dimension.library;

import java.util.List;
import java.util.Random;

import javax.annotation.Nullable;

import com.smellysox345.TheShatteredWorld.World.dimension.features.ShatteredWorldFeatures;
import com.smellysox345.TheShatteredWorld.init.BiomeInit;
import com.smellysox345.TheShatteredWorld.init.ModBlocks;

import net.minecraft.block.Block;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biome.SpawnListEntry;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.ChunkPrimer;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.NoiseGeneratorOctaves;
import net.minecraft.world.gen.NoiseGeneratorPerlin;
import net.minecraftforge.event.ForgeEventFactory;

public abstract class ChunkGenSWHelper implements IChunkGenerator {

	protected final Random rand;

	protected final NoiseGeneratorPerlin surfaceNoise;
	private final NoiseGeneratorOctaves noiseGen4;

	protected final World world;
	protected final WorldType terrainType;

	protected double[] depthBuffer = new double[256];
	protected Biome[] biomesForGeneration;

	private final boolean shouldGenerateBedrock;

	protected static long getSeed(int x, int z) {
		return x * 0x4f9939f508L + z * 0x1ef1565bd5L;
	}

	public ChunkGenSWHelper(World world, long seed, boolean enableFeatures, boolean shouldGenerateBedrock) {
		this.world = world;
		this.terrainType = world.getWorldInfo().getTerrainType();
		this.rand = new Random(seed);
		this.surfaceNoise = new NoiseGeneratorPerlin(this.rand, 4);
		this.shouldGenerateBedrock = shouldGenerateBedrock;
		this.noiseGen4 = new NoiseGeneratorOctaves(rand, 4);
	}

	protected final Chunk makeChunk(int x, int z, ChunkPrimer primer) {

		Chunk chunk = new Chunk(world, primer, x, z);

		// load in biomes, to prevent striping?!
		byte[] chunkBiomes = chunk.getBiomeArray();
		for (int i = 0; i < chunkBiomes.length; ++i) {
			chunkBiomes[i] = (byte) Biome.getIdForBiome(this.biomesForGeneration[i]);
		}

		chunk.generateSkylightMap();

		return chunk;
	}

	// [VanillaCopy] Exact, ChunkGeneratorOverworld.replaceBiomeBlocks
	public void replaceBiomeBlocks(int x, int z, ChunkPrimer primer, Biome[] biomesIn)
	{
		if (!ForgeEventFactory.onReplaceBiomeBlocks(this, x, z, primer, this.world)) return;
		double d0 = 0.03125D;
		this.depthBuffer = this.surfaceNoise.getRegion(this.depthBuffer, (double)(x * 16), (double)(z * 16), 16, 16, 0.0625D, 0.0625D, 1.0D);

		for (int i = 0; i < 16; ++i)
		{
			for (int j = 0; j < 16; ++j)
			{
				Biome biome = biomesIn[j + i * 16];
				biome.genTerrainBlocks(this.world, this.rand, primer, x * 16 + i, z * 16 + j, this.depthBuffer[j + i * 16]);
			}
		}
	}

	/**
	 * Raises up and hollows out the hollow hills.
	 */
	protected final void deformTerrainForFeature(int cx, int cz, ChunkPrimer primer) {
	}
	
	private void addDarkForestCanopy2(int chunkX, int chunkZ, ChunkPrimer primer) {
		int[] thicks = new int[5 * 5];

		for (int z = 0; z < 5; z++) {
			for (int x = 0; x < 5; x++) {

				for (int bx = -1; bx <= 1; bx++) {
					for (int bz = -1; bz <= 1; bz++) {
						Biome biome = biomesForGeneration[x + bx + 2 + (z + bz + 2) * (10)];

						if (biome == BiomeInit.R_ROOFED_FOREST || biome == BiomeInit.R_ROOFED_FOREST) {
							thicks[x + z * 5]++;
						}
					}
				}
			}
		}

		for (int z = 0; z < 16; z++) {
			for (int x = 0; x < 16; x++) {

				int qx = x / 4;
				int qz = z / 4;

				float xweight = (x % 4) * 0.25F + 0.125F;
				float zweight = (z % 4) * 0.25F + 0.125F;

				float thickness = 0;

				thickness += thicks[qx + (qz) * 5] * (1F - xweight) * (1F - zweight);
				thickness += thicks[qx + 1 + (qz) * 5] * (xweight) * (1F - zweight);
				thickness += thicks[qx + (qz + 1) * 5] * (1F - xweight) * (zweight);
				thickness += thicks[qx + 1 + (qz + 1) * 5] * (xweight) * (zweight);

				thickness -= 4;

				//int thickness = thicks[qz + (qz) * 5];

				// make sure we're not too close to the tower
				ShatteredWorldFeatures nearFeature = ShatteredWorldFeatures.getNearestFeature(chunkX, chunkZ, world);
				if (nearFeature == ShatteredWorldFeatures.NAGROT_LAIR) {
					// check for closeness
					int[] nearCenter = ShatteredWorldFeatures.getNearestCenter(chunkX, chunkZ, world);
					int hx = nearCenter[0];
					int hz = nearCenter[1];

					int dx = x - hx;
					int dz = z - hz;
					int dist = (int) Math.sqrt(dx * dx + dz * dz);

					if (dist < 24) {

						thickness -= (24 - dist);
					}
				}

				boolean generateForest = thickness > 1;

				if (generateForest) {
					double d = 0.03125D;
					depthBuffer = noiseGen4.generateNoiseOctaves(depthBuffer, chunkX * 16, chunkZ * 16, 0, 16, 16, 1, d * 2D, d * 2D, d * 2D);

					// find the (current) top block
					int topLevel = -1;
					for (int y = 127; y >= 0; y--) {
						Block currentBlock = primer.getBlockState(x, y, z).getBlock();
						if (currentBlock == Blocks.WATER) {
							// don't generate over water
							break;
						}
						if (currentBlock == Blocks.STONE) {
							topLevel = y;
							break;
						}
					}

					if (topLevel != -1) {
						// just use the same noise generator as the terrain uses
						// for stones
						int noise = Math.min(3, (int) (depthBuffer[z & 15 | (x & 15) << 4] / 1.25f));

						// manipulate top and bottom
						int treeBottom = topLevel + 12 - (int) (thickness * 0.5F);
						int treeTop = treeBottom + (int) (thickness * 1.5F);

						treeBottom -= noise;

						for (int y = treeBottom; y < treeTop; y++) {
							primer.setBlockState(x, y, z, ModBlocks.R_DARK_LEAVES.getDefaultState().withProperty(null, null));
						}
					}
				}
			}
		}
	}

	private void raiseHills(ChunkPrimer primer, int hdiam, int x, int z, int dx, int dz, int hillHeight) {
		int newGround = -1;
		boolean foundGroundLevel = false;
	}

	private void flattenTerrainForFeature(ChunkPrimer primer, int x, int z, int dx, int dz) {
		int oldGround;
		int newGround;
		float squishFactor = 0;
	}
	
	protected final boolean allowSurfaceLakes(Biome biome) {
		return true;
	}

	public final boolean shouldGenerateBedrock() {
		return shouldGenerateBedrock;
	}

	@Override
	public boolean generateStructures(Chunk chunk, int x, int z) {
		return false;
	}

	/**
	 * Returns a list of creatures of the specified type that can spawn at the
	 * given location.
	 * <p>
	 * Twilight Forest variant! First check features, then only if we're not in
	 * a feature, check the biome.
	 */
	@Override
	public List<SpawnListEntry> getPossibleCreatures(EnumCreatureType creatureType, BlockPos pos) {
		return null;
	}

	@Nullable
	@Override
	public BlockPos getNearestStructurePos(World world, String structureName, BlockPos position, boolean findUnexplored) {
		return null;
	}

	@Override
	public void recreateStructures(Chunk chunk, int x, int z) {
	}

	@Override
	public boolean isInsideStructure(World world, String structureName, BlockPos pos) {
		return shouldGenerateBedrock;
	}
}