package com.emedinaa.peruvianrecipes;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.emedinaa.peruvianrecipes.core.Navigation;
import com.emedinaa.peruvianrecipes.core.PeruvianRecipesUI;
import com.emedinaa.peruvianrecipes.core.helpers.GsonHelper;
import com.emedinaa.peruvianrecipes.core.storage.DefaultSharedPreferencesHelper;
import com.emedinaa.peruvianrecipes.core.storage.SharedPreferencesHelper;
import com.emedinaa.peruvianrecipes.core.storage.UserSessionLocalInteractor;
import com.emedinaa.peruvianrecipes.core.ui.BaseActivity;

import java.util.Timer;
import java.util.TimerTask;

public class SplashActivity extends BaseActivity implements UserSessionContract.View {

    private final int SPLASH_TIME=1500;
    private Timer timer;
    private UserSessionPresenter userSessionPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        SharedPreferences sharedPreferences= getSharedPreferences(SPREFERENCES, Context.MODE_PRIVATE);
        SharedPreferencesHelper preferencesHelper= new DefaultSharedPreferencesHelper(
                new GsonHelper(),sharedPreferences );
        setPresenter(new UserSessionPresenter(this, new UserSessionLocalInteractor(preferencesHelper)));

        app();
    }

    private void app() {
        timer= new Timer();
        TimerTask task = new TimerTask()
        {
            @Override
            public void run()
            {
                validateSession();
            }
        };

        timer.schedule(task, SPLASH_TIME);
    }

    private void validateSession() {
        userSessionPresenter.validateSession();
    }


    @Override
    public void gotoLogIn() {
        Navigation.getInstance().startActivity(this,
                new Bundle(), PeruvianRecipesUI.Activity.LOGIN,true);
    }

    @Override
    public void gotoMain() {
        Navigation.getInstance().startActivity(this,
                new Bundle(),  PeruvianRecipesUI.Activity.RECIPES,true);
    }


    @Override
    public void setPresenter(UserSessionPresenter presenter) {
        this.userSessionPresenter= presenter;
    }
}
