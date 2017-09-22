package com.emedinaa.peruvianrecipes.core.storage;


import com.emedinaa.peruvianrecipes.core.entity.UserEntity;

/**
 * Created by eduardomedina on 15/11/16.
 */
public interface SharedPreferencesHelper {

    void saveEmail(String email);
    String email();

    void saveUser(UserEntity user);
    UserEntity user();

    void clear();
}
