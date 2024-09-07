package com.example.learnc;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class CreditsActivity extends AppCompatActivity {

    private ImageView appLogo;
    private Handler handler = new Handler();
    private boolean isLogoGold = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.credits_name);

        appLogo = findViewById(R.id.appLogo);
        ImageView aiw = findViewById(R.id.aiw);
        ImageView homeIcon = findViewById(R.id.homeIcon);  // Reference to the homeIcon

        startLogoSwitcher();

        aiw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openBotActivity();
            }
        });

        homeIcon.setOnClickListener(new View.OnClickListener() {  // Set OnClickListener on homeIcon
            @Override
            public void onClick(View v) {
                openMainActivity();
            }
        });
    }

    private void startLogoSwitcher() {
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (isLogoGold) {
                    appLogo.setImageResource(R.drawable.logopopberry);
                } else {
                    appLogo.setImageResource(R.drawable.logogold);
                }
                isLogoGold = !isLogoGold;
                handler.postDelayed(this, 1500);
            }
        }, 1500);
    }

    private void openBotActivity() {
        Intent intent = new Intent(CreditsActivity.this, BotActivity.class);
        startActivity(intent);
    }

    private void openMainActivity() {
        Intent intent = new Intent(CreditsActivity.this, MainActivity.class);  // Intent to open MainActivity
        startActivity(intent);
    }
}
