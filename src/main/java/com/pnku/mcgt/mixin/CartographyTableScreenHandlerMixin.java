package com.pnku.mcgt.mixin;

import com.pnku.mcgt.block.MoreCartographyTablesBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.screen.CartographyTableScreenHandler;
import net.minecraft.screen.ScreenHandlerContext;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(CartographyTableScreenHandler.class)
public abstract class CartographyTableScreenHandlerMixin {

    @Shadow
    @Final
    private ScreenHandlerContext context;

    @Inject(method = "canUse", at = @At("HEAD"), cancellable = true)
    private void canUse(PlayerEntity player, CallbackInfoReturnable<Boolean> info) {
        if (context.get((world, pos) -> world.getBlockState(pos).getBlock() instanceof MoreCartographyTablesBlock, true)) {
            info.setReturnValue(true);
        }
    }
}