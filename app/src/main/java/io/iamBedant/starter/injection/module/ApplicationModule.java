
package io.iamBedant.starter.injection.module;

import android.app.Application;
import android.content.Context;
import io.iamBedant.starter.BuildConfig;
import io.iamBedant.starter.R;
import io.iamBedant.starter.data.remote.ApiHeader;
import io.iamBedant.starter.data.remote.ApiHelper;
import io.iamBedant.starter.data.remote.AppApiHelper;
import io.iamBedant.starter.data.local.PreferencesHelper;
import io.iamBedant.starter.injection.ApiInfo;
import io.iamBedant.starter.injection.ApplicationContext;
import io.iamBedant.starter.injection.DatabaseInfo;
import io.iamBedant.starter.injection.PreferenceInfo;
import io.iamBedant.starter.utils.AppConstants;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

/**
 * Created by @iamBedant on 15/03/17.
 */

@Module
public class ApplicationModule {

    private final Application mApplication;

    public ApplicationModule(Application application) {
        mApplication = application;
    }

    @Provides
    @ApplicationContext
    Context provideContext() {
        return mApplication;
    }

    @Provides
    Application provideApplication() {
        return mApplication;
    }

    @Provides
    @DatabaseInfo
    String provideDatabaseName() {
        return AppConstants.DB_NAME;
    }

    @Provides
    @ApiInfo
    String provideApiKey() {
        return BuildConfig.API_KEY;
    }

    @Provides
    @PreferenceInfo
    String providePreferenceName() {
        return AppConstants.PREF_NAME;
    }


    @Provides
    @Singleton ApiHelper provideApiHelper(AppApiHelper appApiHelper) {
        return appApiHelper;
    }

    @Provides
    @Singleton
    ApiHeader.ProtectedApiHeader provideProtectedApiHeader(@ApiInfo String apiKey,
                                                           PreferencesHelper preferencesHelper) {
        //return new ApiHeader.ProtectedApiHeader(
        //        apiKey,
        //        preferencesHelper.getCurrentUserId(),
        //        preferencesHelper.getAccessToken());

        return new ApiHeader.ProtectedApiHeader(
            apiKey,
            "",
            "");
    }

    @Provides
    @Singleton CalligraphyConfig provideCalligraphyDefaultConfig() {
        return new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/source-sans-pro/SourceSansPro-Regular.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build();
    }
}
