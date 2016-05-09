package com.example.emmancipatemusemwa.c77172238myplacesapp;


import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
/**
 * Created by emmancipatemusemwa on 22/04/16.
 */
class PlacesCustomAdapter extends ArrayAdapter<String> {

    int[] background_images;
    int[] flag_images;
    String[] countries;
    PlacesCustomAdapter(Context context, String[] places, String[] countries, int[] background_images, int[] flag_images) {
        super(context, R.layout.places_row_layout, places);
        this.countries = countries;
        this.background_images = background_images;
        this.flag_images = flag_images;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater placesInflater = LayoutInflater.from(getContext());
        View customView = placesInflater.inflate(R.layout.places_row_layout, parent, false);

        String singlePlaceItem = getItem(position);
        TextView placeCityName = (TextView) customView.findViewById(R.id.cityName);
        TextView placeCountryName = (TextView) customView.findViewById(R.id.countryName);
        Typeface custom_font = Typeface.createFromAsset(getContext().getAssets(),  "fonts/Lato-Regular.ttf");
        placeCityName.setTypeface(custom_font);
        ImageView flagImage = (ImageView) customView.findViewById(R.id.flagImage);

        FrameLayout placeBackground = (FrameLayout) customView.findViewById(R.id.placesFrame);


        placeCityName.setText(singlePlaceItem);
        placeCountryName.setText(countries[position]);
        flagImage.setImageResource(flag_images[position]);
        placeBackground.setBackgroundResource(background_images[position]);
        return customView;


    }


}
