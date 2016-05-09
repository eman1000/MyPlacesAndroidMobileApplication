package com.example.emmancipatemusemwa.c77172238myplacesapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Array Declaration
        String[] placeCities = {"Harare","Pretoria", "Kuala Lumpur", "Paris", "Abuja"};
        String[] placeCountries = {"Zimbabwe", "South Africa", "Malaysia", "France", "Nigeria"};

        int[] background_images = {R.drawable.harare,R.drawable.pretoria, R.drawable.kualalumpur, R.drawable.paris, R.drawable.abuja};
        int[] flag_images = {R.drawable.zimflag, R.drawable.southafricaflag, R.drawable.malaysiaflag, R.drawable.franceflag, R.drawable.nigeriaflag};



        ListAdapter placesAdapter = new PlacesCustomAdapter(this, placeCities, placeCountries, background_images, flag_images);
        ListView placesListView = (ListView) findViewById(R.id.placesListView);
        placesListView.setAdapter(placesAdapter);

        placesListView.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                        String placeCities = String.valueOf(parent.getItemAtPosition(position));

                        //Toast.makeText(MainActivity.this, placeCities, Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(getApplicationContext(), WeatherActivity.class);
                        intent.putExtra("Message",placeCities.replaceAll("\\s+",""));
                        startActivity(intent);
                    }
                });

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        //if (id == R.id.action_settings) {
         //   return true;
      //  }

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_weather) {

            Intent intent = new Intent(this, WeatherActivity.class);
            intent.putExtra("Message","harare");
            startActivity(intent);

            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
