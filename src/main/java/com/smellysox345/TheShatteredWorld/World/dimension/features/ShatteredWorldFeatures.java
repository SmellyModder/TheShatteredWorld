package com.smellysox345.TheShatteredWorld.World.dimension.features;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import javax.annotation.Nullable;

import com.google.common.collect.Lists;
import com.smellysox345.TheShatteredWorld.World.dimension.provider.SWBiomeProvider;
import com.smellysox345.TheShatteredWorld.World.dimension.shattered.ShatteredWorld;
import com.smellysox345.TheShatteredWorld.init.BiomeInit;
import com.smellysox345.TheShatteredWorld.util.Reference;

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biome.SpawnListEntry;
import net.minecraft.world.gen.MapGenBase;
import net.minecraft.world.gen.structure.MapGenStructureIO;

public enum ShatteredWorldFeatures {
	
	NOTHING    ( 0, "no_feature"       , false) { { this.enableDecorations().disableStructure(); } },
	NAGROT_LAIR ( 1, "nagrot_lair", true ) {
		{
			this.enableDecorations().enableTerrainAlterations();
		}
	},
	SHROOM_CAVE ( 2, "medium_hollow_hill", true ) {
		{
			this.enableDecorations().enableTerrainAlterations();
		}
	},
	SHROOM_VILLAGE ( 3, "large_hollow_hill", true ) {
		{
			this.enableDecorations().enableTerrainAlterations();
		}
	},
	ABOMINABLE_SNOWGOLEM ( 2, "ice_lair", true ) {
		{
			this.enableTerrainAlterations();

			//MapGenStructureIO.registerStructure(StructureStartHedgeMaze.class, "TFHedge");
			//MapGenStructureIO.registerStructureComponent(ComponentTFHedgeMaze.class, "TFHedge");
		}

	},
	JUNGLE_DWELLING ( 3, "jungle_dwelling", true ) {
		{
			this.enableTerrainAlterations();

			//MapGenStructureIO.registerStructureComponent(ComponentNagaCourtyardMain.class, "TFNaga");
			//NagaCourtyardPieces.registerPieces();
		}

	},
	WITCH_HUT ( 1, "lich_tower", true) {
		{
		}

	},
	DESERT_TEMPLE ( 2, "ice_tower", true) {
		{
			//TFIceTowerPieces.registerPieces();
		}

	},
	OCEAN_TRENCH ( 1, "quest_island", false ) { { this.disableStructure(); } },
	OCEAN_TEMPLE  ( 1, "quest_grove" , true  ) {
		{
			this.enableTerrainAlterations();

			//MapGenStructureIO.registerStructure(StructureStartQuestGrove.class, "TFQuest1");
			//MapGenStructureIO.registerStructureComponent(ComponentTFQuestGrove.class, "TFQuest1");
		}

	},
	PLC_1    ( 1, "druid_grove"   , false                                                                    ) { { this.disableStructure(); } },
	PLC_2 ( 3, "floating_ruins", false                                                                    ) { { this.disableStructure(); } },
	PLC_3     ( 2, "hydra_lair"    , true) {
		{
			this.enableTerrainAlterations();

			//MapGenStructureIO.registerStructure(StructureStartHydraLair.class, "TFHydra");
			//MapGenStructureIO.registerStructureComponent(ComponentTFHydraLair.class, "TFHydra");
		}

	},
	PLC_8 ( 3, "labyrinth", true) {
		{
			this.enableDecorations();

			//TFMinotaurMazePieces.registerPieces();
		}

	},
	PLC_9 ( 1, "dark_tower", true) {
		{
			//TFDarkTowerPieces.registerPieces();
		}

	},
	KNIGHT_STRONGHOLD ( 3, "knight_stronghold", true) {
		{
			this.enableDecorations().disableProtectionAura();

			//TFStrongholdPieces.registerPieces();
		}
	},
	WORLD_TREE ( 3, "world_tree", false                                                               ) { { this.disableStructure(); } },
	YETI_CAVE  ( 2, "yeti_lairs", true) {
		{
			this.enableDecorations().enableTerrainAlterations();

			//MapGenStructureIO.registerStructure(StructureStartYetiCave.class, "TFYeti");
			//MapGenStructureIO.registerStructureComponent(ComponentTFYetiCave.class, "TFYeti");

			//this.addMonster(EntityTFYeti.class, 10, 4, 4);
		}

	},
	// TODO split cloud giants from this
	PLC_10 ( 3, "troll_lairs", true) {
		{
			this.enableDecorations().enableTerrainAlterations().disableProtectionAura();

			//TFTrollCavePieces.registerPieces();
		}

	},
	THE_LIGHTHOUSE ( 3, "final_castle", true) {
		{
			//TFFinalCastlePieces.registerFinalCastlePieces();

			// plain parts of the castle, like the tower maze
		}

	},
	PLC_11 ( 2, "mushroom_tower", true ) {
		{
			//TFMushroomTowerPieces.registerPieces();
		}
	};

