package io.github.lawin.buildpc.core.block.entity.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import io.github.lawin.buildpc.core.block.entity.PcCaseBlockEntity;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.LightTexture;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LightLayer;

public class PcCaseBlockEntityRenderer implements BlockEntityRenderer<PcCaseBlockEntity> {
	private final ItemRenderer itemRenderer;

	public PcCaseBlockEntityRenderer(BlockEntityRendererProvider.Context context) {
		this.itemRenderer = Minecraft.getInstance().getItemRenderer();
	}

    @Override
    public void render(PcCaseBlockEntity pBlockEntity, float pPartialTick, PoseStack pPoseStack, MultiBufferSource pBufferSource, int pPackedLight, int pPackedOverlay) {
	    Level level = pBlockEntity.getLevel();
	    if (level == null) return;

	    pPoseStack.pushPose();
	    pPoseStack.translate(0.5D, 0.5D, 0.5D);

		// motherboard (slots 0)
	    // Motherboard (slot 0)
	    ItemStack motherboard = pBlockEntity.inventory.getStackInSlot(0);
	    if (!motherboard.isEmpty()) {

		    pPoseStack.pushPose();

		    pPoseStack.translate(-0.1D, 0.17D, -0.18D);
			pPoseStack.mulPose(Axis.XP.rotationDegrees(180));
			pPoseStack.mulPose(Axis.ZP.rotationDegrees(180));
		    pPoseStack.scale(0.45F, 0.45F, 0.45F);

		    itemRenderer.renderStatic(
				    motherboard,
				    ItemDisplayContext.FIXED,
				    pPackedLight,
				    pPackedOverlay,
				    pPoseStack,
				    pBufferSource,
				    level,
				    0
		    );

		    pPoseStack.popPose();
	    }


	    // GPU (PCIe) (slots 9-10)
	    ItemStack gpu = pBlockEntity.inventory.getStackInSlot(9);
	    if (!gpu.isEmpty()) {
		    pPoseStack.pushPose();
		    pPoseStack.translate(0.0D, 0.15D, -0.1D);
		    pPoseStack.scale(0.8F, 0.8F, 0.8F);

		    itemRenderer.renderStatic(
				    gpu,
				    ItemDisplayContext.FIXED,
				    pPackedLight,
				    pPackedOverlay,
				    pPoseStack,
				    pBufferSource,
				    level,
				    0
		    );
		    pPoseStack.popPose();
	    }

	    // CPU (slots 1)
	    ItemStack cpu = pBlockEntity.inventory.getStackInSlot(1);
	    if (!cpu.isEmpty()) {
		    pPoseStack.pushPose();
		    pPoseStack.translate(0.0D, 0.25D, 0.0D);
		    pPoseStack.scale(0.4F, 0.4F, 0.4F);

		    itemRenderer.renderStatic(
				    cpu,
				    ItemDisplayContext.FIXED,
				    pPackedLight,
				    pPackedOverlay,
				    pPoseStack,
				    pBufferSource,
				    level,
				    0
		    );
		    pPoseStack.popPose();
	    }

	    // RAM (slots 3-6)
	    for (int i = 3; i <= 6; i++) {
		    ItemStack ram = pBlockEntity.inventory.getStackInSlot(i);
		    if (ram.isEmpty()) continue;

		    pPoseStack.pushPose();
		    pPoseStack.translate(-0.15D + (i - 3) * 0.1D, 0.25D, 0.0D);
		    pPoseStack.scale(0.35F, 0.35F, 0.35F);

		    itemRenderer.renderStatic(
				    ram,
				    ItemDisplayContext.FIXED,
				    pPackedLight,
				    pPackedOverlay,
				    pPoseStack,
				    pBufferSource,
				    level,
				    0
		    );
		    pPoseStack.popPose();
	    }

	    // M.2 (slots 7-8)
	    for (int i = 7; i <= 8; i++) {
		    ItemStack ssd = pBlockEntity.inventory.getStackInSlot(i);
		    if (ssd.isEmpty()) continue;

		    pPoseStack.pushPose();
		    pPoseStack.translate(0.0D, 0.18D, 0.15D + (i - 7) * 0.08D);
		    pPoseStack.scale(0.3F, 0.3F, 0.3F);

		    itemRenderer.renderStatic(
				    ssd,
				    ItemDisplayContext.FIXED,
				    pPackedLight,
				    pPackedOverlay,
				    pPoseStack,
				    pBufferSource,
				    level,
				    0
		    );
		    pPoseStack.popPose();
	    }

		// PSU (slots 11)

	    // fans (slots 12-16)

	    pPoseStack.popPose();
    }

	private int getLightLevel(Level level, BlockPos pos) {
		int bLight = level.getBrightness(LightLayer.BLOCK, pos);
		int sLight = level.getBrightness(LightLayer.SKY, pos);
		return LightTexture.pack(bLight, sLight);
	}
}