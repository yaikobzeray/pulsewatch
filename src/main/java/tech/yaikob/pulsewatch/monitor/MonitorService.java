package tech.yaikob.pulsewatch.monitor;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import tech.yaikob.pulsewatch.monitor.dto.MonitorRequest;
import tech.yaikob.pulsewatch.monitor.dto.MonitorResponse;

@Service
public class MonitorService {
    private final MonitorRepository monitorRepository;

    public MonitorService(MonitorRepository monitorRepository) {
        this.monitorRepository = monitorRepository;
    }

    public List<MonitorResponse> getActiveMonitors() {
       return  monitorRepository.findByActiveTrue().stream().map(monitor -> new MonitorResponse(
           monitor.getId(),
           monitor.getName(),
           monitor.getUrl(),
           monitor.isActive(),
           monitor.getCheckIntervalSeconds(),
           monitor.getCreatedAt().toString()
       )).toList();
    }

    public List<MonitorResponse> getAllMonitors() {
        return monitorRepository.findAll().stream().map(monitor -> new MonitorResponse(
            monitor.getId(),
            monitor.getName(),
            monitor.getUrl(),
            monitor.isActive(),
            monitor.getCheckIntervalSeconds(),
            monitor.getCreatedAt().toString()
        )).toList();
    }

 public Optional<MonitorResponse> getMonitorById(Long id) {

    return monitorRepository.findById(id).map(monitor-> new MonitorResponse(
        monitor.getId(),
        monitor.getName(),
        monitor.getUrl(),
        monitor.isActive(),
        monitor.getCheckIntervalSeconds(),
        monitor.getCreatedAt().toString()
    ));
    }

    public MonitorResponse createMonitor(MonitorRequest monitor) {
        Monitor newMonitor = new Monitor(monitor.name(), monitor.url(), monitor.checkIntervalSeconds());
        Monitor createdMonitor = monitorRepository.save(newMonitor);
        return new MonitorResponse(
            createdMonitor.getId(),
            createdMonitor.getName(),
            createdMonitor.getUrl(),
            createdMonitor.isActive(),
            createdMonitor.getCheckIntervalSeconds(),
            createdMonitor.getCreatedAt().toString()
        );
    }

    public boolean deleteMonitor(Long id) {

        if (!monitorRepository.existsById(id)) {
            return false;
        }

        monitorRepository.deleteById(id);
        return true;
    }

}
