package net.fabricmc.example;

import com.mojang.brigadier.CommandDispatcher;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class SpawnWatcherCommand {
    public static void register(CommandDispatcher<ServerCommandSource> dispatcher) {
        dispatcher.register(CommandManager.literal("spawnwatcher")
                .executes(context -> {
                    var player = context.getSource().getPlayer();
                    World world = player.getWorld();
                    Vec3d pos = player.getPos().add(player.getRotationVec(1.0F).multiply(2));

                    WatcherEntity watcher = new WatcherEntity(ExampleMod.WATCHER, world);
                    watcher.refreshPositionAndAngles(pos.getX(), pos.getY(), pos.getZ(), 0, 0);
                    world.spawnEntity(watcher);

                    context.getSource().sendFeedback(
                            net.minecraft.text.Text.of("👁️ You feel something watching..."), false);

                    return 1;
                }));
    }
}
