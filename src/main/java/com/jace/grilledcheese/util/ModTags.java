package com.jace.grilledcheese.util;

import com.jace.grilledcheese.GrilledCheese;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class ModTags {
    public static class Blocks {

        private static TagKey<Block> createTag(String path) {
            return TagKey.of(RegistryKeys.BLOCK, Identifier.of(GrilledCheese.MOD_ID, path));
        }
    }

    public static class Items {
        public static final TagKey<Item> KNIVES = createTag("knives");

        private static TagKey<Item> createTag(String path) {
            return TagKey.of(RegistryKeys.ITEM, Identifier.of(GrilledCheese.MOD_ID, path));
        }
    }
}

