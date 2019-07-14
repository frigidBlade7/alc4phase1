package com.codedevtech.alc4phase1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.Objects;

public class ActivityC extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        //display back button
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);


        TextView track, country, email , phone, slack;

        track = findViewById(R.id.track);
        country = findViewById(R.id.country);
        email = findViewById(R.id.email);
        phone = findViewById(R.id.phone);
        slack = findViewById(R.id.slack_user);

        track.setText(String.format(getString(R.string.track_1_s), "ANDROID"));
        country.setText(String.format(getString(R.string.country_1_s), "GHANA"));
        email.setText(String.format(getString(R.string.email_1_s), "kobbatt@gmail.com"));
        phone.setText(String.format(getString(R.string.phone_number_1_s), "+233553972269"));
        slack.setText(String.format(getString(R.string.slack_username_1_s), "@Nathany Natornam Attipoe"));
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                onBackPressed();

                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
