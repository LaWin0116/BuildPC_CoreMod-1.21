package io.github.lawin.buildpc.core.datagen;

import io.github.lawin.buildpc.core.BuildPCCore;
import io.github.lawin.buildpc.core.item.ModItems;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, BuildPCCore.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(ModItems.TEST_ITEM.get());

//        basicItem(ModItems.MOTHER_BOARD.get());
//        basicItem(ModItems.CPU.get());
//        basicItem(ModItems.RAM.get());
//        basicItem(ModItems.MD2_SSD.get());
//        basicItem(ModItems.POWER_SUPPLY.get());
    }
}
