package space.opendisk.vulp35mod.hud;

import io.github.cottonmc.cotton.gui.client.CottonHud;
import io.github.cottonmc.cotton.gui.widget.WLabel;
import net.minecraft.text.Text;

public class CustomHud {

        public static void Hud(){

            CottonHud.add(new WLabel(Text.literal("Test label")), 0, -30, 10, 10);
    }
}
