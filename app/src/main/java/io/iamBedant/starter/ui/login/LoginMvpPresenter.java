package io.iamBedant.starter.ui.login;


import io.iamBedant.starter.injection.PerActivity;
import io.iamBedant.starter.ui.base.MvpPresenter;

/**
 * Created by @iamBedant on 15/03/17.
 */

@PerActivity
public interface LoginMvpPresenter<V extends LoginMvpView> extends MvpPresenter<V> {



}
