package dev.photoncore.server;

import dev.photoncore.server.init.*;
import net.minestom.server.MinecraftServer;
import net.minestom.server.extras.MojangAuth;
import org.fusesource.jansi.AnsiConsole;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
    public static Logger LOGGER = LoggerFactory.getLogger(Main.class);
    public static boolean stopping = false;

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        
        AnsiConsole.systemInstall();
        MinecraftServer server = MinecraftServer.init();

        MojangAuth.init();
        Levels.init();
        Events.init();
        Commands.init();
        Blocks.init();
        Schedulers.init();

        server.start("0.0.0.0", 1033);
        LOGGER.info("Done! ({}s)",  String.format("%.2f", (double) (System.currentTimeMillis() - startTime) / 1000));
    }
    
    public static void stop() {
        MinecraftServer.stopCleanly();
        System.exit(0);
    }
}
