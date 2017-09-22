package com.emedinaa.peruvianrecipes;


import com.emedinaa.peruvianrecipes.core.callback.StorageCallback;
import com.emedinaa.peruvianrecipes.core.interactors.UserSessionInteractor;

/**
 * Created by eduardomedina on 14/03/17.
 */

public class UserSessionPresenter {

    private  final UserSessionContract.View sessionView;
    private final UserSessionInteractor userSessionInteractor;


    public UserSessionPresenter(UserSessionContract.View sessionView, UserSessionInteractor userSessionInteractor) {
        this.sessionView = sessionView;
        this.userSessionInteractor = userSessionInteractor;
    }

    private StorageCallback storageCallback= new StorageCallback() {
        @Override
        public void onSuccess(Object object) {
            sessionView.gotoMain();
        }

        @Override
        public void onFailure(Exception e) {
            sessionView.gotoLogIn();
        }
    };

    public void validateSession(){
        userSessionInteractor.validateCurrentSession(storageCallback);
    }
}
