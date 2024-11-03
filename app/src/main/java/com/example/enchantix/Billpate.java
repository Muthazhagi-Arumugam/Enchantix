package com.example.enchantix;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class Billpate extends AppCompatActivity {

    TextView tvCustomerName, tvPhoneNumber, tvEventPlace, tvEventDate, tvEventCost;
    Button btnFinish;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_billpate);

        tvCustomerName = findViewById(R.id.tvCustomerName);
        tvPhoneNumber = findViewById(R.id.tvPhoneNumber);
        tvEventPlace = findViewById(R.id.tvEventPlace);
        tvEventDate = findViewById(R.id.tvEventDate);
        tvEventCost = findViewById(R.id.tvEventCost);
        btnFinish = findViewById(R.id.btnFinish);

        // Get data from EventDetailActivity
        Intent intent = getIntent();
        String customerName = intent.getStringExtra("customerName");
        String phoneNumber = intent.getStringExtra("phoneNumber");
        String eventPlace = intent.getStringExtra("eventPlace");
        String eventDate = intent.getStringExtra("eventDate");
        String eventCost = intent.getStringExtra("eventCost");

        // Set data to TextViews
        tvCustomerName.setText("Customer Name: " + customerName);
        tvPhoneNumber.setText("Phone Number: " + phoneNumber);
        tvEventPlace.setText("Event Place: " + eventPlace);
        tvEventDate.setText("Event Date: " + eventDate);
        tvEventCost.setText("Decoration Cost: " + eventCost);

        btnFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Finish the activity or return to the main page
                Intent intent1=new Intent(Billpate.this, MainActivity.class);
                startActivity(intent1);
            }
        });
    }
}
