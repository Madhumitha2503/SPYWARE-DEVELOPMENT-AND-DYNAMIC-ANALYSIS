package com.example.learnc;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {

    // Splash screen display time in milliseconds
    private static final int SPLASH_TIME_OUT = 3500;

    // Time interval for logo switching
    private static final int LOGO_SWITCH_INTERVAL = 1500;

    private ImageView logoImageView;
    private Handler handler = new Handler();
    private boolean isLogoGold = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        // Find the ImageView in the layout
        logoImageView = findViewById(R.id.logoImageView);

        // Load the animation
        @SuppressLint("ResourceType") Animation fadeIn = AnimationUtils.loadAnimation(this, R.layout.fade_in);

        // Start the animation
        logoImageView.startAnimation(fadeIn);

        // Start logo switching
        startLogoSwitcher();

        // Delayed start of the main activity
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // Start your main activity
                Intent i = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(i);

                // Close this activity
                finish();
            }
        }, SPLASH_TIME_OUT);
    }

    private void startLogoSwitcher() {
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (isLogoGold) {
                    logoImageView.setImageResource(R.drawable.logopopberry);
                } else {
                    logoImageView.setImageResource(R.drawable.logogold);
                }
                isLogoGold = !isLogoGold;
                handler.postDelayed(this, LOGO_SWITCH_INTERVAL);
            }
        }, LOGO_SWITCH_INTERVAL);
    }
}
