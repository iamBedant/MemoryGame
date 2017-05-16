
package io.iamBedant.starter.injection.component;

import io.iamBedant.starter.injection.PerService;
import io.iamBedant.starter.injection.module.ServiceModule;
import dagger.Component;

/**
 * Created by @iamBedant on 15/03/17.
 */

@PerService
@Component(dependencies = ApplicationComponent.class, modules = ServiceModule.class)
public interface ServiceComponent {


}
