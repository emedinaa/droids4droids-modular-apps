package com.emedinaa.peruvianrecipes.core.callback;

/**
 * Created by eduardo on 11/12/16.
 */
public interface StorageCallback {

    void onSuccess(Object object);
    void onFailure(Exception e);
}
