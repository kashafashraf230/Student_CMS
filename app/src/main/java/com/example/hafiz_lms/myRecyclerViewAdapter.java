package com.example.hafiz_lms;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

class myRecyclerViewAdapter extends RecyclerView.Adapter<myRecyclerViewAdapter.MyVH> {
    private OnItemClickListener listener;

    Activity act;

    List<Students> studentList;
    public myRecyclerViewAdapter(List<Students> studentList, OnItemClickListener listener) {
        this.studentList = studentList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public MyVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.single_student, parent, false);
        return new MyVH(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyVH holder, int position) {
        holder.data=studentList.get(position);
        holder.Name.setText(holder.data.getName());
        holder.Age.setText(String.valueOf(holder.data.getAge()));
        holder.Roll.setText(String.valueOf(holder.data.getRoll()));
        holder.Class.setText(String.valueOf(holder.data.getClas()));





    }

    @Override
    public int getItemCount() {
        return studentList.size();
    }


    public class MyVH extends RecyclerView.ViewHolder {
        TextView Name;
        TextView Roll;
        TextView Age;
        TextView Class;

        Button btn;
        Students data;
        public MyVH(@NonNull View itemView) {
            super(itemView);
            Name = itemView.findViewById(R.id.Name);
            Roll = itemView.findViewById(R.id.Roll);
            Age = itemView.findViewById(R.id.Age);
            Class= itemView.findViewById(R.id.Class);
            btn = itemView.findViewById(R.id.editbutton);


            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();
                    String rollno = Roll.getText().toString();
                    int roll = Integer.parseInt(rollno);
                    if (position != RecyclerView.NO_POSITION && listener != null) {
                        listener.onButtonClick(position, roll);
                    }

                }
            });
        }
    }

    public interface OnItemClickListener {
        void onButtonClick(int position, int roll);
    }

}


