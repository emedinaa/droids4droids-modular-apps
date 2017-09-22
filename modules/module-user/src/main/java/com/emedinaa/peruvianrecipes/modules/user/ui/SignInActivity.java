package com.emedinaa.peruvianrecipes.modules.user.ui;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.emedinaa.peruvianrecipes.core.ui.BaseActivity;
import com.emedinaa.peruvianrecipes.modules.user.R;
import com.emedinaa.peruvianrecipes.modules.user.presenter.SigInPresenter;
import com.emedinaa.peruvianrecipes.modules.user.view.SigInContract;


public class SignInActivity extends BaseActivity implements SigInContract.View{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        ui();
    }

    private void ui() {
        myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        buildCustomToolbar();

        //events
    }

    private void closeActivity() {
        finish();
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public boolean validate() {
        return false;
    }

    @Override
    public void gotoLogIn() {

    }

    @Override
    public void setPresenter(SigInPresenter presenter) {

    }
}
