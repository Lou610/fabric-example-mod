package net.fabricmc.example;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.fabricmc.fabric.api.command.v1.CommandRegistrationCallback;

public class ExampleMod implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger("modid");

	public static final String MOD_ID = "example";

	public static final EntityType<WatcherEntity> WATCHER = Registry.register(
			Registry.ENTITY_TYPE,
			new Identifier(MOD_ID, "watcher"),
			EntityType.Builder.create(WatcherEntity::new, SpawnGroup.MONSTER)
					.setDimensions(0.6f, 1.95f)
					.build("watcher") // required in your Loom version
	);


	@Override
	public void onInitialize() {
		FabricDefaultAttributeRegistry.register(WATCHER, WatcherEntity.createWatcherAttributes());
		System.out.println("👁️ The Watcher mod is loaded!");
		CommandRegistrationCallback.EVENT.register((dispatcher, dedicated) -> {
			SpawnWatcherCommand.register(dispatcher);
		});
	}
}
