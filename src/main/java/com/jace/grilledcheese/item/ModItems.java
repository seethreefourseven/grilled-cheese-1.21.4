package com.jace.grilledcheese.item;

import com.jace.grilledcheese.GrilledCheese;
import com.jace.grilledcheese.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.Blocks;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.ConsumableComponents;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

import java.util.function.Function;

import static net.minecraft.item.Items.BUCKET;

public class ModItems {

        //Food Items
        public static final Item GRILLED_CHEESE_SANDWICH = register("grilled_cheese_sandwich", Item::new, new Item.Settings()
                .food(new FoodComponent.Builder().nutrition(10).saturationModifier(15F).build())
        );
        public static final Item CHEESE_SANDWICH = register("cheese_sandwich", Item::new, new Item.Settings()
                .food(new FoodComponent.Builder().nutrition(8).saturationModifier(8F).build())
        );
        public static final Item SLICED_BREAD = register("sliced_bread", Item::new, new Item.Settings()
                .food(new FoodComponent.Builder().nutrition(1).saturationModifier(1.2F).build())
        );
        public static final Item TOAST = register("toast", Item::new, new Item.Settings()
                .food(new FoodComponent.Builder().nutrition(2).saturationModifier(1.2F).build())
        );
    public static final Item CHEESE_BUCKET = register(
            "cheese_bucket",
            settings ->
                    new CheeseBucketItem(ModBlocks.CHEESE_BLOCK, settings),
                    new Item.Settings()
                    .recipeRemainder(BUCKET)
                            .component(DataComponentTypes.CONSUMABLE, Consumables.CHEESE_BUCKET).useRemainder(BUCKET).maxCount(1)
                            .food(new FoodComponent.Builder().nutrition(5).saturationModifier(6F).build())
    );


        public static Item register(String path, Function<Item.Settings, Item> factory, Item.Settings settings) {
            final RegistryKey<Item> registryKey = RegistryKey.of(RegistryKeys.ITEM, Identifier.of("grilledcheese", path));
            return Items.register(registryKey, factory, settings);
        }

        public static void registerModItems() {
            GrilledCheese.LOGGER.info("Registering Mod Items for " + GrilledCheese.MOD_ID);

            ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(entries -> {
                //here put "entries.add(EXAMPLE_ITEM);"
                entries.add(SLICED_BREAD);
                entries.add(TOAST);
                entries.add(CHEESE_BUCKET);
                entries.add(CHEESE_SANDWICH);
                entries.add(GRILLED_CHEESE_SANDWICH);
            });

    }
}
