package tech.yaikob.pulsewatch.monitor;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tech.yaikob.pulsewatch.monitor.dto.MonitorRequest;
import tech.yaikob.pulsewatch.monitor.dto.MonitorResponse;

@RestController 
@RequestMapping ("/api")
public class MonitorController {
    private final MonitorService monitorService;
    public MonitorController(MonitorService monitorService) {
        this.monitorService = monitorService;
    }
    @GetMapping ("/monitors")
    public ResponseEntity<List<MonitorResponse>> getAllMonitors(){
        List<MonitorResponse> response = monitorService.getAllMonitors();
        return ResponseEntity.ok(response);
    }

    @GetMapping ("/monitors/{id}")
    public ResponseEntity<MonitorResponse> getMonitorById(@PathVariable Long id){
            return monitorService.getMonitorById(id).map(ResponseEntity::ok)
            .orElseGet(() -> ResponseEntity.notFound().build());
        
    }

    @PostMapping("/monitors")
    public ResponseEntity<MonitorResponse> createMonitor(
            @RequestBody MonitorRequest monitor) {

        MonitorResponse response = monitorService.createMonitor(monitor);

        URI location = URI.create("/api/monitors/" + response.id());

        return ResponseEntity.created(location).body(response);
    }

    @DeleteMapping ("/monitors/{id}")
    public ResponseEntity<Void> deleteMonitor(@PathVariable Long id) {
        boolean isDeleted = monitorService.deleteMonitor(id);
        if (!isDeleted) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/monitors/active")
    public ResponseEntity<List<MonitorResponse>> getActiveMonitors() {
        List<MonitorResponse> response = monitorService.getActiveMonitors();
        return ResponseEntity.ok(response);
    }

}
