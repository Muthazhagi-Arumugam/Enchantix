
package com.example.enchantix;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class EventGridAdapter extends BaseAdapter {
    private Context context;
    private String[] eventNames;
    private int[] eventImages;

    public EventGridAdapter(Context context, String[] eventNames, int[] eventImages) {
        this.context = context;
        this.eventNames = eventNames;
        this.eventImages = eventImages;
    }

    @Override
    public int getCount() {
        return eventNames.length;
    }

    @Override
    public Object getItem(int position) {
        return eventNames[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.activity_event_grid_adapter, parent, false);
        }

        ImageView imageView = convertView.findViewById(R.id.eventImage);
        TextView textView = convertView.findViewById(R.id.eventName);

        imageView.setImageResource(eventImages[position]);
        textView.setText(eventNames[position]);

        return convertView;
    }
}
