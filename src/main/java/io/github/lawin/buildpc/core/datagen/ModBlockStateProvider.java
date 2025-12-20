package io.github.lawin.buildpc.core.datagen;

import io.github.lawin.buildpc.core.BuildPCCore;
import io.github.lawin.buildpc.core.block.ModBlocks;
import io.github.lawin.buildpc.core.block.custom.PcCaseBlock;
import net.minecraft.core.Direction;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ConfiguredModel;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, BuildPCCore.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.TEST_BLOCK);

        for (DyeColor color : DyeColor.values()) {
            // horizontalBlockWithItem(ModBlocks.PC_CASES.get(color));
            pcCaseBlockWithItem(ModBlocks.PC_CASES.get(color));
        }
    }

    private void blockWithItem(DeferredBlock<?> deferredBlock) {
        simpleBlockWithItem(deferredBlock.get(), cubeAll(deferredBlock.get()));
    }

//    private void horizontalBlockWithItem(DeferredBlock<?> deferredBlock) {
////        horizontalBlock(deferredBlock.get(), blockState -> models().getExistingFile(modLoc("block/" + deferredBlock.getId().getPath())));
////        blockItem(deferredBlock);
//        String name = deferredBlock.getId().getPath();
//        ModelFile model = models()
//                .withExistingParent(
//                        name,
//                        modLoc("block/pc_case") // 부모 모델
//                )
//                .texture("0", modLoc("block/" + name))
//                .texture("particle", modLoc("block/" + name));
//        horizontalBlock(deferredBlock.get(), model);
//        simpleBlockItem(deferredBlock.get(), model);
//    }

    private void pcCaseBlockWithItem(DeferredBlock<?> deferredBlock) {
        String name = deferredBlock.getId().getPath();
        ModelFile closed = models().withExistingParent("pccase/close/" + name + "_close", modLoc("block/pccase/close/pc_case_close"))
                .texture("0", modLoc("block/pccase/close/" + name + "_close")).texture("particle", modLoc("block/pccase/close/" + name + "_close"));
        ModelFile open = models().withExistingParent("pccase/open/" + name + "_open", modLoc("block/pccase/open/pc_case_open"))
                .texture("0", modLoc("block/pccase/open/" + name + "_open")).texture("particle", modLoc("block/pccase/open/" + name + "_open"));
        getVariantBuilder(deferredBlock.get())
                .forAllStates(state -> {
                    boolean isOpen = state.getValue(PcCaseBlock.OPEN);
                    Direction dir = state.getValue(HorizontalDirectionalBlock.FACING);
                    ModelFile model = isOpen ? open : closed;
//                    int yRot = ((int) dir.toYRot()) % 360;
                    int yRot = ((int) dir.toYRot());
                    return ConfiguredModel.builder().modelFile(model).rotationY(yRot).build();
                });
        simpleBlockItem(deferredBlock.get(), closed);
    }

    private void blockItem(DeferredBlock<?> deferredBlock) {
        simpleBlockItem(deferredBlock.get(), new ModelFile.UncheckedModelFile("buildpccoremod:block/" + deferredBlock.getId().getPath()));
    }

    private void blockItem(DeferredBlock<?> deferredBlock, String appendix) {
        simpleBlockItem(deferredBlock.get(), new ModelFile.UncheckedModelFile("buildpccoremod:block/" + deferredBlock.getId().getPath() + appendix));
    }
}
