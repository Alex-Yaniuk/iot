package by.pvt.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@Table(name = "sensor_data")
public class SensorData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "device_id")
    private Long deviceId;
    @Column(name = "sensor_id")
    private Long sensorId;
    @Column(name = "data")
    private Double data;
    @Column(name = "date")
    private Date date;

}
