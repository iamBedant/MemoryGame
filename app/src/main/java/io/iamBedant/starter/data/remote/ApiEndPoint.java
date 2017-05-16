
package io.iamBedant.starter.data.remote;

import io.iamBedant.starter.BuildConfig;

/**
 * Created by @iamBedant on 15/03/17.
 */

public final class ApiEndPoint {


    public static final String GAME_OBJECT_ENDPOINT = "http://demo7502315.mockable.io/logos";

    public static final String ENDPOINT_LOGIN = BuildConfig.BASE_URL
            + "/login";

    private ApiEndPoint() {
        // This class is not publicly instantiable
    }

}
