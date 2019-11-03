package by.pvt.service;

import by.pvt.pojo.SensorData;
import by.pvt.repository.SensorDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class SensorDataService {

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
}
