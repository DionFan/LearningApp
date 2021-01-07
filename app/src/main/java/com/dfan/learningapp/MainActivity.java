package com.dfan.learningapp;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener
{

    TextView Tvintro;
    Button Bt1lesson;
    Button Bt2lesson;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Tvintro = (TextView) findViewById (R.id.TVintro);
        Tvintro.setBackgroundResource(android.R.color.transparent);
        Bt1lesson = (Button) findViewById(R.id.Bt1Lesson);
        Bt2lesson = (Button) findViewById(R.id.Bt2Lesson);
        Bt1lesson.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent (getApplicationContext (), Act2.class);
                startActivity (intent);
            }
        });

    }
    public void ChColor (View V)
    {
        Random Ra = new Random ();
        int color = Color.argb (255, Ra.nextInt (256), Ra.nextInt (256), Ra.nextInt (256));
        ((TextView) V).setTextColor (color);
    }

    @Override
    public void onClick(View v) {

    }
}