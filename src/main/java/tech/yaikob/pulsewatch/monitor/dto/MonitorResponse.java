package tech.yaikob.pulsewatch.monitor.dto;

public record MonitorResponse( Long id,
     String name,
     String url,
     boolean active,
     int checkIntervalSeconds,
     String createdAt) {}
