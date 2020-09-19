package by.serg.radiationcontrol.detectoring.bean;

import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.UpdateTimestamp;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;

@Data
@Builder
@Entity
public class Detector {
    @Id
    private Long id;
    private String location;
    private Double activity;
    @UpdateTimestamp
    private Timestamp dateTime;

    public Detector() {
    }
}
