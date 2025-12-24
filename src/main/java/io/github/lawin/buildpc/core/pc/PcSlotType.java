package io.github.lawin.buildpc.core.pc;

import io.github.lawin.buildpc.core.util.ModTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public enum PcSlotType {
    MOTHERBOARD(ModTags.Items.MOTHER_BOARD, 1),
    CPU(ModTags.Items.CPU, 1),
    COOLER(ModTags.Items.COOLER, 1),
    RAM(ModTags.Items.RAM, 1),
    MD2_SSD(ModTags.Items.MD2_SSD, 1),
    GPU(ModTags.Items.GPU, 1),
    POWER_SUPPLY(ModTags.Items.POWER_SUPPLY, 1),
    FAN(ModTags.Items.FAN, 1);

    public final TagKey<Item> tag;
    public final int limit;

    PcSlotType(TagKey<Item> tag, int limit) {
        this.tag = tag;
        this.limit = limit;
    }
}

