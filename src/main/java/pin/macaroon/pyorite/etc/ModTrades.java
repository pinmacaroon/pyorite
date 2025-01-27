package pin.macaroon.pyorite.etc;

import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.village.TradeOffer;
import pin.macaroon.pyorite.Pyorite;
import pin.macaroon.pyorite.items.ModItems;

public class ModTrades {
    public static void regTrades(){
        Pyorite.LOGGER.info("registering trades");

        TradeOfferHelper.registerWanderingTraderOffers(1, factories -> {
            factories.add(((entity, random) -> new TradeOffer(
                    new ItemStack(Items.EMERALD, 8),
                    new ItemStack(ModItems.PRETTY_PINK_HEART, 1),
                    3, 5, 0.1F
            )));
        });
    }
}
