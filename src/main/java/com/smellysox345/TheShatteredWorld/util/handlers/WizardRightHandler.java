package com.smellysox345.TheShatteredWorld.util.handlers;

import com.smellysox345.TheShatteredWorld.entity.NPCShroomWizard;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class WizardRightHandler {

    @SubscribeEvent
    public static void getEntityRightClick(PlayerInteractEvent.EntityInteract event) {
        if (event.getEntity() instanceof NPCShroomWizard) {
            System.out.println("Yo");
        }
    }
}
