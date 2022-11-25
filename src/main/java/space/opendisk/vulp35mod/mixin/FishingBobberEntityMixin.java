package space.opendisk.vulp35mod.mixin;


import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.projectile.FishingBobberEntity;
import net.minecraft.util.Hand;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import space.opendisk.vulp35mod.Vulp35mod;
import space.opendisk.vulp35mod.module.AutoFishing;

@Mixin(FishingBobberEntity.class)
public abstract class FishingBobberEntityMixin {

    @Shadow private boolean caughtFish;

    @Inject(method = "onTrackedDataSet", at = @At("TAIL"))
    public void onTrackedDataSet(TrackedData<?> data, CallbackInfo ci) {

        MinecraftClient client = MinecraftClient.getInstance();

        if(caughtFish && Vulp35mod.autoFishingEnabled) {
            AutoFishing.setRecastRod(40);
            client.interactionManager.interactItem(client.player, Hand.MAIN_HAND);
        }
    }

}
