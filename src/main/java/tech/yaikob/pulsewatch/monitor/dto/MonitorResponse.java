package tech.yaikob.pulsewatch.monitor.dto;

import java.time.Instant;

public record MonitorResponse( Long id,
     String name,
     String url,
     boolean active,
     int checkIntervalSeconds,
     Instant createdAt) {}
