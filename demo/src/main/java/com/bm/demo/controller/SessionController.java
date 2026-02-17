package com.bm.demo.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.bm.demo.dto.CreateSessionRequest;
import com.bm.demo.dto.UseSessionRequest;
import com.bm.demo.dto.UseSessionResponse;
import com.bm.demo.entity.Teacher;
import com.bm.demo.repository.TeacherRepository;
import com.bm.demo.service.SessionService;

public class SessionController {

    private final TeacherRepository teacherRepository;
    private final SessionService sessionService;

    public SessionController(TeacherRepository teacherRepository, SessionService sessionService) {
        this.teacherRepository = teacherRepository;
        this.sessionService = sessionService;
    }

     // 1️⃣ Create Session
    @PostMapping("/sessions")
    public String createSession(@RequestBody CreateSessionRequest request) {

        Teacher teacher = teacherRepository.findById(request.getTeacherId())
                .orElseThrow(() -> new RuntimeException("Teacher not found"));

        return sessionService.createSession(
                teacher,
                request.getBeaconUuid());
    }

     // 4 Use Session
    @PostMapping("/use-session")
public UseSessionResponse useSession(
        @RequestBody UseSessionRequest request) {

    return sessionService
            .useSessionForStudent(request.getClassCode());
}


}
