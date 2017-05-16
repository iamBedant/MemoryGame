

package io.iamBedant.starter.ui.login;

import javax.inject.Inject;
import io.iamBedant.starter.data.DataManager;
import io.iamBedant.starter.ui.base.BasePresenter;
import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by @iamBedant on 15/03/17.
 */

public class LoginPresenter<V extends LoginMvpView> extends BasePresenter<V>
        implements LoginMvpPresenter<V> {

    private static final String TAG = "LoginPresenter";

    @Inject
    public LoginPresenter(DataManager dataManager, CompositeDisposable compositeDisposable) {
        super(dataManager, compositeDisposable);
    }




}
