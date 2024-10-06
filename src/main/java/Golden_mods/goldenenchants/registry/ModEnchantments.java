package Golden_mods.goldenenchants.registry;

import Golden_mods.goldenenchants.enchantments.PowerDrillEnchantment;
import Golden_mods.goldenenchants.enchantments.SoftFallingEnchantment;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentLevelEntry;
import net.minecraft.item.EnchantedBookItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
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

    public static void registerEnchantments() {
        Registry.register(Registry.ENCHANTMENT, new Identifier("goldenenchants", "power_drill"), POWER_DRILL);
        Registry.register(Registry.ENCHANTMENT, new Identifier("goldenenchants", "soft_falling"), SOFT_FALLING);

        // Aggiunge i libri incantati nell'inventario creativo
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(entries -> {

            // Libro Power Drill
            ItemStack powerDrillBook = EnchantedBookItem.forEnchantment(new EnchantmentLevelEntry(POWER_DRILL, 1));
            entries.add(powerDrillBook);

            // Libro Soft Falling
            ItemStack softFallingBook = EnchantedBookItem.forEnchantment(new EnchantmentLevelEntry(SOFT_FALLING, 1));
            entries.add(softFallingBook);
        });
    }
}
