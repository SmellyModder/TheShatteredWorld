package com.smellysox345.TheShatteredWorld.tileentity.gui;

import com.smellysox345.TheShatteredWorld.blocks.container.ContainerShroomChest;
import com.smellysox345.TheShatteredWorld.tileentity.TileEntityShroomChest;
import com.smellysox345.TheShatteredWorld.util.Reference;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.util.ResourceLocation;

public class GuiShroomChest extends GuiContainer{

	private static final ResourceLocation GUI_CHEST = new ResourceLocation(Reference.MOD_ID + ":textures/gui/container/shroom_chest_gui.png");
	private final InventoryPlayer playerInventory;
	private final TileEntityShroomChest te;
			
	public GuiShroomChest(InventoryPlayer playerInventory, TileEntityShroomChest chestInventory, EntityPlayer player) {
		super(new ContainerShroomChest(playerInventory, chestInventory, player));
		this.playerInventory = playerInventory;
		this.te = chestInventory;
		
		this.xSize = 179;
		this.ySize = 256;
	}

	@Override
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) 
	{
		this.fontRenderer.drawString(this.te.getDisplayName().getUnformattedText(), 8, 6, 3121919);
		this.fontRenderer.drawString(this.playerInventory.getDisplayName().getUnformattedText(), 8, this.ySize - 92, 3121919);
	}
	
	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY)
	{
		GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
		this.mc.getTextureManager().bindTexture(GUI_CHEST);
		this.drawTexturedModalRect(this.guiLeft, this.guiTop, 0, 0, this.xSize, this.ySize);
	}
}
