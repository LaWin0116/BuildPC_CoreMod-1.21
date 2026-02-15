package io.github.lawin.buildpc.core.block.entity.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import io.github.lawin.buildpc.core.block.custom.PcCaseBlock;
import io.github.lawin.buildpc.core.block.entity.PcCaseBlockEntity;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.LightTexture;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
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
	    pPoseStack.translate(.5D, .5D, .5D);

	    Direction dir = pBlockEntity
			    .getBlockState()
			    .getValue(PcCaseBlock.FACING);

	    float rotY = switch (dir) {
		    case NORTH -> 0F;
		    case SOUTH -> 180F;
		    case WEST  -> 90F;
		    case EAST  -> -90F;
		    default -> 0F;
	    };

	    pPoseStack.mulPose(Axis.YP.rotationDegrees(rotY));


	    // motherboard (slots 0)
	    ItemStack motherboard = pBlockEntity.inventory.getStackInSlot(0);
	    if (!motherboard.isEmpty()) {

		    pPoseStack.pushPose();

		    pPoseStack.translate(-.1D, .17D, -.18D);
			pPoseStack.mulPose(Axis.XP.rotationDegrees(180));
			pPoseStack.mulPose(Axis.ZP.rotationDegrees(180));
		    pPoseStack.scale(.45F, .45F, .45F);

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


	    // PCIe (slots 9-10)
//	    for (int i = 9; i <= 10; i++) {
//		    ItemStack PCIe = pBlockEntity.inventory.getStackInSlot(i);
//		    if (PCIe.isEmpty()) continue;
//
//		    pPoseStack.pushPose();
//		    pPoseStack.translate(.0D, .0D + (i - 9) * .0D, .0D);
//		    pPoseStack.scale(.0F, .0F, .0F);
//
//		    itemRenderer.renderStatic(
//				    PCIe,
//				    ItemDisplayContext.FIXED,
//				    pPackedLight,
//				    pPackedOverlay,
//				    pPoseStack,
//				    pBufferSource,
//				    level,
//				    0
//		    );
//		    pPoseStack.popPose();
//	    }

	    // CPU (slots 1)
	    ItemStack cpu = pBlockEntity.inventory.getStackInSlot(1);
	    if (!cpu.isEmpty()) {
		    pPoseStack.pushPose();
		    pPoseStack.translate(-.185D, .255D, -.16D);
		    pPoseStack.mulPose(Axis.XP.rotationDegrees(180));
		    pPoseStack.scale(.26F, .26F, .26F);

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
		    pPoseStack.translate(.015D + (i - 3) * .021D, .255D, -.14D);
		    pPoseStack.mulPose(Axis.XP.rotationDegrees(180));
			pPoseStack.mulPose(Axis.YP.rotationDegrees(90));
		    pPoseStack.mulPose(Axis.ZN.rotationDegrees(45));
		    pPoseStack.scale(.2F, .2F, .2F);

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
	    ItemStack Md2SSDI = pBlockEntity.inventory.getStackInSlot(7);
	    if (!Md2SSDI.isEmpty()) {
		    pPoseStack.pushPose();
		    pPoseStack.translate(0.0D, 0.25D, 0.0D);
		    pPoseStack.mulPose(Axis.YP.rotationDegrees(180));
		    pPoseStack.mulPose(Axis.ZP.rotationDegrees(45));
		    pPoseStack.scale(0.1F, 0.1F, 0.1F);

		    itemRenderer.renderStatic(
				    Md2SSDI,
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

//	    ItemStack Md2SSDII = pBlockEntity.inventory.getStackInSlot(8);
//	    if (!Md2SSDII.isEmpty()) {
//		    pPoseStack.pushPose();
//		    pPoseStack.translate(0.0D, 0.25D, 0.0D);
//	        pPoseStack.mulPose(Axis.XP.rotationDegrees(90));
//	        pPoseStack.mulPose(Axis.YP.rotationDegrees(180));
//	        pPoseStack.mulPose(Axis.ZP.rotationDegrees(45));
//	        pPoseStack.scale(0.1F, 0.1F, 0.1F);
//
//		    itemRenderer.renderStatic(
//				    Md2SSDII,
//				    ItemDisplayContext.FIXED,
//				    pPackedLight,
//				    pPackedOverlay,
//				    pPoseStack,
//				    pBufferSource,
//				    level,
//				    0
//		    );
//		    pPoseStack.popPose();
//	    }

		// PSU (slots 11)
	    ItemStack PSU = pBlockEntity.inventory.getStackInSlot(11);
	    if (!PSU.isEmpty()) {
		    pPoseStack.pushPose();
		    pPoseStack.translate(-.19D, .1D, -.02D);
		    pPoseStack.scale(1.1F, 1.1F, 1.1F);

		    itemRenderer.renderStatic(
				    PSU,
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

	    // fans (slots 12-16)

	    pPoseStack.popPose();
    }

	private int getLightLevel(Level level, BlockPos pos) {
		int bLight = level.getBrightness(LightLayer.BLOCK, pos);
		int sLight = level.getBrightness(LightLayer.SKY, pos);
		return LightTexture.pack(bLight, sLight);
	}
}