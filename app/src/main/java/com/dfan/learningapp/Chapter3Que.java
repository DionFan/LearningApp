package com.dfan.learningapp;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelStoreOwner;
import android.content.DialogInterface;
import android.graphics.text.LineBreaker;
import android.os.Build;
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

public class Chapter3Que extends AppCompatActivity implements View.OnClickListener
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
        static boolean active = false;
        String Grades1;
        String Grades2;


        @Override
        public void onStart()
        {
            super.onStart();
            active = true;
        }

        @Override
        public void onStop()
        {
            super.onStop();
            active = false;
        }
        @Override
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
         Intent intent = getIntent();
         Bundle box = intent.getExtras();
         String Gr1 = box.getString("Points1");
         String Gr2 = box.getString("Points2");
         Grades1 = Gr1;
         Grades2 = Gr2;
         System.out.println("***Chap3Que Grades 1" + Grades1);
         System.out.println("***Chap3Que Grades 2" + Grades2);
        super.onCreate (savedInstanceState);
        setContentView (R.layout.chapter3que);
        System.out.println("***ARXH");
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
        @RequiresApi(api = Build.VERSION_CODES.O)
        @Override
        public void onClick(View v)
        {
        BtStart.setVisibility(View.INVISIBLE);
        TvQuestion.setVisibility(View.VISIBLE);
        TvQuestion.setJustificationMode(LineBreaker.JUSTIFICATION_MODE_INTER_WORD);
        TvAnswers[0].setVisibility(View.VISIBLE);
        TvAnswers[1].setVisibility(View.VISIBLE);
        TvAnswers[2].setVisibility(View.VISIBLE);
        TvAnswers[3].setVisibility(View.VISIBLE);
        BtNext.setVisibility(View.VISIBLE);
        BtOK.setVisibility(View.VISIBLE);
        BtPrev.setVisibility(View.VISIBLE);
        TvQueNumber.setVisibility(View.VISIBLE);
        startCountDownTimertask(mCountDownBar1,120);
        }
        });
        BackDraw = TvAnswers[0].getBackground();
        AllQuests = Questionnaire.GetInstance (this, 3);
        System.out.println("***Fortwsh Questionnaire");
        DoNext ();
        mCountDownBar1 = new CircularCountDownBar.Builder(this)
        .setMaxProgress(120)
        .setProgressColor(Color.GREEN)
        .setTextColor(Color.YELLOW)
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
        if (Chapter3Que.active == false)
        {
            System.out.println("***Dn kano tipota");
        }
        else
        {
            System.out.println("***Chap3QueOnclick Grades1" + Grades1);
            System.out.println("***Chap3QueOnclick Grades2" + Grades2);
            System.out.println("***kano auto pou prepei");
            Intent intent = new Intent (getApplicationContext (), Chapter3Results.class);
            intent.putExtra("Points3", AllQuests.Success());
            intent.putExtra("WrongQue", AllQuests.WrongQue());
            intent.putExtra("WrongAns", AllQuests.WrongAns());
            intent.putExtra("Points2", Grades2);
            intent.putExtra("Points1", Grades1);
            startActivity (intent);
        }

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
            System.out.println("***DoNext");
            CurQNum = AllQuests.GoNextUnAns ();
        if (CurQNum == -1)
        {
            System.out.println("***Chap3QueOnclick Grades1" + Grades1);
            System.out.println("***Chap3QueOnclick Grades2" + Grades2);
            Intent intent = new Intent (getApplicationContext (), Chapter3Results.class);
            intent.putExtra("Points3", AllQuests.Success());
            intent.putExtra("WrongQue", AllQuests.WrongQue());
            intent.putExtra("WrongAns", AllQuests.WrongAns());
            intent.putExtra("Points2", Grades2);
            intent.putExtra("Points1", Grades1);
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
