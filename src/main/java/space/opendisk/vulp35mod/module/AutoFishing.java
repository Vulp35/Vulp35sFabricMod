package space.opendisk.vulp35mod.module;

import net.minecraft.client.MinecraftClient;
import net.minecraft.util.Hand;
import space.opendisk.vulp35mod.Vulp35mod;

public class AutoFishing {
    public static int recastRod = -1;

    public static void tick(MinecraftClient client) {
        while(recastRod > 0) {
            recastRod--;
        }
        if (recastRod == 0 && Vulp35mod.autoFishingEnabled) {
            client.interactionManager.interactItem(client.player, Hand.MAIN_HAND);
            recastRod =- 1;
        }

    }

    public static void setRecastRod(int countdown) {
        recastRod = countdown;
        tick(MinecraftClient.getInstance());
    }

}
