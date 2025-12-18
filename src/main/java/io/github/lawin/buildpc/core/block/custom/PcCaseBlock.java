package io.github.lawin.buildpc.core.block.custom;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

public class PcCaseBlock extends HorizontalDirectionalBlock {
    public static final MapCodec<PcCaseBlock> CODEC = simpleCodec(PcCaseBlock::new);
    // private static final VoxelShape SHAPE = Block.box(1, 0, 4, 15, 16, 12);
    private static final VoxelShape SHAPE_NORTH = Block.box(1, 0, 4, 15, 16, 12);
    private static final VoxelShape SHAPE_SOUTH = Block.box(1, 0, 4, 15, 16, 12);
    private static final VoxelShape SHAPE_WEST  = Block.box(4, 0, 1, 12, 16, 15);
    private static final VoxelShape SHAPE_EAST  = Block.box(4, 0, 1, 12, 16, 15);

    public PcCaseBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected VoxelShape getShape(BlockState state, BlockGetter level,
                                  BlockPos pos, CollisionContext context) {
        return switch (state.getValue(FACING)) {
            case NORTH -> SHAPE_NORTH;
            case SOUTH -> SHAPE_SOUTH;
            case WEST  -> SHAPE_WEST;
            case EAST  -> SHAPE_EAST;
            default    -> SHAPE_NORTH;
        };
    }


    @Override
    protected MapCodec<? extends HorizontalDirectionalBlock> codec() {
        return CODEC;
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite());
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }
}
