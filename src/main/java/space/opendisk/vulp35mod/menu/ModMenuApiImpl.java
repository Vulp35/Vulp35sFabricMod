package space.opendisk.vulp35mod.menu;

import com.terraformersmc.modmenu.api.ConfigScreenFactory;
import com.terraformersmc.modmenu.api.ModMenuApi;
import space.opendisk.vulp35mod.module.Vulp35Screen;

public class ModMenuApiImpl implements ModMenuApi {

    @Override
    public ConfigScreenFactory<?> getModConfigScreenFactory() {
        return parent -> new Vulp35Screen(parent, null);
    }
}
