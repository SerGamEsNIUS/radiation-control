package by.serg.radiationcontrol.detectoring.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;


@Entity
@Table(name = "DETECTORS")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Detector {
    @Id
    private String location;
    private Double activity;
    @DateTimeFormat
    private Date dateTime;

}
