package io.github.lawin.buildpc.core.block.entity;

import io.github.lawin.buildpc.core.BuildPCCore;

import io.github.lawin.buildpc.core.block.ModBlocks;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(BuiltInRegistries.BLOCK_ENTITY_TYPE, BuildPCCore.MODID);

//    public static final Supplier<BlockEntityType<PcCaseBlockEntity>> WHITE_PCCASE_BE = BLOCK_ENTITIES.register("white_pccase_be",
//            () -> BlockEntityType.Builder.of(PcCaseBlockEntity::new, ModBlocks.WHITE_PC_CASE.get()).build(null));
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<PcCaseBlockEntity>> PC_CASE = BLOCK_ENTITIES.register("pc_case",
        () -> BlockEntityType.Builder.of(PcCaseBlockEntity::new,
                ModBlocks.PC_CASES.values().stream().map(DeferredBlock::get).toArray(Block[]::new)).build(null));

    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}
