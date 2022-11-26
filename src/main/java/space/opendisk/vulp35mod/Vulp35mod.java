package space.opendisk.vulp35mod;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import space.opendisk.vulp35mod.module.Flying;

public class Vulp35mod implements ModInitializer {

    public static final String MOD_ID = "vulp35mod";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
    public static boolean autoFishingEnabled = false;
    public static boolean flyingEnabled = false;
    public static boolean forceAntiFly;

    @Override
    public void onInitialize() {
        LOGGER.info("Vulp35 Mod Initialize!");
        Flying.Fly();
    }
}
