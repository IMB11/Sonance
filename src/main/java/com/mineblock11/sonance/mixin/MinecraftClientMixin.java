package com.mineblock11.sonance.mixin;

import com.mineblock11.sonance.config.SonanceConfig;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.screens.inventory.BookEditScreen;
import net.minecraft.client.gui.screens.inventory.BookViewScreen;
import net.minecraft.sounds.SoundEvents;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Minecraft.class)
public abstract class MinecraftClientMixin {
    @Shadow
    @Nullable
    public Screen currentScreen;

    @Inject(method = "setScreen", at = @At("HEAD"), cancellable = false)
    public void $open_close_inventory_sound_effect(Screen screen, CallbackInfo ci) {
        if (screen == null && (currentScreen instanceof BookViewScreen || currentScreen instanceof BookEditScreen)) {
            SonanceConfig.get().inventoryCloseSoundEffect.playDynamicSound(SoundEvents.VILLAGER_WORK_LIBRARIAN);
        } else if (currentScreen != screen && (screen instanceof BookViewScreen || screen instanceof BookEditScreen)) {
            SonanceConfig.get().inventoryOpenSoundEffect.playDynamicSound(SoundEvents.VILLAGER_WORK_LIBRARIAN);
        } else if (screen == null && currentScreen instanceof AbstractContainerScreen<?> handledScreen)
            SonanceConfig.get().inventoryCloseSoundEffect.playDynamicSound(handledScreen.getMenu(), false);
        else if (currentScreen != screen && screen instanceof AbstractContainerScreen<?> handledScreen)
            SonanceConfig.get().inventoryOpenSoundEffect.playDynamicSound(handledScreen.getMenu(), true);
    }
}
