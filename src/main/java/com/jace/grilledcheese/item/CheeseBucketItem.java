package com.jace.grilledcheese.item;

import net.minecraft.block.Block;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItem;
import net.minecraft.item.BucketItem;
import net.minecraft.item.FluidModificationItem;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.util.ActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class CheeseBucketItem extends BlockItem implements FluidModificationItem {
    public CheeseBucketItem(Block block, Settings settings) {
        super(block, settings);
    }
    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        ActionResult actionResult = super.useOnBlock(context);
        PlayerEntity playerEntity = context.getPlayer();
        if (actionResult.isAccepted() && playerEntity != null) {
            playerEntity.setStackInHand(context.getHand(), BucketItem.getEmptiedStack(context.getStack(), playerEntity));
        }

        return actionResult;
    }

    @Override
    public boolean placeFluid(@Nullable PlayerEntity player, World world, BlockPos pos, @Nullable BlockHitResult hitResult) {
        if (world.isInBuildLimit(pos) && world.isAir(pos)) {
            if (!world.isClient) {
                world.setBlockState(pos, this.getBlock().getDefaultState(), Block.NOTIFY_ALL);
            }
            return true;
        } else {
            return false;
        }
    }
}
