package io.github.lawin.buildpc.core.util;

import io.github.lawin.buildpc.core.BuildPCCore;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ModTags {
    public static class Blocks {
        private static TagKey<Block> createTag(String name) {
            return BlockTags.create(ResourceLocation.fromNamespaceAndPath(BuildPCCore.MODID, name));
        }
    }

    public static class Items {
        public static final TagKey<Item> CPU = createTag("cpu");
        public static final TagKey<Item> GPU = createTag("gpu");
        public static final TagKey<Item> RAM = createTag("ram");
        public static final TagKey<Item> COOLER = createTag("cooler");
        public static final TagKey<Item> FAN = createTag("fan");
        public static final TagKey<Item> POWER_SUPPLY = createTag("power_supply");
        public static final TagKey<Item> MOTHER_BOARD = createTag("mother_board");
        public static final TagKey<Item> MD2_SSD = createTag("md2_ssd");

        private static TagKey<Item> createTag(String name) {
            return ItemTags.create(ResourceLocation.fromNamespaceAndPath(BuildPCCore.MODID, name));
        }
    }
}
