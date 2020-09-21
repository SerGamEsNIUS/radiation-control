package by.serg.radiationcontrol.detectoring.sources;

import by.serg.radiationcontrol.detectoring.bean.Detector;
import java.util.Set;

public interface Source {
    void readSourceAndUpdateDetectors(Set<Detector> detectors);
}
