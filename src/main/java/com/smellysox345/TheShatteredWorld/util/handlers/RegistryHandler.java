package com.smellysox345.TheShatteredWorld.util.handlers;

import com.smellysox345.TheShatteredWorld.World.commands.CommandDimensionTP;
import com.smellysox345.TheShatteredWorld.World.gen.WorldGenCustomTrees;
import com.smellysox345.TheShatteredWorld.World.gen.generators.tree.WorldGenSpookyTrees;
import com.smellysox345.TheShatteredWorld.init.*;
import com.smellysox345.TheShatteredWorld.util.interfaces.IHasModel;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.registry.VillagerRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;


@EventBusSubscriber
public class RegistryHandler {
    @SubscribeEvent
    public static void registerTrades(RegistryEvent.Register<VillagerRegistry.VillagerProfession> event) {
        VillagerRegistry.VillagerProfession nitwit = ForgeRegistries.VILLAGER_PROFESSIONS.getValue(new ResourceLocation("minecraft:nitwit"));
        nitwit.getCareer(5).addTrade(1,new WizardTrades());
    }
    @SubscribeEvent
    public static void onItemRegister(RegistryEvent.Register<Item> event) {
        event.getRegistry().registerAll(ModItems.ITEMS.toArray(new Item[0]));
    }

    @SubscribeEvent
    public static void onBlockRegister(RegistryEvent.Register<Block> event) {
        event.getRegistry().registerAll(ModBlocks.BLOCKS.toArray(new Block[0]));
    }

    @SubscribeEvent
    public static void onModelRegister(ModelRegistryEvent event) {
        for (Item item : ModItems.ITEMS) {
            if (item instanceof IHasModel) {
                ((IHasModel) item).registerModels();
            }
        }

        for (Block block : ModBlocks.BLOCKS) {
            if (block instanceof IHasModel) {
                ((IHasModel) block).registerModels();
            }
        }


    }

    public static void preInitRegistries() {

        EntityInit.registerEntities();
        EntityInit.registerEntities2();
        DimensionInit.registerDimensions();
    }

    @SideOnly(Side.CLIENT)
    public static void preInitRegistriesSide() {

        RenderHandler.registerEntityRenders();
    }

    public static void initRegistries() {

        SoundHandler.registerSounds();

    }

    public static void otherRegistries() {

        GameRegistry.registerWorldGenerator(new WorldGenCustomTrees(), 0);
        GameRegistry.registerWorldGenerator(new WorldGenSpookyTrees(), 0);
        BiomeInit.registerBiomes();
    }

    public static void serverRegistries(FMLServerStartingEvent event) {

        event.registerServerCommand(new CommandDimensionTP());

    }

}
