package Golden_mods.goldenenchants.enchantments;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.AxeItem;
import net.minecraft.item.TridentItem;
import net.minecraft.entity.EquipmentSlot;

public class QuickHitEnchantment extends Enchantment {

    public QuickHitEnchantment(Rarity rarity, EquipmentSlot... slots) {
        super(rarity, EnchantmentTarget.WEAPON, slots);
    }

    @Override
    public int getMaxLevel() {
        return 5;  // Quick Hit avrà un massimo di 3 livelli
    }

    @Override
    public boolean isTreasure() {
        return true;  // Definisci se è un incantesimo raro
    }

    @Override
    public boolean isAvailableForEnchantedBookOffer() {
        return true;  // Disponibile come libro incantato
    }

    @Override
    public boolean isAcceptableItem(ItemStack stack) {
        // Compatibile con spade, asce e tridenti
        return stack.getItem() instanceof SwordItem || stack.getItem() instanceof AxeItem || stack.getItem() instanceof TridentItem;
    }
}
