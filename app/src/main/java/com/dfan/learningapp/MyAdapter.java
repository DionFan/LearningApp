package com.dfan.learningapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.text.LineBreaker;
import android.net.Uri;
import android.os.Build;
import android.text.Html;
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


public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> implements View.OnClickListener
{
    private Context context;

    public MyAdapter(Context context)
    {
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(context).inflate(R.layout.act2one, parent, false);
        return new MyViewHolder(view);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position)
    {
        boolean start = false;
        if (position == 0)
        {
            holder.tvName.setText(R.string.screen1);
            holder.tvName.setTextColor(Color.BLUE);
            holder.tvName.setBackgroundColor(Color.WHITE);
            holder.TvChap.setText(R.string.screen1_2);
            holder.TvChap.setTextColor(Color.GREEN);
            holder.Tvlesson.setText(R.string.screen1_3);
            holder.Tvlesson.setJustificationMode(LineBreaker.JUSTIFICATION_MODE_INTER_WORD);
            holder.IvVavelTower.setVisibility(View.VISIBLE);
        }
        else if (position == 1)
        {
            holder.tvName.setVisibility(View.INVISIBLE);
            holder.TvChap.setVisibility(View.INVISIBLE);
            holder.Tvlesson.setText(R.string.screen1_4);
            holder.Tvlesson.setJustificationMode(LineBreaker.JUSTIFICATION_MODE_INTER_WORD);
            holder.Ivagnostes.setVisibility(View.VISIBLE);
        }
        else if (position == 2)
        {
            holder.tvName.setVisibility(View.INVISIBLE);
            holder.TvChap.setText(R.string.screen2);
            holder.TvChap.setTextColor(Color.GREEN);
            holder.Tvlesson.setText(R.string.screen2_1);
            holder.Tvlesson.setJustificationMode(LineBreaker.JUSTIFICATION_MODE_INTER_WORD);
            holder.TvVideo1.setVisibility(View.VISIBLE);
            holder.TvVideo2.setVisibility(View.VISIBLE);
            holder.TvVideo2.setTextColor(Color.YELLOW);
            holder.TvVideo1.setTextColor(Color.YELLOW);
            holder.TvVideo2.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
                    context.startActivity(new Intent(Intent.ACTION_VIEW,Uri.parse("https://www.youtube.com/watch?v=0dbpMYFlK78&list=PLnxyoMVDsfQaFNXMKBKJ2eLXEjVspXRb_&index=17&ab_channel=COSMOTETV")));
                    Log.i("Video", "Video Playing....");
                }
            });

            holder.TvVideo1.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
                    context.startActivity(new Intent(Intent.ACTION_VIEW,Uri.parse("https://www.youtube.com/watch?v=nPhZkWcgbzs&list=PLnxyoMVDsfQaFNXMKBKJ2eLXEjVspXRb_&index=1&ab_channel=COSMOTETV")));
                    Log.i("Video", "Video Playing....");
                }
            });
            holder.Tvlesson2.setVisibility(View.VISIBLE);
            holder.Tvlesson2.setText(R.string.screen2_2);
            holder.Tvlesson2.setJustificationMode(LineBreaker.JUSTIFICATION_MODE_INTER_WORD);
        }
        else if (position == 3)
        {
            holder.tvName.setVisibility(View.INVISIBLE);
            holder.TvChap.setVisibility(View.INVISIBLE);
            holder.TvlessonNew.setText(R.string.screen3);
            holder.TvlessonNew.setJustificationMode(LineBreaker.JUSTIFICATION_MODE_INTER_WORD);
            holder.TvlessonNew.setVisibility(View.VISIBLE);
            holder.Tvlesson.setVisibility(View.INVISIBLE);

        }
        else if (position == 4)
        {
            holder.tvName.setVisibility(View.INVISIBLE);
            holder.TvChap.setVisibility(View.INVISIBLE);
            holder.TvlessonNew.setVisibility(View.VISIBLE);
            holder.TvlessonNew.setText(R.string.screen1_6);
            holder.TvlessonNew.setJustificationMode(LineBreaker.JUSTIFICATION_MODE_INTER_WORD);
            holder.Tvlesson.setVisibility(View.INVISIBLE);
            holder.Ivle3ilogio.setVisibility(View.VISIBLE);
        }
        else if (position == 5)
        {
            holder.tvName.setText(R.string.screen1);
            holder.tvName.setTextColor(Color.BLUE);
            holder.tvName.setBackgroundColor(Color.WHITE);
            holder.TvChap.setTextColor(Color.MAGENTA);
            holder.TvChap.setJustificationMode(LineBreaker.JUSTIFICATION_MODE_INTER_WORD);
            holder.Tvlesson.setVisibility(View.VISIBLE);
            holder.Tvlesson.setText(R.string.askhsh1);
            holder.Tvlesson.setJustificationMode(LineBreaker.JUSTIFICATION_MODE_INTER_WORD);
            holder.TvChap.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
                    Intent intent = new Intent(context.getApplicationContext(), Act3.class);
                    context.startActivity(intent);
                    Activity Act3 = null;
                    Act3.startActivity(intent);
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
        ImageView IvVavelTower;
        ImageView Ivagnostes;
        Button BtTest;
        TextView TvlessonNew;
        ImageView Ivle3ilogio;


        public MyViewHolder(@NonNull View itemView)
        {
            super(itemView);
            TvChap = itemView.findViewById(R.id.TvChap);
            IvVavelTower = itemView.findViewById(R.id.IvVavelTower);
            IvVavelTower.setVisibility(View.INVISIBLE);
            Ivagnostes = itemView.findViewById(R.id.Ivagnostes);
            Ivagnostes.setVisibility(View.INVISIBLE);
            TvVideo1 = itemView.findViewById(R.id.TvVideo1);
            TvVideo2 = itemView.findViewById(R.id.TvVideo2);
            Tvlesson = itemView.findViewById(R.id.Tvlesson);
            Tvlesson2 = itemView.findViewById(R.id.Tvlesson2);
            TvlessonNew = itemView.findViewById(R.id.TvlessonNew);
            Ivle3ilogio = itemView.findViewById(R.id.Ivle3ilogio);
            tvName = itemView.findViewById(R.id.tvName);
            BtTest = itemView.findViewById(R.id.BtTest);
            BtTest.setOnClickListener((new View.OnClickListener ()
            {
                @Override
                public void onClick (View v)
                {
                    Intent intent = new Intent (context.getApplicationContext(), Act3.class);
                    context.startActivity(intent);
                }
            }));
            
        }
    }
}
