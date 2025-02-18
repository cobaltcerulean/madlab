package com.example.l4q3;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.ToggleButton;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    ToggleButton toggleMode;
    ImageView imageMode;
    Button buttonChangeMode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toggleMode = findViewById(R.id.toggle_mode);
        imageMode = findViewById(R.id.image_mode);
        buttonChangeMode = findViewById(R.id.button_change_mode);

        // Set initial state
        updateUI(toggleMode.isChecked());

        // ToggleButton listener
        toggleMode.setOnCheckedChangeListener((buttonView, isChecked) -> {
            updateUI(isChecked);
        });

        // Change Mode button listener
        buttonChangeMode.setOnClickListener(v -> {
            boolean newState = !toggleMode.isChecked();
            toggleMode.setChecked(newState);
            updateUI(newState);
        });
    }

    // Updates UI (Image and Toast message)
    private void updateUI(boolean isWiFi) {
        if (isWiFi) {
            imageMode.setImageResource(R.drawable.eve1);
            showToast("Wi-Fi Mode Activated");
        } else {
            imageMode.setImageResource(R.drawable.ritsu2);
            showToast("Mobile Data Mode Activated");
        }
    }

    // Show a Toast message
    private void showToast(String message) {
        Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
    }
}
