package com.bm.demo.dto;

public class CreateSessionRequest {

    private String teacherId;
    private String beaconUuid;

    public String getTeacherId() { return teacherId; }
    public void setTeacherId(String teacherId) { this.teacherId = teacherId; }

    public String getBeaconUuid() { return beaconUuid; }
    public void setBeaconUuid(String beaconUuid) { this.beaconUuid = beaconUuid; }
}
