package io.github.lawin.buildpc.core.block;

import io.github.lawin.buildpc.core.BuildPCCore;

import io.github.lawin.buildpc.core.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(BuildPCCore.MODID);

    public static final DeferredBlock<Block> TEST_BLOCK = registerBlock("test_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(4f)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.STONE)));

    /** pc case 블록의 공통 속성 */
    private static final BlockBehaviour.Properties PC_CASES = BlockBehaviour.Properties.of().strength(1f).noOcclusion().sound(SoundType.METAL);

    // public static final DeferredBlock<Block> PC_CASE = registerBlock("pc_case", () -> new Block(PC_CASES));
    public static final DeferredBlock<Block> WHITE_PC_CASE = registerBlock("white_pc_case", () -> new Block(PC_CASES));
    public static final DeferredBlock<Block> LIGHT_GRAY_PC_CASE = registerBlock("light_gray_pc_case", () -> new Block(PC_CASES));
    public static final DeferredBlock<Block> GRAY_PC_CASE = registerBlock("gray_pc_case", () -> new Block(PC_CASES));
    public static final DeferredBlock<Block> BLACK_PC_CASE = registerBlock("black_pc_case", () -> new Block(PC_CASES));
    public static final DeferredBlock<Block> BROWN_PC_CASE = registerBlock("brown_pc_case", () -> new Block(PC_CASES));
    public static final DeferredBlock<Block> RED_PC_CASE = registerBlock("red_pc_case", () -> new Block(PC_CASES));
    public static final DeferredBlock<Block> ORANGE_PC_CASE = registerBlock("orange_pc_case", () -> new Block(PC_CASES));
    public static final DeferredBlock<Block> YELLOW_PC_CASE = registerBlock("yellow_pc_case", () -> new Block(PC_CASES));
    public static final DeferredBlock<Block> LIME_PC_CASE = registerBlock("lime_pc_case", () -> new Block(PC_CASES));
    public static final DeferredBlock<Block> GREEN_PC_CASE = registerBlock("green_pc_case", () -> new Block(PC_CASES));
    public static final DeferredBlock<Block> CYAN_PC_CASE = registerBlock("cyan_pc_case", () -> new Block(PC_CASES));
    public static final DeferredBlock<Block> LIGHT_BLUE_PC_CASE = registerBlock("light_blue_pc_case", () -> new Block(PC_CASES));
    public static final DeferredBlock<Block> BLUE_PC_CASE = registerBlock("blue_pc_case", () -> new Block(PC_CASES));
    public static final DeferredBlock<Block> PURPLE_PC_CASE = registerBlock("purple_pc_case", () -> new Block(PC_CASES));
    public static final DeferredBlock<Block> MAGENTA_PC_CASE = registerBlock("magenta_pc_case", () -> new Block(PC_CASES));
    public static final DeferredBlock<Block> PINK_PC_CASE = registerBlock("pink_pc_case", () -> new Block(PC_CASES));

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
