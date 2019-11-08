package by.pvt.service.impl;

import by.pvt.model.Device;
import by.pvt.model.Sensor;
import by.pvt.repository.DeviceDao;
import by.pvt.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class DeviceServiceImpl implements DeviceService {

    @Autowired
    private DeviceDao deviceRepository;


    @Transactional
    public void addDevice(Device device) {
        Sensor sensor = new Sensor();
        sensor.setValue("speed");
        Sensor sensor2 = new Sensor();
        sensor2.setValue("temperature");
        device.getSensors().add(sensor);
        device.getSensors().add(sensor2);
        sensor.setDevice(device);
        sensor2.setDevice(device);
        deviceRepository.addDevice(device);
    }

    @Transactional
    public List<Device> getAll() {
        return deviceRepository.findAll();
    }

    @Transactional
    public Device findDevice(Long id) {
        return deviceRepository.findDeviceById(id);
    }

    @Transactional
    public List<Device> searchByLocation(String location) {
        return deviceRepository.findDeviceByLocation(location);
    }
}
