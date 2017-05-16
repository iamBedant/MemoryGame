package io.iamBedant.starter.injection.module;

import android.app.Activity;
import android.content.Context;

import io.iamBedant.starter.injection.ActivityContext;
import io.iamBedant.starter.injection.PerActivity;
import io.iamBedant.starter.ui.game.GameMvpPresenter;
import io.iamBedant.starter.ui.game.GameMvpView;
import io.iamBedant.starter.ui.game.GamePresenter;
import io.iamBedant.starter.ui.login.LoginMvpPresenter;
import io.iamBedant.starter.ui.login.LoginMvpView;
import io.iamBedant.starter.ui.login.LoginPresenter;
import io.iamBedant.starter.ui.splash.SplashMvpPresenter;
import io.iamBedant.starter.ui.splash.SplashMvpView;
import io.iamBedant.starter.ui.splash.SplashPresenter;
import dagger.Module;
import dagger.Provides;
import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by @iamBedant on 15/03/17.
 */

@Module
public class ActivityModule {

    private Activity mActivity;

    public ActivityModule(Activity activity) {
        this.mActivity = activity;
    }

    @Provides
    @ActivityContext
    Context provideContext() {
        return mActivity;
    }

    @Provides
    Activity provideActivity() {
        return mActivity;
    }

    @Provides
    CompositeDisposable provideCompositeDisposable() {
        return new CompositeDisposable();
    }

    @Provides
    @PerActivity
    SplashMvpPresenter<SplashMvpView> provideSplashPresenter(SplashPresenter<SplashMvpView> presenter) {
        return presenter;
    }

    @Provides
    @PerActivity
    LoginMvpPresenter<LoginMvpView> provideLoginPresenter(LoginPresenter<LoginMvpView> presenter) {
        return presenter;
    }

    @Provides
    @PerActivity
    GameMvpPresenter<GameMvpView> provideGamePresenter(GamePresenter<GameMvpView> presenter) {
        return presenter;
    }
}
