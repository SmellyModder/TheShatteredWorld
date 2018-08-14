package com.smellysox345.TheShatteredWorld.init;

import java.util.ArrayList;
import java.util.List;

import com.smellysox345.TheShatteredWorld.blocks.CrystalBlock;
import com.smellysox345.TheShatteredWorld.blocks.RefractedCactus;
import com.smellysox345.TheShatteredWorld.blocks.RefractedSandBlock;
import com.smellysox345.TheShatteredWorld.blocks.RefractedStone;
import com.smellysox345.TheShatteredWorld.blocks.DimensionStuff.BlockTeleporter;
import com.smellysox345.TheShatteredWorld.blocks.Summoner.BlockSpiderSack;
import com.smellysox345.TheShatteredWorld.blocks.Summoner.SpiderQueenEgg;
import com.smellysox345.TheShatteredWorld.blocks.TreeStuff.BlockDirts;
import com.smellysox345.TheShatteredWorld.blocks.TreeStuff.BlockLeaf;
import com.smellysox345.TheShatteredWorld.blocks.TreeStuff.BlockLogs;
import com.smellysox345.TheShatteredWorld.blocks.TreeStuff.BlockPlanks;
import com.smellysox345.TheShatteredWorld.blocks.TreeStuff.BlockSaplings;
import com.smellysox345.TheShatteredWorld.blocks.TreeStuff.magic.EyeTreeLeavesDefault;
import com.smellysox345.TheShatteredWorld.blocks.TreeStuff.magic.EyeTreeLog;
import com.smellysox345.TheShatteredWorld.blocks.TreeStuff.magic.EyeTreeLogDefault;
import com.smellysox345.TheShatteredWorld.blocks.magic.ForceFieldShroom;
import com.smellysox345.TheShatteredWorld.blocks.shroom.BouncyShroom;
import com.smellysox345.TheShatteredWorld.blocks.shroom.BouncyShroomStem;
import com.smellysox345.TheShatteredWorld.blocks.shroom.RefractedMycelium;
import com.smellysox345.TheShatteredWorld.blocks.shroom.ShroomDirt;
import com.smellysox345.TheShatteredWorld.blocks.shroom.ShroomPlantBase;
import com.smellysox345.TheShatteredWorld.blocks.shroom.ShroomWeb;
import com.smellysox345.TheShatteredWorld.blocks.shroom.nightcrawler.BaseShroom;
import com.smellysox345.TheShatteredWorld.blocks.shroom.nightcrawler.BaseShroomStem;

import net.minecraft.block.Block;
import net.minecraft.block.BlockFalling;
import net.minecraft.block.material.Material;

public class ModBlocks {

	public static final List<Block> BLOCKS = new ArrayList<Block>();
	
	public static final Block CRYSTAL_BLOCK = new CrystalBlock("crystal_block", Material.GLASS);
	public static final BlockFalling REFRACTEDSAND_BLOCK = new RefractedSandBlock("refractedsand_block", Material.SAND);
	public static final Block REFRACTEDSTONE_BLOCK = new RefractedStone("refractedstone_block", Material.ROCK);
	public static final Block REFRACTEDCOBBLESTONE_BLOCK = new RefractedStone("refractedcobblestone_block", Material.ROCK);
	public static final Block REFRACTED_CACTUS = new RefractedCactus("refractedcactus_block", Material.CACTUS);
	public static final Block DIRT = new BlockDirts("dirts");
	
	//Wood
	public static final Block LOGS = new BlockLogs("log");
	public static final Block EYE_TREE = new EyeTreeLog("eye_tree", Material.WOOD);
	public static final Block EYE_TREE_DEFAULT = new EyeTreeLogDefault("eye_tree_default", Material.WOOD);
	public static final Block PLANKS = new BlockPlanks("planks");
	public static final Block LEAVES = new BlockLeaf("leaves");
	public static final Block EYE_LEAVES_DEFAULT = new EyeTreeLeavesDefault("eye_tree_leaves_default", Material.LEAVES);
	public static final Block SAPLING = new BlockSaplings("saplings");
	
	//Portals
	public static final Block R_PORTAL = new BlockTeleporter("refractedportal_block", Material.PORTAL);
	
	//Spawner's
	public static final Block SPIDEREGG_BLOCK = new SpiderQueenEgg("spider_egg", Material.DRAGON_EGG);
	public static final Block SPIDERSACK_BLOCK = new BlockSpiderSack("spider_eggsack", Material.DRAGON_EGG);
	
	//Shroom Blocks
	public static final Block SHROOMWEB_BLOCK = new ShroomWeb("shroom_web", Material.WEB);
	public static final Block MYCELIUM_REFRACTED_BLOCK = new RefractedMycelium("r_mycelium", Material.GROUND);
	public static final Block MYCELIUM_DIRT_BLOCK = new ShroomDirt("rd_mycelium", Material.GROUND);
	public static final Block REFRACTA_SHROOM = new ShroomPlantBase("r_shroom", Material.GOURD);
	public static final Block REFRACTISTEM_SHROOM = new BaseShroomStem("refractistem_block", Material.GOURD);
	public static final Block NIGHTCRAWLER_SHROOM = new ShroomPlantBase("night_shroom", Material.GOURD);
	public static final Block NIGHTCRAWLERSTEM_SHROOM = new BaseShroomStem("nightcrawlershroomstem_block", Material.GOURD);
	public static final Block GRASS_SHROOM = new ShroomPlantBase("g_shroom", Material.GOURD);
	public static final Block PINKI_SHROOM = new ShroomPlantBase("p_shroom", Material.GOURD);
	public static final Block PINK_SHROOM = new BaseShroom("pinkshroom_block", Material.GOURD);
	public static final Block PINK_SHROOM_STEM = new BaseShroomStem("pinkshroomstem_block", Material.GOURD);
	public static final Block GRASS_S_SHROOM = new BaseShroom("grassshroom_block", Material.GOURD);
	public static final Block GRASS_STEM_SHROOM = new BaseShroomStem("grassshroomstem_block", Material.GOURD);
	public static final Block NIGHTCRAWLERSHROOM_BLOCK = new BaseShroom("nightcrawlershroom_block", Material.GOURD);
	public static final Block REFRACTISHROOM_BLOCK = new BaseShroom("refractishroom_block", Material.GOURD);
	public static final Block BOUNCYSHROOM_BLOCK = new BouncyShroom("bouncyshroom_block", Material.GOURD);
	public static final Block BOUNCYSHROOMSTEM_BLOCK = new BouncyShroomStem("bouncyshroomstem_block", Material.GOURD);
	public static final Block SHROOM_SHIELD = new ForceFieldShroom("force_field_s", Material.ICE);
}
