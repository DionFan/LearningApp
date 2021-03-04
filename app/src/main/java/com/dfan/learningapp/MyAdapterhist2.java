package com.dfan.learningapp;

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


public class MyAdapterhist2 extends RecyclerView.Adapter<MyAdapterhist2.MyViewHolder> implements View.OnClickListener
{

    String grades1;
    private Context context;

    public MyAdapterhist2(Context context, String x)
    {
        System.out.println("***MyAdapterhist2"+ x);
        grades1 = x;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(context).inflate(R.layout.myadapterhist2, parent, false);
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
            holder.tvName.setText(R.string.hist2_1);
            holder.tvName.setTextColor(Color.BLUE);
            holder.tvName.setBackgroundColor(Color.WHITE);
            holder.TvChap.setText(R.string.hist2);
            holder.TvChap.setTextColor(Color.CYAN);
            holder.TvChap.setVisibility(View.VISIBLE);
            holder.Tvlesson.setVisibility(View.INVISIBLE);
            holder.Tvlesson2.setVisibility(View.VISIBLE);
            holder.Tvlesson2.setText(R.string.hist2_2);
            holder.Tvlesson2.setJustificationMode(LineBreaker.JUSTIFICATION_MODE_INTER_WORD);
            holder.Ivpolitevma.setVisibility(View.VISIBLE);
            holder.TvVideo1.setVisibility(View.VISIBLE);
            holder.TvVideo1.setTextColor(Color.GREEN);
            holder.TvVideo1.setText("Χρήσιμες πληροφορίες για τα πολιτεύματα θα βρείτε σε αυτό το σύνδεσμο.");
            holder.TvVideo1.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
                    context.startActivity(new Intent(Intent.ACTION_VIEW,Uri.parse("http://ebooks.edu.gr/ebooks/v/html/8547/4720/Koinoniki-kai-Politiki-Agogi_G-Gymnasiou_html-apli/index8.html")));
                    Log.i("Video", "Video Playing....");
                }
            });
            holder.TvVideo1.setJustificationMode(LineBreaker.JUSTIFICATION_MODE_INTER_WORD);
            holder.Tvlesson3.setVisibility(View.VISIBLE);
            holder.Tvlesson3.setText(R.string.hist1_13);
            holder.Tvlesson3.setJustificationMode(LineBreaker.JUSTIFICATION_MODE_INTER_WORD);
        }
        else if (position == 1)
        {
            holder.TvLesson2.setVisibility(View.VISIBLE);
            holder.TvLesson2.setText(R.string.hist2_4);
            holder.TvLesson2.setJustificationMode(LineBreaker.JUSTIFICATION_MODE_INTER_WORD);
        }
        else if (position == 2)
        {

            holder.TvLesson2.setText(R.string.hist2_5);
            holder.TvLesson2.setJustificationMode(LineBreaker.JUSTIFICATION_MODE_INTER_WORD);
            holder.TvLesson2.setVisibility(View.VISIBLE);
            holder.Ivakropoli.setVisibility(View.VISIBLE);

        }

        else if (position == 3)
        {
            holder.tvName.setText(R.string.hist2_1);
            holder.tvName.setTextColor(Color.BLUE);
            holder.tvName.setBackgroundColor(Color.WHITE);
            holder.TvChap.setVisibility(View.VISIBLE);
            holder.TvChap.setTextColor(Color.MAGENTA);
            holder.TvChap.setJustificationMode(LineBreaker.JUSTIFICATION_MODE_INTER_WORD);
            holder.TvChap.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
                    System.out.println("***EDW1");
                    Intent intent = new Intent (context.getApplicationContext(), Histque2.class);
                    intent.putExtra("Points1", grades1);
                    context.startActivity(intent);
                    Activity Histque2 = null;
                    Histque2.startActivity(intent);
                }
            });
            String first = "Η θεωρία για το δεύτερο κεφάλαιο τέλειωσε, αν είστε έτοιμος πατήστε ";
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
        return 4;
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
        TextView TvVideo1;
        TextView TvVideo2;
        ImageView Ivpolitevma;
        ImageView Ivakropoli;
        TextView TvLesson2;
        Button BtTest;


        public MyViewHolder(@NonNull View itemView)
        {
            super(itemView);
            TvChap = itemView.findViewById(R.id.TvChap);
            Ivpolitevma = itemView.findViewById(R.id.Ivpolitevma);
            Ivpolitevma.setVisibility(View.INVISIBLE);
            Ivakropoli = itemView.findViewById(R.id.Ivakropoli);
            TvVideo1 = itemView.findViewById(R.id.TvVideo1);
            TvLesson2 = itemView.findViewById(R.id.TvLesson2);
            TvVideo2 = itemView.findViewById(R.id.TvVideo2);
            Tvlesson = itemView.findViewById(R.id.Tvlesson);
            Tvlesson2 = itemView.findViewById(R.id.Tvlesson2);
            Tvlesson3 = itemView.findViewById(R.id.Tvlesson3);
            tvName = itemView.findViewById(R.id.tvName);
            BtTest = itemView.findViewById(R.id.BtTest);
            BtTest.setOnClickListener((new View.OnClickListener ()
            {
                @Override
                public void onClick (View v)
                {
                    System.out.println("***EDW2");
                    Intent intent = new Intent (context.getApplicationContext(), Histque2.class);
                    context.startActivity(intent);
                    Activity Histque2 = null;
                    Histque2.startActivity(intent);
                }
            }));
            
        }
    }
}
