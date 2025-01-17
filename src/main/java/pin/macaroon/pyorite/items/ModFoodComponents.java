package pin.macaroon.pyorite.items;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;
import pin.macaroon.pyorite.entity.effect.ModStatusEffects;

public class ModFoodComponents {
    public static  final FoodComponent CREEPER_COOKIE = new FoodComponent.Builder()
            .hunger(2)
            .saturationModifier(0.1F)
            .statusEffect(new StatusEffectInstance(ModStatusEffects.EXPLOSIVE, 1, 75), 0.5f) //amplifier a szazalek
            .build();
}
