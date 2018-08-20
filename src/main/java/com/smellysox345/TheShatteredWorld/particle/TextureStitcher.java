package com.smellysox345.TheShatteredWorld.particle;

import com.smellysox345.TheShatteredWorld.util.Reference;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.TextureStitchEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class TextureStitcher {
    @SubscribeEvent
    public void stitcherEventPre(TextureStitchEvent.Pre event) {
        ResourceLocation riftTex = new ResourceLocation(Reference.MODID, "particle/fireballparticle");
        event.getMap().registerSprite(riftTex);
    }
}