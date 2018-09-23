package com.example.nemo1.sqllite.model;

import java.io.Serializable;

public class eStudent implements Serializable {
    private int sv_Ma;
    private String sv_Ten;
    private String sv_Lop;
    private String sv_Mon;

    public eStudent(int sv_Ma, String sv_Ten, String sv_Lop, String sv_Mon) {
        this.sv_Ma = sv_Ma;
        this.sv_Ten = sv_Ten;
        this.sv_Lop = sv_Lop;
        this.sv_Mon = sv_Mon;
    }

    public eStudent(String sv_Ten, String sv_Lop) {
        this.sv_Ten = sv_Ten;
        this.sv_Lop = sv_Lop;
    }

    public eStudent(String sv_Ten, String sv_Lop, String sv_Mon) {
        this.sv_Ten = sv_Ten;
        this.sv_Lop = sv_Lop;
        this.sv_Mon = sv_Mon;
    }

    public int getSv_Ma() {
        return sv_Ma;
    }

    public void setSv_Ma(int sv_Ma) {
        this.sv_Ma = sv_Ma;
    }

    public String getSv_Ten() {
        return sv_Ten;
    }

    public void setSv_Ten(String sv_Ten) {
        this.sv_Ten = sv_Ten;
    }

    public String getSv_Lop() {
        return sv_Lop;
    }

    public void setSv_Lop(String sv_Lop) {
        this.sv_Lop = sv_Lop;
    }

    public String getSv_Mon() {
        return sv_Mon;
    }

    public void setSv_Mon(String sv_Mon) {
        this.sv_Mon = sv_Mon;
    }
}