package com.bm.demo.dto;

public class MarkAttendanceRequest {

    private String studentId;
    private String classCode;
    private String beaconUuid;

    public String getStudentId() { return studentId; }
    public void setStudentId(String studentId) { this.studentId = studentId; }

    public String getClassCode() { return classCode; }
    public void setClassCode(String classCode) { this.classCode = classCode; }

    public String getBeaconUuid() { return beaconUuid; }
    public void setBeaconUuid(String beaconUuid) { this.beaconUuid = beaconUuid; }
}
