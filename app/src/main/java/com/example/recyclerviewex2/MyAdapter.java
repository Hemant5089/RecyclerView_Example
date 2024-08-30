package com.example.recyclerviewex2;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {

    Context context;
    List<Item> items;

    public MyAdapter(Context context, List<Item> items) {
        this.context = context;
        this.items = items;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.item_view,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.nameView.setText(items.get(position).getName());
        holder.emailView.setText(items.get(position).getEmail());
        holder.imageView.setImageResource(items.get(position).getImage());
        holder.llrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog dialog = new Dialog(context);
                dialog.setContentView(R.layout.add_update_lay);


                EditText edtName = dialog.findViewById(R.id.edtName);
                EditText edtEmail = dialog.findViewById(R.id.edtEmail);
                Button btnAction = dialog.findViewById(R.id.btnAction);
                TextView textTitle = dialog.findViewById(R.id.txtTitle);

                textTitle.setText("Update Contact");

                btnAction.setText("Update");

                edtName.setText((items.get(position)).name);
                edtEmail.setText((items.get(position)).email);

                btnAction.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String name  = "", email = "";
                        if(!edtName.getText().toString().equals("")){
                            name = edtName.getText().toString();
                        }
                        else {
                            Toast.makeText(context,"Please Enter Name of Contact!" , Toast.LENGTH_SHORT);

                        }

                        if(!edtEmail.getText().toString().equals("")){
                            email = edtEmail.getText().toString();
                        }
                        else {
                            Toast.makeText(context,"Please Enter Contact Number!" , Toast.LENGTH_SHORT);

                        }
                        items.set(position,new Item(name,email,items.get(position).image));
                        notifyItemChanged(position);

                        dialog.dismiss();

                    }
                });
                     dialog.show();
            }
        });


    holder.llrow.setOnLongClickListener(new View.OnLongClickListener() {
        @Override
        public boolean onLongClick(View v) {
            AlertDialog.Builder builder = new AlertDialog.Builder(context)
                    .setTitle("Delete Contact")
                    .setMessage("Are you sure want to delete")
                    .setIcon(R.drawable.baseline_delete_24)
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                          items.remove(position);
                          notifyItemRemoved(position);
                        }
                    })
                    .setNegativeButton("No", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });


            builder.show();

            return true;
        }
    });

    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}
