package com.example.learnc;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class BotActivity extends AppCompatActivity {

    private EditText userInput;
    private TextView responseText;
    private ScrollView scrollView;
    private final String API_KEY = "AIzaSyDRkyu4ad3whW7wL7cqJf3op5C0u6gGhOM"; // Use your actual API key

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_ai_interface);

        userInput = findViewById(R.id.message_input);
        responseText = findViewById(R.id.received_message_text);
        scrollView = findViewById(R.id.scroll_view);

        ImageButton sendButton = findViewById(R.id.send_button);
        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendMessage(v);
            }
        });

        ImageButton backButton = findViewById(R.id.back_button);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    public void sendMessage(View view) {
        String message = userInput.getText().toString();
        if (!message.isEmpty()) {
            new SendRequestTask().execute(message);
            // Clear the input field and append the user message to the chat
            responseText.append("You: " + message + "\n");
            userInput.setText("");
            scrollToBottom();
        }
    }

    private void scrollToBottom() {
        scrollView.post(new Runnable() {
            @Override
            public void run() {
                scrollView.fullScroll(View.FOCUS_DOWN);
            }
        });
    }

    private class SendRequestTask extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... strings) {
            String message = strings[0];
            return handleRequest(message);
        }

        @Override
        protected void onPostExecute(String response) {
            responseText.append("Bot: " + response + "\n");
            scrollToBottom();
        }
    }

    private String handleRequest(String message) {
        String apiURL = "https://generativelanguage.googleapis.com/v1beta/models/gemini-pro:generateContent?key=" + API_KEY;
        JSONObject payload = new JSONObject();
        JSONObject parts = new JSONObject();
        JSONObject text = new JSONObject();

        try {
            text.put("text", message);
            parts.put("parts", text);
            payload.put("contents", parts);

            URL url = new URL(apiURL);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setDoOutput(true);

            OutputStream os = connection.getOutputStream();
            os.write(payload.toString().getBytes());
            os.flush();
            os.close();

            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                Scanner scanner = new Scanner(connection.getInputStream());
                StringBuilder response = new StringBuilder();
                while (scanner.hasNextLine()) {
                    response.append(scanner.nextLine());
                }
                scanner.close();
                JSONObject jsonResponse = new JSONObject(response.toString());
                String generatedText = jsonResponse.getJSONArray("candidates")
                        .getJSONObject(0)
                        .getJSONObject("content")
                        .getJSONArray("parts")
                        .getJSONObject(0)
                        .getString("text");

                // Handle replacements
                if (generatedText.contains("Gemini")) {
                    generatedText = generatedText.replace("Gemini", "ZARA");
                }
                if (generatedText.contains("Google")) {
                    generatedText = generatedText.replace("Google", "PRANESH");
                }

                return generatedText;
            } else {
                return "Error: " + responseCode;
            }

        } catch (IOException | JSONException e) {
            e.printStackTrace();
            return "Error occurred while fetching response";
        }
    }
}

