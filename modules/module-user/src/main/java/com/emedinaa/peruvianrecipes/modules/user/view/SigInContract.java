package com.emedinaa.peruvianrecipes.modules.user.view;

import com.emedinaa.peruvianrecipes.core.presenter.BaseView;
import com.emedinaa.peruvianrecipes.modules.user.presenter.SigInPresenter;

/**
 * Created by emedinaa on 13/03/17.
 */

public interface SigInContract {

    interface View extends BaseView<SigInPresenter> {
        void showLoading();
        void hideLoading();
        boolean validate();
        void gotoLogIn();
    }
}
