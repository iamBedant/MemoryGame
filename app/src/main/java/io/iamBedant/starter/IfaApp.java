package io.iamBedant.starter;

import android.app.Application;
import io.iamBedant.starter.data.DataManager;
import io.iamBedant.starter.injection.component.ApplicationComponent;
import io.iamBedant.starter.injection.component.DaggerApplicationComponent;
import io.iamBedant.starter.injection.module.ApplicationModule;
import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.interceptors.HttpLoggingInterceptor;
import javax.inject.Inject;
import timber.log.Timber;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

/**
 * Created by @iamBedant on 15/03/17.
 */

public class IfaApp extends Application {
  @Inject DataManager mDataManager;

  @Inject CalligraphyConfig mCalligraphyConfig;

  private ApplicationComponent mApplicationComponent;

  @Override
  public void onCreate() {
    super.onCreate();

    mApplicationComponent = DaggerApplicationComponent.builder()
        .applicationModule(new ApplicationModule(this)).build();

    mApplicationComponent.inject(this);

    if (BuildConfig.DEBUG) {
      Timber.plant(new Timber.DebugTree());
    }

    AndroidNetworking.initialize(getApplicationContext());
    if (BuildConfig.DEBUG) {
      AndroidNetworking.enableLogging(HttpLoggingInterceptor.Level.BODY);
    }

    CalligraphyConfig.initDefault(mCalligraphyConfig);
  }

  public ApplicationComponent getComponent() {
    return mApplicationComponent;
  }


  // Needed to replace the component with a test specific one
  public void setComponent(ApplicationComponent applicationComponent) {
    mApplicationComponent = applicationComponent;
  }
}
