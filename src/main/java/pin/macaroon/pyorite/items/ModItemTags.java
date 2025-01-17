package pin.macaroon.pyorite.items;

import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import pin.macaroon.pyorite.Pyorite;

public class ModItemTags {
    public static final TagKey<Item> AMMO = of("gun_ammo");

    public static void regTags(){
        Pyorite.LOGGER.info("item tags");
    }

    private static TagKey<Item> of(String id) {
        return TagKey.of(RegistryKeys.ITEM, new Identifier(Pyorite.MOD_ID + ":" + id));
    }
}
