package com.example.tgapp;

public class StudentModal {
    private int SID;
    private String fullname,year,semester;

    public StudentModal() {
    }

    public int getSID() {
        return SID;
    }

    public void setSID(int SID) {
        this.SID = SID;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public StudentModal(int SID, String fullname, String year, String semester) {
        this.SID = SID;
        this.fullname = fullname;
        this.year = year;
        this.semester = semester;
    }
}
