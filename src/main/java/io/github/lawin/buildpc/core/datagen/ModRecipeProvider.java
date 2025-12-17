package io.github.lawin.buildpc.core.datagen;

import io.github.lawin.buildpc.core.block.ModBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    protected void buildRecipes(RecipeOutput recipeOutput) {
        // List<ItemLike>
        //NOTE: 광석 등 굽는 아이템의 레시피 정의부분

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.WHITE_PC_CASE.get())
                .pattern("CCC")
                .pattern("CGG")
                .pattern("CCC")
                .define('C', Blocks.WHITE_CONCRETE)
                .define('G', Blocks.GLASS)
                .unlockedBy("has_white_concrete", has(Blocks.WHITE_CONCRETE))
                .unlockedBy("has_glass", has(Blocks.GLASS))
                .group("pc_case")
                .save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.LIGHT_GRAY_PC_CASE.get())
                .pattern("CCC")
                .pattern("CGG")
                .pattern("CCC")
                .define('C', Blocks.LIGHT_GRAY_CONCRETE)
                .define('G', Blocks.GLASS)
                .unlockedBy("has_light_gray_concrete", has(Blocks.LIGHT_GRAY_CONCRETE))
                .unlockedBy("has_glass", has(Blocks.GLASS))
                .group("pc_case")
                .save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.GRAY_PC_CASE.get())
                .pattern("CCC")
                .pattern("CGG")
                .pattern("CCC")
                .define('C', Blocks.GRAY_CONCRETE)
                .define('G', Blocks.GLASS)
                .unlockedBy("has_gray_concrete", has(Blocks.GRAY_CONCRETE))
                .unlockedBy("has_glass", has(Blocks.GLASS))
                .group("pc_case")
                .save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.BLACK_PC_CASE.get())
                .pattern("CCC")
                .pattern("CGG")
                .pattern("CCC")
                .define('C', Blocks.BLACK_CONCRETE)
                .define('G', Blocks.GLASS)
                .unlockedBy("has_black_concrete", has(Blocks.BLACK_CONCRETE))
                .unlockedBy("has_glass", has(Blocks.GLASS))
                .group("pc_case")
                .save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.BROWN_PC_CASE.get())
                .pattern("CCC")
                .pattern("CGG")
                .pattern("CCC")
                .define('C', Blocks.BROWN_CONCRETE)
                .define('G', Blocks.GLASS)
                .unlockedBy("has_brown_concrete", has(Blocks.BROWN_CONCRETE))
                .unlockedBy("has_glass", has(Blocks.GLASS))
                .group("pc_case")
                .save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.RED_PC_CASE.get())
                .pattern("CCC")
                .pattern("CGG")
                .pattern("CCC")
                .define('C', Blocks.RED_CONCRETE)
                .define('G', Blocks.GLASS)
                .unlockedBy("has_red_concrete", has(Blocks.RED_CONCRETE))
                .unlockedBy("has_glass", has(Blocks.GLASS))
                .group("pc_case")
                .save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.ORANGE_PC_CASE.get())
                .pattern("CCC")
                .pattern("CGG")
                .pattern("CCC")
                .define('C', Blocks.ORANGE_CONCRETE)
                .define('G', Blocks.GLASS)
                .unlockedBy("has_orange_concrete", has(Blocks.ORANGE_CONCRETE))
                .unlockedBy("has_glass", has(Blocks.GLASS))
                .group("pc_case")
                .save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.YELLOW_PC_CASE.get())
                .pattern("CCC")
                .pattern("CGG")
                .pattern("CCC")
                .define('C', Blocks.YELLOW_CONCRETE)
                .define('G', Blocks.GLASS)
                .unlockedBy("has_yellow_concrete", has(Blocks.YELLOW_CONCRETE))
                .unlockedBy("has_glass", has(Blocks.GLASS))
                .group("pc_case")
                .save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.LIME_PC_CASE.get())
                .pattern("CCC")
                .pattern("CGG")
                .pattern("CCC")
                .define('C', Blocks.LIME_CONCRETE)
                .define('G', Blocks.GLASS)
                .unlockedBy("has_lime_concrete", has(Blocks.LIME_CONCRETE))
                .unlockedBy("has_glass", has(Blocks.GLASS))
                .group("pc_case")
                .save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.GREEN_PC_CASE.get())
                .pattern("CCC")
                .pattern("CGG")
                .pattern("CCC")
                .define('C', Blocks.GREEN_CONCRETE)
                .define('G', Blocks.GLASS)
                .unlockedBy("has_green_concrete", has(Blocks.GREEN_CONCRETE))
                .unlockedBy("has_glass", has(Blocks.GLASS))
                .group("pc_case")
                .save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.CYAN_PC_CASE.get())
                .pattern("CCC")
                .pattern("CGG")
                .pattern("CCC")
                .define('C', Blocks.CYAN_CONCRETE)
                .define('G', Blocks.GLASS)
                .unlockedBy("has_cyan_concrete", has(Blocks.CYAN_CONCRETE))
                .unlockedBy("has_glass", has(Blocks.GLASS))
                .group("pc_case")
                .save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.LIGHT_BLUE_PC_CASE.get())
                .pattern("CCC")
                .pattern("CGG")
                .pattern("CCC")
                .define('C', Blocks.LIGHT_BLUE_CONCRETE)
                .define('G', Blocks.GLASS)
                .unlockedBy("has_light_blue_concrete", has(Blocks.LIGHT_BLUE_CONCRETE))
                .unlockedBy("has_glass", has(Blocks.GLASS))
                .group("pc_case")
                .save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.BLUE_PC_CASE.get())
                .pattern("CCC")
                .pattern("CGG")
                .pattern("CCC")
                .define('C', Blocks.BLUE_CONCRETE)
                .define('G', Blocks.GLASS)
                .unlockedBy("has_blue_concrete", has(Blocks.BLUE_CONCRETE))
                .unlockedBy("has_glass", has(Blocks.GLASS))
                .group("pc_case")
                .save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.PURPLE_PC_CASE.get())
                .pattern("CCC")
                .pattern("CGG")
                .pattern("CCC")
                .define('C', Blocks.PURPLE_CONCRETE)
                .define('G', Blocks.GLASS)
                .unlockedBy("has_purple_concrete", has(Blocks.PURPLE_CONCRETE))
                .unlockedBy("has_glass", has(Blocks.GLASS))
                .group("pc_case")
                .save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.MAGENTA_PC_CASE.get())
                .pattern("CCC")
                .pattern("CGG")
                .pattern("CCC")
                .define('C', Blocks.MAGENTA_CONCRETE)
                .define('G', Blocks.GLASS)
                .unlockedBy("has_magenta_concrete", has(Blocks.MAGENTA_CONCRETE))
                .unlockedBy("has_glass", has(Blocks.GLASS))
                .group("pc_case")
                .save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.PINK_PC_CASE.get())
                .pattern("CCC")
                .pattern("CGG")
                .pattern("CCC")
                .define('C', Blocks.PINK_CONCRETE)
                .define('G', Blocks.GLASS)
                .unlockedBy("has_pink_concrete", has(Blocks.PINK_CONCRETE))
                .unlockedBy("has_glass", has(Blocks.GLASS))
                .group("pc_case")
                .save(recipeOutput);
    }
}
