package com.ford.war;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button twplay = (Button)findViewById(R.id.twoPlayer);
        Button computer = (Button)findViewById(R.id.comp);

        twplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                newActivity(getApplicationContext(), TwoPlayerActivity.class);
            }
        });

        computer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                newActivity(getApplicationContext(), CompPlayerActivity.class);
            }
        });
    }

    private void newActivity(Context context, Class className){

        Intent intent = new Intent(context, className);
        startActivity(intent);

    }

    public void onBackPressed(){
        super.onBackPressed();
        finish();
    }
}
