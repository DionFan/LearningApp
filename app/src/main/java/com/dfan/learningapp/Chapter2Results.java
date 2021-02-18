package com.dfan.learningapp;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.text.LineBreaker;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class Chapter2Results extends AppCompatActivity implements View.OnClickListener
{
    TextView TvGrades;
    TextView TvWrongQue;
    TextView TvWrongAns;
    TextView Tvadvice;
    TextView TvStandardQue;
    TextView TvStandardAns;
    Button BtNextChapter;


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
        setContentView(R.layout.chapter2results);
        TvGrades = findViewById(R.id.TvGrades);
        TvWrongQue = findViewById(R.id.TvWrongQue);
        TvWrongAns = findViewById(R.id.TvWrongAns);
        Tvadvice = findViewById(R.id.Tvadvice);
        TvStandardAns = findViewById(R.id.TvStandardAns);
        TvStandardQue = findViewById(R.id.TvStandardQue);
        BtNextChapter = findViewById(R.id.BtNextChapter);
        BtNextChapter.setOnClickListener(this);
        Intent intent = getIntent();
        Bundle box = intent.getExtras();
        Float Grades = box.getFloat("Points");
        if (Grades >= 90.0)
        {
            Tvadvice.setText("Ήσουν ΑΡΙΣΤΟΣ!!! Συνέχισε την καλή δουλειά.");
            TvStandardQue.setVisibility(View.INVISIBLE);
            TvStandardAns.setVisibility(View.INVISIBLE);
            TvWrongAns.setVisibility(View.INVISIBLE);
            TvWrongQue.setVisibility(View.INVISIBLE);

        }
        else if (Grades >= 75.0)
        {
            Tvadvice.setText("Τα πήγες αρκετά καλά όμως με λίγη προσπάθεια ακόμα μπορείς και καλύτερα!");
        }
        else if (Grades >= 50.0)
        {
            Tvadvice.setText("Με μεγάλη δυσκολία πέρασες την βάση, θες ακόμη αρκετή δουλεία.");
        }
        else
        {
            BtNextChapter.setVisibility(View.INVISIBLE);
            Tvadvice.setText("Ήσουν πολύ κακός, πάτησε ΕΔΩ για να γυρίσεις πίσω και να διαβάσεις το κεφάλαιο από την αρχή.");
            Tvadvice.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
                    Intent intent = new Intent(getApplicationContext(), Chapter2.class);
                    startActivity(intent);
                    Activity Chapter2 = null;
                    Chapter2.startActivity(intent);
                }
            });
        }
        String grades = Float.toString(Grades);
        TvGrades.setText(grades + "%");
        String WrongQue = box.getString("WrongQue");
        TvWrongQue.setText(WrongQue);
        TvWrongQue.setJustificationMode(LineBreaker.JUSTIFICATION_MODE_INTER_WORD);
        String WrongAns = box.getString("WrongAns");
        TvWrongAns.setText(WrongAns);
    }

    @Override
    public void onClick(View v)
    {
        Intent intent = new Intent (getApplicationContext (),  Chapter3.class);
        startActivity (intent);
    }
}
