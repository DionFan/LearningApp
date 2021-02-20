package com.dfan.learningapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.text.LineBreaker;
import android.net.Uri;
import android.os.Build;
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


public class MyAdapter2 extends RecyclerView.Adapter<MyAdapter2.MyViewHolder> implements View.OnClickListener
{
    String grades1;

    private Context context;

    public MyAdapter2(Context context, String x)
    {
        System.out.println("***MyAdapter2"+ x);
        grades1 = x;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(context).inflate(R.layout.myadapter2, parent, false);
        return new MyViewHolder(view);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position)
    {
        //holder.tvName.setText(String.format("Page  %d ", position + 1));
        boolean start = false;
        if (position == 0)
        {
            holder.tvName.setText(R.string.screen1);
            holder.tvName.setTextColor(Color.BLUE);
            holder.tvName.setBackgroundColor(Color.WHITE);
            holder.TvChap.setText(R.string.chap2);
            holder.TvChap.setTextColor(Color.GREEN);
            holder.TvChap.setVisibility(View.VISIBLE);
            holder.Tvlesson2.setText(R.string.chap2_2);
            holder.Tvlesson2.setJustificationMode(LineBreaker.JUSTIFICATION_MODE_INTER_WORD);
            holder.Tvlesson2.setVisibility(View.VISIBLE);
            holder.Ivargo.setVisibility(View.VISIBLE);
            holder.TvVideo1.setVisibility(View.VISIBLE);
            holder.TvVideo1.setTextColor(Color.YELLOW);
            holder.TvVideo1.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
                    context.startActivity(new Intent(Intent.ACTION_VIEW,Uri.parse("https://www.youtube.com/watch?v=J3letleHneo")));
                    Log.i("Video", "Video Playing....");
                }
            });
            holder.Tvlesson3.setVisibility(View.VISIBLE);
            holder.Tvlesson3.setJustificationMode(LineBreaker.JUSTIFICATION_MODE_INTER_WORD);
            holder.Tvlesson3.setText(R.string.chap2_3);

        }
        else if (position == 1)
        {
            holder.tvName.setText(R.string.screen1);
            holder.tvName.setTextColor(Color.BLUE);
            holder.tvName.setBackgroundColor(Color.WHITE);
            holder.TvChap.setVisibility(View.VISIBLE);
            holder.TvChap.setText(R.string.chap2);
            holder.TvChap.setTextColor(Color.GREEN);
            holder.Tvlesson.setText(R.string.chap2_4);
            holder.Tvlesson.setJustificationMode(LineBreaker.JUSTIFICATION_MODE_INTER_WORD);
            holder.Tvlesson.setVisibility(View.VISIBLE);
            holder.Tvlesson3.setVisibility(View.INVISIBLE);
        }
        else if (position == 2)
        {
            holder.tvName.setText(R.string.screen1);
            holder.tvName.setTextColor(Color.BLUE);
            holder.tvName.setBackgroundColor(Color.WHITE);
            holder.TvChap.setVisibility(View.VISIBLE);
            holder.TvChap.setText(R.string.chap2);
            holder.TvChap.setTextColor(Color.GREEN);
            holder.Tvlesson.setText(R.string.chap2_5);
            holder.Tvlesson.setJustificationMode(LineBreaker.JUSTIFICATION_MODE_INTER_WORD);
            holder.Tvlesson.setVisibility(View.VISIBLE);
            holder.Tvlesson3.setVisibility(View.INVISIBLE);
        }
        else if (position == 3)
        {
            holder.tvName.setText(R.string.screen1);
            holder.tvName.setTextColor(Color.BLUE);
            holder.tvName.setBackgroundColor(Color.WHITE);
            holder.TvChap.setVisibility(View.VISIBLE);
            holder.TvChap.setText(R.string.chap2);
            holder.TvChap.setTextColor(Color.GREEN);
            holder.Tvlesson.setText(R.string.chap2_6);
            holder.Tvlesson.setJustificationMode(LineBreaker.JUSTIFICATION_MODE_INTER_WORD);
            holder.Tvlesson.setVisibility(View.VISIBLE);
            holder.Tvlesson3.setVisibility(View.INVISIBLE);

        }
        else if (position == 4)
        {
            holder.tvName.setText(R.string.screen1);
            holder.tvName.setTextColor(Color.BLUE);
            holder.tvName.setBackgroundColor(Color.WHITE);
            holder.TvChap.setVisibility(View.VISIBLE);
            holder.TvChap.setText(R.string.test1);
            holder.TvChap.setTextColor(Color.MAGENTA);
            holder.TvChap.setJustificationMode(LineBreaker.JUSTIFICATION_MODE_INTER_WORD);
            holder.Tvlesson.setVisibility(View.VISIBLE);
            holder.Tvlesson.setText(R.string.askhsh2);
            holder.Tvlesson.setJustificationMode(LineBreaker.JUSTIFICATION_MODE_INTER_WORD);
            holder.TvChap.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
                    System.out.println("***EDW1");
                    //Intent intent = new Intent (context.getApplicationContext(), Chapter2Que.class);
                    //context.startActivity(intent);
                    Intent intent = new Intent(context.getApplicationContext(), Chapter2Que.class);
                    intent.putExtra("Points1", grades1);
                    context.startActivity(intent);
                    Activity Chapter2Que = null;
                    Chapter2Que.startActivity(intent);
                }
            });
            holder.BtTest.setVisibility(View.INVISIBLE);
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
        TextView TvVideo1;
        Button BtTest;
        ImageView Ivargo;
        TextView Tvlesson3;


        public MyViewHolder(@NonNull View itemView)
        {
            super(itemView);
            TvChap = itemView.findViewById(R.id.TvChap);
            TvVideo1 = itemView.findViewById(R.id.TvVideo1);
            Tvlesson = itemView.findViewById(R.id.Tvlesson);
            Tvlesson2 = itemView.findViewById(R.id.Tvlesson2);
            tvName = itemView.findViewById(R.id.tvName);
            BtTest = itemView.findViewById(R.id.BtTest);
            Ivargo = itemView.findViewById(R.id.Ivargo);
            Tvlesson3 = itemView.findViewById(R.id.Tvlesson3);
            BtTest.setOnClickListener((new View.OnClickListener ()
            {
                @Override
                public void onClick (View v)
                {
                    //Context context = null;
                    System.out.println("***EDW2");
                    //Intent intent = new Intent (context.getApplicationContext(), Chapter2Que.class);
                    //context.startActivity(intent);
                    Intent intent = new Intent(context.getApplicationContext(), Chapter2Que.class);
                    context.startActivity(intent);
                    Activity Chapter2Que = null;
                    Chapter2Que.startActivity(intent);
                }
            }));

        }
    }
}

