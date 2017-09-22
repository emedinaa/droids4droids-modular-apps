package com.emedinaa.peruvianrecipes.core.interactors;


import com.emedinaa.peruvianrecipes.core.callback.StorageCallback;
import com.emedinaa.peruvianrecipes.core.entity.User;

/**
 * Created by eduardomedina on 14/03/17.
 */

public interface UserSessionInteractor {

    void validateCurrentSession(final StorageCallback storageCallback);
    void saveSession(User user, final StorageCallback storageCallback);
    void closeSession(final StorageCallback storageCallback);
}
