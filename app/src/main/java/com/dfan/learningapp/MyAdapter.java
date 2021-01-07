package com.dfan.learningapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
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

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        //holder.tvName.setText(String.format("Page  %d ", position + 1));
        boolean start = false;
        if (position == 0)
        {
            holder.tvName.setText(R.string.screen1);
        }
        else if (position == 1)
        {
            holder.tvName.setText(R.string.screen2);
        }
        else if (position == 2)
        {
            holder.tvName.setText(R.string.Fin1Chapter);
            start = true;
        }
        else if (position == 3)
        {
            if (start = true)
            {
                holder.BtTest.setVisibility(View.VISIBLE);
            }

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
        return 4;
    }

    @Override
    public void onClick(View v) {

    }


    public class MyViewHolder extends RecyclerView.ViewHolder
    {
        TextView tvName;
        //ImageView imgBanner;
        Button BtTest;


        public MyViewHolder(@NonNull View itemView)
        {
            super(itemView);
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
            //imgBanner = itemView.findViewById(R.id.imgBanner);
        }
    }
}
