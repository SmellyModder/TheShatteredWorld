package com.smellysox345.TheShatteredWorld.quest;

import com.smellysox345.TheShatteredWorld.util.Reference;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.resources.I18n;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class GuideGui extends GuiScreen {
    public static World worldIn;
    private static int bookTotalPages = 1;
    private static ResourceLocation[] bookPageTextures = new ResourceLocation[bookTotalPages];
    private static String[] stringPageText = new String[bookTotalPages];
    private final int bookImageHeight = 228;
    private final int bookImageWidth = 228;
    private int currPage = 0;
    private GuiButton buttonDone;
    private ContentButton contentButton;
    private ContentButton contentButton1;
    private ContentButton contentButton2;
    private ContentButton contentButton3;
    private ContentButton contentButton4;
    private int tempX = 0;

    public GuideGui(World worldIn) {
        GuideGui.worldIn = worldIn;

        switch (tempX) {
            case 0:
                bookPageTextures[0] = new ResourceLocation(Reference.MODID + ":textures/gui/questing/book.png");

                stringPageText[0] = "";
                break;
            case 1:
                bookPageTextures[0] = new ResourceLocation(Reference.MODID + ":textures/gui/book/book1.png");
                bookPageTextures[1] = new ResourceLocation(Reference.MODID + ":textures/gui/book/book2.png");
                bookPageTextures[2] = new ResourceLocation(Reference.MODID + ":textures/gui/book/book3.png");
                bookPageTextures[3] = new ResourceLocation(Reference.MODID + ":textures/gui/book/book4.png");
                bookPageTextures[4] = new ResourceLocation(Reference.MODID + ":textures/gui/book/book5.png");
                bookPageTextures[5] = new ResourceLocation(Reference.MODID + ":textures/gui/book/book6.png");
                bookPageTextures[6] = new ResourceLocation(Reference.MODID + ":textures/gui/book/book.png");
                bookPageTextures[7] = new ResourceLocation(Reference.MODID + ":textures/gui/book/book.png");
                bookPageTextures[8] = new ResourceLocation(Reference.MODID + ":textures/gui/book/book.png");
                bookPageTextures[9] = new ResourceLocation(Reference.MODID + ":textures/gui/book/book.png");
                bookPageTextures[10] = new ResourceLocation(Reference.MODID + ":textures/gui/book/book.png");
                bookPageTextures[11] = new ResourceLocation(Reference.MODID + ":textures/gui/book/book.png");

                stringPageText[0] = "";
                stringPageText[1] = "";
                stringPageText[2] = "";
                stringPageText[3] = "";
                stringPageText[4] = "";
                stringPageText[5] = "";
                //Hints
                stringPageText[6] = "* Arcane materials require a sufficient amount of Visceon Power in order to craft. It is well worth stockpiling those Crystals.\n";
                stringPageText[7] = "* Florus is very time consuming to make, but the payoff is well worth the wait: All Floric tools and weapons are immediately craft-able.\n";
                stringPageText[8] = "";
                stringPageText[9] = "";
                stringPageText[10] = "";
                stringPageText[11] = "";
                break;
            case 2:
                bookPageTextures[0] = new ResourceLocation(Reference.MODID + ":textures/gui/book/book1.png");
                bookPageTextures[1] = new ResourceLocation(Reference.MODID + ":textures/gui/book/book2.png");
                bookPageTextures[2] = new ResourceLocation(Reference.MODID + ":textures/gui/book/book3.png");
                bookPageTextures[3] = new ResourceLocation(Reference.MODID + ":textures/gui/book/book4.png");
                bookPageTextures[4] = new ResourceLocation(Reference.MODID + ":textures/gui/book/book5a.png");
                bookPageTextures[5] = new ResourceLocation(Reference.MODID + ":textures/gui/book/book6a.png");
                bookPageTextures[6] = new ResourceLocation(Reference.MODID + ":textures/gui/book/book.png");
                bookPageTextures[7] = new ResourceLocation(Reference.MODID + ":textures/gui/book/book.png");
                bookPageTextures[8] = new ResourceLocation(Reference.MODID + ":textures/gui/book/book.png");
                bookPageTextures[9] = new ResourceLocation(Reference.MODID + ":textures/gui/book/book.png");
                bookPageTextures[10] = new ResourceLocation(Reference.MODID + ":textures/gui/book/book.png");
                bookPageTextures[11] = new ResourceLocation(Reference.MODID + ":textures/gui/book/book.png");

                stringPageText[0] = "";
                stringPageText[1] = "";
                stringPageText[2] = "";
                stringPageText[3] = "";
                stringPageText[4] = "";
                stringPageText[5] = "";
                //Hints
                stringPageText[6] = "* Vitaem is by far the most difficult material to acquire. The Quazan Serpent is invincible, but with a little secret brew it is possible to knock the beast unconscious for long enough to steal some of its scales.\n";
                stringPageText[7] = "* The only way to forge Vitaem is with the Pervateki Forge. The Forge requires an abhorrent amount of Visceon Magic to stay hot and yet even when cold it seems to resonate some form of energy.\n";
                stringPageText[8] = "";
                stringPageText[9] = "";
                stringPageText[10] = "";
                stringPageText[11] = "";
                break;
            case 3:
                bookPageTextures[0] = new ResourceLocation(Reference.MODID + ":textures/gui/book/book1.png");
                bookPageTextures[1] = new ResourceLocation(Reference.MODID + ":textures/gui/book/book2.png");
                bookPageTextures[2] = new ResourceLocation(Reference.MODID + ":textures/gui/book/book3.png");
                bookPageTextures[3] = new ResourceLocation(Reference.MODID + ":textures/gui/book/book4.png");
                bookPageTextures[4] = new ResourceLocation(Reference.MODID + ":textures/gui/book/book5a.png");
                bookPageTextures[5] = new ResourceLocation(Reference.MODID + ":textures/gui/book/book6b.png");
                bookPageTextures[6] = new ResourceLocation(Reference.MODID + ":textures/gui/book/book7.png");
                bookPageTextures[7] = new ResourceLocation(Reference.MODID + ":textures/gui/book/book8.png");
                bookPageTextures[8] = new ResourceLocation(Reference.MODID + ":textures/gui/book/book.png");
                bookPageTextures[9] = new ResourceLocation(Reference.MODID + ":textures/gui/book/book.png");
                bookPageTextures[10] = new ResourceLocation(Reference.MODID + ":textures/gui/book/book.png");
                bookPageTextures[11] = new ResourceLocation(Reference.MODID + ":textures/gui/book/book.png");

                stringPageText[0] = "";
                stringPageText[1] = "";
                stringPageText[2] = "";
                stringPageText[3] = "";
                stringPageText[4] = "";
                stringPageText[5] = "";
                stringPageText[6] = "";
                stringPageText[7] = "";
                stringPageText[8] = "";
                stringPageText[9] = "";
                stringPageText[10] = "";
                stringPageText[11] = "";
                break;
            case 4:
                bookPageTextures[0] = new ResourceLocation(Reference.MODID + ":textures/gui/book/book1.png");
                bookPageTextures[1] = new ResourceLocation(Reference.MODID + ":textures/gui/book/book2.png");
                bookPageTextures[2] = new ResourceLocation(Reference.MODID + ":textures/gui/book/book3.png");
                bookPageTextures[3] = new ResourceLocation(Reference.MODID + ":textures/gui/book/book4.png");
                bookPageTextures[4] = new ResourceLocation(Reference.MODID + ":textures/gui/book/book5a.png");
                bookPageTextures[5] = new ResourceLocation(Reference.MODID + ":textures/gui/book/book6b.png");
                bookPageTextures[6] = new ResourceLocation(Reference.MODID + ":textures/gui/book/book7.png");
                bookPageTextures[7] = new ResourceLocation(Reference.MODID + ":textures/gui/book/book8.png");
                bookPageTextures[8] = new ResourceLocation(Reference.MODID + ":textures/gui/book/book9.png");
                bookPageTextures[9] = new ResourceLocation(Reference.MODID + ":textures/gui/book/book10.png");
                bookPageTextures[10] = new ResourceLocation(Reference.MODID + ":textures/gui/book/book11.png");
                bookPageTextures[11] = new ResourceLocation(Reference.MODID + ":textures/gui/book/book12.png");

                stringPageText[0] = "";
                stringPageText[1] = "";
                stringPageText[2] = "";
                stringPageText[3] = "";
                stringPageText[4] = "";
                stringPageText[5] = "";
                stringPageText[6] = "";
                stringPageText[7] = "";
                stringPageText[8] = "";
                stringPageText[9] = "";
                stringPageText[10] = "";
                stringPageText[11] = "";
            case 5:
            case 6:
            case 7:
        }
    }
    @Override
    public void initGui() {
        int offsetFromScreenTop = (height / 4);
        int buttonWidth = 70;
        int offsetFromScreenRight = (width / 2) - (buttonWidth / 2);
        int buttonHeight = 20;
        int buttonSpacing = 30;
        buttonList.clear();
        Keyboard.enableRepeatEvents(true);

        buttonDone = new GuiButton(0, (width / 2) + (width / 4), (height / 2) + (height / 4), buttonWidth, buttonHeight, I18n.format("gui.done"));

        buttonList.add(buttonDone);

        buttonList.add(contentButton = new ContentButton(3, (width / 2) - (width / 4), (height / 2) + (height / 4), buttonWidth, buttonHeight, I18n.format("theshatteredworld.gui.home")));
        buttonList.add(contentButton1 = new ContentButton(4, offsetFromScreenRight, offsetFromScreenTop + buttonSpacing, buttonWidth, buttonHeight, I18n.format("theshatteredworld.gui.quest1")));
        buttonList.add(contentButton2 = new ContentButton(5, offsetFromScreenRight, offsetFromScreenTop + buttonSpacing + (buttonHeight), buttonWidth, buttonHeight, I18n.format("theshatteredworld.gui.quest2")));
        buttonList.add(contentButton3 = new ContentButton(6, offsetFromScreenRight, offsetFromScreenTop + buttonSpacing + (buttonHeight * 2), buttonWidth, buttonHeight, I18n.format("theshatteredworld.gui.quest3")));
        buttonList.add(contentButton4 = new ContentButton(7, offsetFromScreenRight, offsetFromScreenTop + buttonSpacing + (buttonHeight * 3), buttonWidth, buttonHeight, I18n.format("theshatteredworld.gui.quest4")));
        //buttonList.add(contentButton4 = new ContentButton(5, offsetFromScreenLeft - 28, 97, 50, 20, I18n.format("thenewjourney.gui.inversion", new Object[0])));
    }

    @Override
    public void updateScreen() {
        contentButton.visible = true;
        contentButton1.visible = true;
        contentButton2.visible = true;
        contentButton3.visible = true;
        contentButton4.visible = true;

        contentButton.enabled = currPage != 0;
        contentButton1.enabled = currPage != 4;
        contentButton2.enabled = currPage != 5;
        contentButton3.enabled = currPage != 6;
        contentButton4.enabled = currPage != 8;
        buttonDone.visible = true;
    }

    @Override
    public void drawScreen(int parWidth, int parHeight, float p_73863_3_) {
        int offsetFromScreenTop = (height / 4);
        int buttonWidth = 70;
        int offsetFromScreenRight = (width / 2) - (buttonWidth / 2);
        int buttonHeight = 20;
        int buttonSpacing = 30;
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        mc.getTextureManager().bindTexture(bookPageTextures[currPage]);
        //int offsetFromScreenLeft = (width - bookImageWidth) / 2;
        //this.drawTexturedModalRect((width - bookImageWidth) / 2, (height - bookImageHeight) / 2, 0, 0, bookImageWidth, bookImageHeight);
        drawScaledCustomSizeModalRect((width - bookImageWidth) / 2, (height - bookImageHeight) / 2, 0F, 0F, bookImageWidth, bookImageHeight, bookImageWidth, bookImageHeight, 228, 228);
        ResourceLocation spiderHead = new ResourceLocation(Reference.MODID + ":textures/gui/head.png");
        mc.getTextureManager().bindTexture(spiderHead);
        drawScaledCustomSizeModalRect(offsetFromScreenRight + buttonWidth, offsetFromScreenTop + buttonSpacing, 0F, 0F, 20, 20, 20, 20, 20, 20);
        super.drawScreen(parWidth, parHeight, p_73863_3_);

        //fontRendererObj.drawSplitString(stringPageText[currPage], offsetFromScreenLeft + 36, 10, 116, 0);
        //this.drawCenteredString(fontRendererObj, stringPageText[currPage], offsetFromScreenLeft + 81, 19, 0);


    }

    @Override
    protected void mouseClickMove(int parMouseX, int parMouseY, int parLastButtonClicked, long parTimeSinceMouseClick) {
    }

    @Override
    protected void actionPerformed(GuiButton parButton) {
        if (parButton == buttonDone) {
            mc.displayGuiScreen(null);
        } else if (parButton == contentButton) {
            //TODO THis is the home button it has no use right now
        } else if (parButton == contentButton1) {
            //TODO Run quest functions
            this.sendChatMessage("Began the Spider Queen Quest!");
            System.out.println("Spider Quest");
        } else if (parButton == contentButton2) {
            //TODO Run quest functions
            System.out.println("No Quest1");
        } else if (parButton == contentButton3) {
            //TODO Run quest functions
            System.out.println("No Quest2");
        } else if (parButton == contentButton4) {
            //TODO Run quest functions
            System.out.println("No Quest3");
        }
    }

    @Override
    public void onGuiClosed() {
    }

    @Override
    public boolean doesGuiPauseGame() {
        return true;
    }

    @SideOnly(Side.CLIENT)
    static class ContentButton extends GuiButton {
        public ContentButton(int parButtonId, int parPosX, int parPosY, int width, int height, String text) {
            super(parButtonId, parPosX, parPosY, width, height, text);
            this.visible = false;
        }

        @Override
        public void drawButton(Minecraft mc, int mouseX, int mouseY, float partialTicks) {

            if (this.visible) {
                FontRenderer fontrenderer = mc.fontRenderer;
                mc.getTextureManager().bindTexture(BUTTON_TEXTURES);
                GlStateManager.color(0.0F, 0.0F, 1.0F, 1.0F);
                this.hovered = mouseX >= this.x && mouseY >= this.y && mouseX < this.x + this.width && mouseY < this.y + this.height;
                int i = this.getHoverState(this.hovered);
                GlStateManager.enableBlend();
                GlStateManager.tryBlendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
                GlStateManager.blendFunc(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA);
                this.drawTexturedModalRect(this.x, this.y, 0, 46 + i * 20, this.width / 2, this.height);
                this.drawTexturedModalRect(this.x + this.width / 2, this.y, 200 - this.width / 2, 46 + i * 20, this.width / 2, this.height);
                this.mouseDragged(mc, mouseX, mouseY);
                int j = 14737632;

                if (packedFGColour != 0) {
                    j = packedFGColour;
                } else if (!this.enabled) {
                    j = 10526880;
                } else if (this.hovered) {
                    j = 16777120;
                }

                this.drawCenteredString(fontrenderer, this.displayString, this.x + this.width / 2, this.y + (this.height - 8) / 2, j);
            }
        }
    }
}
