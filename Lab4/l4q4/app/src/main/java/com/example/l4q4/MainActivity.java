package com.example.l4q4;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    CheckBox pi, bu, pa;
    Button sub;
    TextView summ;
    boolean orderSubmitted = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pi = findViewById(R.id.check_pizza);
        bu = findViewById(R.id.check_burger);
        pa = findViewById(R.id.check_pasta);
        sub = findViewById(R.id.button_submit);
        summ = findViewById(R.id.text_summary);

        sub.setOnClickListener(v -> {
            if (!orderSubmitted) {
                processOrder();
                disableCheckboxes();
                orderSubmitted = true;
            } else {
                Toast.makeText(MainActivity.this, "Order already submitted!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void processOrder() {
        ArrayList<String> selectedItems = new ArrayList<>();
        ArrayList<Integer> itemPrices = new ArrayList<>();

        if (pi.isChecked()) {
            selectedItems.add("Pizza");
            itemPrices.add(10);
        }
        if (bu.isChecked()) {
            selectedItems.add("Burger");
            itemPrices.add(6);
        }
        if (pa.isChecked()) {
            selectedItems.add("Pasta");
            itemPrices.add(8);
        }

        if (selectedItems.isEmpty()) {
            Toast.makeText(MainActivity.this, "No items selected!", Toast.LENGTH_SHORT).show();
            return;
        }

        // Generate order summary
        StringBuilder summary = new StringBuilder("Order Summary:\n");
        int totalCost = 0;

        for (int i = 0; i < selectedItems.size(); i++) {
            summary.append(selectedItems.get(i)).append(": $").append(itemPrices.get(i)).append("\n");
            totalCost += itemPrices.get(i);
        }

        summary.append("\nTotal Cost: $").append(totalCost);
        summ.setText(summary.toString());
    }

    private void disableCheckboxes() {
        pi.setEnabled(false);
        bu.setEnabled(false);
        pa.setEnabled(false);
    }
}
