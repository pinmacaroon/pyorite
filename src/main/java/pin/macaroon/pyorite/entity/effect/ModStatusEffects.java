package pin.macaroon.pyorite.entity.effect;

import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import pin.macaroon.pyorite.Pyorite;

public class ModStatusEffects {

    public static final StatusEffect EXPLOSIVE = registerEffect("explosive", new ExplosiveStatusEffect());
    public static final StatusEffect FREEZING = registerEffect("freezing", new FreezingEffect());

    private static StatusEffect registerEffect(String name, StatusEffect statusEffect){
        return Registry.register(Registries.STATUS_EFFECT, new Identifier(Pyorite.MOD_ID, name), statusEffect);
    }

    public static void registerModEffects(){
        Pyorite.LOGGER.info("registering effects");
    }
}
