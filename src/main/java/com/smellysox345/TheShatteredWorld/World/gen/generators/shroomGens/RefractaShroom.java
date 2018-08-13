package com.smellysox345.TheShatteredWorld.World.gen.generators.shroomGens;


import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.server.MinecraftServer;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.util.Mirror;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraft.world.gen.structure.template.PlacementSettings;
import net.minecraft.world.gen.structure.template.Template;
import net.minecraft.world.gen.structure.template.TemplateManager;

import java.util.Random;

import com.smellysox345.TheShatteredWorld.util.Reference;

public class RefractaShroom extends WorldGenerator {

    private int xPos;
    private int yPos;
    private int zPos;

    @Override
    public boolean generate(World world, Random rand, BlockPos pos) {
    	if (rand.nextFloat() < .34) {
            if (!world.isRemote) {
                WorldServer worldserver = (WorldServer) world;
                MinecraftServer minecraftserver = world.getMinecraftServer();
                TemplateManager templatemanager = worldserver.getStructureTemplateManager();
                ResourceLocation loc = new ResourceLocation(Reference.MOD_ID, "shroom_r_r");
                Template template = templatemanager.get(minecraftserver, loc);

                if (template != null) {
                    IBlockState iblockstate = world.getBlockState(pos);
                    world.notifyBlockUpdate(pos, iblockstate, iblockstate, 3);
                    PlacementSettings placementsettings = (new PlacementSettings()).setMirror(Mirror.NONE)
                            .setRotation(Rotation.NONE).setIgnoreEntities(true).setChunk(null)
                            .setReplacedBlock(null).setIgnoreStructureBlock(true);
                    template.addBlocksToWorld(world, pos, placementsettings);
                }
            }
        }
		return true;
    }

    }

   
   
