package com.emedinaa.peruvianrecipes.modules.recipe.view;


import com.emedinaa.peruvianrecipes.core.entity.Recipe;
import com.emedinaa.peruvianrecipes.core.presenter.BaseView;
import com.emedinaa.peruvianrecipes.modules.recipe.presenter.RecipesPresenter;

import java.util.List;

/**
 * Created by emedinaa on 14/03/17.
 */

public interface RecipesContract {

    interface View extends BaseView<RecipesPresenter> {
        void showLoading();
        void hideLoading();
        void showMessage(String message);
        void renderRecipes(List<Recipe> recipeList);
        void gotoRecipe(Recipe recipe);
    }
}
