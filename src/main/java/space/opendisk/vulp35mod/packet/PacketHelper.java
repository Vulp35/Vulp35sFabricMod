package space.opendisk.vulp35mod.packet;

import net.minecraft.client.MinecraftClient;
import net.minecraft.network.Packet;
import net.minecraft.network.packet.c2s.play.PlayerMoveC2SPacket;
import net.minecraft.util.math.Vec3d;
import space.opendisk.vulp35mod.Vulp35mod;
import space.opendisk.vulp35mod.mixin.ClientConnectionInvokerMixin;

public class PacketHelper {
    public static void sendPosition(Vec3d pos) {
        MinecraftClient client = MinecraftClient.getInstance();
        ClientConnectionInvokerMixin conn = (ClientConnectionInvokerMixin)client.player.networkHandler.getConnection();
        pos = PacketHelper.fixCoords(pos);
        Packet<?> packet = new PlayerMoveC2SPacket.PositionAndOnGround(pos.getX(), pos.getY(), pos.getZ(), false);
        conn.callSendImmediately(packet, null);
        Vulp35mod.LOGGER.info("Position Sent?");

    }

    private static Vec3d fixCoords(Vec3d pos) {
        return pos;
    }

}
