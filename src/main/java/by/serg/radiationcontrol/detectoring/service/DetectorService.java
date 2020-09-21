package by.serg.radiationcontrol.detectoring.service;

import by.serg.radiationcontrol.detectoring.bean.Detector;
import by.serg.radiationcontrol.detectoring.sources.Source;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.Set;

@Data
@Service
public class DetectorService {

    @OneToMany(fetch = FetchType.EAGER)
    private Set<Detector> detectors;
    @Autowired
    @Qualifier("Source")
    private Set<Source> sources;

    @Scheduled(cron = "0 0 10 * * *")
    public void updateMeasurements() {
        for (Source source: sources) {
            source.readSourceAndUpdateDetectors(detectors);
        }
    }
}
