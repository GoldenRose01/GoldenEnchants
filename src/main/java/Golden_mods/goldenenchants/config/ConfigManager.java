package Golden_mods.goldenenchants.config;

import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.EnchantedBookItem;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentLevelEntry;
import net.minecraft.registry.Registry;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.HashMap;
import java.util.Map;


public class ConfigManager {

    private static final String CONFIG_FILENAME = "lvlench.dat";
    private static final String DEFAULT_CONFIG_PATH = "/defaultlvlench.dat";
    private static Map<Enchantment, Integer> enchantmentLevels = new HashMap<>();

    public static void loadConfig() {
        // Percorso della cartella config di Minecraft
        Path configDir = FabricLoader.getInstance().getConfigDir();
        Path configFile = configDir.resolve(CONFIG_FILENAME);

        // Se il file di configurazione non esiste, crea una copia del default
        if (!Files.exists(configFile)) {
            createDefaultConfig(configFile);
        }

        // Leggi i livelli degli incantesimi dal file di configurazione
        readEnchantmentsFromConfig(configFile);
    }

    private static void createDefaultConfig(Path configFile) {
        try {
            // Ottieni il file di default dal jar del progetto
            Path defaultConfig = FabricLoader.getInstance().getModContainer("goldenenchants")
                    .orElseThrow(() -> new IllegalStateException("Mod container not found"))
                    .findPath(DEFAULT_CONFIG_PATH).orElseThrow(() -> new IllegalStateException("Default config file not found"));

            // Copia il file default nella cartella config
            Files.createDirectories(configFile.getParent());  // Crea la directory se non esiste
            Files.copy(defaultConfig, configFile, StandardCopyOption.REPLACE_EXISTING);

            System.out.println("File di configurazione copiato da defaultlvlench.dat a lvlench.dat.");
        } catch (IOException e) {
            System.err.println("Errore durante la copia del file di configurazione: " + e.getMessage());
        }
    }

    private static void readEnchantmentsFromConfig(Path configFile) {
        try (BufferedReader reader = new BufferedReader(new FileReader(configFile.toFile()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Ignora le righe vuote e i commenti
                if (line.trim().isEmpty() || line.startsWith("#")) continue;

                String[] parts = line.split(":");
                if (parts.length == 2) {
                    String enchantmentName = parts[0].trim();
                    int level = Integer.parseInt(parts[1].trim());

                    Enchantment enchantment = Registry.ENCHANTMENT.get(new Identifier("goldenenchants", enchantmentName));
                    if (enchantment != null) {
                        enchantmentLevels.put(enchantment, level);
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Errore durante la lettura del file di configurazione: " + e.getMessage());
        }
    }

    public static void updateCreativeInventory() {
        // Aggiungi i libri incantati all'inventario creativo in base ai livelli
        for (Map.Entry<Enchantment, Integer> entry : enchantmentLevels.entrySet()) {
            Enchantment enchantment = entry.getKey();
            int level = entry.getValue();

            // Solo per incantesimi con più di un livello
            if (level > 1) {
                ItemStack enchantedBook = EnchantedBookItem.forEnchantment(new EnchantmentLevelEntry(enchantment, level));
                // Aggiungi il libro incantato all'inventario creativo (modifica il gruppo di item)
                // Assicurati di usare l'ItemGroup corretto
            }
        }
    }
}