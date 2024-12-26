package com.jace.grilledcheese.block;


import com.jace.grilledcheese.GrilledCheese;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.*;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

import java.util.function.Function;

public class ModBlocks {
        public static final Block CHEESE_BLOCK = register("cheese_block", CheeseBlock::new,
                AbstractBlock.Settings.create()
                        .mapColor(MapColor.YELLOW)
                        .strength(0.25F)
                        .sounds(BlockSoundGroup.SPONGE)
        );

        public static Block register(String path, Function<Block.Settings, Block> factory, Block.Settings settings) {
            final RegistryKey<Block> registryKey = RegistryKey.of(RegistryKeys.BLOCK, Identifier.of("grilledcheese", path));
            return Blocks.register(registryKey, factory, settings);
        }

        public static void registerModBlocks() {
            GrilledCheese.LOGGER.info("Registering Mod Blocks for " + GrilledCheese.MOD_ID);

            ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> {
                //here put "entries.add(EXAMPLE_ITEM);"
                entries.add(CHEESE_BLOCK);
            });

        }

}
