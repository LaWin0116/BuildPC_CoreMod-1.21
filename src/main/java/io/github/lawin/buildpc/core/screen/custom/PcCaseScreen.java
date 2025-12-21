package io.github.lawin.buildpc.core.screen.custom;

import com.mojang.blaze3d.systems.RenderSystem;
import io.github.lawin.buildpc.core.BuildPCCore;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

public class PcCaseScreen extends AbstractContainerScreen<PcCaseMenu> {
    private static final ResourceLocation GUI_TEXTURE = ResourceLocation.fromNamespaceAndPath(BuildPCCore.MODID, "textures/gui/pccase/pc_case_gui.png");

    public PcCaseScreen(PcCaseMenu menu, Inventory playerInventory, Component title) {
        super(menu, playerInventory, title);
        this.imageHeight = 217;
    }

    @Override
    protected void renderBg(GuiGraphics guiGraphics, float pPartialTick, int pMouseX, int pMouseY) {
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, GUI_TEXTURE);

        int x = (width - imageWidth) / 2;
        int y = (height - imageHeight) / 2;

        guiGraphics.blit(GUI_TEXTURE, x, y, 0, 0, imageWidth, imageHeight);
    }

    @Override
    protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
        int titleX = 7;
        int titleY = this.font.lineHeight - 5;
        guiGraphics.drawString(this.font, this.title, titleX, titleY, 0x404040, false);

        int inventoryX = 7;
        int inventoryY = this.imageHeight - 93;
        guiGraphics.drawString(this.font, this.playerInventoryTitle, inventoryX, inventoryY, 0x404040, false);
    }

}
