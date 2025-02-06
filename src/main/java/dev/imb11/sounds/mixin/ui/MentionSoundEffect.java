package dev.imb11.sounds.mixin.ui;

import dev.imb11.mru.LoaderUtils;
import dev.imb11.sounds.config.ChatSoundsConfig;
import dev.imb11.sounds.config.SoundsConfig;
import net.minecraft.client.GuiMessageTag;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.ChatComponent;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MessageSignature;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ChatComponent.class)
public class MentionSoundEffect {
    @Shadow
    @Final
    private Minecraft client;

    @Unique
    private float cooldownPeriod = 0f;

    @Inject(method = "render", at = @At("HEAD"))
    /*? if =1.20.1 {*/
    /*public void $cooldown_period(DrawContext context, int currentTick, int mouseX, int mouseY, CallbackInfo ci) {
    *//*?} else {*/
    public void $cooldown_period(GuiGraphics context, int currentTick, int mouseX, int mouseY, boolean focused, CallbackInfo ci) {
    /*?}*/
        if (cooldownPeriod > 0) {
            /*? if <1.21 {*/
            /*cooldownPeriod -= this.client.getTickDelta() / 2f;
            *//*?} else {*/
            cooldownPeriod -= this.client.getDeltaTracker().getGameTimeDeltaPartialTick(true);
            /*?}*/
        }
    }
    /*? if =1.20.1 {*/
    /*@Inject(method = "addMessage(Lnet/minecraft/text/Text;Lnet/minecraft/network/message/MessageSignatureData;ILnet/minecraft/client/gui/hud/MessageIndicator;Z)V", at = @At("HEAD"), cancellable = false)
    public void $mention_recieve_sound_effect(Text message, MessageSignatureData signature, int ticks, MessageIndicator indicator, boolean refresh, CallbackInfo ci) {
    *//*?} else {*/
    @Inject(method = "addMessage(Lnet/minecraft/text/Text;Lnet/minecraft/network/message/MessageSignatureData;Lnet/minecraft/client/gui/hud/MessageIndicator;)V", at = @At("HEAD"), cancellable = false)
    public void $mention_recieve_sound_effect(Component message, MessageSignature signatureData, GuiMessageTag indicator, CallbackInfo ci) {
    /*?}*/
        if (cooldownPeriod > 0 && (SoundsConfig.get(ChatSoundsConfig.class).enableChatSoundCooldown || LoaderUtils.isModInstalled("chatpatches"))) {
            return;
        }

        cooldownPeriod = (LoaderUtils.isModInstalled("chatpatches") ? 0.01f : SoundsConfig.get(ChatSoundsConfig.class).chatSoundCooldown) * 20f;

        String messageString = message.getString();

        // Generate regex from mentionKeywords
        StringBuilder regex = new StringBuilder();
        regex.append("(?i).*(");
        for (String keyword : SoundsConfig.get(ChatSoundsConfig.class).mentionKeywords) {
            regex.append(keyword).append("|");
        }
        regex.deleteCharAt(regex.length() - 1);
        regex.append(").*");

        boolean isMention = messageString.matches(regex.toString());

        if (SoundsConfig.get(ChatSoundsConfig.class).ignoreSystemChats) {
            /*? >1.20.1 {*/
            if (indicator == GuiMessageTag.system() || indicator == GuiMessageTag.chatError()) {
                /*?} else {*/
            /*if(indicator == MessageIndicator.system()) {
            *//*?}*/
                return;
            }
        }

        if (isMention)
            SoundsConfig.get(ChatSoundsConfig.class).mentionSoundEffect.playSound();
        else SoundsConfig.get(ChatSoundsConfig.class).messageSoundEffect.playSound();
    }
}
