package io.iamBedant.starter.ui.splash;


import io.iamBedant.starter.injection.PerActivity;
import io.iamBedant.starter.ui.base.MvpPresenter;

/**
 * Created by @iamBedant on 15/03/17.
 */

@PerActivity
public interface SplashMvpPresenter<V extends SplashMvpView> extends MvpPresenter<V> {

}
