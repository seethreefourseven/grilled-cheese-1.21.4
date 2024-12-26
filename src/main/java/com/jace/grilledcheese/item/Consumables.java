package com.jace.grilledcheese.item;

import net.minecraft.component.type.ConsumableComponent;
import net.minecraft.item.consume.UseAction;
import net.minecraft.sound.SoundEvents;

public class Consumables {
    public static final ConsumableComponent CHEESE_BUCKET;

    public static ConsumableComponent.Builder food() {
        return ConsumableComponent.builder().consumeSeconds(1.6F).useAction(UseAction.EAT).sound(SoundEvents.ENTITY_GENERIC_EAT).consumeParticles(true);
    }

    static {
        CHEESE_BUCKET = food().consumeSeconds(2.0F).build();
    }
}
