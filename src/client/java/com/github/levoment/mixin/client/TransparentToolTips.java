package com.github.levoment.mixin.client;

import com.github.levoment.MoreTranslucentTooltipsClientMod;
import net.minecraft.client.gui.tooltip.TooltipBackgroundRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(TooltipBackgroundRenderer.class)
public class TransparentToolTips {
	@ModifyArg(method = "render(Lnet/minecraft/client/gui/DrawContext;IIIII)V",
			at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/tooltip/TooltipBackgroundRenderer;renderRectangle(Lnet/minecraft/client/gui/DrawContext;IIIIII)V"), index = 6)
	private static int MoreTranslucentTooltipsMod$renderRectangleModifyArg(int color) {
		return MoreTranslucentTooltipsClientMod.backgroundColor;
	}
}