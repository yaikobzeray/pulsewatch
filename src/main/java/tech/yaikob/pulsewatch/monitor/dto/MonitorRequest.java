package tech.yaikob.pulsewatch.monitor.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record MonitorRequest(
        @NotBlank
        @Size(max = 255)
        String name,
        @NotBlank
        @Size(max = 255)
       @Pattern(
        regexp = "^https?://.+$",
        message = "URL must start with http:// or https://"
                )
        String url,
        @NotNull
        @Min(10)
        @Max(86400)
        Integer checkIntervalSeconds
) {}