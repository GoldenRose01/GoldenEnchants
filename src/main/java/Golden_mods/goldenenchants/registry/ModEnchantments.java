package Golden_mods.goldenenchants.registry;

import Golden_mods.goldenenchants.enchantments.PowerDrillEnchantment;
import Golden_mods.goldenenchants.enchantments.SoftFallingEnchantment;
import Golden_mods.goldenenchants.enchantments.QuickHitEnchantment;

import Golden_mods.goldenenchants.config.ConfigManager;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentLevelEntry;
import net.minecraft.item.EnchantedBookItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;
import net.minecraft.registry.Registry;
import net.minecraft.registry.Registries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.ItemGroups;

public class ModEnchantments {

    public static final Enchantment POWER_DRILL = new PowerDrillEnchantment(
            Enchantment.Rarity.RARE,
            EnchantmentTarget.DIGGER,
            EquipmentSlot.MAINHAND
    );

    public static final Enchantment SOFT_FALLING = new SoftFallingEnchantment(
            Enchantment.Rarity.RARE,
            EnchantmentTarget.ARMOR_FEET,
            EquipmentSlot.FEET
    );

    public static final Enchantment QUICK_HIT = new QuickHitEnchantment(
            Enchantment.Rarity.RARE,
            EquipmentSlot.MAINHAND
    );

    public static void registerEnchantments() {
        Registry.register(Registry.ENCHANTMENT, new Identifier("goldenenchants", "power_drill"), POWER_DRILL);
        Registry.register(Registry.ENCHANTMENT, new Identifier("goldenenchants", "soft_falling"), SOFT_FALLING);
        Registry.register(Registries.ENCHANTMENT, new Identifier("goldenenchants", "quick_hit"), QUICK_HIT);

        ConfigManager.updateCreativeInventory();

        // Aggiunta dei libri incantati con i vari livelli nell'inventario creativo
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(entries -> {

            // Power Drill
            for (int i = 1; i <= POWER_DRILL.getMaxLevel(); i++) {
                ItemStack powerDrillBook = EnchantedBookItem.forEnchantment(new EnchantmentLevelEntry(POWER_DRILL, i));
                entries.add(powerDrillBook);
            }

            // Soft Falling
            for (int i = 1; i <= SOFT_FALLING.getMaxLevel(); i++) {
                ItemStack softFallingBook = EnchantedBookItem.forEnchantment(new EnchantmentLevelEntry(SOFT_FALLING, i));
                entries.add(softFallingBook);
            }

            // Quick Hit - aggiunge tutti e 5 i livelli
            for (int i = 1; i <= 5; i++) {
                ItemStack quickHitBook = EnchantedBookItem.forEnchantment(new EnchantmentLevelEntry(QUICK_HIT, i));
                entries.add(quickHitBook);
            }
        });
    }
}
