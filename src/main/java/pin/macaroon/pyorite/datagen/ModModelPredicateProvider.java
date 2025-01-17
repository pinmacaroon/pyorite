package pin.macaroon.pyorite.datagen;

import net.minecraft.client.item.ModelPredicateProviderRegistry;
import net.minecraft.item.CrossbowItem;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import pin.macaroon.pyorite.Pyorite;

public class ModModelPredicateProvider {

    public static void regModModels(){
        Pyorite.LOGGER.info("doing regModModels() stuff");
        //regCrossbow(ModItems.BUTTERBOW);
    }

    // wtf is this method bruh
    private static void regCrossbow(Item crossbow){
        ModelPredicateProviderRegistry.register(crossbow, new Identifier("pull"),
                (stack, world, entity, seed) -> {
                    if (entity == null){
                        return 0.0F;
                    } if (entity.getActiveItem() != stack){
                        return 0.0F;
                    } return (float)stack.getMaxUseTime() - entity.getItemUseTimeLeft() / 20.0F;
                }
                );

        ModelPredicateProviderRegistry.register(crossbow, new Identifier("pulling"),
                (stack, world, entity, seed) -> entity != null && entity.isUsingItem() && entity.getActiveItem() == stack ? 1.0F : 0.0F
                );

        ModelPredicateProviderRegistry.register(crossbow, new Identifier("charged"), (stack, world, entity, seed) -> CrossbowItem.isCharged(stack) ? 1.0F : 0.0F);
    }
}
