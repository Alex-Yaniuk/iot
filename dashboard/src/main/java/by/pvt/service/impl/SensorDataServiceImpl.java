package by.pvt.service.impl;

import by.pvt.model.SensorData;
import by.pvt.repository.SensorDataDao;
import by.pvt.service.SensorDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Comparator;
import java.util.List;

@Service
public class SensorDataServiceImpl implements SensorDataService {

    private final int MAX_RESULT = 10;

    @Autowired
    private SensorDataDao dataRepository;

    @Transactional
    public List<SensorData> findAll() {
        return dataRepository.findAll();
    }

    @Transactional
    public List<SensorData> findSensorData(Long deviceId, Long sensorId) {
        return dataRepository.findSensorDataById(deviceId, sensorId);
    }

    @Transactional
    public List<SensorData> findSensorDataLastTen(Long deviceId, Long sensorId) {
        List<SensorData> sensorData = dataRepository.findSensorDataById(deviceId, sensorId, MAX_RESULT);
        sensorData.sort(Comparator.comparing(SensorData::getId));
        return sensorData;
    }


}
