package pin.macaroon.pyorite.items;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import pin.macaroon.pyorite.items.custom.SytheItem;
import pin.macaroon.pyorite.Pyorite;

public class ModItems {

    public static final Item SYTHE = registerItem("elementite_scythe", new SytheItem(
            ModToolMaterial.SCYTHE_MATERIAL,
            -3F,
            new FabricItemSettings(),
            10));

    public static final Item ELEMENTITE = registerItem("elementite_ingot", new Item(new FabricItemSettings().fireproof().rarity(Rarity.RARE)));

    public static void regModItems(){
        Pyorite.LOGGER.info("pinmacaroon registering items lmao");
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
