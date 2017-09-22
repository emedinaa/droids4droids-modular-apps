package com.emedinaa.peruvianrecipes.core;

import android.support.annotation.StringDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import static com.emedinaa.peruvianrecipes.core.PeruvianRecipesUI.Activity.LOGIN;
import static com.emedinaa.peruvianrecipes.core.PeruvianRecipesUI.Activity.MAIN;
import static com.emedinaa.peruvianrecipes.core.PeruvianRecipesUI.Activity.PROFILE;
import static com.emedinaa.peruvianrecipes.core.PeruvianRecipesUI.Activity.RECIPES;
import static com.emedinaa.peruvianrecipes.core.PeruvianRecipesUI.Activity.RECIPE_DETAILS;
import static com.emedinaa.peruvianrecipes.core.PeruvianRecipesUI.Activity.SIGNIN;

/**
 * Created by emedinaa on 22/09/17.
 */

public class PeruvianRecipesUI {

    @StringDef({LOGIN,SIGNIN,PROFILE,RECIPES,RECIPE_DETAILS,MAIN})
    @Retention(RetentionPolicy.SOURCE)
    public @interface Activity {
        String MAIN = "com.emedinaa.peruvianrecipes.modules.user.ui.DashboardActivity";
        String SIGNIN = "com.emedinaa.peruvianrecipes.modules.user.ui.SignInActivity";
        String LOGIN = "com.emedinaa.peruvianrecipes.modules.user.ui.LogInActivity";
        String PROFILE = "com.emedinaa.peruvianrecipes.modules.user.ui.ProfileActivity";
        String RECIPES = "com.emedinaa.peruvianrecipes.modules.recipe.ui.DashboardRecipesActivity";
        String RECIPE_DETAILS = "com.emedinaa.peruvianrecipes.modules.recipe.ui.RecipeDetailActivity";
    }
}
