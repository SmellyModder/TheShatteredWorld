package com.smellysox345.TheShatteredWorld.util.handlers;

import com.smellysox345.TheShatteredWorld.QuestGui.GuideGui;
import com.smellysox345.TheShatteredWorld.entity.NPCShroomWizard;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.Random;

public class WizardRightHandler {
    @SideOnly(Side.CLIENT)
    @SubscribeEvent
    public static void getEntityRightClick(PlayerInteractEvent.EntityInteract event) {
        if (event.getTarget() instanceof NPCShroomWizard) {
            if (event.getWorld().isRemote) {
                if (GuiScreen.isShiftKeyDown()) {
                    Minecraft.getMinecraft().displayGuiScreen(new GuideGui(event.getWorld()));
                } else {
                    return;
                }
            }
        } else if ((event.getTarget() instanceof EntityVillager)) {
            EntityVillager villager = (EntityVillager) event.getTarget();
            if (villager.getProfession() == 5) {
                event.setCanceled(true);
            }
        }
    }
}
