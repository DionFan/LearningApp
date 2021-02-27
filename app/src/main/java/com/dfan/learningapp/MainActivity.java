package com.dfan.learningapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener
{

    TextView Tvintro;
    Button Bt1lesson;
    Button Bt2lesson;
    private ClassLoader context;

    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Tvintro = (TextView) findViewById (R.id.TVintro);
        Tvintro.setBackgroundResource(android.R.color.transparent);
        Bt1lesson = (Button) findViewById(R.id.Bt1Lesson);
        //Bt1lesson.setBackgroundColor(context.getResources(this).getColor(R.color.teal_200));
        Bt2lesson = (Button) findViewById(R.id.Bt2Lesson);
        Bt2lesson.setBackgroundColor(Color.YELLOW);
        Bt1lesson.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent (getApplicationContext (), Act2.class);
                startActivity (intent);
            }
        });
        Bt2lesson.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent (getApplicationContext (), Hist1.class);
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