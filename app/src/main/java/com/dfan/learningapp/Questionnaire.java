package com.dfan.learningapp;

import android.content.Context;
import android.content.res.AssetManager;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class Questionnaire
{
    private ArrayList<Question> Questions;
    private int CurQuest;
    private static Questionnaire Instance = null;
    private static Context Cont;
    int wrong = 0;

    public static Questionnaire GetInstance (Context Co, int x)
    {
        Cont = Co;
        if (Instance == null)
            Instance = new Questionnaire (x);
        return Instance;
    }


    public int getCurQuest ()
    {
        return CurQuest;
    }

    public void setCurQuest (int curQuest)
    {
        CurQuest = curQuest;
    }

    private Questionnaire (int x)
    {
        Questions = new ArrayList ();
        CurQuest = -1 ;
        LoadDatabase (x);
    }

    private void LoadDatabase (int x)
    {
        int NoQ;
        AssetManager AssMan = Cont.getAssets();
        System.out.println ("*** !!!!!");
        if(x==1)
        {
            try (BufferedReader BR = new BufferedReader (new InputStreamReader (AssMan.open ("Questionnaire1.txt"))))
            {
                System.out.println ("*** Erwthmatologio 1");
                System.out.println ("*** -----");
                NoQ = Integer.parseInt (BR.readLine ());
                for (int i = 0; i < NoQ; i++)
                {
                    System.out.println ("*** ///");
                    Question Q = new Question ();
                    Q.setQueText (BR.readLine ());
                    int NoA = Integer.parseInt (BR.readLine ());
                    Q.setCorrectAns (Integer.parseInt (BR.readLine ()));
                    for (int j = 0; j < NoA; j++)
                        Q.AddAnswer (BR.readLine ());
                    Questions.add (Q);
                }
            }
            catch (IOException e1)
            {
                System.err.println ("***Exception in Reading Database");
            }
        }
        else if(x==2)
        {
            try (BufferedReader BR = new BufferedReader (new InputStreamReader (AssMan.open ("Questionnaire2.txt"))))
            {
                System.out.println ("*** Erwthmatologio 2");
                System.out.println ("*** -----");
                NoQ = Integer.parseInt (BR.readLine ());
                for (int i = 0; i < NoQ; i++)
                {
                    System.out.println ("*** ///");
                    Question Q = new Question ();
                    Q.setQueText (BR.readLine ());
                    int NoA = Integer.parseInt (BR.readLine ());
                    Q.setCorrectAns (Integer.parseInt (BR.readLine ()));
                    for (int j = 0; j < NoA; j++)
                        Q.AddAnswer (BR.readLine ());
                    Questions.add (Q);
                }
            }
            catch (IOException e1)
            {
                System.err.println ("***Exception in Reading Database");
            }
        }
        else if(x==3)
        {
            try (BufferedReader BR = new BufferedReader (new InputStreamReader (AssMan.open ("Questionnaire3.txt"))))
            {
                System.out.println ("*** Erwthmatologio 3");
                System.out.println ("*** -----");
                NoQ = Integer.parseInt (BR.readLine ());
                for (int i = 0; i < NoQ; i++)
                {
                    System.out.println ("*** ///");
                    Question Q = new Question ();
                    Q.setQueText (BR.readLine ());
                    int NoA = Integer.parseInt (BR.readLine ());
                    Q.setCorrectAns (Integer.parseInt (BR.readLine ()));
                    for (int j = 0; j < NoA; j++)
                        Q.AddAnswer (BR.readLine ());
                    Questions.add (Q);
                }
            }
            catch (IOException e1)
            {
                System.err.println ("***Exception in Reading Database");
            }
        }
        else if(x==4)
        {
            try (BufferedReader BR = new BufferedReader (new InputStreamReader (AssMan.open ("Questionnaire4.txt"))))
            {
                System.out.println ("*** Erwthmatologio 4");
                System.out.println ("*** -----");
                NoQ = Integer.parseInt (BR.readLine ());
                for (int i = 0; i < NoQ; i++)
                {
                    System.out.println ("*** ///");
                    Question Q = new Question ();
                    Q.setQueText (BR.readLine ());
                    int NoA = Integer.parseInt (BR.readLine ());
                    Q.setCorrectAns (Integer.parseInt (BR.readLine ()));
                    for (int j = 0; j < NoA; j++)
                        Q.AddAnswer (BR.readLine ());
                    Questions.add (Q);
                }
            }
            catch (IOException e1)
            {
                System.err.println ("***Exception in Reading Database");
            }
        }
        else if(x==5)
        {
            try (BufferedReader BR = new BufferedReader (new InputStreamReader (AssMan.open ("Questionnaire5.txt"))))
            {
                System.out.println ("*** Erwthmatologio 5");
                System.out.println ("*** -----");
                NoQ = Integer.parseInt (BR.readLine ());
                for (int i = 0; i < NoQ; i++)
                {
                    System.out.println ("*** ///");
                    Question Q = new Question ();
                    Q.setQueText (BR.readLine ());
                    int NoA = Integer.parseInt (BR.readLine ());
                    Q.setCorrectAns (Integer.parseInt (BR.readLine ()));
                    for (int j = 0; j < NoA; j++)
                        Q.AddAnswer (BR.readLine ());
                    Questions.add (Q);
                }
            }
            catch (IOException e1)
            {
                System.err.println ("***Exception in Reading Database");
            }
        }
        else if(x==6)
        {
            try (BufferedReader BR = new BufferedReader (new InputStreamReader (AssMan.open ("Questionnaire6.txt"))))
            {
                System.out.println ("*** Erwthmatologio 6");
                System.out.println ("*** -----");
                NoQ = Integer.parseInt (BR.readLine ());
                for (int i = 0; i < NoQ; i++)
                {
                    System.out.println ("*** ///");
                    Question Q = new Question ();
                    Q.setQueText (BR.readLine ());
                    int NoA = Integer.parseInt (BR.readLine ());
                    Q.setCorrectAns (Integer.parseInt (BR.readLine ()));
                    for (int j = 0; j < NoA; j++)
                        Q.AddAnswer (BR.readLine ());
                    Questions.add (Q);
                }
            }
            catch (IOException e1)
            {
                System.err.println ("***Exception in Reading Database");
            }
        }

    }

    public int GetNoQuestions ()
    {
        return Questions.size ();
    }

    public int GetNoAnsweredQuestions ()
    {
        int Count;
        int i;
        for (Count = 0, i = 0; i < GetNoQuestions (); i++)
            if (GetQuestion (i).getUserAns () != -1)
                Count ++;
        return Count;
    }

    public int GetNoUnAnsweredQuestions ()
    {
        int Count;
        int i;
        for (Count = 0, i = 0; i < GetNoQuestions (); i++)
            if (GetQuestion (i).getUserAns () == -1)
                Count ++;
        return Count;
    }

    public Question GetQuestion (int QN)
    {
        return Questions.get (QN);
    }

    public Question GetQuestion ()
    {
        return Questions.get (CurQuest);
    }

    public int GoNext ()
    {
        CurQuest++;
        if (CurQuest == GetNoQuestions ())
            CurQuest = 0;
        return CurQuest;
    }

    public int GoPrevious ()
    {
        CurQuest--;
        if (CurQuest == -1)
            CurQuest = GetNoQuestions () - 1;
        return CurQuest;
    }

    public int GoNextUnAns ()
    {
        if (GetNoUnAnsweredQuestions () == 0)
            return -1;
        do
        {
            CurQuest++;
            if (CurQuest == GetNoQuestions ())
                CurQuest = 0;
        }
        while (GetQuestion (CurQuest).isAnswered ());
        return CurQuest;
    }

    public int GoPrevUnAns ()
    {
        if (GetNoUnAnsweredQuestions () == 0)
            return -1;
        do
        {
            CurQuest--;
            if (CurQuest == -1 )
                CurQuest = GetNoQuestions () - 1;
        }
        while (GetQuestion (CurQuest).isAnswered ());
        return CurQuest;
    }

    public void PrintAll ()
    {
        int i, j;
        System.out.println ("***HERE!!!!!!!");
        for (i = 0; i < GetNoQuestions (); i++)
        {
            Question Q = GetQuestion (i);
            System.out.println ("***" + "Question : " + (i + 1) + " " + Q.getQueText ());
            System.out.println ("***" + "Number of Answers : " + Q.GetNoAnswers ());
            System.out.println ("***" + "Correct Answer     : " + Q.getCorrectAns ());
            for (j = 0; j < Q.GetNoAnswers (); j++)
            {
                System.out.println ("***" + "Answer : "  + Q.getAnswer (j));
            }
        }

    }

    public String WrongQue()
    {
        int i = 0;
        ArrayList<String> WrongQue = new ArrayList<>();
        String WrongQuestion = "";
        for (i = 0; i < GetNoQuestions (); i++)
        {

            Question Q = GetQuestion(i);
            if (Q.isCorrect() == false)
            {
                if (Q.getQueText() != null)
                {
                    WrongQue.add(Q.getQueText());
                }

            }
        }
        WrongQuestion = WrongQue.toString().replace("[","").replace("]","").replaceAll(",","\n\n").trim();
     return WrongQuestion;
    }

    public String WrongAns()
    {
        int i = 0;
        ArrayList<String> WrongAns = new ArrayList<>();
        String WrongAnswer = "";
        for (i = 0; i < GetNoQuestions (); i++)
        {
            Question Q = GetQuestion(i);
            if (Q.isCorrect() == false)
            {
                if (Q.getQueText() != null)
                {
                    WrongAns.add(Q.getAnswer(Q.getCorrectAns()));
                }

            }
        }
        WrongAnswer = WrongAns.toString().replace("[","").replace("]","").replaceAll(",","\n\n").trim();
        return WrongAnswer;
    }


    public float Success ()
    {
        int i;
        int wrong = 0;
        for (i = 0; i < GetNoQuestions (); i++)
        {
            Question Q = GetQuestion (i);
            if (Q.isCorrect() == false)
            {
                wrong++;
            }
        }
        float success = (((GetNoQuestions() - wrong) * 100) / GetNoQuestions());
        return success;
    }


    public void PrintAnswers ()
    {
        int i;
        int wrong = 0;
        for (i = 0; i < GetNoQuestions (); i++)
        {
            Question Q = GetQuestion (i);
            System.out.println ("*** Question Number : " + (i + 1) + "Student Answer : " + Q.getUserAns () + "Correct Answer: " +Q.getCorrectAns());
                if (GetQuestion(i).isCorrect() == false)
                {
                    System.out.println("***LATHOS***" + Q.getQueText());
                    System.out.println("***" + Q.getAnswer(Q.getCorrectAns()));
                    wrong++;
                }
        }
        float success = (((GetNoQuestions() - wrong) * 100) / GetNoQuestions());
        System.out.println("***" + wrong);
        System.out.println("***Success Point is: " + success);
    }



}
