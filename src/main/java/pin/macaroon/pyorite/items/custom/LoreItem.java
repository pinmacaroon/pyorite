package pin.macaroon.pyorite.items.custom;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import pin.macaroon.pyorite.Pyorite;

import java.util.List;

public class LoreItem extends Item {
    public LoreItem(Settings settings) {
        super(settings);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        assert stack.getNbt() != null;
        String DOT = ".";
        tooltip.add(Text.translatable("item." + Pyorite.MOD_ID +DOT+ stack.getNbt().getString("id") +DOT+ "lore"));
    }
}
