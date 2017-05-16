
package io.iamBedant.starter.injection.component;

import io.iamBedant.starter.injection.PerActivity;
import io.iamBedant.starter.injection.module.ActivityModule;
import io.iamBedant.starter.ui.game.GameActivity;
import io.iamBedant.starter.ui.login.LoginActivity;
import io.iamBedant.starter.ui.splash.SplashActivity;
import dagger.Component;

/**
 * Created by @iamBedant on 15/03/17.
 */

@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

    void inject(SplashActivity splashActivity);

    void inject(LoginActivity loginActivity);

    void inject(GameActivity gameActivity);


}
