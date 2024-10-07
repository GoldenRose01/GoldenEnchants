package Golden_mods.goldenenchants.enchantments;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;

public class PowerDrillEnchantment extends Enchantment {
    public PowerDrillEnchantment(Rarity weight, EnchantmentTarget target, EquipmentSlot... slots) {
        super(weight, target, slots);
    }


    @Override
    public boolean isTreasure() {
        return true; // Definisci se è un incantesimo raro
    }

    @Override
    public boolean isCursed() {
        return false; // Non è maledetto
    }

    @Override
    public int getMaxLevel() {
        return 1; // Definisci il livello massimo dell'incantesimo
    }

    @Override
    public boolean isAcceptableItem(ItemStack stack) {
        // Rendi compatibile con pale e picconi
        return stack.isOf(Items.DIAMOND_SHOVEL) || stack.isOf(Items.DIAMOND_PICKAXE)
                || stack.isOf(Items.NETHERITE_SHOVEL) || stack.isOf(Items.NETHERITE_PICKAXE)
                || stack.isOf(Items.IRON_SHOVEL) || stack.isOf(Items.IRON_PICKAXE)
                || stack.isOf(Items.STONE_SHOVEL) || stack.isOf(Items.STONE_PICKAXE)
                || stack.isOf(Items.GOLDEN_SHOVEL) || stack.isOf(Items.GOLDEN_PICKAXE)
                || stack.isOf(Items.WOODEN_SHOVEL) || stack.isOf(Items.WOODEN_PICKAXE);
    }
}
