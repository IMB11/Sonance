package com.mineblock11.sonance.mixin;

import com.mineblock11.sonance.config.SonanceConfig;
import com.mineblock11.sonance.dynamic.DynamicSoundHelper;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ClickType;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import org.lwjgl.glfw.GLFW;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

@Mixin(AbstractContainerMenu.class)
public abstract class ScreenHandlerMixin {
    @Shadow public abstract Slot getSlot(int index);
    @Unique
    private double prevTime = 0D;

    @Inject( method = "method_34249", at = @At(value = "INVOKE", shift = At.Shift.AFTER, target = "Lnet/minecraft/screen/ScreenHandler;setCursorStack(Lnet/minecraft/item/ItemStack;)V"))
    void $item_click_0_sound_effect(Slot slot, Player playerEntity, ItemStack stack, CallbackInfo ci)
    {
        double currentTime = GLFW.glfwGetTime();
        double timeElapsed = currentTime - prevTime;

        if (timeElapsed >= 0.085D) {
            if (!stack.isEmpty())
                SonanceConfig.get().itemClickSoundEffect.playDynamicSound(stack, DynamicSoundHelper.BlockSoundType.PLACE);
            prevTime = currentTime;
        }
    }

    @Inject(method = "internalOnSlotClick", at = @At(value = "INVOKE", shift = At.Shift.AFTER, target = "Lnet/minecraft/screen/ScreenHandler;setCursorStack(Lnet/minecraft/item/ItemStack;)V"))
    void $item_click_1_sound_effect(int slotIndex, int button, ClickType actionType, Player player, CallbackInfo ci)
    {
        if (slotIndex >= 0)
            SonanceConfig.get().itemClickSoundEffect.playDynamicSound(getSlot(slotIndex).getItem(), DynamicSoundHelper.BlockSoundType.PLACE);
    }

    @Inject(method = "internalOnSlotClick", at = @At(value = "INVOKE", shift = At.Shift.AFTER, target = "Lnet/minecraft/item/ItemStack;increment(I)V"))
    void $item_transfer_0_sound_effects(int slotIndex, int button, ClickType actionType, Player player, CallbackInfo ci)
    {
        double currentTime = GLFW.glfwGetTime();
        double timeElapsed = currentTime - prevTime;

        if (timeElapsed >= 0.085D) {
            if (slotIndex >= 0)
                SonanceConfig.get().itemClickSoundEffect.playDynamicSound(getSlot(slotIndex).getItem(), DynamicSoundHelper.BlockSoundType.PLACE);
            prevTime = currentTime;
        }
    }
}
