package dev.imb11.sounds.mixin.gameplay;

import dev.imb11.sounds.config.GameplaySoundConfig;
import net.minecraft.block.entity.JukeboxBlockEntity;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(JukeboxBlockEntity.class)
public class JukeboxBlockEntityMixin {
    @Inject(method = "setStack", at = @At(value = "HEAD"))
    /*? <1.20.3 {*//*
    public void $jukebox_use_sound_effect(int slot, ItemStack stack, CallbackInfo ci) {
    /*?} else {*/
    public void $jukebox_use_sound_effect(ItemStack stack, CallbackInfo ci) {
    /*?}*/
        GameplaySoundConfig.get().jukeboxUseSoundEffect.playSound();
    }
}