	public int size;
	public String name;
	private final boolean shouldHaveFeatureGenerator;
	public boolean areChunkDecorationsEnabled;
	public boolean isStructureEnabled;
	public boolean isTerrainAltered;
	private List<List<SpawnListEntry>> spawnableMonsterLists;
	private List<SpawnListEntry> ambientCreatureList;
	private List<SpawnListEntry> waterCreatureList;
	private final ResourceLocation[] requiredAdvancements;
	public boolean hasProtectionAura;

	private long lastSpawnedHintMonsterTime;

	private static final int maxSize = Arrays.stream(values()).mapToInt(v -> v.size).max().orElse(0);


	ShatteredWorldFeatures(int parSize, String parName, boolean featureGenerator, ResourceLocation... requiredAdvancements) {
		this.size = parSize;
		this.name = parName;
		this.areChunkDecorationsEnabled = false;
		this.isStructureEnabled = true;
		this.isTerrainAltered = false;
		this.spawnableMonsterLists = new ArrayList<>();
		this.ambientCreatureList = new ArrayList<>();
		this.waterCreatureList = new ArrayList<>();
		this.hasProtectionAura = true;

		this.requiredAdvancements = requiredAdvancements;

		shouldHaveFeatureGenerator = featureGenerator;
	}

	public static int getMaxSize() {
		return maxSize;
	}

	/**
	 * doesn't require modid
	 */
	public static ShatteredWorldFeatures getFeatureByName(String name) {
		for (ShatteredWorldFeatures feature : ShatteredWorldFeatures.values()) {
			if (feature != null && feature.name.equalsIgnoreCase(name))
				return feature;
		}
		return NOTHING;
	}

	/**
	 * modid sensitive
	 */
	public static ShatteredWorldFeatures getFeatureByName(ResourceLocation name) {
		if (name.getResourceDomain().equalsIgnoreCase(Reference.MODID))
			return getFeatureByName(name.getResourcePath());
		return NOTHING;
	}

	public static ShatteredWorldFeatures getFeatureByID(int id) {
		return id < ShatteredWorldFeatures.values().length ? ShatteredWorldFeatures.values()[id] : NOTHING;
	}

	public static int getFeatureID(int mapX, int mapZ, World world) {
		return getFeatureAt(mapX, mapZ, world).ordinal();
	}

	public static ShatteredWorldFeatures getFeatureAt(int mapX, int mapZ, World world) {
		return generateFeature(mapX >> 4, mapZ >> 4, world);
	}

	public static boolean isInFeatureChunk(World world, int mapX, int mapZ) {
		int chunkX = mapX >> 4;
		int chunkZ = mapZ >> 4;
		BlockPos cc = getNearestCenterXYZ(chunkX, chunkZ, world);

		return chunkX == (cc.getX() >> 4) && chunkZ == (cc.getZ() >> 4);
	}

	/**
	 * Turns on biome-specific decorations like grass and trees near this feature.
	 */
	public ShatteredWorldFeatures enableDecorations() {
		this.areChunkDecorationsEnabled = true;
		return this;
	}

	/**
	 * Tell the chunkgenerator that we don't have an associated structure.
	 */
	public ShatteredWorldFeatures disableStructure() {
		this.isStructureEnabled = false;
		return this;
	}

