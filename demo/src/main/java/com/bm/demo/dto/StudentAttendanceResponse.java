package com.bm.demo.dto;

public class StudentAttendanceResponse {

    private String studentId;
    private String studentName;
    private double percentage;

    public StudentAttendanceResponse(String studentId,
                                     String studentName,
                                     double percentage) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.percentage = percentage;
    }

    public String getStudentId() { return studentId; }
    public String getStudentName() { return studentName; }
    public double getPercentage() { return percentage; }
}
