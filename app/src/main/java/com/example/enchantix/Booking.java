package com.example.enchantix;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import androidx.appcompat.app.AppCompatActivity;

public class Booking extends AppCompatActivity {
    GridView gridViewEvents;

    int[] eventImages = {
            R.drawable.birthday2,
            R.drawable.marriage2,
            R.drawable.baby_shower1,
            R.drawable.naming2,
            R.drawable.engagement,
            R.drawable.getto
    };

    String[] eventNames = {
            "Birthday Party",
            "Marriage",
            "Baby Shower",
            "Naming Ceremony",
            "Engagement",
            "Get to Together"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking);

        gridViewEvents = findViewById(R.id.gridViewEvents);

        EventGridAdapter adapter = new EventGridAdapter(this, eventNames, eventImages);
        gridViewEvents.setAdapter(adapter);

        gridViewEvents.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(Booking.this, EventPage.class);
                intent.putExtra("eventName", eventNames[position]);
                intent.putExtra("eventImage", eventImages[position]);
                startActivity(intent);
            }
        });
    }
}

