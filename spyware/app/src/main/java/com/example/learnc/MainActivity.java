package com.example.learnc;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

public class MainActivity extends AppCompatActivity {

    private static final int NOTIFICATION_PERMISSION_CODE = 100;
    private ImageView appLogo;
    private Handler handler = new Handler();
    private boolean isLogoGold = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        appLogo = findViewById(R.id.appLogo);
        ImageView aiw = findViewById(R.id.aiw);
        ImageView communityIcon = findViewById(R.id.communityIcon);  // Reference to the communityIcon
        View startLearningButton = findViewById(R.id.startLearningButton); // Reference to the startLearningButton

        startLogoSwitcher();

        aiw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openBotActivity();
            }
        });

        communityIcon.setOnClickListener(new View.OnClickListener() {  // Set OnClickListener on communityIcon
            @Override
            public void onClick(View v) {
                openCreditsActivity();
            }
        });

        startLearningButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openTopicListActivity();
            }
        });

        // Request notification permission
        requestNotificationPermission();
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
        Intent intent = new Intent(MainActivity.this, BotActivity.class);
        startActivity(intent);
    }

    private void openCreditsActivity() {
        Intent intent = new Intent(MainActivity.this, CreditsActivity.class);  // Intent to open CreditsActivity
        startActivity(intent);
    }

    private void openTopicListActivity() {
        Intent intent = new Intent(MainActivity.this, Topic.class);  // Intent to open Topic list activity
        startActivity(intent);
    }

    private void requestNotificationPermission() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.POST_NOTIFICATIONS) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.POST_NOTIFICATIONS}, NOTIFICATION_PERMISSION_CODE);
            } else {
                // Permission already granted, trigger a notification
                triggerNotification();
            }
        } else {
            // OS version is less than Android 13, trigger a notification directly
            triggerNotification();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == NOTIFICATION_PERMISSION_CODE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // Permission granted, trigger a notification
                triggerNotification();
            } else {
                // Permission denied, handle accordingly
                // You might want to show a message to the user explaining why the permission is necessary
            }
        }
    }

    private void triggerNotification() {
        // Implement the code to trigger a notification through the server
        // Example: Call your server's API to send a notification
    }
}
