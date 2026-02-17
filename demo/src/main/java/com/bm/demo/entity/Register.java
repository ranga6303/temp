package com.bm.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "register")
public class Register {

    @Id
    @Column(name = "sid", nullable = false)
    private int sid;

    @Column(name = "sname", length = 45, nullable = false)
    private String sname;

    @Column(name = "no_of_atended_classes", nullable = false)
    private int noOfAttendedClasses;

    public Register() {}

    public Register(int sid, String sname, int noOfAttendedClasses) {
        this.sid = sid;
        this.sname = sname;
        this.noOfAttendedClasses = noOfAttendedClasses;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public int getNoOfAttendedClasses() {
        return noOfAttendedClasses;
    }

    public void setNoOfAttendedClasses(int noOfAttendedClasses) {
        this.noOfAttendedClasses = noOfAttendedClasses;
    }
}
