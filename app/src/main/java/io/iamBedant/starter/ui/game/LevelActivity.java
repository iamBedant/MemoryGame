package io.iamBedant.starter.ui.game;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;
import io.iamBedant.starter.R;


public class LevelActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_one)
    public void levelOneClicked(){
        startGame(1);
    }
    @OnClick(R.id.btn_two)
    public void levelTwoClicked(){
        startGame(2);
    }
    @OnClick(R.id.btn_three)
    public void levelThreeClicked(){
        startGame(3);
    }
    @OnClick(R.id.btn_four)
    public void levelFourClicked(){
        startGame(4);
    }

    public void startGame(int level){
        Intent intent = new Intent(this,GameActivity.class);
        intent.putExtra("level",level);
        startActivity(intent);
    }

}
