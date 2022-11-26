package space.opendisk.vulp35mod.module;

import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.util.math.BlockPos;
import space.opendisk.vulp35mod.Vulp35mod;
import space.opendisk.vulp35mod.packet.PacketHelper;

public class Flying {

    int toggle = 0;
    int MAX_SPEED = 3;
    static double FALL_SPEED = -0.04;
    static double acceleration = 0.1;
    static int floatingTickCount;

    public static void Fly() {
        ClientTickEvents.START_CLIENT_TICK.register(client -> {
            if(client.player !=null && Vulp35mod.flyingEnabled) {
                client.player.getAbilities().allowFlying = true;

                double oldY = client.player.getPos().getY();

                if(client.player.getPos().getY() >= oldY-0.0433D) {
                    floatingTickCount += 1;

                }

//                if((floatingTickCount > 20 || Vulp35mod.forceAntiFly)
                if(floatingTickCount > 20 && client.player.world.getBlockState(new BlockPos(client.player.getPos().subtract(0, 0.0433D, 0))).isAir()) {
                    PacketHelper.sendPosition(client.player.getPos().subtract(0.0, 0.0433D, 0.0));

//                    Vulp35mod.forceAntiFly = false;
                    floatingTickCount = 0;

                    Vulp35mod.LOGGER.info("floatingTickCount: " + floatingTickCount);
                }

                client.player.getAbilities().allowFlying = false;
            }
        });
    }


//    public void tick(MinecraftClient client) {
//
//    }
}
