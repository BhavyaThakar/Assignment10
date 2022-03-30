package com.example.studentregistrationform;

import static com.example.studentregistrationform.AddUpdateForm.*;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.sql.Struct;
import java.util.ArrayList;

public class StudentsRVAdapter extends RecyclerView.Adapter<StudentsRVAdapter.MyOwnHolder> {
    ArrayList<ModelClass> data;
    Context context;

    public StudentsRVAdapter(ArrayList<ModelClass> data, Context context) {
        this.data = data;
        this.context = context;
    }

    @NonNull
    @Override
    public MyOwnHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater mInflater = LayoutInflater.from(context);
        View myOwnView = mInflater.inflate(R.layout.student_raw_layout, parent, false);
        return new MyOwnHolder(myOwnView);
    }



    @Override
    public int getItemCount() {
        return data.size();
    }


    public class MyOwnHolder extends RecyclerView.ViewHolder {
        TextView s_name, s_email, s_contact, s_school, s_qualification;
        Button btn_delete, btn_update;
        public MyOwnHolder(@NonNull View itemView) {
            super(itemView);
            s_name = itemView.findViewById(R.id.tv_sName);
            s_contact = itemView.findViewById(R.id.tv_phone);
            s_email = itemView.findViewById(R.id.tv_email);
            s_school = itemView.findViewById(R.id.tv_school);
            s_qualification = itemView.findViewById(R.id.tv_qualification);
            btn_delete = itemView.findViewById(R.id.btn_delete);
            btn_update = itemView.findViewById(R.id.btn_update);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull MyOwnHolder holder, int position) {
        ModelClass modelClass = data.get(position);
        holder.s_name.setText(data.get(position).sName);
        holder.s_email.setText(data.get(position).sEmail);
        holder.s_contact.setText(data.get(position).sContact);
        holder.s_school.setText(data.get(position).sSchool);
        holder.s_qualification.setText(data.get(position).sQualification);
        holder.btn_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle("Delete");
                builder.setMessage("Are you sure you want to delete ?");
                builder.setIcon(R.drawable.ic_baseline_delete_24);
                builder.setCancelable(false);
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        DatabaseHandler dbHandler = new DatabaseHandler(context);
                        dbHandler.deleteStudent(modelClass.getsName());
                        data.remove(modelClass);
                        notifyDataSetChanged();
                    }
                });
                builder.setNegativeButton("No", null);
                builder.show();
            }
        });
        holder.btn_update.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                updateData = true;
                Intent intent = new Intent(context, AddUpdateForm.class);
                intent.putExtra("sName", modelClass.getsName());
                intent.putExtra("sEmail", modelClass.getsEmail());
                intent.putExtra("sContact", modelClass.getsContact());
                intent.putExtra("sDob", modelClass.getsDob());
                intent.putExtra("sQualification", modelClass.getsQualification());
                intent.putExtra("sSchool", modelClass.getsSchool());
                intent.putExtra("sStream", modelClass.getsStream());
                intent.putExtra("sPercentage", modelClass.getsPercentage());
                intent.putExtra("sGender", modelClass.getsGender());
                intent.putExtra("fatherName", modelClass.getfName());
                intent.putExtra("fOccupation", modelClass.getfOccupation());
                intent.putExtra("motherName", modelClass.getmName());
                intent.putExtra("mOccupation", modelClass.getmOccupation());
                intent.putExtra("pContact", modelClass.getsName());
                intent.putExtra("address", modelClass.getAddress());
                context.startActivity(intent);


            }
        });

    }
}
