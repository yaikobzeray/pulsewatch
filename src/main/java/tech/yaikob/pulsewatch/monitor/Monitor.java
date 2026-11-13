package tech.yaikob.pulsewatch.monitor;

import java.time.Instant;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

@Entity
@Table(name = "monitor")
public class Monitor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String url;

    @Column (name = "check_interval_seconds", nullable = false)
    private int checkIntervalSeconds;

    @Column(nullable = false)
    private boolean active = true;

    @Column (name = "created_at", nullable = false)
    private Instant createdAt;

    protected Monitor(){
        // REQUIRED BY JPA
    }

    public Monitor(String name, String url, int checkIntervalSeconds) {
        this.name = name;
        this.url = url;
        this.checkIntervalSeconds = checkIntervalSeconds;
    }
    
    @PrePersist
    protected void onCreate() {
       if(createdAt == null) {
          createdAt = Instant.now();
       }
    }

    // getters
    public Long getId() {
        return id;
    }
      public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }

    public int getCheckIntervalSeconds() {
        return checkIntervalSeconds;
    }

    public boolean isActive() {
        return active;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }
    
}
