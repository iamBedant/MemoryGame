package io.iamBedant.starter.ui.game;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.iamBedant.starter.R;
import io.iamBedant.starter.data.remote.model.game.Logo;
import io.iamBedant.starter.ui.base.BaseActivity;


public class GameActivity extends BaseActivity implements GameMvpView {

    @Inject
    GameMvpPresenter<GameMvpView> mPresenter;

    @BindView(R.id.iv_display_image)
    ImageView mImageViewDisplay;

    @BindView(R.id.rv_image)
    RecyclerView mRecyclerView;

    LogoRvAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        getActivityComponent().inject(this);
        setUnBinder(ButterKnife.bind(this));
        mPresenter.onAttach(GameActivity.this);

        mPresenter.getImages(getIntent().getExtras().getInt("level", 3));
        mRecyclerView.setLayoutManager(new GridLayoutManager(this, 3));

    }

    @Override
    protected void setUp() {

    }

    @Override
    public void openMainActivity() {

    }

    @Override
    public void displayRecyclerView(List<Logo> logos, int delay) {

        ArrayList<Logo> list = new ArrayList();
        list.addAll(logos);
        adapter = new LogoRvAdapter(this, list);
        mRecyclerView.setAdapter(adapter);

        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                mPresenter.hideLogos();
            }
        }, delay);
    }

    @Override
    public void updateRecyclerview(List<Logo> logoList) {
        adapter.onNewProducts(new ArrayList<Logo>(logoList));
        mPresenter.showImage();

    }

    @Override
    public void showQuestionImage(String image) {
        Glide.with(this).load(image).into(mImageViewDisplay);
    }

    @Override
    public void showToast(String s) {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }


    public void logoClicked(Logo logo) {
        mPresenter.checkLogo(logo);
    }
}
