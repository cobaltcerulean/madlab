package com.example.myapplication;

import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private EditText emailInput, mobileInput, passwordInput;
    private Button registerBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        emailInput = findViewById(R.id.emailInput);
        mobileInput = findViewById(R.id.mobileInput);
        passwordInput = findViewById(R.id.passwordInput);
        registerBtn = findViewById(R.id.registerBtn);

        registerBtn.setOnClickListener(v -> validateInput());
    }

    private void validateInput() {
        String email = emailInput.getText().toString().trim();
        String mobile = mobileInput.getText().toString().trim();
        String password = passwordInput.getText().toString().trim();

        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            showToast("❌ Invalid Email Address!");
            return;
        }

        if (!mobile.matches("\\d{10}")) { // Checks for exactly 10 digits
            showToast("❌ Mobile Number must be 10 digits!");
            return;
        }

        if (password.length() < 6) {
            showToast("❌ Password must be at least 6 characters!");
            return;
        }

        showToast("✅ Registration Successful!");
    }

    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
