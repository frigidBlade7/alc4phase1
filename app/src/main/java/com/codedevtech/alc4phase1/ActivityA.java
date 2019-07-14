package com.codedevtech.alc4phase1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

//implement the view onclick interface
public class ActivityA extends AppCompatActivity implements View.OnClickListener {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //declare buttons in scope
        Button aboutButton, profileButton;

        //perform data binding on buttons
        aboutButton = findViewById(R.id.about_button);
        profileButton = findViewById(R.id.profile_button);


        //attach onclick listeners to buttons within ActivityA
        aboutButton.setOnClickListener(this);
        profileButton.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){

            case R.id.about_button:
                startActivity(new Intent(ActivityA.this, ActivityB.class));
                break;

            case R.id.profile_button:
                startActivity(new Intent(ActivityA.this, ActivityC.class));

                break;
        }
    }
}
