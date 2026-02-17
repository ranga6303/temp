package com.bm.demo.service;

import com.bm.demo.dto.UseSessionResponse;
import com.bm.demo.entity.*;
import com.bm.demo.repository.*;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Random;

@Service
public class SessionService {

    private final SessionRepository sessionRepository;
    private final AttendanceRepository attendanceRepository;
    private final StudentRepository studentRepository;

    public SessionService(SessionRepository sessionRepository,
                          AttendanceRepository attendanceRepository,
                          StudentRepository studentRepository) {
        this.sessionRepository = sessionRepository;
        this.attendanceRepository = attendanceRepository;
        this.studentRepository = studentRepository;
    }
    private static final Random random = new Random();

    // 1️⃣ Create Session
    public String createSession(Teacher teacher, String beaconUuid) {

        String classCode =
                String.valueOf(random.nextInt(900000) + 100000);

        Session session = new Session();
        session.setSessionCode(classCode);
        session.setBeaconUuid(beaconUuid);
        session.setStartTime(LocalDateTime.now());
        session.setExpiryTime(LocalDateTime.now().plusMinutes(10));
        session.setTeacher(teacher);

        sessionRepository.save(session);

        return classCode;
    }

    // 2️⃣ Use Session
    public Session useSession(String classCode) {
        return sessionRepository
                .findBySessionCodeAndExpiryTimeAfter(
                        classCode,
                        LocalDateTime.now())
                .orElseThrow(() ->
                        new RuntimeException("Session expired or invalid"));
    }

    // 3️⃣ Validate & Mark Attendance
    public String markAttendance(String studentId,
                                 String classCode,
                                 String beaconUuid) {

        Student student = studentRepository.findById(studentId)
                .orElseThrow(() ->
                        new RuntimeException("Student not found"));

        Session session = useSession(classCode);

        if (!session.getBeaconUuid().equals(beaconUuid)) {
            return "Invalid beacon - Not in classroom";
        }

        if (attendanceRepository.existsByStudentAndSession(student, session)) {
            return "Already marked";
        }

        Attendance attendance = new Attendance(
                student,
                session,
                LocalDateTime.now(),
                AttendanceStatus.PRESENT
        );

        attendanceRepository.save(attendance);

        return "Attendance marked";
    }


    /**
 * 6 Use Session (Student Side - Phase 1 Design)
 *
 * Flow:
 * - Student enters classCode in app.
 * - Backend validates session exists and is not expired.
 * - Backend returns the beacon UUID for that session.
 *
 * IMPORTANT:
 * - This endpoint DOES NOT mark attendance.
 * - It only provides the beacon UUID.
 * - Frontend compares detected BLE UUID with returned UUID.
 *
 * ⚠ Security Note:
 * - This is temporary static UUID validation.
 * - Frontend validation alone is NOT secure.
 * - Backend MUST still validate beacon UUID again
 *   when marking attendance.
 *
 * Future Upgrade:
 * - Replace static UUID with dynamic cryptographic payload
 *   using private/secret keys.
 */
        public UseSessionResponse useSessionForStudent(String classCode) {

    Session session = sessionRepository
            .findBySessionCodeAndExpiryTimeAfter(
                    classCode,
                    LocalDateTime.now())
            .orElseThrow(() ->
                    new RuntimeException("Session expired or invalid"));

    return new UseSessionResponse(
            session.getBeaconUuid(),
            session.getExpiryTime()
    );
}

}
