package com.dfan.learningapp;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.text.LineBreaker;
import android.net.Uri;
import android.os.Build;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;


public class MyAdapterhist extends RecyclerView.Adapter<MyAdapterhist.MyViewHolder> implements View.OnClickListener
{
    private Context context;

    public MyAdapterhist(Context context)
    {
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(context).inflate(R.layout.myadapterhist, parent, false);
        return new MyViewHolder(view);
    }

    @SuppressLint("ResourceAsColor")
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position)
    {
        boolean start = false;
        if (position == 0)
        {
            holder.tvName.setText(R.string.hist1_1);
            holder.tvName.setTextColor(Color.BLUE);
            holder.tvName.setBackgroundColor(Color.WHITE);
            holder.TvChap.setText(R.string.hist1_3);
            holder.TvChap.setTextColor(Color.CYAN);
            holder.TvChap.setJustificationMode(LineBreaker.JUSTIFICATION_MODE_INTER_WORD);
            holder.TvChap.setVisibility(View.VISIBLE);
            holder.Tvlesson.setText(R.string.hist1_2);
            holder.Tvlesson.setJustificationMode(LineBreaker.JUSTIFICATION_MODE_INTER_WORD);
            holder.Tvlesson.setBackgroundColor(context.getResources().getColor(R.color.colorPrimaryDark));
            holder.Tvlesson.setVisibility(View.VISIBLE);
            holder.TvVideo1.setVisibility(View.VISIBLE);
            holder.TvVideo1.setTextColor(Color.GREEN);
            holder.TvVideo1.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
                    context.startActivity(new Intent(Intent.ACTION_VIEW,Uri.parse("https://www.youtube.com/watch?v=ACUOzG20FdM")));
                    Log.i("Video", "Video Playing....");
                }
            });
        }
        else if (position == 1)
        {
            holder.TvlessonNewHist.setText(R.string.hist1_5);
            holder.TvlessonNewHist.setJustificationMode(LineBreaker.JUSTIFICATION_MODE_INTER_WORD);
            holder.TvlessonNewHist.setVisibility(View.VISIBLE);
            holder.Ivpolikr.setVisibility(View.VISIBLE);
        }
        else if (position == 2)
        {
            holder.TvlessonNewHist.setText(R.string.hist1_7);
            holder.TvlessonNewHist.setJustificationMode(LineBreaker.JUSTIFICATION_MODE_INTER_WORD);
            holder.TvlessonNewHist.setVisibility(View.VISIBLE);
            holder.TvVideo2.setVisibility(View.VISIBLE);
            holder.TvVideo2.setTextColor(Color.GREEN);
            holder.TvVideo2.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
                    context.startActivity(new Intent(Intent.ACTION_VIEW,Uri.parse("https://www.youtube.com/watch?v=W4zidtrhQRg")));
                    Log.i("Video", "Video Playing....");
                }
            });
            holder.Tvlesson2.setVisibility(View.VISIBLE);
            holder.Tvlesson2.setText(R.string.hist1_8);
            holder.Tvlesson2.setJustificationMode(LineBreaker.JUSTIFICATION_MODE_INTER_WORD);
        }
        else if (position == 3)
        {
            holder.TvlessonNewHist.setText(R.string.hist1_9);
            holder.TvlessonNewHist.setJustificationMode(LineBreaker.JUSTIFICATION_MODE_INTER_WORD);
            holder.TvlessonNewHist.setVisibility(View.VISIBLE);
        }
        else if (position == 4)
        {
            holder.TvlessonNewHist.setText(R.string.hist1_11);
            holder.TvlessonNewHist.setJustificationMode(LineBreaker.JUSTIFICATION_MODE_INTER_WORD);
            holder.TvlessonNewHist.setVisibility(View.VISIBLE);
            holder.Ivpolkrati.setVisibility(View.VISIBLE);
        }
        else if (position == 5)
        {
            holder.tvName.setText(R.string.hist1_1);
            holder.tvName.setTextColor(Color.BLUE);
            holder.tvName.setBackgroundColor(Color.WHITE);
            //holder.TvChap.setText(R.string.test);
            holder.TvChap.setTextColor(Color.MAGENTA);
            holder.TvChap.setVisibility(View.VISIBLE);
            holder.TvChap.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
                    Intent intent = new Intent(context.getApplicationContext(), Histque1.class);
                    context.startActivity(intent);
                    Activity Histque1 = null;
                    Histque1.startActivity(intent);
                }
            });
            holder.BtTest.setVisibility(View.INVISIBLE);
            String first = "Η θεωρία για το πρώτο κεφάλαιο τέλειωσε, αν είστε έτοιμος πατήστε ";
            String lats = " για να ξεκινήσει το TEST σας!";
            String next = "<font color='#EE0000'>«ΕΔΩ»</font>";
            holder.TvChap.setText(Html.fromHtml(first + next + lats));
            holder.Tvlesson.setVisibility(View.VISIBLE);
            holder.Tvlesson.setText(R.string.askhsh2);
            holder.Tvlesson.setJustificationMode(LineBreaker.JUSTIFICATION_MODE_INTER_WORD);
        }
    }

    @Override
    public int getItemCount()
    {
        return 6;
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
        ImageView Ivpolikr;
        ImageView Ivpolkrati;
        Button BtTest;
        TextView TvlessonNewHist;


        public MyViewHolder(@NonNull View itemView)
        {
            super(itemView);
            TvChap = itemView.findViewById(R.id.TvChap);
            Ivpolikr = itemView.findViewById(R.id.Ivpolikr);
            Ivpolikr.setVisibility(View.INVISIBLE);
            Ivpolkrati = itemView.findViewById(R.id.Ivpolkrati);
            Ivpolkrati.setVisibility(View.INVISIBLE);
            TvVideo1 = itemView.findViewById(R.id.TvVideo1);
            TvVideo2 = itemView.findViewById(R.id.TvVideo2);
            Tvlesson = itemView.findViewById(R.id.Tvlesson);
            Tvlesson2 = itemView.findViewById(R.id.Tvlesson2);
            TvlessonNewHist = itemView.findViewById(R.id.TvlessonNewHist);
            tvName = itemView.findViewById(R.id.tvName);
            BtTest = itemView.findViewById(R.id.BtTest);
            BtTest.setOnClickListener((new View.OnClickListener ()
            {
                @Override
                public void onClick (View v)
                {
                    Intent intent = new Intent (context.getApplicationContext(), Histque1.class);
                    context.startActivity(intent);
                }
            }));
            
        }
    }
}
