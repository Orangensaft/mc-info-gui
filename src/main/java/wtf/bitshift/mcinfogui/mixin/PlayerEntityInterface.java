package wtf.bitshift.mcinfogui.mixin;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(PlayerEntity.class)
public interface PlayerEntityInterface {
    @Invoker("getNextLevelExperience")
    int invoke_getNextLevelExperience();

    @Invoker("sendMessage")
    void invoke_sendMessage(Text message, boolean actionBar);

    @Accessor("experienceProgress")
    float getExperienceProgress();
}
