package by.pvt.service;

import by.pvt.model.SensorData;

import java.util.List;

public interface SensorDataService {

    List<SensorData> findAll();

    List<SensorData> findSensorData(Long deviceId, Long sensorId);

    List<SensorData> findSensorDataLastTen(Long deviceId, Long sensorId);
}
