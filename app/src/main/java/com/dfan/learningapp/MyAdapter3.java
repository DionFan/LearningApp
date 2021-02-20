package com.dfan.learningapp;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.text.LineBreaker;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;
import android.graphics.Color;
import android.widget.ImageView;

public class MyAdapter3 extends RecyclerView.Adapter<MyAdapter3.MyViewHolder> implements View.OnClickListener
{
    String grades1;
    String grades2;

    private Context context;

    public MyAdapter3(Context context, String x, String y)
    {

        //Intent intent = null;
        System.out.println("***MyAdapter3 Grades 2"+ x);
        System.out.println("***MyAdapter3 Grades 1"+ y);
        //intent.putExtra("Points2", x);
        grades1 = y;
        grades2 = x;
        this.context = context;
    }

    @NonNull
    @Override
    public MyAdapter3.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)

    {
        View view = LayoutInflater.from(context).inflate(R.layout.myadapter3, parent, false);
        return new MyAdapter3.MyViewHolder(view);

    }

    @SuppressLint("ResourceAsColor")
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onBindViewHolder(@NonNull MyAdapter3.MyViewHolder holder, int position)
    {

        //holder.tvName.setText(String.format("Page  %d ", position + 1));
        boolean start = false;
        if (position == 0)
        {
            holder.tvName.setText(R.string.screen1);
            holder.tvName.setTextColor(Color.BLUE);
            holder.tvName.setBackgroundColor(Color.WHITE);
            holder.TvChap.setText(R.string.chap3);
            holder.TvChap.setTextColor(Color.GREEN);
            holder.TvChap.setVisibility(View.VISIBLE);
            holder.Tvlesson.setText(R.string.chap3_1);
            //holder.Tvlesson.setJustificationMode(LineBreaker.JUSTIFICATION_MODE_INTER_WORD);
            holder.Tvlesson.setVisibility(View.VISIBLE);
            holder.Tvlesson.setBackgroundColor(context.getResources().getColor(R.color.coral));
            holder.Tvlesson.setTextColor(Color.BLACK);
            holder.Tvlesson2.setVisibility(View.VISIBLE);
            holder.Tvlesson2.setJustificationMode(LineBreaker.JUSTIFICATION_MODE_INTER_WORD);
            holder.Tvlesson2.setText(R.string.chap3_2);
            //holder.Ivaerostata.setVisibility(View.VISIBLE);
            holder.Tvlesson3.setVisibility(View.INVISIBLE);
        }
        else if (position == 1)
        {
            holder.tvName.setText(R.string.screen1);
            holder.tvName.setTextColor(Color.BLUE);
            holder.tvName.setBackgroundColor(Color.WHITE);
            holder.TvChap.setVisibility(View.VISIBLE);
            holder.TvChap.setText(R.string.chap3);
            holder.TvChap.setTextColor(Color.GREEN);
            holder.Ivaerostata.setVisibility(View.VISIBLE);
            holder.Tvlesson3.setText(R.string.chap3_3);
            holder.Tvlesson3.setJustificationMode(LineBreaker.JUSTIFICATION_MODE_INTER_WORD);
            holder.Tvlesson3.setVisibility(View.VISIBLE);
        }
        else if (position == 2)
        {
            holder.tvName.setText(R.string.screen1);
            holder.tvName.setTextColor(Color.BLUE);
            holder.tvName.setBackgroundColor(Color.WHITE);
            holder.TvChap.setVisibility(View.VISIBLE);
            holder.TvChap.setText(R.string.chap3);
            holder.TvChap.setTextColor(Color.GREEN);
            holder.Tvlesson.setText(R.string.chap3_4);
            holder.Tvlesson.setJustificationMode(LineBreaker.JUSTIFICATION_MODE_INTER_WORD);
            holder.Tvlesson.setVisibility(View.VISIBLE);
            holder.Tvlesson2.setVisibility(View.INVISIBLE);
            holder.Tvlesson3.setVisibility(View.INVISIBLE);
        }
        else if (position == 3)
        {
            holder.tvName.setText(R.string.screen1);
            holder.tvName.setTextColor(Color.BLUE);
            holder.tvName.setBackgroundColor(Color.WHITE);
            holder.TvChap.setVisibility(View.VISIBLE);
            holder.TvChap.setText(R.string.chap3);
            holder.TvChap.setTextColor(Color.GREEN);
            holder.Tvlesson.setText(R.string.chap3_5);
            holder.Tvlesson.setJustificationMode(LineBreaker.JUSTIFICATION_MODE_INTER_WORD);
            holder.Tvlesson.setVisibility(View.VISIBLE);
            holder.Tvlesson2.setVisibility(View.INVISIBLE);
            holder.Tvlesson3.setVisibility(View.INVISIBLE);
        }
        else if (position == 4)
        {
            holder.tvName.setText(R.string.screen1);
            holder.tvName.setTextColor(Color.BLUE);
            holder.tvName.setBackgroundColor(Color.WHITE);
            holder.TvChap.setVisibility(View.VISIBLE);
            holder.TvChap.setText(R.string.test2);
            holder.TvChap.setTextColor(Color.MAGENTA);
            holder.TvChap.setJustificationMode(LineBreaker.JUSTIFICATION_MODE_INTER_WORD);
            holder.Tvlesson.setVisibility(View.VISIBLE);
            holder.Tvlesson.setText(R.string.askhsh3);
            holder.Tvlesson.setJustificationMode(LineBreaker.JUSTIFICATION_MODE_INTER_WORD);
            holder.TvChap.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
                    System.out.println("***EDW1");
                    Intent intent = new Intent(context.getApplicationContext(), Chapter3Que.class);
                    intent.putExtra("Points2", grades2);
                    intent.putExtra("Points1", grades1);
                    context.startActivity(intent);
                    System.out.println("***MyAdapter3Onclick Grades 2" + grades2);
                    System.out.println("***MyAdapter3Onclick Grades 1" + grades1);
                    Activity Chapter3Que = null;
                    Chapter3Que.startActivity(intent);
                }
            });
            holder.Tvlesson3.setVisibility(View.INVISIBLE);
        }
        /*if (position %2 == 0)
        {
            //holder.imgBanner.setBackgroundColor(Color.RED);
        }
        else
            {
                //holder.imgBanner.setBackgroundColor(Color.GREEN);
            }*/
    }

    @Override
    public int getItemCount()
    {
        return 5;
    }

    @Override
    public void onClick(View v) {

    }


    public class MyViewHolder extends RecyclerView.ViewHolder

    {
        TextView TvChap;
        TextView tvName;
        TextView Tvlesson;
        TextView Tvlesson2;
        TextView Tvlesson3;
        ImageView Ivaerostata;



        public MyViewHolder(@NonNull View itemView)
        {

            super(itemView);
            TvChap = itemView.findViewById(R.id.TvChap);
            Tvlesson = itemView.findViewById(R.id.Tvlesson);
            Tvlesson2 = itemView.findViewById(R.id.Tvlesson2);
            tvName = itemView.findViewById(R.id.tvName);
            Tvlesson3 = itemView.findViewById(R.id.Tvlesson3);
            Ivaerostata = itemView.findViewById(R.id.Ivaerostata);
        }
    }
}
