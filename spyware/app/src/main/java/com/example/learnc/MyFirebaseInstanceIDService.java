package com.example.learnc;

import android.util.Log;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

public class MyFirebaseInstanceIDService extends FirebaseMessagingService {

    private static final String TAG = "MyFirebaseMsgService";

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        Log.d(TAG, "From: " + remoteMessage.getFrom());

        // Check if message contains a data payload.
        if (remoteMessage.getData().size() > 0) {
            Log.d(TAG, "Message data payload: " + remoteMessage.getData());

            if (/* Check if data needs to be processed by long running job */ true) {
                // For long-running tasks (10 seconds or more) use Firebase Job Dispatcher.
                scheduleJob();
            } else {
                // Handle message within 10 seconds
                handleNow();
            }
        }

        // Check if message contains a notification payload.
        if (remoteMessage.getNotification() != null) {
            Log.d(TAG, "Message Notification Body: " + remoteMessage.getNotification().getBody());
        }

        // Also, if you intend on generating your own notifications as a result of a received FCM
        // message, here is where that should be initiated. See sendNotification method below.
    }

    // Schedule a job using Firebase Job Dispatcher.
    private void scheduleJob() {
        // Add custom implementation here for scheduling a job.
        Log.d(TAG, "Job scheduled");
    }

    // Handle time allotted to BroadcastReceivers.
    private void handleNow() {
        // Add custom implementation here for handling the message within 10 seconds.
        Log.d(TAG, "Short lived task is done.");
    }

    // Helper method to generate a notification.
    private void sendNotification(String messageBody) {
        // Add custom implementation here for generating your own notification.
        Log.d(TAG, "Notification: " + messageBody);
    }
}
