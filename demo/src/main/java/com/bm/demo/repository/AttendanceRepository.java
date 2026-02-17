package com.bm.demo.repository;

import com.bm.demo.entity.Attendance;
import com.bm.demo.entity.Student;
import com.bm.demo.entity.Session;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttendanceRepository extends JpaRepository<Attendance, Long> {

    boolean existsByStudentAndSession(Student student, Session session);

    long countByStudentStudentIdAndStatus(String studentId, com.bm.demo.entity.AttendanceStatus status);
}
