package com.example.studentregistrationform;

public class ModelClass {
    String sName;
    String sEmail;
    String sContact;
    String sDob;
    String sQualification;

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public String getsEmail() {
        return sEmail;
    }

    public void setsEmail(String sEmail) {
        this.sEmail = sEmail;
    }

    public String getsContact() {
        return sContact;
    }

    public void setsContact(String sContact) {
        this.sContact = sContact;
    }

    public String getsDob() {
        return sDob;
    }

    public void setsDob(String sDob) {
        this.sDob = sDob;
    }

    public String getsQualification() {
        return sQualification;
    }

    public void setsQualification(String sQualification) {
        this.sQualification = sQualification;
    }

    public String getsSchool() {
        return sSchool;
    }

    public void setsSchool(String sSchool) {
        this.sSchool = sSchool;
    }

    public String getsStream() {
        return sStream;
    }

    public void setsStream(String sStream) {
        this.sStream = sStream;
    }

    public String getsPercentage() {
        return sPercentage;
    }

    public void setsPercentage(String sPercentage) {
        this.sPercentage = sPercentage;
    }

    public String getsGender() {
        return sGender;
    }

    public void setsGender(String sGender) {
        this.sGender = sGender;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getfOccupation() {
        return fOccupation;
    }

    public void setfOccupation(String fOccupation) {
        this.fOccupation = fOccupation;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getmOccupation() {
        return mOccupation;
    }

    public void setmOccupation(String mOccupation) {
        this.mOccupation = mOccupation;
    }

    public String getpContact() {
        return pContact;
    }

    public void setpContact(String pContact) {
        this.pContact = pContact;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public ModelClass(String sName, String sEmail, String sContact, String sDob, String sQualification, String sSchool, String sStream, String sPercentage, String sGender, String fName, String fOccupation, String mName, String mOccupation, String pContact, String address) {
        this.sName = sName;
        this.sEmail = sEmail;
        this.sContact = sContact;
        this.sDob = sDob;
        this.sQualification = sQualification;
        this.sSchool = sSchool;
        this.sStream = sStream;
        this.sPercentage = sPercentage;
        this.sGender = sGender;
        this.fName = fName;
        this.fOccupation = fOccupation;
        this.mName = mName;
        this.mOccupation = mOccupation;
        this.pContact = pContact;
        this.address = address;
    }

    String sSchool;
    String sStream;
    String sPercentage;
    String sGender;
    String fName;
    String fOccupation;
    String mName;
    String mOccupation;
    String pContact;
    String address;


}
