package com.dfan.learningapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelStoreOwner;

import android.content.DialogInterface;
import android.os.CountDownTimer;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.dfan.coutdownbar.CircularCountDownBar;

public class Act3 extends AppCompatActivity implements View.OnClickListener
{
    TextView TvQueNumber;
    TextView TvQuestion;
    TextView[] TvAnswers;
    Button BtPrev;
    Button BtOK;
    Button BtNext;
    Button BtStart;
    Questionnaire AllQuests;
    Question CurQ;
    int CurQNum;
    int SelAns;
    Drawable BackDraw;
    private LinearLayout linearLayout;
    private CircularCountDownBar mCountDownBar1;
    @Override

    public void onBackPressed() {
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
                        finish();
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

    @Override
    protected void onCreate (Bundle savedInstanceState)
    {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.act3);
        findView();
        TvQueNumber = findViewById (R.id.TvQueNumber);
        TvQuestion = findViewById (R.id.TvQuestion);
        TvAnswers = new TextView[4];
        TvAnswers[0] = findViewById (R.id.TvAnswer1);
        TvAnswers[1] = findViewById (R.id.TvAnswer2);
        TvAnswers[2] = findViewById (R.id.TvAnswer3);
        TvAnswers[3] = findViewById (R.id.TvAnswer4);
        for (int i = 0; i < 4; i++)
            TvAnswers[i].setOnClickListener (this);
        BtPrev = findViewById (R.id.BtPrevious);
        BtOK = findViewById (R.id.BtOK);
        BtNext = findViewById (R.id.BtNext);
        BtStart = findViewById(R.id.BtStart);
        BtPrev.setOnClickListener (this);
        BtOK.setOnClickListener (this);
        BtNext.setOnClickListener (this);
        BtStart.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                BtStart.setVisibility(View.INVISIBLE);
                TvQuestion.setVisibility(View.VISIBLE);
                TvAnswers[0].setVisibility(View.VISIBLE);
                TvAnswers[1].setVisibility(View.VISIBLE);
                TvAnswers[2].setVisibility(View.VISIBLE);
                TvAnswers[3].setVisibility(View.VISIBLE);
                BtNext.setVisibility(View.VISIBLE);
                BtOK.setVisibility(View.VISIBLE);
                BtPrev.setVisibility(View.VISIBLE);
                TvQueNumber.setVisibility(View.VISIBLE);
                startCountDownTimertask(mCountDownBar1,60);
            }
        });
        BackDraw = TvAnswers[0].getBackground();
        AllQuests = Questionnaire.GetInstance (this);
        DoNext ();
        mCountDownBar1 = new CircularCountDownBar.Builder(this)
                .setMaxProgress(60)
                .setProgressColor(Color.GREEN)
                .setTextColor(Color.WHITE)
                .build();
        LinearLayout.LayoutParams params1 = new LinearLayout.LayoutParams(350,350);
        params1.gravity = Gravity.CENTER;
        params1.topMargin = 10;
        linearLayout.addView(mCountDownBar1,params1);
    }

    private void findView()
    {
        linearLayout = (LinearLayout)findViewById(R.id.linearLayout);
    }

    private void startCountDownTimertask(final CircularCountDownBar countDownBar, int cd)
    {
        int timeOffset = 10;
        new CountDownTimer((cd *= 1000) + timeOffset, 1000)
        {

            @Override
            public void onTick(long millisUntilFinished)
            {
                countDownBar.setProgress((int)(millisUntilFinished/1000));
            }

            @Override
            public void onFinish()
            {
                Intent intent = new Intent (getApplicationContext (), Results.class);
                intent.putExtra("Points", AllQuests.Success());
                intent.putExtra("WrongQue", AllQuests.WrongQue());
                intent.putExtra("WrongAns", AllQuests.WrongAns());
                startActivity (intent);
            }
        }.start();
    }

    @Override
    public void onClick (View v)
    {
        if (v == BtPrev)
        {
            AllQuests.GoPrevUnAns ();
            AllQuests.setCurQuest (AllQuests.getCurQuest () - 1);
            DoNext ();
        }
        if (v == BtOK)
        {
            if (SelAns == -1)
                return;
            CurQ.setUserAns (SelAns);
            DoNext ();
        }
        if (v == BtNext)
        {
            DoNext ();
        }
        for (int i = 0; i < 4; i++)
        {
            if (v == TvAnswers[i])
                SelAns = i;

        }
        DoChangeAnswer ();
    }

    void DoNext ()
    {
        CurQNum = AllQuests.GoNextUnAns ();
        if (CurQNum == -1)
        {
            Intent intent = new Intent (getApplicationContext (), Results.class);
            intent.putExtra("Points", AllQuests.Success());
            intent.putExtra("WrongQue", AllQuests.WrongQue());
            intent.putExtra("WrongAns", AllQuests.WrongAns());
            startActivity (intent);
        }
        else
        {
            CurQ = AllQuests.GetQuestion ();
            for (int i = 0; i < 4; i++)
                TvAnswers[i].setEnabled (true);
            TvQueNumber.setText ("ΕΡΩΤΗΣΗ " + (CurQNum + 1));
            TvQuestion.setText (CurQ.getQueText ());
            for (int i = 0; i < CurQ.GetNoAnswers (); i++)
                TvAnswers[i].setText (CurQ.getAnswer (i));
            for (int i = CurQ.GetNoAnswers (); i < 4; i++)
            {
                TvAnswers[i].setEnabled (false);
                TvAnswers[i].setText ("");
            }
        }
        SelAns = -1;

    }

    void DoChangeAnswer ()
    {
        int i;
        for (i = 0; i < 4; i++)
        {
            TvAnswers[i].setBackground (BackDraw);
            if (i == SelAns)
                TvAnswers[i].setBackgroundColor (Color.GREEN);
        }
    }
}
