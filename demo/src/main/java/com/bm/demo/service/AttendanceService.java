package com.bm.demo.service;

import com.bm.demo.dto.StudentAttendanceResponse;
import com.bm.demo.entity.*;
import com.bm.demo.repository.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AttendanceService {

    private final AttendanceRepository attendanceRepository;
    private final StudentRepository studentRepository;
    private final SessionRepository sessionRepository;

    public AttendanceService(AttendanceRepository attendanceRepository,
                             StudentRepository studentRepository,
                             SessionRepository sessionRepository) {
        this.attendanceRepository = attendanceRepository;
        this.studentRepository = studentRepository;
        this.sessionRepository = sessionRepository;
    }

    // Get percentage of single student
    public double getAttendancePercentage(String studentId) {

        long attended = attendanceRepository
                .countByStudentStudentIdAndStatus(
                        studentId, AttendanceStatus.PRESENT);

        long totalSessions = sessionRepository.count();

        if (totalSessions == 0) return 0;

        return (attended * 100.0) / totalSessions;
    }

    // Get all students attendance list
    public List<StudentAttendanceResponse> getAttendanceList() {

        List<Student> students = studentRepository.findAll();
        long totalSessions = sessionRepository.count();

        List<StudentAttendanceResponse> result = new ArrayList<>();

        for (Student student : students) {

            long attended =
                    attendanceRepository
                            .countByStudentStudentIdAndStatus(
                                    student.getStudentId(),
                                    AttendanceStatus.PRESENT);

            double percentage = 0;

            if (totalSessions > 0) {
                percentage = (attended * 100.0) / totalSessions;
            }

            result.add(new StudentAttendanceResponse(
                    student.getStudentId(),
                    student.getStudentName(),
                    percentage
            ));
        }

        return result;
    }

    
}
