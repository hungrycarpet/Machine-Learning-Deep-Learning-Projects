package com.example.quakedec;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.graphics.drawable.GradientDrawable;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

import java.util.List;

public class ListAdapter extends ArrayAdapter<EarthQuakeData> {

    public ListAdapter(Context context, List<EarthQuakeData> objects) {
        super(context, 0, objects);
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

            View listView = convertView;
            if (listView == null) {
                listView = LayoutInflater.from(getContext()).inflate(
                    R.layout.earthquakeview, parent, false);
        }

        EarthQuakeData earthQuakeData = getItem(position);

        String myPlace = earthQuakeData.getPlace();
        int end = myPlace.indexOf("of");
        String startStringPlace;
        String endStringPlace;
        if (end != -1) {
            startStringPlace = myPlace.substring(0, end + 2);
            endStringPlace = myPlace.substring(end + 2);
        } else {
            startStringPlace = null;
            endStringPlace = myPlace;
        }

        TextView scaleText = listView.findViewById(R.id.scale_text);
        {
            GradientDrawable magnitudeCircle = (GradientDrawable) scaleText.getBackground();
            int magnitudeColor = getMagnitudeColor(earthQuakeData.getScale());
            magnitudeCircle.setColor(magnitudeColor);
            scaleText.setText(earthQuakeData.getScale());
        }
        TextView placeText = listView.findViewById(R.id.place_text);
        placeText.setText(startStringPlace);
        TextView place_twoText = listView.findViewById(R.id.place2_text);
        place_twoText.setText(endStringPlace);
        TextView dateText = listView.findViewById(R.id.date_text);
        dateText.setText(earthQuakeData.getDate());

        return listView;
    }
    public int getMagnitudeColor(String scale) {
        int magnitudeColorResourceId;
        int magnitudeFloor = (int)Double.parseDouble(scale);
        switch (magnitudeFloor) {
            case 0:
            case 1:
                magnitudeColorResourceId = R.color.magnitude1;
                break;
            case 2:
                magnitudeColorResourceId = R.color.magnitude2;
                break;
            case 3:
                magnitudeColorResourceId = R.color.magnitude3;
                break;
            case 4:
                magnitudeColorResourceId = R.color.magnitude4;
                break;
            case 5:
                magnitudeColorResourceId = R.color.magnitude5;
                break;
            case 6:
                magnitudeColorResourceId = R.color.magnitude6;
                break;
            case 7:
                magnitudeColorResourceId = R.color.magnitude7;
                break;
            case 8:
                magnitudeColorResourceId = R.color.magnitude8;
                break;
            case 9:
                magnitudeColorResourceId = R.color.magnitude9;
                break;
            default:
                magnitudeColorResourceId = R.color.magnitude10plus;
                break;
        }
        return ContextCompat.getColor(getContext(), magnitudeColorResourceId);
    }
}
