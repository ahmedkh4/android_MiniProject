package com.khadraoui.Ahmed;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class LoadActivity extends AppCompatActivity {

    private  static int wait = 4000 ;
 MediaPlayer player ;
    Animation frontAnim ;
    ImageView image ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load);

        //
        frontAnim = AnimationUtils.loadAnimation(this, R.anim.front_anime) ;
        // hooks
        image = findViewById(R.id.madara) ;

        image.setAnimation(frontAnim);

        if( player == null) {
            player = MediaPlayer.create(this , R.raw.heaven) ;
            player.start();
        }

    new Handler().postDelayed(new Runnable() {
        @Override
        public void run() {
            Intent intent = new Intent(LoadActivity.this , MainActivity.class)  ;
            startActivity(intent);
            finish();
        }
    },wait);

    }
}
