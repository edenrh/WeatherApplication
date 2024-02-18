package com.example.weatherapplication.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.weatherapplication.Common.Common;
import com.example.weatherapplication.Model.ForecastResult;
import com.example.weatherapplication.R;
import com.squareup.picasso.Picasso;

public class ForecastAdapter extends RecyclerView.Adapter<ForecastAdapter.MyViewHolder> {

    Context context;
    ForecastResult forecastResult;

    public ForecastAdapter(Context context, ForecastResult forecastResult){
        this.context = context;
        this.forecastResult = forecastResult;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.item_forecast,parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        //Load image
        Picasso.get().load(new StringBuilder("https://openweathermap.org/img/w/04d.png")
                .append(forecastResult.list.get(position).weather.get(0).getIcon())
                .append(".png").toString()).into(holder.img_weather);

        holder.txt_date.setText(new StringBuilder(Common.convertUnixToDate(forecastResult.list.get(position).dt)));

        holder.txt_desc.setText(new StringBuilder(forecastResult.list.get(position).weather.get(0).getDescription()));

        holder.txt_temp.setText(new StringBuilder(String.valueOf(
                forecastResult.list.get(position).main.getTemp())).append("°C"));
    }

    @Override
    public int getItemCount() {
        return forecastResult.list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView txt_date, txt_desc, txt_temp;
        ImageView img_weather;
        public MyViewHolder(View itemView) {
            super(itemView);

            img_weather = (ImageView)itemView.findViewById(R.id.img_weather);
            txt_date = (TextView)itemView.findViewById(R.id.txt_date);
            txt_desc  = (TextView)itemView.findViewById(R.id.txt_desc);
            txt_temp  = (TextView)itemView.findViewById(R.id.txt_temp);
        }
    }
}
