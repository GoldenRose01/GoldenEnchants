package Golden_mods.goldenenchants.events;

import Golden_mods.goldenenchants.registry.ModEnchantments;
import net.fabricmc.fabric.api.event.player.PlayerTickCallback;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;

public class QuickHitHandler {

    public static void register() {
        // Usa un tick event per aggiornare la velocità di attacco in base all'incantesimo
        PlayerTickCallback.EVENT.register((player) -> applyQuickHitEffect(player));
    }

    private static void applyQuickHitEffect(PlayerEntity player) {
        ItemStack mainHandItem = player.getMainHandStack();

        // Controlla se l'oggetto ha l'incantesimo "Quick Hit"
        if (mainHandItem.hasEnchantments() && mainHandItem.getEnchantments().toString().contains("quick_hit")) {
            int level = mainHandItem.getEnchantmentLevel(ModEnchantments.QUICK_HIT);

            // Calcola la velocità di attacco in base al livello (ogni livello aggiunge +1.0 alla velocità di attacco)
            double baseAttackSpeed = 4.0;
            double additionalSpeed = (level * 2.0);  // Incremento progressivo

            // Imposta la velocità d'attacco combinata
            player.getAttributeInstance(EntityAttributes.GENERIC_ATTACK_SPEED).setBaseValue(baseAttackSpeed + additionalSpeed);

            // Aggiungi un tag per identificare che l'effetto è attivo
            if (!player.getScoreboardTags().contains("quick_hit")) {
                player.addScoreboardTag("quick_hit");
            }
        } else {
            // Ripristina la velocità d'attacco predefinita e rimuovi il tag
            player.getAttributeInstance(EntityAttributes.GENERIC_ATTACK_SPEED).setBaseValue(4.0);
            if (player.getScoreboardTags().contains("quick_hit")) {
                player.removeScoreboardTag("quick_hit");
            }
        }
    }
}