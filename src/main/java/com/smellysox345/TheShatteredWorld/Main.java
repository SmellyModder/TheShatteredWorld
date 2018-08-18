package com.smellysox345.TheShatteredWorld;

import com.smellysox345.TheShatteredWorld.QuestGui.GuiHandlerRegistry;
import com.smellysox345.TheShatteredWorld.World.gen.structures.WorldGenCustomStructures;
import com.smellysox345.TheShatteredWorld.init.ModBlocks;
import com.smellysox345.TheShatteredWorld.init.ModItems;
import com.smellysox345.TheShatteredWorld.potion.Deformation;
import com.smellysox345.TheShatteredWorld.potion.PotionTypeRegistry;
import com.smellysox345.TheShatteredWorld.potion.Shroom_Bounce;
import com.smellysox345.TheShatteredWorld.proxy.CommonProxy;
import com.smellysox345.TheShatteredWorld.util.Reference;
import com.smellysox345.TheShatteredWorld.util.handlers.RegistryHandler;
import com.smellysox345.TheShatteredWorld.util.handlers.WizardRightHandler;
import com.smellysox345.TheShatteredWorld.util.handlers.WizardTrades;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.registry.VillagerRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import smellysox345.lib.Config;

@Mod(modid = Reference.MOD_ID, name = Reference.NAME, version = Reference.VERSION)
public class Main {

    public static final Potion DEFORMATION_POTION = new Deformation();
    public static final Potion BOUNCE_POTION = new Shroom_Bounce();
    @Instance
    public static Main instance;
    @SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.COMMON_PROXY_CLASS)
    public static CommonProxy proxy;
    public static CreativeTabs refracteditems = new CreativeTabs("refracteditems") {
        @Override
        public ItemStack getTabIconItem() {
            return new ItemStack(ModItems.PRISM);
        }
    };
    public static CreativeTabs refractedblocks = new CreativeTabs("refractedblocks") {
        @Override
        public ItemStack getTabIconItem() {
            return new ItemStack(ModBlocks.CRYSTAL_BLOCK);
        }
    };
    public static CreativeTabs shatteredworldweapons = new CreativeTabs("refractedweapons") {
        @Override
        public ItemStack getTabIconItem() {
            return new ItemStack(ModItems.CRYSTAL_SWORD);
        }
    };
    public static CreativeTabs shatteredworldtools = new CreativeTabs("refractedtools") {
        @Override
        public ItemStack getTabIconItem() {
            return new ItemStack(ModItems.CRYSTAL_SHOVEL);
        }
    };
    public static CreativeTabs shatteredworldarmors = new CreativeTabs("refractedarmors") {
        @Override
        public ItemStack getTabIconItem() {
            return new ItemStack(ModItems.CRYSTAL_HELMET);
        }
    };
    public static CreativeTabs shatteredworldfoods = new CreativeTabs("refractedfoods") {
        @Override
        public ItemStack getTabIconItem() {
            return new ItemStack(ModItems.CORRUPTEDCOOKEDBEEF);
        }
    };
    public static CreativeTabs shatteredworldplants = new CreativeTabs("refractedplants") {
        @Override
        public ItemStack getTabIconItem() {
            return new ItemStack(ModBlocks.SAPLING);
        }
    };

    @EventHandler
    public static void preinit(FMLPreInitializationEvent event) {
        Config.load(event);
        RegistryHandler.preInitRegistries();
        ForgeRegistries.POTIONS.register(DEFORMATION_POTION);
        ForgeRegistries.POTIONS.register(BOUNCE_POTION);
        PotionTypeRegistry.registerPotionTypes();
    }

    @SideOnly(Side.CLIENT)
    @EventHandler
    public static void preinitSide(FMLPreInitializationEvent event) {
        RegistryHandler.preInitRegistriesSide();
    }

    @EventHandler
    public static void init(FMLInitializationEvent event) {
        RegistryHandler.initRegistries();
        RegistryHandler.otherRegistries();
    }

    @EventHandler
    public static void Postinit(FMLPostInitializationEvent event) {
        GameRegistry.registerWorldGenerator(new WorldGenCustomStructures(), 0);
        NetworkRegistry.INSTANCE.registerGuiHandler(instance, GuiHandlerRegistry.getInstance());
        MinecraftForge.EVENT_BUS.register(WizardRightHandler.class);

    }

    @EventHandler
    public static void serverInit(FMLServerStartingEvent event) {

        RegistryHandler.serverRegistries(event);

    }

}

