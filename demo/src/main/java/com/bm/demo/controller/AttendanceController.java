package com.bm.demo.controller;

import com.bm.demo.dto.StudentAttendanceResponse;
import com.bm.demo.service.AttendanceService;

import java.util.List;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class AttendanceController {

    private final AttendanceService attendanceService;

    public AttendanceController(AttendanceService attendanceService) {
        this.attendanceService = attendanceService;
    }

    // 1 Get Attendance % of aspecific student
    @GetMapping("/attendance/{studentId}")
    public double getAttendancePercentage(@PathVariable String studentId) {
        return attendanceService.getAttendancePercentage(studentId);
    }

    // 2 Get Attendance List of all students
    @GetMapping("/attendance-list")
    public List<StudentAttendanceResponse> getAttendanceList() {
        return attendanceService.getAttendanceList();
    }

}
