package by.pvt.controller;

import by.pvt.model.Device;
import by.pvt.model.SensorData;
import by.pvt.service.DeviceService;
import by.pvt.service.SensorDataService;
import by.pvt.util.DeviceRegistrationValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/device-catalog")
public class DeviceController {

    @Autowired
    private DeviceService deviceService;

    @Autowired
    private SensorDataService dataMvcService;

    @Autowired
    private DeviceRegistrationValidator deviceRegistrationValidator;

    @GetMapping

    public String showAllDevices(Model model) {
        model.addAttribute("devices", deviceService.getAll());
        return "device/device_catalog";
    }

    @GetMapping("/device/{id}")
    public String showDevice(@PathVariable Long id, Model model) {
        Device device = deviceService.findDevice(id);
        model.addAttribute("device", device);
        return "/device/one_device";
    }

    @GetMapping("/register-new-device")
    public String registerNewDeviceView(Model model) {
        model.addAttribute("device", new Device());
        return "device/register_new_device";
    }

    @PostMapping("/register-new-device")
    public String registerNewDevicePost(@ModelAttribute("device") Device device, BindingResult result) {
        deviceRegistrationValidator.validate(device, result);
        if (result.hasErrors()) {
            return "device/register_new_device";
        }
        deviceService.addDevice(device);
        return "redirect:/device-catalog";
    }


    @GetMapping("/device/{deviceId}/{sensorId}")
    public String oneSensorDataChart(@PathVariable Long deviceId, @PathVariable Long sensorId, Model model) {
        List<SensorData> sensorData = dataMvcService.findSensorDataLastTen(deviceId, sensorId);
        model.addAttribute("sensorData", sensorData);
        return "sensor/show_one_sensor_data_chart";
    }


    @GetMapping("/device/{deviceId}/{sensorId}/list")
    public String oneSensorDataList(@PathVariable Long deviceId, @PathVariable Long sensorId, Model model) {
        List<SensorData> sensorData = dataMvcService.findSensorData(deviceId, sensorId);
        model.addAttribute("sensorData", sensorData);
        return "sensor/show_one_sensor_data_list";
    }


}
