package com.isquare.expensetracker;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;
import com.isquare.expensetracker.databinding.ActivityAddExpenseBinding;
import com.isquare.expensetracker.databinding.ActivityMainBinding;

import java.util.Calendar;
import java.util.List;
import java.util.UUID;

public class AddExpense extends AppCompatActivity {

     ActivityAddExpenseBinding binding;
     private String type;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= ActivityAddExpenseBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        type=getIntent().getStringExtra("type");
        if(type.equals("Income")){
            binding.income.setChecked(true);
        }
        else if(type.equals("Expense")){
            binding.expense.setChecked(true);
        }
        binding.income.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                type="Income";
            }
        });
        binding.expense.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                type="Expense";
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater menuInflater=getMenuInflater();
        menuInflater.inflate(R.menu.add_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id=item.getItemId();
        if(id==R.id.saveExpense){
            createExpense();
            return true;
        }
        return false;
    }

    private void createExpense() {
        String expenseId= UUID.randomUUID().toString();
        String amount=binding.amount.getText().toString();
        String note=binding.note.getText().toString();


        String category=binding.category.getText().toString();
        boolean incomeChecked=binding.income.isChecked();
        boolean expenseChecked=binding.expense.isChecked();

        if(incomeChecked){
            type="Income";
        }else{
            type="Expense";

        }

        if(amount.trim().length()==0){
            binding.amount.setError("Please, provide the data");
            return;
        }
        ExpenseModel expenseModel=new ExpenseModel(expenseId,note,category,Long.parseLong(amount), Calendar.getInstance().getTimeInMillis(),type,FirebaseAuth.getInstance().getUid());
        FirebaseFirestore
                .getInstance()
                .collection("expense")
                .document(expenseId)
                .set(expenseModel);
        finish();


    }




  }