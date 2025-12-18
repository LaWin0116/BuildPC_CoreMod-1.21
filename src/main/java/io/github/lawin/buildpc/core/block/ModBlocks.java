package io.github.lawin.buildpc.core.block;

import io.github.lawin.buildpc.core.BuildPCCore;

import io.github.lawin.buildpc.core.block.custom.PcCaseBlock;
import io.github.lawin.buildpc.core.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.EnumMap;
import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(BuildPCCore.MODID);

    public static final DeferredBlock<Block> TEST_BLOCK = registerBlock("test_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(4f)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.STONE)));

    /** pc case 블록의 공통 속성 */
    private static final BlockBehaviour.Properties PC_CASE_PROPERTIES = BlockBehaviour.Properties.of().strength(1f).noOcclusion().sound(SoundType.METAL);

    public static final EnumMap<DyeColor, DeferredBlock<Block>> PC_CASES = new EnumMap<>(DyeColor.class);
    static {
        for (DyeColor color : DyeColor.values()) {
            String name = color.getName() + "_pc_case";
            DeferredBlock<Block> block = BLOCKS.register(name, () -> new PcCaseBlock(PC_CASE_PROPERTIES));
            PC_CASES.put(color, block);
            registerBlockItem(name, block);
        }
    }

    // public static final DeferredBlock<Block> PC_CASE = registerBlock("pc_case", () -> new Block(PC_CASES));
    public static final DeferredBlock<Block> WHITE_PC_CASE = PC_CASES.get(DyeColor.WHITE);
    public static final DeferredBlock<Block> LIGHT_GRAY_PC_CASE = PC_CASES.get(DyeColor.LIGHT_GRAY);
    public static final DeferredBlock<Block> GRAY_PC_CASE = PC_CASES.get(DyeColor.GRAY);
    public static final DeferredBlock<Block> BLACK_PC_CASE = PC_CASES.get(DyeColor.BLACK);
    public static final DeferredBlock<Block> BROWN_PC_CASE = PC_CASES.get(DyeColor.BROWN);
    public static final DeferredBlock<Block> RED_PC_CASE = PC_CASES.get(DyeColor.RED);
    public static final DeferredBlock<Block> ORANGE_PC_CASE = PC_CASES.get(DyeColor.ORANGE);
    public static final DeferredBlock<Block> YELLOW_PC_CASE = PC_CASES.get(DyeColor.YELLOW);
    public static final DeferredBlock<Block> LIME_PC_CASE = PC_CASES.get(DyeColor.LIME);
    public static final DeferredBlock<Block> GREEN_PC_CASE = PC_CASES.get(DyeColor.GREEN);
    public static final DeferredBlock<Block> CYAN_PC_CASE = PC_CASES.get(DyeColor.CYAN);
    public static final DeferredBlock<Block> LIGHT_BLUE_PC_CASE = PC_CASES.get(DyeColor.LIGHT_BLUE);
    public static final DeferredBlock<Block> BLUE_PC_CASE = PC_CASES.get(DyeColor.BLUE);
    public static final DeferredBlock<Block> PURPLE_PC_CASE = PC_CASES.get(DyeColor.PURPLE);
    public static final DeferredBlock<Block> MAGENTA_PC_CASE = PC_CASES.get(DyeColor.MAGENTA);
    public static final DeferredBlock<Block> PINK_PC_CASE = PC_CASES.get(DyeColor.PINK);

    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block) {
        DeferredBlock<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
