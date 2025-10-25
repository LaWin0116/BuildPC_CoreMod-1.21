package io.github.lawin.buildpc.core.item;

import io.github.lawin.buildpc.core.BuildPCCore;

import net.minecraft.world.item.Item;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(BuildPCCore.MODID);

    public static final DeferredItem<Item> TEST_ITEM = ITEMS.register("test_item", () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> CPU = ITEMS.register("cpu", () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> RAM = ITEMS.register("ram", () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> MD2_SSD = ITEMS.register("md2_ssd", () -> new  Item(new Item.Properties()));
    public static final DeferredItem<Item> MOTHER_BOARD = ITEMS.register("mother_board", () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> POWER_SUPPLY = ITEMS.register("power_supply", () -> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
