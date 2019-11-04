package by.pvt.controller;

import by.pvt.service.SensorDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/sensor-data")
public class SensorDataController {


    @Autowired
    private SensorDataService dataMvcService;


    @GetMapping
    public String showAll(Model model) {
        model.addAttribute("data", dataMvcService.findAll());
        return "sensor/show_all_sensors_data";
    }


}
