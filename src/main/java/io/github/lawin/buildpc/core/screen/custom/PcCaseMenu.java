package io.github.lawin.buildpc.core.screen.custom;

import io.github.lawin.buildpc.core.block.ModBlocks;
import io.github.lawin.buildpc.core.block.custom.PcCaseBlock;
import io.github.lawin.buildpc.core.block.entity.PcCaseBlockEntity;
import io.github.lawin.buildpc.core.screen.ModMenuTypes;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.neoforged.neoforge.items.SlotItemHandler;
import org.jetbrains.annotations.Nullable;

public class PcCaseMenu extends AbstractContainerMenu {
    public final PcCaseBlockEntity blockEntity;
    private final Level level;

    public PcCaseMenu(int containerId, Inventory inv, FriendlyByteBuf extraData) {
        this(containerId, inv, inv.player.level().getBlockEntity(extraData.readBlockPos()));
    }

    public PcCaseMenu(int containerId, Inventory inv, BlockEntity blockEntity) {
        super(ModMenuTypes.PC_CASE_MENU.get(), containerId);
        this.blockEntity = ((PcCaseBlockEntity) blockEntity);
        this.level = inv.player.level();

        addPlayerInventory(inv);
        addPlayerHotbar(inv);

//        this.addSlot(new SlotItemHandler(this.blockEntity.inventory, 0, ));
        int[][] slotPositions = {
                {76, 45}, {76, 71}, {46, 60},
                {107, 45}, {137, 45}, {107, 71}, {137, 71},
                {107, 97}, {137, 97},
                {46, 97}, {76, 97},
                {23, 97},
                {23, 60}, {23, 23}, {61, 23}, {99, 23}, {137, 23}
        };

        for (int i = 0; i < slotPositions.length; i++) {
            int x = slotPositions[i][0];
            int y = slotPositions[i][1];
            this.addSlot(new SlotItemHandler(this.blockEntity.inventory, i, x, y));
        }

    }

    @Override
    public ItemStack quickMoveStack(Player player, int index) {
        return ItemStack.EMPTY;
    }

    @Override
    public boolean stillValid(Player player) {
        return stillValid(ContainerLevelAccess.create(level, blockEntity.getBlockPos()), player, blockEntity.getBlockState().getBlock());
    }

    private void addPlayerInventory(Inventory playerInventory) {
        for (int i = 0; i < 3; ++i) {
            for (int l = 0; l < 9; ++l) {
                this.addSlot(new Slot(playerInventory, l + i * 9 + 9, 8 + l * 18, 134 + i * 18));
            }
        }
    }

    private void addPlayerHotbar(Inventory playerInventory) {
        for (int i = 0; i < 9; ++i) {
            this.addSlot(new Slot(playerInventory, i, 8 + i * 18, 192));
        }
    }

    @Override
    public void removed(Player player) {
        super.removed(player);
        if (!player.level().isClientSide()) {
            blockEntity.getLevel().setBlock(blockEntity.getBlockPos(), blockEntity.getBlockState().setValue(PcCaseBlock.OPEN, false), 3);
        }
    }
}
