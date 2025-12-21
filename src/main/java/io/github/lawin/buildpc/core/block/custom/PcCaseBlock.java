package io.github.lawin.buildpc.core.block.custom;

import com.mojang.serialization.MapCodec;
import io.github.lawin.buildpc.core.block.entity.PcCaseBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.SimpleMenuProvider;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

public class PcCaseBlock extends BaseEntityBlock {
    public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;
    public static final MapCodec<PcCaseBlock> CODEC = simpleCodec(PcCaseBlock::new);
    public static final BooleanProperty OPEN = BooleanProperty.create("open");
    //private static final VoxelShape SHAPE = Block.box(1, 0, 4, 15, 16, 12);
    private static final VoxelShape SHAPE_NORTH = Block.box(1, 0, 4, 15, 16, 12);
    private static final VoxelShape SHAPE_SOUTH = Block.box(1, 0, 4, 15, 16, 12);
    private static final VoxelShape SHAPE_WEST  = Block.box(4, 0, 1, 12, 16, 15);
    private static final VoxelShape SHAPE_EAST  = Block.box(4, 0, 1, 12, 16, 15);

    public PcCaseBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH).setValue(OPEN, false));
    }

    @Override
    protected VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return switch (state.getValue(FACING)) {
            case NORTH -> SHAPE_NORTH;
            case SOUTH -> SHAPE_SOUTH;
            case WEST  -> SHAPE_WEST;
            case EAST  -> SHAPE_EAST;
            default    -> SHAPE_NORTH;
        };
        // return SHAPE;
    }

    @Override
    protected MapCodec<? extends BaseEntityBlock> codec() {
        return CODEC;
    }

    @Override
    protected RenderShape getRenderShape(BlockState state) {
        return RenderShape.MODEL;
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new PcCaseBlockEntity(pos, state);
    }

    @Override
    protected void onRemove(BlockState state, Level level, BlockPos pos, BlockState newState, boolean movedByPiston) {
        if (state.getBlock() != newState.getBlock()) {
            if (level.getBlockEntity(pos) instanceof PcCaseBlockEntity pcCaseBlockEntity) {
                pcCaseBlockEntity.drops();
                level.updateNeighbourForOutputSignal(pos, this);
            }
        }
        super.onRemove(state, level, pos, newState, movedByPiston);
    }

    @Override
    protected ItemInteractionResult useItemOn(ItemStack stack, BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hitResult) {
        if (level.getBlockEntity(pos) instanceof PcCaseBlockEntity pcCaseBlockEntity) {
            if (!level.isClientSide()) {
                level.setBlock(pos, state.setValue(OPEN, true), 3);
                ((ServerPlayer) player).openMenu(new SimpleMenuProvider(pcCaseBlockEntity, Component.literal("PC Case")), pos);
                return ItemInteractionResult.SUCCESS;
            }
        }
        return ItemInteractionResult.SUCCESS;
    }

//    @Override
//    protected InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult hitResult) {
//        if (!level.isClientSide) {
//            level.setBlock(pos, state.cycle(OPEN), 3);
//        }
//        return InteractionResult.sidedSuccess(level.isClientSide);
//    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING, OPEN);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
//        return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite());
        return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection());
    }
}
