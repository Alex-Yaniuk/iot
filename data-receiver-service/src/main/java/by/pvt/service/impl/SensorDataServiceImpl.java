package by.pvt.service.impl;

import by.pvt.pojo.SensorData;
import by.pvt.repository.SensorDataRepository;
import by.pvt.service.SensorDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class SensorDataServiceImpl implements SensorDataService {

    @Autowired
    private SensorDataRepository dataRepository;


    public void saveData(SensorData data) {
        data.setDate(new Date());
        dataRepository.save(data);
    }


}
