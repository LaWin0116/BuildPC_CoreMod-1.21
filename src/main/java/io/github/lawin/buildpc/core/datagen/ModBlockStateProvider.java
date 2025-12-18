package io.github.lawin.buildpc.core.datagen;

import io.github.lawin.buildpc.core.BuildPCCore;
import io.github.lawin.buildpc.core.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.DyeColor;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
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
            horizontalBlockWithItem(ModBlocks.PC_CASES.get(color));
        }
    }

    private void blockWithItem(DeferredBlock<?> deferredBlock) {
        simpleBlockWithItem(deferredBlock.get(), cubeAll(deferredBlock.get()));
    }

    private void horizontalBlockWithItem(DeferredBlock<?> deferredBlock) {
//        horizontalBlock(deferredBlock.get(), blockState -> models().getExistingFile(modLoc("block/" + deferredBlock.getId().getPath())));
//        blockItem(deferredBlock);
        String name = deferredBlock.getId().getPath();
        ModelFile model = models()
                .withExistingParent(
                        name,
                        modLoc("block/pc_case") // 부모 모델
                )
                .texture("0", modLoc("block/" + name))
                .texture("particle", modLoc("block/" + name));
        horizontalBlock(deferredBlock.get(), model);
        simpleBlockItem(deferredBlock.get(), model);
    }

    private void blockItem(DeferredBlock<?> deferredBlock) {
        simpleBlockItem(deferredBlock.get(), new ModelFile.UncheckedModelFile("buildpccoremod:block/" + deferredBlock.getId().getPath()));
    }

    private void blockItem(DeferredBlock<?> deferredBlock, String appendix) {
        simpleBlockItem(deferredBlock.get(), new ModelFile.UncheckedModelFile("buildpccoremod:block/" + deferredBlock.getId().getPath() + appendix));
    }
}
