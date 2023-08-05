package com.example.practice3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AdapterCars {

    /*Context context;

    List<ModelCars> CarssList;



    public AdapterCars( Context context , List<ModelCars> CarssList){
        this.context=context;
        this.CarssList=CarssList;

    }



    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.item_Cars, parent, false);
        ViewHolder viewHolder =new ViewHolder(view);
        return viewHolder;

    }





    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        ModelCars tempModel=CarssList.get(position);


        *//*holder.tvCarsName.setText( CarssList.get(position).getCarsName());
        holder.tvLastMsg.setText( CarssList.get(position).getLastMsg());*//*



        holder.tvCarsName.setText( tempModel.getCarsName());
        holder.tvLastMsg.setText( tempModel.getLastMsg());



    }



    @Override
    public int getItemCount() {
        return CarssList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder  {


        public TextView tvCarsName,tvLastMsg;

        ViewHolder(View itemView) {

            super(itemView);
            tvCarsName = itemView.findViewById(R.id.tvCarsName);
            tvLastMsg = itemView.findViewById(R.id.tvLastmsg);

        }


    }*/






}
