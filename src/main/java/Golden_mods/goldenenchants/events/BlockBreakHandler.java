package Golden_mods.goldenenchants.events;

import Golden_mods.goldenenchants.Goldenenchants;
import Golden_mods.goldenenchants.registry.ModEnchantments;
import net.fabricmc.fabric.api.event.player.AttackBlockCallback;
import net.minecraft.block.Block;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockBreakHandler {

    public static void register() {
        // Quando il giocatore rompe un blocco
        AttackBlockCallback.EVENT.register((player, world, hand, pos, direction) -> {
            if (!world.isClient && hand.equals(player.getMainHandStack()) && isPowerDrillEnchanted(player)) {
                breakSurroundingBlocks(player, world, pos);
            }
            return ActionResult.PASS;
        });
    }

    // Controlla se l'oggetto del giocatore ha l'incantesimo Power Drill
    private static boolean isPowerDrillEnchanted(PlayerEntity player) {
        return EnchantmentHelper.getLevel(ModEnchantments.POWER_DRILL, player.getMainHandStack()) > 0;
    }

    // Rompe i blocchi circostanti secondo la logica del datapack
    private static void breakSurroundingBlocks(PlayerEntity player, World world, BlockPos pos) {
        BlockPos[] surroundingBlocks = {
                pos.up(), pos.down(), pos.north(), pos.south(), pos.east(), pos.west()
        };

        for (BlockPos blockPos : surroundingBlocks) {
            Block block = world.getBlockState(blockPos).getBlock();
            if (block != null && player.canHarvest(block.getDefaultState())) {
                world.breakBlock(blockPos, true, player);
            }
        }
    }
}
