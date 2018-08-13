package smellysox345.lib;

import com.smellysox345.TheShatteredWorld.util.Reference;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class Config {
	private static final String LANG_PREFIX = Reference.MOD_ID + ".config.";

	private static Configuration config;
	
	public static int ShatteredWorldDimId;

	public static void load(FMLPreInitializationEvent event) {
		config = new Configuration(event.getSuggestedConfigurationFile());
		reloadConfig();

		MinecraftForge.EVENT_BUS.register(Config.class);
	}

	private static void reloadConfig() {
		//Basics
		ShatteredWorldDimId = config.getInt("ShatteredWorldDimId", Configuration.CATEGORY_GENERAL, -9, -150, 150, " Use for compatibility purposes.", LANG_PREFIX + "ShatteredWorldDimId");
		if (config.hasChanged()) {
			config.save();
		}
	}

	@SubscribeEvent
	public static void onConfigChanged(ConfigChangedEvent.OnConfigChangedEvent event) {
		if (event.getModID().equals(Reference.MOD_ID)) {
			reloadConfig();
		}
	}
}