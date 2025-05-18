package pin.macaroon.pyorite.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.block.Blocks;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.data.server.recipe.SmithingTransformRecipeJsonBuilder;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import pin.macaroon.pyorite.block.ModBlocks;
import pin.macaroon.pyorite.items.ModItems;

import java.util.List;
import java.util.function.Consumer;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output) {
        super(output);
    }



    //private static final List<ItemConvertible> STEEL_SMELTABLES = List.of(ModItems.RAW_STEEL, ModBlocks.RAW_STEEL_BLOCK, ModBlocks.DEEPSLATE_STEEL_ORE);
    private static final List<ItemConvertible> ICES = List.of(Blocks.ICE, Blocks.BLUE_ICE, Blocks.FROSTED_ICE, Blocks.PACKED_ICE);
    @Override
    public void generate(Consumer<RecipeJsonProvider> exporter) {

        //offerSmelting(exporter, STEEL_SMELTABLES, RecipeCategory.MISC, ModItems.STEEL_INGOT,
        //        0.7f, 200, "steel");

        //offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.STEEL_INGOT, RecipeCategory.DECORATIONS,
        //        ModBlocks.STEEL_BLOCK);

        ShapedRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.CREEPER_COOKIE, 1)
                .pattern(" MM")
                .pattern("GCM")
                .pattern("GG ")
                .input('C', Items.COOKIE)
                .input('M', Items.MOSS_BLOCK)
                .input('G', Items.GUNPOWDER)
                .criterion(hasItem(Items.COOKIE), conditionsFromItem(Items.COOKIE))
                .criterion(hasItem(Items.GUNPOWDER), conditionsFromItem(Items.GUNPOWDER))
                .criterion(hasItem(Items.MOSS_BLOCK), conditionsFromItem(Items.MOSS_BLOCK))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.CREEPER_COOKIE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.ELEMENTITE, 1)
                .pattern("SA") // ayo 🧐
                .pattern("AS") // lmao again 💀
                .input('A', Items.AMETHYST_SHARD)
                .input('S', Items.NETHERITE_SCRAP)
                .criterion(hasItem(Items.AMETHYST_SHARD), conditionsFromItem(Items.AMETHYST_SHARD))
                .criterion(hasItem(Items.NETHERITE_INGOT), conditionsFromItem(Items.NETHERITE_INGOT))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.ELEMENTITE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.ELEMENTITE_TEMPLATE, 2)
                .pattern("SDg")
                .pattern("aTG")
                .pattern("SDg")
                .input('S', Items.AMETHYST_SHARD)
                .input('g', Items.GOLD_INGOT)
                .input('G', Blocks.GOLD_BLOCK)
                .input('D', Blocks.COBBLED_DEEPSLATE)
                .input('T', ModItems.ELEMENTITE_TEMPLATE)
                .input('a', Items.AMETHYST_BLOCK)
                .criterion(hasItem(Items.AMETHYST_SHARD), conditionsFromItem(Items.AMETHYST_SHARD))
                .criterion(hasItem(Items.AMETHYST_BLOCK), conditionsFromItem(Items.AMETHYST_BLOCK))
                .criterion(hasItem(Blocks.GOLD_BLOCK), conditionsFromItem(Blocks.GOLD_BLOCK))
                .criterion(hasItem(Blocks.DEEPSLATE), conditionsFromItem(Blocks.DEEPSLATE))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.ELEMENTITE_TEMPLATE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.GILDED_NETHERITE_HOLY_GREATSWORD, 1)
                .pattern("r n")
                .pattern("fng")
                .pattern("bfr")
                .input('r', Items.RAW_GOLD)
                .input('n', Items.NETHERITE_BLOCK)
                .input('g', Items.RAW_GOLD_BLOCK)
                .input('b', Items.BLAZE_ROD)
                .input('f', Items.NETHERITE_SCRAP)
                .criterion(hasItem(Items.ANCIENT_DEBRIS), conditionsFromItem(Items.ANCIENT_DEBRIS))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.GILDED_NETHERITE_HOLY_GREATSWORD)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.HANDGUN, 1)
                .pattern("f  ")
                .pattern(" p ")
                .pattern("  s")
                .input('s', Items.FLINT_AND_STEEL)
                .input('p', ModItems.PYORITE_CHUNK)
                .input('f', Items.DROPPER)
                .criterion(hasItem(ModItems.PYORITE_CHUNK), conditionsFromItem(ModItems.PYORITE_CHUNK))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.HANDGUN)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.PIN_PLUSH, 1)
                .pattern("bbb")
                .pattern("fhf")
                .pattern("wpw")
                .input('b', Blocks.BROWN_WOOL)
                .input('h', ModItems.PRETTY_PINK_HEART)
                .input('f', Blocks.BLACK_WOOL)
                .input('w', Blocks.WHITE_WOOL)
                .input('p', Blocks.RED_WOOL)
                .criterion(hasItem(ModItems.PRETTY_PINK_HEART), conditionsFromItem(ModItems.PRETTY_PINK_HEART))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.PIN_PLUSH)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.BOX_PLUSH, 1)
                .pattern("bbb")
                .pattern("yhy")
                .pattern("wpw")
                .input('b', Blocks.BROWN_WOOL)
                .input('h', ModItems.PRETTY_PINK_HEART)
                .input('y', Blocks.YELLOW_WOOL)
                .input('w', Blocks.BLUE_WOOL)
                .input('p', Blocks.GREEN_WOOL)
                .criterion(hasItem(ModItems.PRETTY_PINK_HEART), conditionsFromItem(ModItems.PRETTY_PINK_HEART))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.BOX_PLUSH)));

        // ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.ICE_SWORD, 1)
        //  .pattern("i")
        //   .pattern("i")
        //  .pattern("s")
        //  .input('i', Ingredient.ofItems(Blocks.ICE, Blocks.BLUE_ICE, Blocks.FROSTED_ICE, Blocks.PACKED_ICE))
        //  .input('s', Items.STICK)
        // .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
        // .offerTo(exporter, new Identifier(getRecipeName(ModItems.ICE_SWORD)));
        /*
        //ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.MAILCE, 1)
        //   .pattern("i")
        //   .pattern("s")
        //   .pattern("s")
        //   .input('i', Blocks.IRON_BLOCK)
        //   .input('s', Items.STICK)
        //.criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
        // .offerTo(exporter, new Identifier(getRecipeName(ModItems.MAILCE)));
        */
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.ARCH_PLUSH, 1)
                .pattern("bbg")
                .pattern("bhg")
                .pattern("w#w")
                .input('b', Blocks.BROWN_WOOL)
                .input('h', ModItems.PRETTY_PINK_HEART)
                .input('w', Blocks.WHITE_WOOL)
                .input('#', Blocks.BLACK_WOOL)
                .input('g', Blocks.GREEN_WOOL)
                .criterion(hasItem(ModItems.PRETTY_PINK_HEART), conditionsFromItem(ModItems.PRETTY_PINK_HEART))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.ARCH_PLUSH)));



        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.AEROBLADE, 1)
                .pattern("IA")
                .input('I', Items.IRON_SWORD)
                .input('A', ModItems.AEROITE)
                .criterion(hasItem(ModItems.AEROITE), conditionsFromItem(ModItems.AEROITE))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.AEROBLADE)));

        /*
        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.CRYSTAL_METH, 1)
                .input(ModItems.STEEL_INGOT)
                .input(Items.QUARTZ)
                .criterion(hasItem(ModItems.STEEL_INGOT), conditionsFromItem(ModItems.STEEL_INGOT))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.CRYSTAL_METH)));

         */

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.PYORITE_CHUNK,1)
                .input(Items.IRON_INGOT)
                .input(Items.NETHERITE_SCRAP)
                .criterion(hasItem(ModItems.PYORITE_CHUNK)
                        ,conditionsFromItem(ModItems.PYORITE_CHUNK))
                .offerTo(exporter,new Identifier(getRecipeName(ModItems.PYORITE_CHUNK)));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.SHWRAPPEL,2)
                .input(Items.IRON_NUGGET)
                .input(Items.GUNPOWDER)
                .criterion(hasItem(ModItems.SHWRAPPEL)
                        ,conditionsFromItem(ModItems.SHWRAPPEL))
                .offerTo(exporter,new Identifier(getRecipeName(ModItems.SHWRAPPEL)));


        offerCustomUpgradeRecipe(exporter, Items.NETHERITE_HOE, RecipeCategory.COMBAT, ModItems.SYTHE, ModItems.ELEMENTITE_TEMPLATE, ModItems.ELEMENTITE);
        offerCustomUpgradeRecipe(exporter, Items.DIAMOND_BOOTS, RecipeCategory.COMBAT, ModItems.PYORITE_BOOTS, Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE, ModItems.PYORITE_CHUNK);
        offerCustomUpgradeRecipe(exporter, Items.DIAMOND_LEGGINGS, RecipeCategory.COMBAT, ModItems.PYORITE_LEGGINGS, Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE, ModItems.PYORITE_CHUNK);
        offerCustomUpgradeRecipe(exporter, Items.DIAMOND_CHESTPLATE, RecipeCategory.COMBAT, ModItems.PYORITE_CHESTPLATE, Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE, ModItems.PYORITE_CHUNK);
        offerCustomUpgradeRecipe(exporter, Items.DIAMOND_HELMET, RecipeCategory.COMBAT, ModItems.PYORITE_HELMET, Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE, ModItems.PYORITE_CHUNK);
    }

    public static void offerCustomUpgradeRecipe(Consumer<RecipeJsonProvider> exporter, Item input, RecipeCategory category, Item result, Item template, Item material) {
        SmithingTransformRecipeJsonBuilder.create(
                        Ingredient.ofItems(template), Ingredient.ofItems(input), Ingredient.ofItems(material), category, result
                )
                .criterion(hasItem(material), conditionsFromItem(material))
                .offerTo(exporter, getItemPath(result) + "_smithing");


    }
}
