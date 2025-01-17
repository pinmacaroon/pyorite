package pin.macaroon.pyorite.items;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import pin.macaroon.pyorite.items.custom.AerobladeItem;
import pin.macaroon.pyorite.items.custom.GunItem;
import pin.macaroon.pyorite.items.custom.SytheItem;
import pin.macaroon.pyorite.Pyorite;

public class ModItems {

    public static final Item SYTHE = registerItem("elementite_scythe", new SytheItem(
            ModToolMaterial.SCYTHE_MATERIAL,
            -3F,
            new FabricItemSettings(),
            10));

    public static final Item ELEMENTITE = registerItem("elementite_ingot", new Item(new FabricItemSettings().fireproof().rarity(Rarity.RARE)));
    public static final Item ELEMENTITE_TEMPLATE = registerItem("elementite_smithing_template", new Item(new FabricItemSettings().fireproof().rarity(Rarity.RARE)));
    public static final Item AEROBLADE = registerItem("aeroblade", new AerobladeItem(ModToolMaterial.AEROITE, 3, -2.7F, new Item.Settings().rarity(Rarity.EPIC), 150, 1.5F));
    public static final Item CREEPER_COOKIE = registerItem("creeper_cookie", new Item(new FabricItemSettings().food(ModFoodComponents.CREEPER_COOKIE).maxCount(64)));
    public static final Item AEROITE = registerItem("aeroite", new Item(new FabricItemSettings().rarity(Rarity.RARE)));
    public static final Item HANDGUN = registerItem("handgun", new GunItem(new FabricItemSettings().maxDamage(60), 10, ModItemTags.AMMO, 6D));


    public static void regModItems(){
        Pyorite.LOGGER.info("pinmacaroon registering items");
    }

    private static void addItemsToBuildingBlockItemGroup(FabricItemGroupEntries entries){
    }

    private static void addItemsToIngredientsItemGroup(FabricItemGroupEntries entries){
    }

    private static void addItemsToFoodItemGroup(FabricItemGroupEntries entries){
        //entries.add();
    }

    private static void addItemsToToolsItemGroup(FabricItemGroupEntries entries){
        //entries.add();
    }

    private static void addItemsToCombatItemGroup(FabricItemGroupEntries entries){
    }

    private static Item registerItem(String name, Item item){
        return Registry.register(Registries.ITEM, new Identifier(Pyorite.MOD_ID, name), item);
    }
}
