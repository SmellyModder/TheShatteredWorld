package com.smellysox345.TheShatteredWorld.potion;

import com.smellysox345.TheShatteredWorld.Main;

import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class DEvent {

	@SubscribeEvent
	public static void onBlunder(TickEvent.PlayerTickEvent event)
	{
		boolean blunder = false;
		if(event.player.isPotionActive(Main.DEFORMATION_POTION))
			blunder = true;
			
	}
}
