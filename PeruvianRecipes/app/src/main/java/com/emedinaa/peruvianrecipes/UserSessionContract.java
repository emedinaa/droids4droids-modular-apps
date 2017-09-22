package com.emedinaa.peruvianrecipes;


import com.emedinaa.peruvianrecipes.core.presenter.BaseView;

/**
 * Created by eduardomedina on 14/03/17.
 */

public interface UserSessionContract {

    interface View extends BaseView<UserSessionPresenter> {
        void gotoLogIn();
        void gotoMain();
    }
}
