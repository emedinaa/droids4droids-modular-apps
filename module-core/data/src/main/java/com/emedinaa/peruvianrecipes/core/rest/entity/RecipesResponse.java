package com.emedinaa.peruvianrecipes.core.rest.entity;


import com.emedinaa.peruvianrecipes.core.entity.Recipe;

import java.util.List;

/**
 * Created by emedinaa on 14/03/17.
 */

public class RecipesResponse extends BaseResponse {

    private List<Recipe> data;

    public List<Recipe> getData() {
        return data;
    }

    public void setData(List<Recipe> data) {
        this.data = data;
    }
}
