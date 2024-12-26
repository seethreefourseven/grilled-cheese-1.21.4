package com.jace.grilledcheese.block;


import com.jace.grilledcheese.item.ModItems;
import net.minecraft.block.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldEvents;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

public class CheeseBlock extends Block implements FluidDrainable {

    public CheeseBlock(Settings settings) {
        super(settings);
    }

    @Override
    public ItemStack tryDrainFluid(@Nullable PlayerEntity player, WorldAccess world, BlockPos pos, BlockState state) {
        world.setBlockState(pos, Blocks.AIR.getDefaultState(), Block.NOTIFY_ALL_AND_REDRAW);
        if (!world.isClient()) {
            world.syncWorldEvent(WorldEvents.BLOCK_BROKEN, pos, Block.getRawIdFromState(state));
        }

        return new ItemStack(ModItems.CHEESE_BUCKET);
    }

    @Override
    public Optional<SoundEvent> getBucketFillSound() {
        return Optional.empty();
    }
}
