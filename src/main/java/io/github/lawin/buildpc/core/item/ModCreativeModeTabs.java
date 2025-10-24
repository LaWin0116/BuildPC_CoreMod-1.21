package io.github.lawin.buildpc.core.item;

import io.github.lawin.buildpc.core.BuildPCCore;
import io.github.lawin.buildpc.core.block.ModBlocks;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
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
            }).build());
    // TODO: PC case 블록 추가 후에 아이콘 변경, line: 31 아이템 등록부 수정
    public static final Supplier<CreativeModeTab> MISC_HARDWARE = CREATIVE_MODE_TAB.register("misc_hardware_tab", () -> CreativeModeTab.builder()
            .icon(() -> new ItemStack(ModBlocks.TEST_BLOCK))
            .title(Component.translatable("creativetab.buildpccoremod.misc_hardware"))
            .displayItems((ItemDisplayParameters, output) -> {
                output.accept(ModBlocks.TEST_BLOCK);
            }).build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }
}
