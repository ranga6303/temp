package com.bm.demo.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


import com.bm.demo.dto.MarkAttendanceRequest;
import com.bm.demo.service.SessionService;

public class ValidationController {
    private final SessionService sessionService;

    public ValidationController(SessionService sessionService) {
        this.sessionService = sessionService;
    }
    // 2 Mark Attendance
    @PostMapping("/mark")
    public String markAttendance(@RequestBody MarkAttendanceRequest request) {

        return sessionService.markAttendance(
                request.getStudentId(),
                request.getClassCode(),
                request.getBeaconUuid());
    }
}
