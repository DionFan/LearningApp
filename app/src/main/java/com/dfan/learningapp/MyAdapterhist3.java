package com.dfan.learningapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.text.LineBreaker;
import android.os.Build;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;


public class MyAdapterhist3 extends RecyclerView.Adapter<MyAdapterhist3.MyViewHolder> implements View.OnClickListener
{
    String grades1;
    String grades2;
    private Context context;
    public MyAdapterhist3(Context context, String x, String y)
    {
        System.out.println("***MyAdapter3 Grades 2"+ x);
        System.out.println("***MyAdapter3 Grades 1"+ y);
        grades1 = y;
        grades2 = x;
        this.context = context;
    }
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(context).inflate(R.layout.myadapterhist3, parent, false);
        return new MyViewHolder(view);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position)
    {
        boolean start = false;
        if (position == 0)
        {
            holder.tvName.setText(R.string.hist3_1);
            holder.tvName.setTextColor(Color.BLUE);
            holder.tvName.setBackgroundColor(Color.WHITE);
            holder.TvChap.setText(R.string.hist3);
            holder.TvChap.setTextColor(Color.CYAN);
            holder.TvChap.setVisibility(View.VISIBLE);
            holder.Tvlesson.setText(R.string.hist3_2);
            holder.Tvlesson.setJustificationMode(LineBreaker.JUSTIFICATION_MODE_INTER_WORD);
            holder.Tvlesson.setVisibility(View.VISIBLE);
        }
        else if (position == 1)
        {
            holder.TvNewLesson.setVisibility(View.VISIBLE);
            holder.TvNewLesson.setText(R.string.hist3_3);
            holder.TvNewLesson.setJustificationMode(LineBreaker.JUSTIFICATION_MODE_INTER_WORD);
            holder.Ivapoik2.setVisibility(View.VISIBLE);
            holder.Tvlesson2.setVisibility(View.VISIBLE);
            holder.Tvlesson2.setText(R.string.hist3_6);
        }
        else if (position == 2)
        {

            holder.TvNewLesson.setText(R.string.hist3_4);
            holder.TvNewLesson.setJustificationMode(LineBreaker.JUSTIFICATION_MODE_INTER_WORD);
            holder.TvNewLesson.setVisibility(View.VISIBLE);

        }
        else if (position == 3)
        {
            holder.TvNewLesson.setText(R.string.hist3_5);
            holder.TvNewLesson.setJustificationMode(LineBreaker.JUSTIFICATION_MODE_INTER_WORD);
            holder.TvNewLesson.setVisibility(View.VISIBLE);
        }

        else if (position == 4)
        {
            holder.tvName.setText(R.string.hist3_1);
            holder.tvName.setTextColor(Color.BLUE);
            holder.tvName.setBackgroundColor(Color.WHITE);
            holder.TvChap.setVisibility(View.VISIBLE);
            holder.TvChap.setTextColor(Color.MAGENTA);
            holder.TvChap.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
                    Intent intent = new Intent (context.getApplicationContext(), Histque3.class);
                    intent.putExtra("Points2", grades2);
                    intent.putExtra("Points1", grades1);
                    context.startActivity(intent);
                    Activity Histque3=null;
                    Histque3.startActivity(intent);
                }
            });
            String first = "Η θεωρία για το πρώτο κεφάλαιο τέλειωσε, αν είστε έτοιμος πατήστε ";
            String lats = " για να ξεκινήσει το TEST σας!";
            String next = "<font color='#EE0000'>«ΕΔΩ»</font>";
            holder.TvChap.setText(Html.fromHtml(first + next + lats));
            holder.BtTest.setVisibility(View.INVISIBLE);
            holder.Tvlesson.setVisibility(View.VISIBLE);
            holder.Tvlesson.setText(R.string.askhsh1);
            holder.Tvlesson.setJustificationMode(LineBreaker.JUSTIFICATION_MODE_INTER_WORD);
        }

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
        TextView TvVideo2;
        ImageView Ivapoik2;
        TextView TvNewLesson;
        Button BtTest;


        public MyViewHolder(@NonNull View itemView)
        {
            super(itemView);
            TvChap = itemView.findViewById(R.id.TvChap);
            Ivapoik2 = itemView.findViewById(R.id.Ivapoik2);
            TvNewLesson = itemView.findViewById(R.id.TvNewLesson);
            Ivapoik2.setVisibility(View.INVISIBLE);
            TvVideo1 = itemView.findViewById(R.id.TvVideo1);
            TvVideo2 = itemView.findViewById(R.id.TvVideo2);
            Tvlesson = itemView.findViewById(R.id.Tvlesson);
            Tvlesson2 = itemView.findViewById(R.id.Tvlesson2);
            tvName = itemView.findViewById(R.id.tvName);
            BtTest = itemView.findViewById(R.id.BtTest);
            BtTest.setOnClickListener((new View.OnClickListener ()
            {
                @Override
                public void onClick (View v)
                {
                    Intent intent = new Intent (context.getApplicationContext(), Histque3.class);
                    context.startActivity(intent);
                }
            }));
            
        }
    }
}
