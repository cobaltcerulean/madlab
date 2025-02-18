package com.example.l4q1;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;
import android.widget.ToggleButton;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

public class MainActivity extends AppCompatActivity {
    Button btn;
    ToggleButton toggleBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = findViewById(R.id.button);
        toggleBtn = findViewById(R.id.toggleButton);

        // Button Click Listener
        btn.setOnClickListener(v -> showImageToast(MainActivity.this, R.drawable.hgwells, "Button Clicked!"));

        // ToggleButton Click Listener
        toggleBtn.setOnClickListener(v -> showImageToast(MainActivity.this, R.drawable.luguang, "Toggle Button Clicked!"));
    }

    private void showImageToast(Context context, int imageResId, String message) {
        // Create a new Toast
        Toast toast = new Toast(context);
        toast.setDuration(Toast.LENGTH_SHORT);

        // Create a LinearLayout
        LinearLayout layout = new LinearLayout(context);
        layout.setOrientation(LinearLayout.HORIZONTAL);
        layout.setGravity(Gravity.CENTER);

        // Create an ImageView
        ImageView imageView = new ImageView(context);
        imageView.setImageResource(imageResId);
        imageView.setLayoutParams(new LinearLayout.LayoutParams(100, 100)); // Set size

        // Create a TextView
        android.widget.TextView textView = new android.widget.TextView(context);
        textView.setText(message);
        textView.setPadding(20, 0, 0, 0); // Add space between image & text

        // Add ImageView & TextView to layout
        layout.addView(imageView);
        layout.addView(textView);

        // Set custom layout to Toast
        toast.setView(layout);

        toast.show();
    }

}
