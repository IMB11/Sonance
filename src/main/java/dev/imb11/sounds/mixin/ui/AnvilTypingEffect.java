package dev.imb11.sounds.mixin.ui;

import dev.imb11.sounds.util.MixinStatics;
import net.minecraft.client.gui.screens.inventory.AnvilScreen;
import dev.imb11.sounds.config.SoundsConfig;
import dev.imb11.sounds.config.UISoundsConfig;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(AnvilScreen.class)
public class AnvilTypingEffect {
    @Inject(method = "keyPressed", at = @At("HEAD"), cancellable = false)
    public void $anvil_typing_sound_effect(int keyCode, int scanCode, int modifiers, CallbackInfoReturnable<Boolean> cir) {
        if (MixinStatics.isNotSpecialKey(keyCode)) {
            SoundsConfig.get(UISoundsConfig.class).inventoryTypingSoundEffect.playSound();
        }
    }
}
