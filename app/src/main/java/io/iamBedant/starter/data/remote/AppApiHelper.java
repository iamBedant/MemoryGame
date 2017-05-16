
package io.iamBedant.starter.data.remote;
import com.rx2androidnetworking.Rx2AndroidNetworking;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.iamBedant.starter.data.remote.model.game.Logo;
import io.reactivex.Observable;

/**
 * Created by @iamBedant on 15/03/17.
 */

@Singleton
public class AppApiHelper implements ApiHelper {

    private ApiHeader mApiHeader;

    @Inject
    public AppApiHelper(ApiHeader apiHeader) {
        mApiHeader = apiHeader;
    }

    @Override
    public ApiHeader getApiHeader() {
        return mApiHeader;
    }

    public Observable<List<Logo>> getGameObject() {
        return Rx2AndroidNetworking.get(ApiEndPoint.GAME_OBJECT_ENDPOINT)
                .build()
                .getObjectListObservable(Logo.class);
    }

}

