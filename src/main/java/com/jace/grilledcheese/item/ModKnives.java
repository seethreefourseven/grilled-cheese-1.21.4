package com.jace.grilledcheese.item;

import com.jace.grilledcheese.GrilledCheese;
import com.jace.grilledcheese.util.ModTags;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

import java.util.function.Function;

public class ModKnives {

    public static final Item WOODEN_KNIFE = register("wooden_knife",
            settings -> new KnifeItem(ToolMaterial.WOOD, 2.0F, -0.5F, settings),
            new Item.Settings().enchantable(15));

    public static final Item GOLDEN_KNIFE = register("golden_knife",
            settings -> new KnifeItem(ToolMaterial.GOLD, 2.0F, -0.5F, settings),
            new Item.Settings().enchantable(22));

    public static final Item STONE_KNIFE = register("stone_knife",
            settings -> new KnifeItem(ToolMaterial.STONE, 2.0F, -0.5F, settings),
            new Item.Settings().enchantable(5));

    public static final Item IRON_KNIFE = register("iron_knife",
            settings -> new KnifeItem(ToolMaterial.IRON, 2.0F, -0.5F, settings),
            new Item.Settings().enchantable(14));

    public static final Item DIAMOND_KNIFE = register("diamond_knife",
            settings -> new KnifeItem(ToolMaterial.DIAMOND, 2.0F, -0.5F, settings),
            new Item.Settings().enchantable(10));

    public static final Item NETHERITE_KNIFE = register("netherite_knife",
            settings -> new KnifeItem(ToolMaterial.NETHERITE, 2.0F, -0.5F, settings),
            new Item.Settings().enchantable(15));



    public static Item register(String path, Function<Item.Settings, Item> factory, Item.Settings settings) {
        final RegistryKey<Item> registryKey = RegistryKey.of(RegistryKeys.ITEM, Identifier.of("grilledcheese", path));
        return Items.register(registryKey, factory, settings);
    }

    public static void registerModKnives() {
        GrilledCheese.LOGGER.info("Registering Mod Items for " + GrilledCheese.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(entries -> {
            //here put "entries.add(EXAMPLE_ITEM);"
            entries.add(WOODEN_KNIFE);
            entries.add(STONE_KNIFE);
            entries.add(IRON_KNIFE);
            entries.add(GOLDEN_KNIFE);
            entries.add(DIAMOND_KNIFE);
            entries.add(NETHERITE_KNIFE);
        });

    }

}