	/**
	 * Tell the chunkgenerator that we want the terrain changed nearby.
	 */
	public ShatteredWorldFeatures enableTerrainAlterations() {
		this.isTerrainAltered = true;
		return this;
	}

	public ShatteredWorldFeatures disableProtectionAura() {
		this.hasProtectionAura = false;
		return this;
	}

	/**
	 * Add a monster to spawn list 0
	 */
	public ShatteredWorldFeatures addMonster(Class<? extends EntityLiving> monsterClass, int weight, int minGroup, int maxGroup) {
		this.addMonster(0, monsterClass, weight, minGroup, maxGroup);
		return this;
	}

	/**
	 * Add a monster to a specific spawn list
	 */
	public ShatteredWorldFeatures addMonster(int listIndex, Class<? extends EntityLiving> monsterClass, int weight, int minGroup, int maxGroup) {
		List<SpawnListEntry> monsterList;
		if (this.spawnableMonsterLists.size() > listIndex) {
			monsterList = this.spawnableMonsterLists.get(listIndex);
		} else {
			monsterList = new ArrayList<>();
			this.spawnableMonsterLists.add(listIndex, monsterList);
		}

		monsterList.add(new SpawnListEntry(monsterClass, weight, minGroup, maxGroup));
		return this;
	}

	/**
	 * Add a water creature
	 */
	public ShatteredWorldFeatures addWaterCreature(Class<? extends EntityLiving> monsterClass, int weight, int minGroup, int maxGroup) {
		this.waterCreatureList.add(new SpawnListEntry(monsterClass, weight, minGroup, maxGroup));
		return this;
	}

	/**
	 * @return The type of feature directly at the specified Chunk coordinates
	 */
	public static ShatteredWorldFeatures getFeatureDirectlyAt(int chunkX, int chunkZ, World world) {
		if (world.getBiomeProvider() instanceof SWBiomeProvider && isInFeatureChunk(world, chunkX << 4, chunkZ << 4))
			return getFeatureAt(chunkX << 4, chunkZ << 4, world);

		return NOTHING;
	}

	/**
	 * What feature would go in this chunk.  Called when we know there is a feature, but there is no cache data,
	 * either generating this chunk for the first time, or using the magic map to forecast beyond the edge of the world.
	 */

	public static ShatteredWorldFeatures generateFeature(int chunkX, int chunkZ, World world) {
		// FIXME Remove block comment start-marker to enable debug
		/*if (true) {
			return NAGA_COURTYARD;
		}//*/

		// set the chunkX and chunkZ to the center of the biome
		chunkX = Math.round(chunkX / 16F) * 16;
		chunkZ = Math.round(chunkZ / 16F) * 16;

		// what biome is at the center of the chunk?
		Biome biomeAt = world.getBiome(new BlockPos((chunkX << 4) + 8, 0, (chunkZ << 4) + 8));

		// glaciers have ice towers
		if (biomeAt == BiomeInit.REFRACTED_FOREST) {
			return NOTHING;
		}
		// swamp has labyrinth
		if (biomeAt == BiomeInit.RF_SHROOM) {
			return SHROOM_CAVE;
		}

		// dark forests have their own things
		if (biomeAt == BiomeInit.R_ROOFED_FOREST) {
			return NAGROT_LAIR;
		}

		int regionOffsetX = Math.abs((chunkX + 64 >> 4) % 8);
		int regionOffsetZ = Math.abs((chunkZ + 64 >> 4) % 8);

		// plant two lich towers near the center of each 2048x2048 map area
		if ((regionOffsetX == 4 && regionOffsetZ == 5) || (regionOffsetX == 4 && regionOffsetZ == 3)) {
			return NOTHING;
		}

		// also two nagas
		if ((regionOffsetX == 5 && regionOffsetZ == 4) || (regionOffsetX == 3 && regionOffsetZ == 4)) {
			return NOTHING;
		}

		// get random value
		// okay, well that takes care of most special cases
		switch (new Random(world.getSeed() + chunkX * 25117 + chunkZ * 151121).nextInt(16)) {
			default:
			case 0:
			case 1:
			case 2:
			case 3:
			case 4:
			case 5:
				return NOTHING;
			case 6:
			case 7:
			case 8:
				return NOTHING;
			case 9:
				return NOTHING;
			case 10:
			case 11:
				return NOTHING;
			case 12:
			case 13:
				return NOTHING;
			case 14:
			case 15:
				return NOTHING;
		}
	}

