package com.example.l4q2;

import android.content.Context;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupButton(R.id.button_oreo, "Android Oreo", R.drawable.oreo);
        setupButton(R.id.button_pie, "Android Pie", R.drawable.pie);
        setupButton(R.id.button_q, "Android 10 (Q)", R.drawable.android10);
    }

    private void setupButton(int buttonId, String versionName, int imageResId) {
        Button button = findViewById(buttonId);
        button.setOnClickListener(v -> showImageToast(MainActivity.this, imageResId, versionName));
    }

    private void showImageToast(Context context, int imageResId, String message) {
        Toast toast = new Toast(context);
        toast.setDuration(Toast.LENGTH_SHORT);

        LinearLayout layout = new LinearLayout(context);
        layout.setOrientation(LinearLayout.HORIZONTAL);
        layout.setGravity(Gravity.CENTER);

        ImageView imageView = new ImageView(context);
        imageView.setImageResource(imageResId);
        imageView.setLayoutParams(new LinearLayout.LayoutParams(100, 100));

        android.widget.TextView textView = new android.widget.TextView(context);
        textView.setText(message);
        textView.setPadding(20, 0, 0, 0);

        layout.addView(imageView);
        layout.addView(textView);

        toast.setView(layout);
        toast.setGravity(Gravity.CENTER, 0, 300);
        toast.show();
    }
}
