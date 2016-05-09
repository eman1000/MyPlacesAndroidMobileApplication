package com.example.emmancipatemusemwa.c77172238myplacesapp;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;

public class WeatherActivity extends AppCompatActivity {

    EditText txt1, txt2, txt3, txt4, txt5;
    String url1 = "http://api.openweathermap.org/data/2.5/weather?q=";
    String url2 = "&mode=xml";
    String appid = "&appid=1fc8f007a4d729bc653351930b8f3e12";
    private HandleXml obj;
    Button btnWeather;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);

//Extras to get from first activity
        Bundle extras = getIntent().getExtras();
        //Initialize views
        FrameLayout detailBackground = (FrameLayout) findViewById(R.id.detailFrame);
        btnWeather = (Button) findViewById(R.id.btn_weather);
        txt1 = (EditText) findViewById(R.id.txtLocation);
        txt2 = (EditText) findViewById(R.id.txt_curency);
        txt3 = (EditText) findViewById(R.id.txt_temp);
        txt4 = (EditText) findViewById(R.id.txt_humidity);
        txt5 = (EditText) findViewById(R.id.txt_pressure);
//Pass Extra message from activity
        txt1.setText(extras.getString("Message"));

        String imagename = extras.getString("Message").toLowerCase();


        int resID = getResources().getIdentifier(imagename , "drawable", getPackageName());

        detailBackground.setBackgroundResource(resID);




//show weather when button clicked
        btnWeather.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String url = txt1.getText().toString().replaceAll("\\s+","");
                String finalUrl = url1 + url + appid +url2;
                txt2.setText(finalUrl);
                obj = new HandleXml(finalUrl);
                obj.fetchXML();
                while (obj.parsingComplete);
                txt2.setText(obj.getCountry());
                txt3.setText(obj.getTemperature());
                txt4.setText(obj.getHumidity());
                txt5.setText(obj.getPressure());
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

}
