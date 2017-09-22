package com.emedinaa.peruvianrecipes.modules.user.presenter;


import com.emedinaa.peruvianrecipes.core.callback.StorageCallback;
import com.emedinaa.peruvianrecipes.core.entity.User;
import com.emedinaa.peruvianrecipes.core.interactors.LogInInteractor;
import com.emedinaa.peruvianrecipes.core.interactors.UserSessionInteractor;
import com.emedinaa.peruvianrecipes.modules.user.view.LogInContract;

/**
 * Created by emedinaa on 13/03/17.
 */

public class LogInPresenter {
    private  final LogInContract.View logInView;
    private final LogInInteractor logInInteractor;
    private final UserSessionInteractor userSessionInteractor;

    public LogInPresenter(LogInContract.View logInView, LogInInteractor logInInteractor, UserSessionInteractor userSessionInteractor) {
        this.logInView = logInView;
        this.logInInteractor = logInInteractor;
        this.userSessionInteractor = userSessionInteractor;
    }

    private StorageCallback storageCallback= new StorageCallback() {
        @Override
        public void onSuccess(Object object) {
            logInView.hideLoading();
            User user=(User)(object);
            saveSession(user);
        }

        @Override
        public void onFailure(Exception e) {
            logInView.hideLoading();
        }
    };

    private StorageCallback sessionStorageCallback= new StorageCallback() {
        @Override
        public void onSuccess(Object object) {
            logInView.hideLoading();
            logInView.gotoMain();
        }

        @Override
        public void onFailure(Exception e) {
            logInView.hideLoading();
        }
    };


    public void logIn(String email, String password){
        logInView.showLoading();
        logInInteractor.logIn(email,password,storageCallback);
    }

    private void saveSession(User user){
        userSessionInteractor.saveSession(user,sessionStorageCallback);
    }
}
