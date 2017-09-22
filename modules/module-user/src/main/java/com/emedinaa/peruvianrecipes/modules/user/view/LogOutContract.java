package com.emedinaa.peruvianrecipes.modules.user.view;

import com.emedinaa.peruvianrecipes.core.presenter.BaseView;
import com.emedinaa.peruvianrecipes.modules.user.presenter.LogOutPresenter;

/**
 * Created by emedinaa on 14/03/17.
 */

public interface LogOutContract {

    interface View extends BaseView<LogOutPresenter> {
        void showLoading();
        void hideLoading();
        void showMessage(String message);
        void gotoLogIn();
    }
}
