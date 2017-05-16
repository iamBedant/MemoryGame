
package io.iamBedant.starter.ui.game;


import java.util.List;

import io.iamBedant.starter.data.remote.model.game.Logo;
import io.iamBedant.starter.ui.base.MvpView;


/**
 * Created by @iamBedant on 15/03/17.
 */

public interface GameMvpView extends MvpView {

    void openMainActivity();

    void displayRecyclerView(List<Logo> logos, int delay);

    void updateRecyclerview(List<Logo> logoList);

    void showQuestionImage(String image);

    void showToast(String s);

}