	/**
	 * @return The feature nearest to the specified chunk coordinates
	 */
	public static ShatteredWorldFeatures getNearestFeature(int cx, int cz, World world) {
		for (int rad = 1; rad <= maxSize; rad++) {
			for (int x = -rad; x <= rad; x++) {
				for (int z = -rad; z <= rad; z++) {
					ShatteredWorldFeatures directlyAt = getFeatureDirectlyAt(x + cx, z + cz, world);
					if (directlyAt.size == rad) {
						return directlyAt;
					}
				}
			}
		}

		return NOTHING;
	}

	// [Vanilla Copy] from MapGenStructure#findNearestStructurePosBySpacing; changed 2nd param to be TFFeature instead of MapGenStructure
	@Nullable
	public static BlockPos findNearestFeaturePosBySpacing(World worldIn, ShatteredWorldFeatures feature, BlockPos blockPos, int p_191069_3_, int p_191069_4_, int p_191069_5_, boolean p_191069_6_, int p_191069_7_, boolean findUnexplored) {
		int i = blockPos.getX() >> 4;
		int j = blockPos.getZ() >> 4;
		int k = 0;

		for (Random random = new Random(); k <= p_191069_7_; ++k) {
			for (int l = -k; l <= k; ++l) {
				boolean flag = l == -k || l == k;

				for (int i1 = -k; i1 <= k; ++i1) {
					boolean flag1 = i1 == -k || i1 == k;

					if (flag || flag1) {
						int j1 = i + p_191069_3_ * l;
						int k1 = j + p_191069_3_ * i1;

						if (j1 < 0) {
							j1 -= p_191069_3_ - 1;
						}

						if (k1 < 0) {
							k1 -= p_191069_3_ - 1;
						}

						int l1 = j1 / p_191069_3_;
						int i2 = k1 / p_191069_3_;
						Random random1 = worldIn.setRandomSeed(l1, i2, p_191069_5_);
						l1 = l1 * p_191069_3_;
						i2 = i2 * p_191069_3_;

						if (p_191069_6_) {
							l1 = l1 + (random1.nextInt(p_191069_3_ - p_191069_4_) + random1.nextInt(p_191069_3_ - p_191069_4_)) / 2;
							i2 = i2 + (random1.nextInt(p_191069_3_ - p_191069_4_) + random1.nextInt(p_191069_3_ - p_191069_4_)) / 2;
						} else {
							l1 = l1 + random1.nextInt(p_191069_3_ - p_191069_4_);
							i2 = i2 + random1.nextInt(p_191069_3_ - p_191069_4_);
						}

						MapGenBase.setupChunkSeed(worldIn.getSeed(), random, l1, i2);
						random.nextInt();

						// Check changed for TFFeature
						if (ShatteredWorldFeatures.getFeatureAt(l1 << 4, i2 << 4, worldIn) == feature) {
							if (!findUnexplored || !worldIn.isChunkGeneratedAt(l1, i2)) {
								return new BlockPos((l1 << 4) + 8, 64, (i2 << 4) + 8);
							}
						} else if (k == 0) {
							break;
						}
					}
				}

				if (k == 0) {
					break;
				}
			}
		}

		return null;
	}

	/**
	 * @return The feature in the chunk "region"
	 */
	public static ShatteredWorldFeatures getFeatureForRegion(int chunkX, int chunkZ, World world) {
		//just round to the nearest multiple of 16 chunks?
		int featureX = Math.round(chunkX / 16F) * 16;
		int featureZ = Math.round(chunkZ / 16F) * 16;

		return ShatteredWorldFeatures.generateFeature(featureX, featureZ, world);
	}

