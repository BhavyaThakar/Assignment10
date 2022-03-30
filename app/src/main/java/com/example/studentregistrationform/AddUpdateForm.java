package com.example.studentregistrationform;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.studentregistrationform.databinding.ActivityAddUpdateFormBinding;
import com.example.studentregistrationform.databinding.ActivityMainBinding;

import java.util.Calendar;

public class AddUpdateForm extends AppCompatActivity {
    ActivityAddUpdateFormBinding binding;
    DatabaseHandler dbHandler;
    RadioGroup radioGroup;
    RadioButton radioButton;
    public static boolean updateData = false;

    String date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAddUpdateFormBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getSupportActionBar().hide();
        binding.ivShowDatePicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePicker();

            }
        });
        if (updateData == false){
            updateData = false;
            binding.btUpdateDb.setClickable(false);
            binding.btnAddStudent.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    add();
                }
            });

        }
        else{
            setStudentDetails();
            binding.btnAddStudent.setClickable(false);
            updateData = false;

        }
            }



    public void showDatePicker(){
        Calendar calendar = Calendar.getInstance();
        final int year = calendar.get(Calendar.YEAR);
        final int month = calendar.get(Calendar.MONTH);
        final int day = calendar.get(Calendar.DAY_OF_MONTH);
        DatePickerDialog.OnDateSetListener setListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                month = month+1;
                date = day+ " / "+month+" / "+year;
                binding.tvDob.setText(date);
            }
        };
        DatePickerDialog datePickerDialog = new DatePickerDialog(
                AddUpdateForm.this, android.R.style.Theme_Holo_Light_Dialog_MinWidth,setListener,year,month,day);
        datePickerDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        datePickerDialog.show();

}
    public  void checkedRadioButton(View v){
        radioGroup = binding.radioGroup;
        int radioId = radioGroup.getCheckedRadioButtonId();
        radioButton = findViewById(radioId);
        Toast.makeText(this, "Selected Type : "+ radioButton.getText(), Toast.LENGTH_SHORT).show();

    }


    public void add(){
        dbHandler = new DatabaseHandler(AddUpdateForm.this);
        String sName = binding.etName.getText().toString();
        String sEmail = binding.etEmail.getText().toString();
        String sContact = binding.etPhone.getText().toString();
        String sDob = binding.tvDob.getText().toString();
        String sQualification = binding.etQualification.getText().toString();
        String sSchool = binding.etSchool.getText().toString();
        String sStream = binding.etStream.getText().toString();
        String sPercentage = binding.etPercentage.getText().toString();
        String sGender = String.valueOf(radioGroup.getCheckedRadioButtonId());
        String fatherName = binding.etFatherName.getText().toString();
        String fOccupation = binding.etFOccupation.getText().toString();
        String motherName = binding.etMotherName.getText().toString();
        String mOccupation = binding.etMOccupation.getText().toString();
        String pContact = binding.etPPhone.getText().toString();
        String address = binding.etAddress.getText().toString();

        dbHandler.addNewStudent(sName, sEmail, sContact, sDob, sQualification, sSchool,sStream, sPercentage, sGender, fatherName, fOccupation, motherName, mOccupation, pContact, address);

        binding.etName.getText().clear();
        binding.etEmail.getText().clear();
        binding.etPhone.getText().clear();
        binding.tvDob.setText("Date of Birth");
        binding.etQualification.getText().clear();
        binding.etSchool.getText().clear();
        binding.etStream.getText().clear();
        binding.etPercentage.getText().clear();
        radioGroup.clearCheck();
        binding.etFatherName.getText().clear();
        binding.etFOccupation.getText().clear();
        binding.etMotherName.getText().clear();
        binding.etMOccupation.getText().clear();
        binding.etPPhone.getText().clear();
        binding.etAddress.getText().clear();

        Intent intent = new Intent(AddUpdateForm.this, MainActivity.class);
        startActivity(intent);
    }

    public void updateDatabase(View view) {

        dbHandler = new DatabaseHandler(AddUpdateForm.this);
        String student = getIntent().getStringExtra("sName");

        dbHandler.updateDatabase(student,
                binding.etName.getText().toString(),
                binding.etEmail.getText().toString(),
                binding.etPhone.getText().toString(),
                binding.tvDob.getText().toString(),
                binding.etQualification.getText().toString(),
                binding.etSchool.getText().toString(),
                binding.etStream.getText().toString(),
                binding.etPercentage.getText().toString(),
                String.valueOf(binding.radioGroup.getCheckedRadioButtonId()),
                binding.etFatherName.getText().toString(),
                binding.etFOccupation.getText().toString(),
                binding.etMotherName.getText().toString(),
                binding.etMOccupation.getText().toString(),
                binding.etPPhone.getText().toString(),
                binding.etAddress.getText().toString());

        Intent intent = new Intent(AddUpdateForm.this, MainActivity.class);
        startActivity(intent);

    }
    public void setStudentDetails(){

        String sName = getIntent().getStringExtra("sName");
        String sEmail = getIntent().getStringExtra("sEmail");
        String sContact = getIntent().getStringExtra("sContact");
        String sDob = getIntent().getStringExtra("sDob");
        String sQualification = getIntent().getStringExtra("sQualification");
        String sSchool = getIntent().getStringExtra("sSchool");
        String sStream = getIntent().getStringExtra("sStream");
        String sPercentage = getIntent().getStringExtra("sPercentage");
        String sGender = getIntent().getStringExtra("sGender");
        String fatherName = getIntent().getStringExtra("fatherName");
        String fOccupation = getIntent().getStringExtra("fOccupation");
        String motherName = getIntent().getStringExtra("motherName");
        String mOccupation = getIntent().getStringExtra("mOccupation");
        String pContact = getIntent().getStringExtra("pContact");
        String address = getIntent().getStringExtra("address");

        binding.etName.setText(sName);
        binding.etEmail.setText(sEmail);
        binding.etPhone.setText(sContact);
        binding.tvDob.setText(sDob);
        binding.etQualification.setText(sQualification);
        binding.etSchool.setText(sSchool);
        binding.etStream.setText(sStream);
        binding.etPercentage.setText(sPercentage);
        binding.etFatherName.setText(fatherName);
        binding.etMotherName.setText(motherName);
        binding.etFOccupation.setText(fOccupation);
        binding.etMOccupation.setText(mOccupation);
        binding.etPPhone.setText(pContact);
        binding.etAddress.setText(address);
        binding.radioGroup.check(Integer.valueOf(sGender));

    }
}