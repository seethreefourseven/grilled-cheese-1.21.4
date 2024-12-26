package com.jace.grilledcheese.item;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterial;

public class KnifeItem extends Item {
    public KnifeItem(ToolMaterial material, float attackDamage, float attackSpeed, Item.Settings settings) {
        super(material.applySwordSettings(settings, attackDamage, attackSpeed));
    }

    @Override
    public ItemStack getRecipeRemainder(ItemStack stack) {
        ItemStack copy = stack.copy();
        copy.setDamage(stack.getDamage() + 1); // Increment the damage (reduce durability)
        if (copy.getDamage() >= copy.getMaxDamage()) {
            return ItemStack.
                    EMPTY
                    ; // Item is fully broken
        }
        return copy;
    }
}