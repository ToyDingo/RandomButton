package com.example.randombutton;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

//Simple app that displays a random number when the "random" button is clicked. Uses 1 activity,
//and no fragments.

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){randomNumber();}
        });
    }

    private void randomNumber(){
        Random random = new Random();
        Integer number = random.nextInt(1027);
        textView.setText(number.toString());
    }
}