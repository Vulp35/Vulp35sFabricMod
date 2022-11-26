package space.opendisk.vulp35mod.module;


import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.option.GameOptions;
import net.minecraft.screen.ScreenTexts;
import net.minecraft.text.*;
import space.opendisk.vulp35mod.Vulp35mod;


public class Vulp35Screen extends Screen {

    private final Screen parent;
    private final GameOptions options;

    public Vulp35Screen(Screen parent, GameOptions options) {
        super(Text.literal("Vulp35's Mod"));
        this.parent = parent;
        this.options = options;
    }

    Text autoFishingText() {
        if(Vulp35mod.autoFishingEnabled) {
            return Text.literal("Auto-fishing is Enabled");
        } else {
            return Text.literal("Auto-fishing is Disabled");
        }
    }

    Text flyingText() {
        if(Vulp35mod.flyingEnabled) {
            return Text.literal("Flying is Enabled");
        } else {
            return Text.literal("Flying is Disabled");
        }
    }

    protected void init() {
        // Auto-fishing button
        this.addDrawableChild(new ButtonWidget(this.width / 2 - 100, this.height / 6 + 90, 200, 20,
                autoFishingText(), button -> {
            Vulp35mod.autoFishingEnabled = !Vulp35mod.autoFishingEnabled;
            button.setMessage(autoFishingText());
        }));

        // Flying button
        this.addDrawableChild(new ButtonWidget(this.width / 2 - 100, this.height / 6 + 65, 200, 20,
                flyingText(), button -> {
            Vulp35mod.flyingEnabled = !Vulp35mod.flyingEnabled;
            button.setMessage(flyingText());
        }));

        // Back Button
        this.addDrawableChild(new ButtonWidget(this.width / 2 - 100, this.height / 6 + 138, 200, 20,
                ScreenTexts.BACK, (button) -> {
            this.client.setScreen(this.parent);
        }));
    }

}
