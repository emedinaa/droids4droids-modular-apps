package com.emedinaa.peruvianrecipes.modules.user.ui;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.emedinaa.peruvianrecipes.core.Navigation;
import com.emedinaa.peruvianrecipes.core.PeruvianRecipesUI;
import com.emedinaa.peruvianrecipes.core.helpers.GsonHelper;
import com.emedinaa.peruvianrecipes.core.storage.DefaultSharedPreferencesHelper;
import com.emedinaa.peruvianrecipes.core.storage.SharedPreferencesHelper;
import com.emedinaa.peruvianrecipes.core.storage.UserSessionLocalInteractor;
import com.emedinaa.peruvianrecipes.modules.user.R;
import com.emedinaa.peruvianrecipes.modules.user.presenter.LogOutPresenter;
import com.emedinaa.peruvianrecipes.modules.user.view.LogOutContract;


public class ProfileActivity extends AppCompatActivity implements
        LogOutContract.View{

    private static final String SPREFERENCES = "com.emedinaa.peruvian_recipes.session";

    private View btnLogOut;
    private LogOutPresenter logOutPresenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        SharedPreferences sharedPreferences= getSharedPreferences(SPREFERENCES, Context.MODE_PRIVATE);
        SharedPreferencesHelper preferencesHelper= new DefaultSharedPreferencesHelper(
                new GsonHelper(),sharedPreferences );
        setPresenter(new LogOutPresenter(this, new UserSessionLocalInteractor(preferencesHelper)));
        ui();
    }

    private void ui() {
        btnLogOut= findViewById(R.id.btnLogOut);
        btnLogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                closeSession();
            }
        });
    }

    private void closeSession() {
        logOutPresenter.closeSession();
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showMessage(String message) {

    }

    @Override
    public void gotoLogIn() {
        Navigation.getInstance().startActivityAndReset(this,new Bundle(),
                PeruvianRecipesUI.Activity.LOGIN,true);
    }

    @Override
    public void setPresenter(LogOutPresenter presenter) {
        logOutPresenter= presenter;
    }
}
