

package io.iamBedant.starter.ui.game;

import com.androidnetworking.error.ANError;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.inject.Inject;

import io.iamBedant.starter.data.DataManager;
import io.iamBedant.starter.data.remote.model.game.Logo;
import io.iamBedant.starter.ui.base.BasePresenter;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by @iamBedant on 15/03/17.
 */

public class GamePresenter<V extends GameMvpView> extends BasePresenter<V>
        implements GameMvpPresenter<V> {

    private static final String TAG = "GamePresenter";
    List<Logo> hiddenList = new ArrayList<>();
    List<Logo> logoList = new ArrayList<>();
    Logo currentLogo = new Logo();
    private Random randomGenerator = new Random();
    int randomInt;

    @Inject
    public GamePresenter(DataManager dataManager, CompositeDisposable compositeDisposable) {
        super(dataManager, compositeDisposable);
    }


    @Override
    public void getImages(final int level) {

        getCompositeDisposable().add(getDataManager().getGameObject()
                .flatMapIterable(new Function<List<Logo>, Iterable<Logo>>() {
                    @Override
                    public Iterable<Logo> apply(@NonNull List<Logo> logos) throws Exception {
                        return logos;
                    }
                })
                .take(level * 2)
                .toList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<List<Logo>>() {
                    @Override
                    public void accept(@NonNull List<Logo> logos) throws Exception {
                        for (Logo l : logos) {
                            l.setHidden(false);
                            logoList.add(new Logo(l.getId(), l.getImage(), false));
                        }
                        getMvpView().displayRecyclerView(logos, 6000);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(@NonNull Throwable throwable) throws Exception {
                        if(!isViewAttached()) {
                            return;
                        }

                        getMvpView().hideLoading();
                        if (throwable instanceof ANError) {
                            ANError anError = (ANError) throwable;
                            handleApiError(anError);
                        }
                    }
                }));

    }

    @Override
    public void hideLogos() {
        List<Logo> newList = new ArrayList<>();

        for (Logo l : logoList) {
            l.setHidden(true);
            newList.add(new Logo(l.getId(), l.getImage(), true));
            hiddenList.add(new Logo(l.getId(), l.getImage(), true));

        }

        getMvpView().updateRecyclerview(newList);
    }

    @Override
    public void checkLogo(Logo logo) {
        if (logo.getId() == currentLogo.getId()) {
            List<Logo> newList = new ArrayList<>();
            for (Logo l : logoList) {
                if (l.getId().equals(currentLogo.getId())) {
                    l.setHidden(false);
                }
            }
            for (Logo l : logoList) {
                newList.add(new Logo(l.getId(), l.getImage(), l.getHidden()));
            }

            getMvpView().updateRecyclerview(newList);


        } else {
            getMvpView().showToast("Wrong tap");
        }
    }

    @Override
    public void showImage() {

        if (hiddenList.size() > 0) {
            randomInt = randomGenerator.nextInt(hiddenList.size());
            currentLogo = hiddenList.get(randomInt);
            hiddenList.remove(currentLogo);
            getMvpView().showQuestionImage(currentLogo.getImage());
        } else {
            getMvpView().showQuestionImage(currentLogo.getImage());
            getMvpView().showToast("You Win");
        }


    }


}
