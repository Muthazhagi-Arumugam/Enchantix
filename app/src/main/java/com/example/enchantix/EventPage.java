package com.example.enchantix;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class EventPage extends AppCompatActivity {

    ImageView eventImage;
    TextView eventName, eventDetails, eventCost;
    EditText etCustomerName, etPhoneNumber, etEventPlace, etEventDate;
    Button btnConfirmBooking;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_page);

        eventImage = findViewById(R.id.eventImage);
        eventName = findViewById(R.id.eventName);
        eventDetails = findViewById(R.id.eventDetails);
        eventCost = findViewById(R.id.eventCost);
        etCustomerName = findViewById(R.id.etCustomerName);
        etPhoneNumber = findViewById(R.id.etPhoneNumber);
        etEventPlace = findViewById(R.id.etEventPlace);
        etEventDate = findViewById(R.id.etEventDate);
        btnConfirmBooking = findViewById(R.id.btnConfirmBooking);

        // Get event details from BookingActivity
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            eventName.setText(bundle.getString("eventName"));
            eventImage.setImageResource(bundle.getInt("eventImage"));
        }

        btnConfirmBooking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String customerName = etCustomerName.getText().toString();
                String phoneNumber = etPhoneNumber.getText().toString();
                String eventPlace = etEventPlace.getText().toString();
                String eventDate = etEventDate.getText().toString();
                String eventCost = "50000";  // You can calculate or set the cost here

                // Check if all fields are filled
                if (!customerName.isEmpty() && !phoneNumber.isEmpty() && !eventPlace.isEmpty() && !eventDate.isEmpty()) {
                    // Create an intent to go to BillActivity
                    Intent intent = new Intent(EventPage.this, Billpate.class);
                    intent.putExtra("customerName", customerName);
                    intent.putExtra("phoneNumber", phoneNumber);
                    intent.putExtra("eventPlace", eventPlace);
                    intent.putExtra("eventDate", eventDate);
                    intent.putExtra("eventCost", eventCost);

                    // Start BillActivity
                    startActivity(intent);
                } else {
                    Toast.makeText(EventPage.this, "Please fill all fields", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
