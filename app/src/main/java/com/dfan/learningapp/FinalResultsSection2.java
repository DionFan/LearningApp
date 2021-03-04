package com.dfan.learningapp;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class FinalResultsSection2 extends AppCompatActivity implements View.OnClickListener
{
    TextView TvGrades;
    ImageView IvOK;

    public void onBackPressed()
    {
        AlertDialog diaBox = AskOption();
        diaBox.show();
    }

    private AlertDialog AskOption()
    {
        AlertDialog myQuittingDialogBox =new AlertDialog.Builder(this)
                .setTitle("Exit")
                .setMessage("Are you sure you want to exit?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener()
                {
                    public void onClick(DialogInterface dialog, int whichButton)
                    {
                        Context context = null;
                        Intent intent = new Intent (context.getApplicationContext(), Chapter2.class);
                        context.startActivity(intent);
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener()
                {
                    public void onClick(DialogInterface dialog, int which)
                    {
                        dialog.dismiss();
                    }
                })
                .create();
        return myQuittingDialogBox;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate (Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.finalresultssection2);
        TvGrades = findViewById(R.id.TvGrades);
        IvOK = findViewById(R.id.IvOK);
        IvOK.setOnClickListener(this);
        Intent intent = getIntent();
        Bundle box = intent.getExtras();
        String Grades1 = box.getString("Points1");
        String Grades2 = box.getString("Points2");
        String Grades3 = box.getString("Points3");
        Float Gr1 = Float.parseFloat(Grades1);
        Float Gr2 = Float.parseFloat(Grades2);
        Float Gr3 = Float.parseFloat(Grades3);
        Float Grades = (Gr1 + Gr2 + Gr3) / 3;
        TvGrades.setText(String.format("%.2f", Grades)+ "%");
    }

    @Override
    public void onClick(View v)
    {
        Intent intent = new Intent (getApplicationContext (),  MainActivity.class);
        startActivity (intent);
    }
}
