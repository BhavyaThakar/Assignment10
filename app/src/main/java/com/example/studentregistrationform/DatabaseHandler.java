package com.example.studentregistrationform;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.ArrayList;

public class DatabaseHandler extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "Student_Database";
    public static final int DATABASE_VERSION = 1;
    public static final String TABLE_NAME = "StudentDetails";
    public static final String ID_COL = "id";
    public static final String S_NAME_COL = "studentName";
    public static final String S_EMAIL_COL = "studentEmail";
    public static final String S_CONTACT_COL = "studentContact";
    public static final String S_DOB_COL = "studentDob";
    public static final String S_QUALIFICATION_COL = "studentQualification";
    public static final String S_SCHOOL_COL = "studentSchool";
    public static final String S_STREAM_COL = "studentStream";
    public static final String S_PERCENTAGE_COL = "studentPercentage";
    public static final String S_GENDER_COL = "studentGender";
    public static final String F_NAME_COL = "fatherName";
    public static final String F_OCCUPATION_COL = "fOccupation";
    public static final String M_NAME_COL = "motherName";
    public static final String M_OCCUPATION_COL = "mOccupation";
    public static final String P_CONTACT_COL = "pContact";
    public static final String ADDRESS_COL = "address";


    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String query = "CREATE TABLE " + TABLE_NAME + " ("
                + ID_COL + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + S_NAME_COL + " TEXT, "
                + S_EMAIL_COL + " TEXT, "
                + S_CONTACT_COL + " TEXT, "
                + S_DOB_COL + " TEXT, "
                + S_QUALIFICATION_COL + " TEXT, "
                + S_SCHOOL_COL + " TEXT, "
                + S_STREAM_COL + " TEXT, "
                + S_PERCENTAGE_COL + " TEXT, "
                + S_GENDER_COL + " TEXT, "
                + F_NAME_COL + " TEXT, "
                + F_OCCUPATION_COL + " TEXT, "
                + M_NAME_COL + " TEXT, "
                + M_OCCUPATION_COL + " TEXT, "
                + P_CONTACT_COL + " TEXT, "
                + ADDRESS_COL + " TEXT) ";

        db.execSQL(query);

    }

    public void addNewStudent(String sName, String sEmail,
                              String sContact,
                              String sDob,
                              String sQualification,
                              String sSchool,
                              String sStream,
                              String sPercentage,
                              String sGender,
                              String fName,
                              String fOccupation,
                              String mName,
                              String mOccupation,
                              String pContact,
                              String address
                              ){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
                values.put(S_NAME_COL, sName);
                values.put(S_EMAIL_COL,sEmail);
                values.put(S_CONTACT_COL,sContact);
                values.put(S_DOB_COL,sDob);
                values.put(S_QUALIFICATION_COL,sQualification);
                values.put(S_SCHOOL_COL,sSchool);
                values.put(S_STREAM_COL,sStream);
                values.put(S_PERCENTAGE_COL,sPercentage);
                values.put(S_GENDER_COL,sGender);
                values.put(F_NAME_COL,fName);
                values.put(F_OCCUPATION_COL,fOccupation);
                values.put(M_NAME_COL,mName);
                values.put(M_OCCUPATION_COL,mOccupation);
                values.put(P_CONTACT_COL,pContact);
                values.put(ADDRESS_COL,address);
                db.insert(TABLE_NAME, null, values);
                db.close();
    }

    public ArrayList<ModelClass> readStudents(){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursorStudents = db.rawQuery("SELECT*FROM " + TABLE_NAME, null);
        ArrayList<ModelClass> studentDataArrayList = new ArrayList<>();
        if (cursorStudents.moveToFirst()){
            do {
                studentDataArrayList.add(new ModelClass(cursorStudents.getString(1),
                        cursorStudents.getString(2),
                        cursorStudents.getString(3),
                        cursorStudents.getString(4),
                        cursorStudents.getString(5),
                        cursorStudents.getString(6),
                        cursorStudents.getString(7),
                        cursorStudents.getString(8),
                        cursorStudents.getString(9),
                        cursorStudents.getString(10),
                        cursorStudents.getString(11),
                        cursorStudents.getString(12),
                        cursorStudents.getString(13),
                        cursorStudents.getString(14),
                        cursorStudents.getString(15)));
            }while (cursorStudents.moveToNext());
        }
        return studentDataArrayList;
    }

    public void deleteStudent(String studentName){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_NAME, "studentName=?", new String[]{studentName});
        db.close();
    }

    public void updateDatabase(String studentNameCons,
                               String sName, String sEmail,
                               String sContact,
                               String sDob,
                               String sQualification,
                               String sSchool,
                               String sStream,
                               String sPercentage,
                               String sGender,
                               String fName,
                               String fOccupation,
                               String mName,
                               String mOccupation,
                               String pContact,
                               String address){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(S_NAME_COL, sName);
        values.put(S_EMAIL_COL,sEmail);
        values.put(S_CONTACT_COL,sContact);
        values.put(S_DOB_COL,sDob);
        values.put(S_QUALIFICATION_COL,sQualification);
        values.put(S_SCHOOL_COL,sSchool);
        values.put(S_STREAM_COL,sStream);
        values.put(S_PERCENTAGE_COL,sPercentage);
        values.put(S_GENDER_COL,sGender);
        values.put(F_NAME_COL,fName);
        values.put(F_OCCUPATION_COL,fOccupation);
        values.put(M_NAME_COL,mName);
        values.put(M_OCCUPATION_COL,mOccupation);
        values.put(P_CONTACT_COL,pContact);
        values.put(ADDRESS_COL,address);
        db.update(TABLE_NAME, values, "studentName=?", new String[]{studentNameCons});
        db.close();

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);

    }

}
