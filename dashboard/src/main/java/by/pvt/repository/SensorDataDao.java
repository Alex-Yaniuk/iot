package by.pvt.repository;

import by.pvt.model.SensorData;

import java.util.List;

public interface SensorDataDao {

    List<SensorData> findAll();

    List<SensorData> findSensorDataById(Long deviceId, Long sensorId);

    List<SensorData> findSensorDataById(Long deviceId, Long sensorId, int i);
}
