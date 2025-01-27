package pin.macaroon.pyorite.items;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import pin.macaroon.pyorite.block.ModBlocks;
import pin.macaroon.pyorite.items.custom.AerobladeItem;
import pin.macaroon.pyorite.items.custom.GunItem;
import pin.macaroon.pyorite.items.custom.LoreItem;
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
    public static final Item AEROBLADE = registerItem("aeroblade", new AerobladeItem(ModToolMaterial.AEROITE, 3,1, new Item.Settings().rarity(Rarity.EPIC), 150, 1.3F));
    private static Item field26a = new Item(new FabricItemSettings().food(ModFoodComponents.CREEPER_COOKIE).maxCount(64));
    public static final Item CREEPER_COOKIE = registerItem("creeper_cookie", field26a);
    public static final Item AEROITE = registerItem("aeroite", new Item(new FabricItemSettings().rarity(Rarity.RARE)));
    public static final Item HANDGUN = registerItem("handgun", new GunItem(new FabricItemSettings().maxDamage(60), 10, ModItemTags.AMMO, 6D));
    public static final Item GILDED_NETHERITE_HOLY_GREATSWORD = registerItem( "gilded_netherite_holy_greatsword", new SwordItem(ModToolMaterial.HOLY, 10, -3.5f, new FabricItemSettings().maxCount(1).rarity(Rarity.UNCOMMON)));
    public static final Item SHWRAPPEL = registerItem("shwrappel",new Item(new FabricItemSettings().rarity(Rarity.COMMON)));
    public static final Item PYORITE_CHUNK = registerItem("pyorite_chunk",new Item(new FabricItemSettings().rarity(Rarity.COMMON)));
    public static final Item PYORITE_HELMET = registeritem( "pyorite_helmet", new ArmorItem(ModArmorMaterials.PYORITE_CHUNK, ArmorItem.Type.HELMET, new FabricItemSettings()));
    public static final Item PYORITE_CHESTPLATE = registeritem( "pyorite_chestplate", new ArmorItem(ModArmorMaterials.PYORITE_CHUNK, ArmorItem.Type.CHESTPLATE, new FabricItemSettings()));
    public static final Item PYORITE_LEGGINGS = registeritem( "pyorite_leggings", new ArmorItem(ModArmorMaterials.PYORITE_CHUNK, ArmorItem.Type.LEGGINGS, new FabricItemSettings()));
    public static final Item PYORITE_BOOTS = registeritem( "pyorite_boots", new ArmorItem(ModArmorMaterials.PYORITE_CHUNK, ArmorItem.Type.BOOTS, new FabricItemSettings()));


    public static void regModItems(){
        Pyorite.LOGGER.info("pinmacaroon registering items");
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(ModItems::addItemsToBuildingBlockItemGroup);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::addItemsToIngredientsItemGroup);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(ModItems::addItemsToFoodItemGroup);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(ModItems::addItemsToToolsItemGroup);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(ModItems::addItemsToCombatItemGroup);
    }

    private static void addItemsToBuildingBlockItemGroup(FabricItemGroupEntries entries){
        entries.addAfter(Items.YELLOW_WOOL, ModBlocks.PIN_PLUSH);
    }

    private static void addItemsToIngredientsItemGroup(FabricItemGroupEntries entries){
        entries.addAfter(Items.NETHERITE_INGOT, PYORITE_CHUNK);
        entries.addAfter(PYORITE_CHUNK, ELEMENTITE);
        entries.addAfter(Items.SPIRE_ARMOR_TRIM_SMITHING_TEMPLATE, ELEMENTITE_TEMPLATE);
        entries.addAfter(Items.GUNPOWDER, SHWRAPPEL);
        entries.addAfter(Items.REDSTONE, AEROITE);
    }

    private static void addItemsToFoodItemGroup(FabricItemGroupEntries entries){
        entries.addAfter(Items.COOKIE, CREEPER_COOKIE);
    }

    private static void addItemsToToolsItemGroup(FabricItemGroupEntries entries){
        //entries.add();
    }

    private static void addItemsToCombatItemGroup(FabricItemGroupEntries entries){

        entries.addAfter(Items.NETHERITE_SWORD, AEROBLADE);
        entries.addAfter(AEROBLADE, GILDED_NETHERITE_HOLY_GREATSWORD);
        entries.addAfter(GILDED_NETHERITE_HOLY_GREATSWORD, HANDGUN);

        entries.addAfter(Items.NETHERITE_BOOTS, PYORITE_HELMET);
        entries.addAfter(PYORITE_HELMET, PYORITE_CHESTPLATE);
        entries.addAfter(PYORITE_CHESTPLATE, PYORITE_LEGGINGS);
        entries.addAfter(PYORITE_LEGGINGS, PYORITE_BOOTS);

        entries.addAfter(Items.TRIDENT, SYTHE);

    }

    private static Item registerItem(String name, Item item){
        return Registry.register(Registries.ITEM, new Identifier(Pyorite.MOD_ID, name), item);
    }
    private static Item registeritem(String name, Item item){
        return registerItem(name, item);
    }
}
