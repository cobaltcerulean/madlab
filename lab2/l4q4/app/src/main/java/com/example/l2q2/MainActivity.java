package com.example.l2q2;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextWatcher;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText ent = findViewById(R.id.enterurl);
        TextView te = findViewById(R.id.url);

        ent.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                updateHyperlink(te, s.toString().trim());
            }

            @Override
            public void afterTextChanged(Editable s) {}
        });
    }

    private void updateHyperlink(TextView textView, String url) {
        if (url.isEmpty()) {
            textView.setText(""); // Clear text when input is empty
            return;
        }

        // Ensure the URL has "http://" or "https://"
        final String fixedUrl = (!url.startsWith("http://") && !url.startsWith("https://")) ? "https://" + url : url;

        SpannableString spannableString = new SpannableString(fixedUrl);
        ClickableSpan clickableSpan = new ClickableSpan() {
            @Override
            public void onClick(View widget) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(fixedUrl)); // Use final variable
                widget.getContext().startActivity(browserIntent);
            }
        };

        spannableString.setSpan(clickableSpan, 0, fixedUrl.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        textView.setText(spannableString);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
    }
}
