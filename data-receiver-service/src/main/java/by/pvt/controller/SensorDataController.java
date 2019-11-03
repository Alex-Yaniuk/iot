package by.pvt.controller;

import by.pvt.pojo.SensorData;
import by.pvt.service.SensorDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sensor-data")
public class SensorDataController {

    @Autowired
    private SensorDataService dataService;

    @PostMapping
    public void saveData(@RequestBody SensorData data) {
        dataService.saveData(data);
    }
}
