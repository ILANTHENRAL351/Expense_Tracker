package com.isquare.expensetracker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ExpenseAdapter extends RecyclerView.Adapter<ExpenseAdapter.MyViewHolder> {


    private Context context;
    private List<ExpenseModel> expenseModelList;

    public ExpenseAdapter(Context context) {
        this.context = context;
        expenseModelList=new ArrayList<>();
    }
    public void add(ExpenseModel expenseModel){
        expenseModelList.add(expenseModel);
        notifyDataSetChanged();
    }
    public void clear(){
        expenseModelList.clear();
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.expenseaddrow,parent,false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        ExpenseModel expenseModel=expenseModelList.get(position);
        holder.note.setText(expenseModel.getNote());
        holder.category.setText(expenseModel.getCategory());
        holder.amount.setText(String.valueOf(expenseModel.getAmount()));

    }

    @Override
    public int getItemCount() {
        return expenseModelList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        private TextView note,category,amount,date;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            note=itemView.findViewById(R.id.note);
            category=itemView.findViewById(R.id.category);
            date=itemView.findViewById(R.id.date);
            amount=itemView.findViewById(R.id.amount);

        }
    }



}
