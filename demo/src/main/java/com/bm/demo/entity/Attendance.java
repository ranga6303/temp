package com.bm.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(
    name = "attendance",
    uniqueConstraints = {
        @UniqueConstraint(columnNames = {"student_id", "session_id"})
    }
)
public class Attendance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Many attendance records belong to one student
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(
        name = "student_id",
        referencedColumnName = "student_id",
        nullable = false
    )
    private Student student;

    // Many attendance records belong to one session
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(
        name = "session_id",
        referencedColumnName = "id",
        nullable = false
    )
    private Session session;

    @Column(name = "marked_at", nullable = false)
    private LocalDateTime markedAt;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private AttendanceStatus status;

    protected Attendance() {
        // Required by JPA
    }

    public Attendance(Student student,
                      Session session,
                      LocalDateTime markedAt,
                      AttendanceStatus status) {
        this.student = student;
        this.session = session;
        this.markedAt = markedAt;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public Student getStudent() {
        return student;
    }

    public Session getSession() {
        return session;
    }

    public LocalDateTime getMarkedAt() {
        return markedAt;
    }

    public AttendanceStatus getStatus() {
        return status;
    }

    public void setStatus(AttendanceStatus status) {
        this.status = status;
    }
}
