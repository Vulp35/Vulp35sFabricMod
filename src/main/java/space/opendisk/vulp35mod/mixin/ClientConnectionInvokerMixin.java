package space.opendisk.vulp35mod.mixin;

import net.minecraft.network.ClientConnection;
import net.minecraft.network.Packet;
import net.minecraft.network.PacketCallbacks;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(ClientConnection.class)
public interface ClientConnectionInvokerMixin {
    @Invoker("sendImmediately")
    void callSendImmediately(Packet<?> packet, PacketCallbacks callbacks);

}
