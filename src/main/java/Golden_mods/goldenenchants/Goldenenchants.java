package Golden_mods.goldenenchants;

import net.fabricmc.api.ModInitializer;

/*Librerie create per gli incantesimi*/
import Golden_mods.goldenenchants.registry.ModEnchantments;
import Golden_mods.goldenenchants.events.BlockBreakHandler;
import Golden_mods.goldenenchants.events.SoftFallingHandler;
import Golden_mods.goldenenchants.config.ConfigManager

public class Goldenenchants implements ModInitializer {
    @Override
    public void onInitialize() {
        ConfigManager.loadConfig();
        ModEnchantments.registerEnchantments();
        BlockBreakHandler.register();
        SoftFallingHandler.register();
    }
}