package com.bm.demo.repository;

import com.bm.demo.entity.Session;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface SessionRepository extends JpaRepository<Session, Long> {

    Optional<Session> findBySessionCode(String sessionCode);

    Optional<Session> findBySessionCodeAndExpiryTimeAfter(String sessionCode, java.time.LocalDateTime time);
}
