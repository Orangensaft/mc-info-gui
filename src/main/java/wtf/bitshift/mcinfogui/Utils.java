package wtf.bitshift.mcinfogui;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;

public class Utils {

    public static void showStats(PlayerEntity player){
        // level stats
        int levelup_xp = player.getNextLevelExperience(); // max xp for CURRENT level
        float progress = player.experienceProgress;
        int currentXP =  (int) (levelup_xp * progress);

        // durability
        ItemStack mainHand = player.getMainHandStack();
        String xpStr;

        if (mainHand.isDamageable()){ // we have an item that may break
            int maxDmg = mainHand.getMaxDamage();
            int curDmg = mainHand.getDamage();
            int hp_left = maxDmg - curDmg;
            xpStr = String.format("XP: %d/%d  D: %d/%d", currentXP, levelup_xp, hp_left, maxDmg);
        } else {
            xpStr = String.format("XP: %d/%d", currentXP, levelup_xp);
        }

        Text msg = Text.of(xpStr);
        player.sendMessage(msg, true);
    }
}
