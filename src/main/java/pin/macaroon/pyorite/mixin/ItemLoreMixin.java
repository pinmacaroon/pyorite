package pin.macaroon.pyorite.mixin;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import pin.macaroon.pyorite.Pyorite;

import java.util.List;

@Mixin(Item.class)
public class ItemLoreMixin {
    @Inject(at=@At("HEAD"), method = "appendTooltip")
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context, CallbackInfo ci) {
        assert stack.getNbt().getString("id") != null;
        String DOT = ".";
        tooltip.add(Text.translatable("item." + Pyorite.MOD_ID +DOT+ stack.getNbt().getString("id") +DOT+ "lore"));
    }
}
