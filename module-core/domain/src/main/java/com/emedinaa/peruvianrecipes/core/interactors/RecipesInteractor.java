package com.emedinaa.peruvianrecipes.core.interactors;


import com.emedinaa.peruvianrecipes.core.callback.StorageCallback;

/**
 * Created by emedinaa on 14/03/17.
 */

public interface RecipesInteractor {

    void getRecipes(final StorageCallback callback);
}
