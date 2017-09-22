package com.emedinaa.peruvianrecipes.modules.user.view;


import com.emedinaa.peruvianrecipes.core.presenter.BaseView;
import com.emedinaa.peruvianrecipes.modules.user.presenter.LogInPresenter;

/**
 * Created by emedinaa on 13/03/17.
 */

public interface LogInContract {

    interface View extends BaseView<LogInPresenter> {
        void showLoading();
        void hideLoading();
        void showMessage(String message);
        boolean validate();
        void gotoMain();
    }
}
