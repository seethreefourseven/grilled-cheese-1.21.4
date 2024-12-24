package com.jace.grilledcheese.item;

import net.minecraft.item.Item;
import net.minecraft.item.ToolMaterial;

public class KnifeItem extends Item {
    public KnifeItem(ToolMaterial material, float attackDamage, float attackSpeed, Item.Settings settings) {
        super(material.applySwordSettings(settings, attackDamage, attackSpeed));
    }
}