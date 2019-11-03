package by.pvt.service;

import by.pvt.pojo.SensorData;
import by.pvt.repository.SensorDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class SensorDataService {

    private final int MAX_RESULT = 10;

    @Autowired
    private SensorDataRepository dataRepository;

    @Transactional
    public List<SensorData> findAll() {
        return dataRepository.findAll();
    }

    @Transactional
    public List<SensorData> findSensorData(Long deviceId, Long sensorId) {
        return dataRepository.findSensorDataById(deviceId,sensorId);
    }

    @Transactional
    public List<SensorData> findSensorDataLastTen(Long deviceId, Long sensorId) {
        List<SensorData> sensorData = dataRepository.findSensorDataById(deviceId,sensorId,MAX_RESULT);
        sensorData.stream().sorted((o1, o2) -> o1.getId().compareTo(o2.getId()));
        return sensorData;
    }
}
