package com.bm.demo.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "teacher")
public class Teacher {

    @Id
    @Column(name = "tacher_id", length = 10, nullable = false)
    private String teacherId;

    @Column(name = "teacher_name", length = 45, nullable = false)
    private String teacherName;

    // One teacher can create many sessions
    @OneToMany(mappedBy = "teacher", cascade = CascadeType.ALL)
    private List<Session> sessions;

    public Teacher() {}

    public Teacher(String teacherId, String teacherName) {
        this.teacherId = teacherId;
        this.teacherName = teacherName;
    }

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public List<Session> getSessions() {
        return sessions;
    }

    public void setSessions(List<Session> sessions) {
        this.sessions = sessions;
    }
}
