package io.iamBedant.starter.ui.game;


import io.iamBedant.starter.data.remote.model.game.Logo;
import io.iamBedant.starter.injection.PerActivity;
import io.iamBedant.starter.ui.base.MvpPresenter;

/**
 * Created by @iamBedant on 15/03/17.
 */

@PerActivity
public interface GameMvpPresenter<V extends GameMvpView> extends MvpPresenter<V> {


    void getImages(int level);

    void hideLogos();

    void checkLogo(Logo logo);

    void showImage();
}
