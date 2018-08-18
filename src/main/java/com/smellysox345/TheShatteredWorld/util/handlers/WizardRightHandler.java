package com.smellysox345.TheShatteredWorld.util.handlers;

import com.smellysox345.TheShatteredWorld.QuestGui.GuideGui;
import com.smellysox345.TheShatteredWorld.entity.NPCShroomWizard;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class WizardRightHandler {

    @SubscribeEvent
    public static void getEntityRightClick(PlayerInteractEvent.EntityInteract event) {
        if (event.getTarget() instanceof NPCShroomWizard) {

            if (event.getWorld().isRemote) {
                if (GuiScreen.isShiftKeyDown()) {
                    Minecraft.getMinecraft().displayGuiScreen(new GuideGui(event.getWorld()));
                } else {
                    //TODO Open Shop
                }
            }
        }
    }
}
