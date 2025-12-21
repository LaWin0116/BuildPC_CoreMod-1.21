package io.github.lawin.buildpc.core.item;

import io.github.lawin.buildpc.core.BuildPCCore;
import io.github.lawin.buildpc.core.block.ModBlocks;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.ItemStack;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, BuildPCCore.MODID);

    // NOTE: creative tab 추가 시, 하나 복제후에 수정하기
    public static final Supplier<CreativeModeTab> PC_CHIPSETS = CREATIVE_MODE_TAB.register("pc_chipsets_tab", () -> CreativeModeTab.builder()
            .icon(() -> new ItemStack(ModItems.CPU.get()))
            .title(Component.translatable("creativetab.buildpccoremod.pc_chipsets"))
            .displayItems((ItemDisplayParameters, output) -> {
                output.accept(ModItems.CPU);
                output.accept(ModItems.RAM);
                output.accept(ModItems.MD2_SSD);
                output.accept(ModItems.MOTHER_BOARD);
                output.accept(ModItems.POWER_SUPPLY);
            }).build());

    public static final Supplier<CreativeModeTab> MISC_HARDWARE = CREATIVE_MODE_TAB.register("misc_hardware_tab", () -> CreativeModeTab.builder()
            .icon(() -> new ItemStack(ModBlocks.WHITE_PC_CASE))
            .title(Component.translatable("creativetab.buildpccoremod.misc_hardware"))
            .displayItems((ItemDisplayParameters, output) -> {
                // output.accept(ModBlocks.PC_CASE);
                for (DyeColor color : DyeColor.values()) {
                    output.accept(ModBlocks.PC_CASES.get(color));
                }
//                output.accept(ModBlocks.WHITE_PC_CASE);
//                output.accept(ModBlocks.LIGHT_GRAY_PC_CASE);
//                output.accept(ModBlocks.GRAY_PC_CASE);
//                output.accept(ModBlocks.BLACK_PC_CASE);
//                output.accept(ModBlocks.BROWN_PC_CASE);
//                output.accept(ModBlocks.RED_PC_CASE);
//                output.accept(ModBlocks.ORANGE_PC_CASE);
//                output.accept(ModBlocks.YELLOW_PC_CASE);
//                output.accept(ModBlocks.LIME_PC_CASE);
//                output.accept(ModBlocks.GREEN_PC_CASE);
//                output.accept(ModBlocks.CYAN_PC_CASE);
//                output.accept(ModBlocks.LIGHT_BLUE_PC_CASE);
//                output.accept(ModBlocks.BLUE_PC_CASE);
//                output.accept(ModBlocks.PURPLE_PC_CASE);
//                output.accept(ModBlocks.MAGENTA_PC_CASE);
//                output.accept(ModBlocks.PINK_PC_CASE);
            }).build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }
}
