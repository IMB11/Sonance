package dev.imb11.sounds.mixin;

import dev.imb11.mru.LoaderUtils;
import dev.imb11.sounds.config.ChatSoundsConfig;
import dev.imb11.sounds.config.SoundsConfig;
import dev.imb11.sounds.config.utils.ConfigGroup;
import dev.imb11.sounds.gui.IncompatabilityScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Arrays;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.gui.screens.TitleScreen;
import net.minecraft.network.chat.Component;

@Mixin(TitleScreen.class)
public abstract class TitleScreenWidget extends Screen {
    protected TitleScreenWidget(Component title) {
        super(title);
    }

    @Inject(method = "init", at = @At("HEAD"))
    public void init(CallbackInfo ci) {
//        this.addDrawableChild(ButtonWidget.builder(Text.of("test"), (button -> {
//            assert this.client != null;
//            this.client.setScreen(new TestScreen());
//        })).dimensions(10, 10, 100, 20).build());

        if(LoaderUtils.isModInstalled("qualitysounds")) {
            this.minecraft.setScreen(new IncompatabilityScreen());
        }
    }
}
