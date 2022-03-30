package com.example.studentregistrationform;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.studentregistrationform.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    private ArrayList<ModelClass> studentsArrayList;
    DatabaseHandler dbHandler;
    StudentsRVAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        getSupportActionBar().hide();


        setContentView(binding.getRoot());

        binding.btnAddStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AddUpdateForm.class);
                startActivity(intent);


            }
        });
        studentsArrayList = new ArrayList<>();
        dbHandler = new DatabaseHandler(MainActivity.this);
        studentsArrayList = dbHandler.readStudents();
        adapter = new StudentsRVAdapter(studentsArrayList, MainActivity.this);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this ));
        binding.recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();

    }






}