package com.example.practice3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.List;


public class AdapterUser extends RecyclerView.Adapter<AdapterUser.ViewHolder> {

    Context context;

    List<ModelUser> usersList;


    public AdapterUser(Context context, List<ModelUser> usersList) {
        this.context = context;
        this.usersList = usersList;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.item_user, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;

    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        ModelUser tempModel = usersList.get(position);
        /*holder.tvUserName.setText( usersList.get(position).getUserName());
        holder.tvLastMsg.setText( usersList.get(position).getLastMsg());*/

        holder.tvUserName.setText(tempModel.getUserName());
        holder.tvLastMsg.setText(tempModel.getLastMsg());
    }
    @Override
    public int getItemCount() {
        return usersList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {


        public TextView tvUserName, tvLastMsg;

        ViewHolder(View itemView) {

            super(itemView);
            tvUserName = itemView.findViewById(R.id.tvUserName);
            tvLastMsg = itemView.findViewById(R.id.tvLastmsg);

        }


    }


}
