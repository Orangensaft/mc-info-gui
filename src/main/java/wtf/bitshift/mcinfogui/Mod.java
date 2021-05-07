package wtf.bitshift.mcinfogui;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.player.AttackBlockCallback;
import net.fabricmc.fabric.api.event.player.AttackEntityCallback;

import net.minecraft.util.ActionResult;

public class Mod implements ModInitializer {
    @Override
    public void onInitialize() {
        // show when hitting blocks
        AttackBlockCallback.EVENT.register(
                ((player, world, hand, pos, direction) -> {
                    Utils.showStats(player);
                    return ActionResult.PASS;
                })
        );

        // show when hitting entities
        AttackEntityCallback.EVENT.register(
                ((player, world, hand, entity, hitResult) -> {
                    Utils.showStats(player);
                    return ActionResult.PASS;
                })
        );
    }



}
