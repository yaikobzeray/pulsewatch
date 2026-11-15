package tech.yaikob.pulsewatch.monitor.dto;


public record MonitorRequest(
     String name,
     String url,
    int checkIntervalSeconds
) {}
