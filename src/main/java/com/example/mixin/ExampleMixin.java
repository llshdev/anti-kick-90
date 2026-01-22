package com.example.mixin;

import net.minecraft.client.network.ClientPlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ClientPlayerEntity.class)
public class ExampleMixin {
    @Inject(method = "tick", at = @At("HEAD"))
    private void limitPitch(CallbackInfo info) {
        ClientPlayerEntity player = (ClientPlayerEntity) (Object) this;
        // Если смотрим вниз больше чем на 87 градусов - ставим ровно 87
        if (player.getPitch() > 87.0f) {
            player.setPitch(87.0f);
        }
    }
}
