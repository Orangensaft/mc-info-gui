package wtf.bitshift.mcinfogui.mixin;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;


@Mixin(PlayerEntity.class)
public class ModMixin{

    @Inject(at = @At("RETURN"), method="addExperience")//, locals = LocalCapture.PRINT)
    public void addXpCallback(int xp, CallbackInfo ci) {
        if (xp >0 ) {
            PlayerEntityInterface player = (PlayerEntityInterface) this;
            int maxXP = player.invoke_getNextLevelExperience();
            float progress = player.getExperienceProgress();
            int currentXP =  (int) (maxXP * progress);
            if (currentXP < xp){
                player.invoke_sendMessage(Text.of(String.format("Got %d xp. Level up! (%d/%d)", xp, currentXP, maxXP)),false);
                player.invoke_sendMessage(Text.of(String.format("Got %d xp. Level up! (%d/%d)", xp, currentXP, maxXP)),true);
            } else {
                player.invoke_sendMessage(Text.of(String.format("Got %d xp. (%d/%d)", xp, currentXP, maxXP)), false);
                player.invoke_sendMessage(Text.of(String.format("Got %d xp. (%d/%d)", xp, currentXP, maxXP)), true);
            }
        }
    }

}
