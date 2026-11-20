package tech.yaikob.pulsewatch.monitor.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.URL;

import java.time.Instant;

public record MonitorResponse( Long id,

     String name,
     String url,
     boolean active,
     Integer checkIntervalSeconds,
     Instant createdAt) {}
