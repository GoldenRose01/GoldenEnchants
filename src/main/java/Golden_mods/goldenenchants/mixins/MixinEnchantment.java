package Golden_mods.goldenenchants.mixins;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantments;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(Enchantment.class)
public abstract class MixinEnchantment {

    /**
     * @author
     * @reason
     */
    @Overwrite
    public int getMaxLevel() {
        // Modifica i livelli massimi per gli incantesimi vanilla
        if (this == Enchantments.AQUA_AFFINITY) {
            return 1; // Aqua Affinity (solo 1 livello, quindi non modificato)
        } else if (this == Enchantments.BANE_OF_ARTHROPODS) {
            return 5; // Maledizione degli Artropodi
        } else if (this == Enchantments.BLAST_PROTECTION) {
            return 4; // Protezione dalle Esplosioni
        } else if (this == Enchantments.BREACH) {
            return 4; // Breach
        } else if (this == Enchantments.CHANNELING) {
            return 1; // Channeling (solo 1 livello, quindi non modificato)
        } else if (this == Enchantments.BINDING_CURSE) {
            return 1; // Maledizione di Legame (solo 1 livello, quindi non modificato)
        } else if (this == Enchantments.VANISHING_CURSE) {
            return 1; // Maledizione di Scomparsa (solo 1 livello, quindi non modificato)
        } else if (this == Enchantments.DENSITY) {
            return 5; // Density
        } else if (this == Enchantments.DEPTH_STRIDER) {
            return 3; // Depth Strider
        } else if (this == Enchantments.EFFICIENCY) {
            return 5; // Efficienza
        } else if (this == Enchantments.FEATHER_FALLING) {
            return 4; // Caduta Morbida
        } else if (this == Enchantments.FIRE_ASPECT) {
            return 2; // Fire Aspect
        } else if (this == Enchantments.FIRE_PROTECTION) {
            return 4; // Protezione dal Fuoco
        } else if (this == Enchantments.FLAME) {
            return 1; // Fiamma (solo 1 livello, quindi non modificato)
        } else if (this == Enchantments.FORTUNE) {
            return 5; // Fortuna
        } else if (this == Enchantments.FROST_WALKER) {
            return 2; // Frost Walker
        } else if (this == Enchantments.IMPALING) {
            return 5; // Impalamento
        } else if (this == Enchantments.INFINITY) {
            return 1; // Infinito (solo 1 livello, quindi non modificato)
        } else if (this == Enchantments.KNOCKBACK) {
            return 2; // Knockback
        } else if (this == Enchantments.LOOTING) {
            return 3; // Predazione
        } else if (this == Enchantments.LOYALTY) {
            return 3; // Loyalty
        } else if (this == Enchantments.LUCK_OF_THE_SEA) {
            return 3; // Luck of the Sea
        } else if (this == Enchantments.LURE) {
            return 3; // Lure
        } else if (this == Enchantments.MENDING) {
            return 1; // Mending (solo 1 livello, quindi non modificato)
        } else if (this == Enchantments.MULTISHOT) {
            return 1; // Multishot (solo 1 livello, quindi non modificato)
        } else if (this == Enchantments.PIERCING) {
            return 4; // Piercing
        } else if (this == Enchantments.POWER) {
            return 5; // Potenza
        } else if (this == Enchantments.PROJECTILE_PROTECTION) {
            return 4; // Protezione dai Proiettili
        } else if (this == Enchantments.PROTECTION) {
            return 4; // Protezione
        } else if (this == Enchantments.PUNCH) {
            return 2; // Punch
        } else if (this == Enchantments.QUICK_CHARGE) {
            return 3; // Quick Charge
        } else if (this == Enchantments.RIPTIDE) {
            return 3; // Riptide
        } else if (this == Enchantments.SILK_TOUCH) {
            return 1; // Silk Touch (solo 1 livello, quindi non modificato)
        } else if (this == Enchantments.SMITE) {
            return 5; // Maledizione
        } else if (this == Enchantments.SOUL_SPEED) {
            return 3; // Soul Speed
        } else if (this == Enchantments.SWEEPING_EDGE) {
            return 3; // Sweeping Edge
        } else if (this == Enchantments.SWIFT_SNEAK) {
            return 3; // Swift Sneak
        } else if (this == Enchantments.THORNS) {
            return 3; // Spine
        } else if (this == Enchantments.UNBREAKING) {
            return 3; // Infrangibile
        } else if (this == Enchantments.WIND_BURST) {
            return 3; // Wind Burst
        }

        // Ritorna 1 per incantesimi con solo un livello
        return 1;
    }
}
