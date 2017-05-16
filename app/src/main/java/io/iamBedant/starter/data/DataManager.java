
package io.iamBedant.starter.data;

import java.util.List;

import io.iamBedant.starter.data.local.PreferencesHelper;
import io.iamBedant.starter.data.remote.AppApiHelper;
import io.iamBedant.starter.data.remote.model.game.Logo;
import io.reactivex.Observable;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by @iamBedant on 15/03/17.
 */

@Singleton
public class DataManager {

    private static final String TAG = "DataManager";

    private final PreferencesHelper mPreferencesHelper;
    private final AppApiHelper mApiHelper;

    @Inject
    public DataManager( PreferencesHelper preferencesHelper,
                       AppApiHelper apiHelper) {
        mPreferencesHelper = preferencesHelper;
        mApiHelper = apiHelper;
    }


    public Observable<List<Logo>> getGameObject(){
        return mApiHelper.getGameObject();
    }

}
