package io.github.lawin.buildpc.core.block.entity;

import io.github.lawin.buildpc.core.screen.custom.PcCaseMenu;
import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.world.Containers;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.items.ItemStackHandler;
import org.jetbrains.annotations.Nullable;

public class PcCaseBlockEntity extends BlockEntity implements MenuProvider {
    public final ItemStackHandler inventory = new ItemStackHandler(17) {
        @Override
        protected int getStackLimit(int slot, ItemStack stack) {
//            return super.getStackLimit(slot, stack);
            return 1;
        }

        @Override
        protected void onContentsChanged(int slot) {
            setChanged();
            if (!level.isClientSide()) {
                level.sendBlockUpdated(getBlockPos(), getBlockState(), getBlockState(), 3);
            }
        }
    };

//    public PcCaseBlockEntity(BlockPos pos, BlockState blockState) {
//        super(ModBlockEntities.WHITE_PCCASE_BE.get(), pos, blockState);
//    }
    public PcCaseBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.PC_CASE.get(), pos, state);
    }


    public void clearContents() {
        inventory.setStackInSlot(0, ItemStack.EMPTY);
    }

    public void drops() {
        SimpleContainer inv = new SimpleContainer(inventory.getSlots());
        for (int i = 0; i < inventory.getSlots(); i++) {
            inv.setItem(i, inventory.getStackInSlot(i));
        }
        Containers.dropContents(this.level, this.worldPosition, inv);
    }

    @Override
    protected void saveAdditional(CompoundTag tag, HolderLookup.Provider registries) {
        super.saveAdditional(tag, registries);
        tag.put("inventory", inventory.serializeNBT(registries));
    }

    @Override
    protected void loadAdditional(CompoundTag tag, HolderLookup.Provider registries) {
        super.loadAdditional(tag, registries);
        inventory.deserializeNBT(registries, tag.getCompound("inventory"));
    }

    @Override
    public Component getDisplayName() {
        return Component.literal("PC Case");
    }

    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
        return new PcCaseMenu(id, inventory, this);
    }

    @Nullable
    @Override
    public Packet<ClientGamePacketListener> getUpdatePacket() {
        return super.getUpdatePacket();
    }

    @Override
    public CompoundTag getUpdateTag(HolderLookup.Provider registries) {
        return super.getUpdateTag(registries);
    }
}
