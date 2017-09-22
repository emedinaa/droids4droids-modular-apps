package com.emedinaa.peruvianrecipes.core.interactors;


import com.emedinaa.peruvianrecipes.core.callback.StorageCallback;

/**
 * Created by eduardomedina on 7/12/16.
 */
public interface EventsInteractor {

    void events(String group_urlname, StorageCallback callback);
    void pastEvents(String group_urlname, StorageCallback callback);
}
