package io.github.lawin.buildpc.core.datagen;

import io.github.lawin.buildpc.core.block.ModBlocks;

import io.github.lawin.buildpc.core.item.ModItems;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

import java.util.Set;

public class ModBlockLootTableProvider extends BlockLootSubProvider {
    protected ModBlockLootTableProvider(HolderLookup.Provider registries) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), registries);
    }

    @Override
    protected void generate() {
        dropSelf(ModBlocks.TEST_BLOCK.get());

        for (DyeColor color : DyeColor.values()) {
            dropSelf(ModBlocks.PC_CASES.get(color).get());
        }
//        dropSelf(ModBlocks.WHITE_PC_CASE.get());
//        dropSelf(ModBlocks.LIGHT_GRAY_PC_CASE.get());
//        dropSelf(ModBlocks.GRAY_PC_CASE.get());
//        dropSelf(ModBlocks.BLACK_PC_CASE.get());
//        dropSelf(ModBlocks.BROWN_PC_CASE.get());
//        dropSelf(ModBlocks.RED_PC_CASE.get());
//        dropSelf(ModBlocks.ORANGE_PC_CASE.get());
//        dropSelf(ModBlocks.YELLOW_PC_CASE.get());
//        dropSelf(ModBlocks.LIME_PC_CASE.get());
//        dropSelf(ModBlocks.GREEN_PC_CASE.get());
//        dropSelf(ModBlocks.CYAN_PC_CASE.get());
//        dropSelf(ModBlocks.LIGHT_BLUE_PC_CASE.get());
//        dropSelf(ModBlocks.BLUE_PC_CASE.get());
//        dropSelf(ModBlocks.PURPLE_PC_CASE.get());
//        dropSelf(ModBlocks.MAGENTA_PC_CASE.get());
//        dropSelf(ModBlocks.PINK_PC_CASE.get());

        // NOTE: 광석 블록에서 광물 나오게 하는거
        // add(ModBlocks.ORE_BLOCK.get(), block -> createOreDrop(ModBlocks.ORE_BLOCK.get(), ModItems.RAW_ORE.get()));
        // add(ModBlocks.ORE_BLOCK.get(), block -> creatMultipleOreDrops(ModBlocks.ORE_BLOCK.get(), ModItems.RAW_ORE.get(), 2, 5));
    }

    // NOTE: 광물 여러게 떨구는 코드 (구리나 석탄같은 광물)
//    protected LootTable.Builder creatMultipleOreDrops(Block pBlock, Item item, float minDrops, float maxDrops) {
//        HolderLookup.RegistryLookup<Enchantment> registryLookup = this.registries.lookupOrThrow(Registries.ENCHANTMENT);
//        return this.createSilkTouchDispatchTable(pBlock,
//                this.applyExplosionDecay(pBlock, LootItem.lootTableItem(item)
//                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(minDrops, maxDrops)))
//                        .apply(ApplyBonusCount.addOreBonusCount(registryLookup.getOrThrow(Enchantments.FORTUNE)))));
//    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(Holder::value)::iterator;
    }
}
