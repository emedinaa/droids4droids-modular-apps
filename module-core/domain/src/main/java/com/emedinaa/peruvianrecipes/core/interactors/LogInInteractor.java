package com.emedinaa.peruvianrecipes.core.interactors;


import com.emedinaa.peruvianrecipes.core.callback.StorageCallback;

/**
 * Created by emedinaa on 13/03/17.
 */

public interface LogInInteractor {

    void logIn(String email, String password, final StorageCallback storageCallback);
}
