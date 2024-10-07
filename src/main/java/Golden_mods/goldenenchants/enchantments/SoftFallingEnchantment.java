package Golden_mods.goldenenchants.enchantments;

import net.minecraft.enchantment.Enchantment;

import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;

public class SoftFallingEnchantment extends Enchantment {

    public SoftFallingEnchantment(Rarity weight, EnchantmentTarget target, EquipmentSlot... slots) {
        super(weight, target, slots);
    }

    @Override
    public int getMaxLevel() {
        return 1;
    }

    @Override
    public boolean isTreasure() {
        return true;
    }

    @Override
    public boolean isCursed() {
        return false;
    }

    @Override
    public boolean canAccept(Enchantment other) {
        // Rende incompatibile con Feather Falling
        return super.canAccept(other) && other != Enchantments.FEATHER_FALLING;
    }

    @Override
    public boolean isAcceptableItem(ItemStack stack) {
        // Compatibile solo con stivaletti di ferro, diamante o netherite
        return stack.isOf(Items.IRON_BOOTS) || stack.isOf(Items.DIAMOND_BOOTS) || stack.isOf(Items.NETHERITE_BOOTS);
    }
}
