package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private EditText nameInput, professionInput, experienceInput, skillsInput;
    private Button submitBtn;
    private TextView profileDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameInput = findViewById(R.id.nameInput);
        professionInput = findViewById(R.id.professionInput);
        experienceInput = findViewById(R.id.experienceInput);
        skillsInput = findViewById(R.id.skillsInput);
        submitBtn = findViewById(R.id.submitBtn);
        profileDisplay = findViewById(R.id.profileDisplay);

        submitBtn.setOnClickListener(v -> {
            String name = nameInput.getText().toString();
            String profession = professionInput.getText().toString();
            String experience = experienceInput.getText().toString();
            String skills = skillsInput.getText().toString();

            String profileText = "👤 Name: " + name + "\n" +
                    "💼 Profession: " + profession + "\n" +
                    "📆 Experience: " + experience + " years\n" +
                    "🛠 Skills: " + skills;

            profileDisplay.setText(profileText);
            profileDisplay.setVisibility(View.VISIBLE); // Show profile after clicking submit
        });
    }
}
