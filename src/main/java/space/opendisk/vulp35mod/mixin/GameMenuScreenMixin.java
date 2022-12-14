package space.opendisk.vulp35mod.mixin;

import net.minecraft.client.gui.screen.GameMenuScreen;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import space.opendisk.vulp35mod.menu.ModOptionsGui;
import space.opendisk.vulp35mod.menu.ModOptionsScreen;

@Mixin(GameMenuScreen.class)
public abstract class GameMenuScreenMixin extends Screen {
    protected GameMenuScreenMixin(Text title) {super(title); }

    @Inject(at = @At("HEAD"), method = "initWidgets")
    private void initWidgets(CallbackInfo ci) {
        this.addDrawableChild(new ButtonWidget(10,20,90,20, Text.translatable("title.vulp35mod.vulp35smod"),
                (button) -> {
                    assert this.client != null;
                    this.client.setScreen(new ModOptionsScreen(new ModOptionsGui(client.currentScreen)));
                }));
    }
}
