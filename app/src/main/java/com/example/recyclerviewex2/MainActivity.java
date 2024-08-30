package com.example.recyclerviewex2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import  java.util.List;
import  java.util.ArrayList;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {
 FloatingActionButton btnOpenDialog;
 MyAdapter adapter;
 RecyclerView recyclerView;
    List<Item> items = new ArrayList<Item>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        recyclerView = findViewById(R.id.recyclerView);
        btnOpenDialog = findViewById(R.id.btnOpenDialog);

        btnOpenDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog dialog = new Dialog(MainActivity.this);
                dialog.setContentView(R.layout.add_update_lay);

                EditText edtName = dialog.findViewById(R.id.edtName);
                EditText edtEmail = dialog.findViewById(R.id.edtEmail);
                Button btnAction = dialog.findViewById(R.id.btnAction);

                btnAction.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String name  = "", email = "";
                        if(!edtName.getText().toString().equals("")){
                             name = edtName.getText().toString();
                        }
                        else {
                            Toast.makeText(MainActivity.this,"Please Enter Name of Contact!" , Toast.LENGTH_SHORT);

                        }

                        if(!edtEmail.getText().toString().equals("")){
                             email = edtEmail.getText().toString();
                        }
                        else {
                            Toast.makeText(MainActivity.this,"Please Enter Contact Number!" , Toast.LENGTH_SHORT);

                        }
                        items.add(new Item(name,email,R.drawable.a));

                        adapter.notifyItemInserted(items.size()-1);
                        recyclerView.scrollToPosition(items.size()-1);

                       dialog.dismiss();

                    }
                });

                   dialog.show();

            }
        });
        items.add(new Item("Hemant","hemantvaishnav18@gmail.com",R.drawable.a));
        items.add(new Item("Ankit","hemantvaishnav18@gmail.com",R.drawable.b));
        items.add(new Item("Sandeep","hemantvaishnav18@gmail.com",R.drawable.c));
        items.add(new Item("Shivam","hemantvaishnav18@gmail.com",R.drawable.d));
        items.add(new Item("Sivam","hemantvaishnav18@gmail.com",R.drawable.e));
        items.add(new Item("Ram","hemantvaishnav18@gmail.com",R.drawable.f));
        items.add(new Item("Hari","hemantvaishnav18@gmail.com",R.drawable.g));
        items.add(new Item("Daksh","hemantvaishnav18@gmail.com",R.drawable.h));
        items.add(new Item("Hariom","hemantvaishnav18@gmail.com",R.drawable.a));
        items.add(new Item("Arun","hemantvaishnav18@gmail.com",R.drawable.b));
        items.add(new Item("Darsh","hemantvaishnav18@gmail.com",R.drawable.c));
        items.add(new Item("Shepu","hemantvaishnav18@gmail.com",R.drawable.d));
        items.add(new Item("yogi","hemantvaishnav18@gmail.com",R.drawable.e));
        items.add(new Item("Hemant","hemantvaishnav18@gmail.com",R.drawable.f));
        items.add(new Item("Hemant","hemantvaishnav18@gmail.com",R.drawable.g));
        items.add(new Item("Hemant","hemantvaishnav18@gmail.com",R.drawable.h));
        items.add(new Item("Hemant","hemantvaishnav18@gmail.com",R.drawable.a));
        items.add(new Item("Hemant","hemantvaishnav18@gmail.com",R.drawable.b));
        items.add(new Item("Hemant","hemantvaishnav18@gmail.com",R.drawable.c));
        items.add(new Item("Hemant","hemantvaishnav18@gmail.com",R.drawable.d));
        items.add(new Item("Hemant","hemantvaishnav18@gmail.com",R.drawable.e));
        items.add(new Item("Hemant","hemantvaishnav18@gmail.com",R.drawable.f));
        items.add(new Item("Hemant","hemantvaishnav18@gmail.com",R.drawable.g));
        items.add(new Item("Hemant","hemantvaishnav18@gmail.com",R.drawable.h));





        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapter = new MyAdapter(this , items);
        recyclerView.setAdapter(adapter);

//        recyclerView.setAdapter(new MyAdapter(getApplicationContext(),items));

    }
}