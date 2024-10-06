package Golden_mods.goldenenchants.events;

import net.fabricmc.fabric.api.event.player.AttackBlockCallback;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;

import Golden_mods.goldenenchants.registry.ModEnchantments;

public class SoftFallingHandler {
    public static void register() {
        AttackBlockCallback.EVENT.register((player, world, hand, pos, direction) -> {
            if (!world.isClient && hand.equals(player.getMainHandStack()) && hasSoftFalling(player)) {
                applySoftFallingEffect(player);
            }
            return ActionResult.PASS;
        });
    }

    // Verifica se il giocatore ha l'incantesimo Soft Falling
    private static boolean hasSoftFalling(PlayerEntity player) {
        return EnchantmentHelper.getLevel(ModEnchantments.SOFT_FALLING, player.getMainHandStack()) > 0;
    }

    // Applica l'effetto Slow Falling
    private static void applySoftFallingEffect(PlayerEntity player) {
        player.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOW_FALLING, 100, 1, true, false, true));
    }
}
