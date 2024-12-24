package com.jace.grilledcheese;

import com.jace.grilledcheese.item.ModKnives;
import net.fabricmc.api.ModInitializer;

import com.jace.grilledcheese.item.ModItems;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GrilledCheese implements ModInitializer {
	public static final String MOD_ID = "grilledcheese";

	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {

		ModItems.registerModItems();
		ModKnives.registerModKnives();

		LOGGER.info("sup boss we workin?");
	}
}