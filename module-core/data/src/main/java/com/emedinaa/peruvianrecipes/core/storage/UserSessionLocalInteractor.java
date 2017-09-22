package com.emedinaa.peruvianrecipes.core.storage;

import com.emedinaa.peruvianrecipes.core.callback.StorageCallback;
import com.emedinaa.peruvianrecipes.core.entity.User;
import com.emedinaa.peruvianrecipes.core.entity.UserEntity;
import com.emedinaa.peruvianrecipes.core.interactors.UserSessionInteractor;

/**
 * Created by eduardomedina on 14/03/17.
 */

public class UserSessionLocalInteractor implements UserSessionInteractor {

    private final SharedPreferencesHelper sharedPreferencesHelper;

    public UserSessionLocalInteractor(SharedPreferencesHelper sharedPreferencesHelper) {
        this.sharedPreferencesHelper = sharedPreferencesHelper;
    }

    @Override
    public void validateCurrentSession(final StorageCallback storageCallback) {
        UserEntity userEntity= sharedPreferencesHelper.user();

        if(userEntity==null){
            storageCallback.onFailure(new Exception(""));
        }else{
            User user= new User();
            userEntity.setName(userEntity.getName());
            userEntity.setId(userEntity.getId());
            userEntity.setEmail(userEntity.getEmail());

            storageCallback.onSuccess(user);
        }
    }

    @Override
    public void saveSession(User user, final StorageCallback storageCallback) {

        if(user==null){
            storageCallback.onFailure(new Exception(""));
        }else{
            UserEntity userEntity= new UserEntity();
            userEntity.setId(user.getId());
            userEntity.setName(user.getName());
            userEntity.setEmail(user.getEmail());

            sharedPreferencesHelper.saveUser(userEntity);

            storageCallback.onSuccess(null);
        }
    }

    @Override
    public void closeSession(StorageCallback storageCallback) {
        sharedPreferencesHelper.clear();
        storageCallback.onSuccess(null);
    }
}
