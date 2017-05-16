
package io.iamBedant.starter.injection.component;

import android.app.Application;
import android.content.Context;

import io.iamBedant.starter.IfaApp;
import io.iamBedant.starter.data.DataManager;
import io.iamBedant.starter.injection.ApplicationContext;
import io.iamBedant.starter.injection.module.ApplicationModule;
import dagger.Component;
import javax.inject.Singleton;

/**
 * Created by @iamBedant on 15/03/17.
 */

@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

    void inject(IfaApp app);


    @ApplicationContext
    Context context();

    Application application();

    DataManager getDataManager();
}