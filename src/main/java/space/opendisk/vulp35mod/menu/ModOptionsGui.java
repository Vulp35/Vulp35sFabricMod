package space.opendisk.vulp35mod.menu;

import io.github.cottonmc.cotton.gui.client.LightweightGuiDescription;
import io.github.cottonmc.cotton.gui.widget.WButton;
import io.github.cottonmc.cotton.gui.widget.WGridPanel;
import io.github.cottonmc.cotton.gui.widget.WLabel;
import io.github.cottonmc.cotton.gui.widget.WToggleButton;
import io.github.cottonmc.cotton.gui.widget.data.HorizontalAlignment;
import io.github.cottonmc.cotton.gui.widget.data.Insets;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.Text;
import space.opendisk.vulp35mod.Vulp35mod;


public class ModOptionsGui extends LightweightGuiDescription {

    public static int gridSize = 18;
    public ModOptionsGui(Screen previous) {

        WGridPanel root = new WGridPanel();
        setRootPanel(root);
        root.setInsets(Insets.ROOT_PANEL);
        root.setSize(gridSize*8, gridSize*4);

        WLabel label = new WLabel(Text.translatable("title.vulp35mod.vulp35smod"));
        label.setHorizontalAlignment(HorizontalAlignment.CENTER);
        root.add(label, 0, 0, 8, 2);

        WToggleButton autofishingToggle = new WToggleButton(Text.literal("Auto-fishing"));
        autofishingToggle.setToggle(Vulp35mod.autoFishingEnabled);
        autofishingToggle.setOnToggle(on -> {
            Vulp35mod.autoFishingEnabled = !Vulp35mod.autoFishingEnabled;
            Vulp35mod.LOGGER.info("Auto-fishing is " + (on ? "on" : "off"));
        });
        root.add(autofishingToggle, 0, 1 );

        WButton backButton = new WButton(Text.translatable("Back"));
        root.add(backButton, 0, 4, 4 ,1);
        backButton.setOnClick(()-> MinecraftClient.getInstance().setScreen(previous));




    }
}
