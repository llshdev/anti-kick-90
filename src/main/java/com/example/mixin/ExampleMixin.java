package net.fabricmc.example.mixin;

import net.minecraft.entity.Entity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Entity.class)
public abstract class ExampleMixin {
    @Shadow public abstract float getPitch();
    @Shadow public abstract void setPitch(float pitch);

    @Inject(method = "tick", at = @At("HEAD"))
    private void limitPitch(CallbackInfo info) {
        // Проверяем, что это игрок (или просто ограничиваем всё живое)
        if (this.getPitch() > 87.0f) {
            this.setPitch(87.0f);
        }
    }
}
