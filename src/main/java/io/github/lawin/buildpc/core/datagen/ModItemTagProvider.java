package io.github.lawin.buildpc.core.datagen;

import io.github.lawin.buildpc.core.BuildPCCore;
import io.github.lawin.buildpc.core.item.ModItems;
import io.github.lawin.buildpc.core.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends ItemTagsProvider {
    public ModItemTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, CompletableFuture<TagLookup<Block>> blockTags, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, blockTags, BuildPCCore.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(ModTags.Items.CPU).add(ModItems.CPU.get());

        tag(ModTags.Items.RAM).add(ModItems.RAM.get());

        // tag(ModTags.Items.GPU).add(ModItems.GPU.get());

        // tag(ModTags.Items.FAN).add(ModItems.FAN.get());

        // tag(ModTags.Items.COOLER).add(ModItems.COOLER.get());

        tag(ModTags.Items.MD2_SSD).add(ModItems.MD2_SSD.get());

        tag(ModTags.Items.MOTHER_BOARD).add(ModItems.MOTHER_BOARD.get());

        tag(ModTags.Items.POWER_SUPPLY).add(ModItems.POWER_SUPPLY.get());
    }
}