	/**
	 * @return The feature in the chunk "region"
	 */
	public static ShatteredWorldFeatures getFeatureForRegionPos(int posX, int posZ, World world) {
		//just round to the nearest multiple of 16 chunks?
		int featureX = Math.round((posX >> 4) / 16F) * 16;
		int featureZ = Math.round((posZ >> 4) / 16F) * 16;

		return ShatteredWorldFeatures.generateFeature(featureX, featureZ, world);
	}

	/**
	 * If we're near a hollow hill, this returns relative block coordinates indicating the center of that hill relative to the current chunk block coordinate system.
	 */
	public static int[] getNearestCenter(int cx, int cz, World world) {
		for (int rad = 1; rad <= maxSize; rad++) {
			for (int x = -rad; x <= rad; x++) {
				for (int z = -rad; z <= rad; z++) {
					if (getFeatureDirectlyAt(x + cx, z + cz, world).size == rad) {
						return new int[]{x * 16 + 8, z * 16 + 8};
					}
				}
			}
		}
		int[] no = {0, 0};
		return no;
	}

	/**
	 * Given some coordinates, return the center of the nearest feature.
	 * <p>
	 * At the moment, with how features are distributed, just get the closest multiple of 256 and add +8 in both directions.
	 * <p>
	 * Maybe in the future we'll have to actually search for a feature chunk nearby, but for now this will work.
	 */
	public static BlockPos getNearestCenterXYZ(int cx, int cz, World world) {
		// generate random number for the whole biome area
		int regionX = (cx + 8) >> 4;
		int regionZ = (cz + 8) >> 4;

		long seed = (long) (regionX * 3129871) ^ (long) regionZ * 116129781L;
		seed = seed * seed * 42317861L + seed * 7L;

		int num0 = (int) (seed >> 12 & 3L);
		int num1 = (int) (seed >> 15 & 3L);
		int num2 = (int) (seed >> 18 & 3L);
		int num3 = (int) (seed >> 21 & 3L);

		// slightly randomize center of biome (+/- 3)
		int centerX = 8 + num0 - num1;
		int centerZ = 8 + num2 - num3;

		// centers are offset strangely depending on +/-
		int ccz;
		if (regionZ >= 0) {
			ccz = (regionZ * 16 + centerZ - 8) * 16 + 8;
		} else {
			ccz = (regionZ * 16 + (16 - centerZ) - 8) * 16 + 9;
		}

		int ccx;
		if (regionX >= 0) {
			ccx = (regionX * 16 + centerX - 8) * 16 + 8;
		} else {
			ccx = (regionX * 16 + (16 - centerX) - 8) * 16 + 9;
		}

		return new BlockPos(ccx, ShatteredWorld.SEALEVEL, ccz);//  Math.abs(chunkX % 16) == centerX && Math.abs(chunkZ % 16) == centerZ;
	}

	/**
	 * Returns a list of hostile monsters.  Are we ever going to need passive or water creatures?
	 */
	public List<SpawnListEntry> getSpawnableList(EnumCreatureType par1EnumCreatureType) {
		if (par1EnumCreatureType == EnumCreatureType.MONSTER) {
			return this.getSpawnableList(EnumCreatureType.MONSTER, 0);
		} else if (par1EnumCreatureType == EnumCreatureType.AMBIENT) {
			return this.ambientCreatureList;
		} else if (par1EnumCreatureType == EnumCreatureType.WATER_CREATURE) {
			return this.waterCreatureList;
		} else {
			return Lists.newArrayList();
		}
	}

	/**
	 * Returns a list of hostile monsters in the specified indexed category
	 */
	public List<SpawnListEntry> getSpawnableList(EnumCreatureType par1EnumCreatureType, int index) {
		if (par1EnumCreatureType == EnumCreatureType.MONSTER) {
			if (index >= 0 && index < this.spawnableMonsterLists.size()) {
				return this.spawnableMonsterLists.get(index);
			} else {
				return Lists.newArrayList();
			}
		} else {
			return getSpawnableList(par1EnumCreatureType);
		}
	}
}
