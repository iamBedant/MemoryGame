package io.iamBedant.starter;


import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

import io.iamBedant.starter.data.DataManager;
import io.iamBedant.starter.data.remote.model.game.Logo;
import io.iamBedant.starter.ui.game.GameMvpView;
import io.iamBedant.starter.ui.game.GamePresenter;
import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.android.plugins.RxAndroidPlugins;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by @iamBedant on 15/03/17.
 */
@RunWith(MockitoJUnitRunner.class)
public class GamePresenterTest {

    @Mock
    GameMvpView mMockGameMvpView;
    @Mock
    DataManager mMockDataManager;
    private GamePresenter<GameMvpView> mGamePresenter;

    @BeforeClass
    public static void onlyOnce() throws Exception {
        RxAndroidPlugins.setInitMainThreadSchedulerHandler(
                new Function<Callable<Scheduler>, Scheduler>() {
                    @Override
                    public Scheduler apply(Callable<Scheduler> schedulerCallable)
                            throws Exception {
                        return Schedulers.trampoline();
                    }
                });
    }

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        CompositeDisposable compositeDisposable = new CompositeDisposable();
        mGamePresenter = new GamePresenter<>(mMockDataManager, compositeDisposable);
        mGamePresenter.onAttach(mMockGameMvpView);
    }


    @Test
    public void getImagesTest() {

        int delay =2;
        List<Logo> logoList = new ArrayList<>();
        logoList.add(new Logo("1","https://logo.clearbit.com/microsoft.com?s=128",null));
        logoList.add(new Logo("1","https://logo.clearbit.com/vw.com?s=128",null));
        logoList.add(new Logo("1","https://logo.clearbit.com/twitter.com?s=128",null));
        logoList.add(new Logo("1","https://logo.clearbit.com/facebook.com?s=128",null));
        when(mMockDataManager.getGameObject())
                .thenReturn(Observable.just(logoList));
        mGamePresenter.getImages(2);

        verify(mMockGameMvpView).displayRecyclerView(logoList,6000);

    }




    @After
    public void tearDown() throws Exception {
        mGamePresenter.onDetach();
        RxAndroidPlugins.reset();
    }

}