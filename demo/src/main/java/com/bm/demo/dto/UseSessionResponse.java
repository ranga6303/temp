package com.bm.demo.dto;

import java.time.LocalDateTime;

public class UseSessionResponse {

    private String beaconUuid;
    private LocalDateTime expiresAt;

    public UseSessionResponse(String beaconUuid,
                              LocalDateTime expiresAt) {
        this.beaconUuid = beaconUuid;
        this.expiresAt = expiresAt;
    }

    public String getBeaconUuid() { return beaconUuid; }
    public LocalDateTime getExpiresAt() { return expiresAt; }
}
