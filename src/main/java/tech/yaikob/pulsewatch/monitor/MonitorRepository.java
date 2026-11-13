package tech.yaikob.pulsewatch.monitor;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MonitorRepository extends JpaRepository<Monitor, Long> {
    List<Monitor> findByActiveTrue();
    
}
