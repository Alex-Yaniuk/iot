package by.pvt.service;

import by.pvt.pojo.Device;

import java.util.List;

public interface DeviceService {

    void addDevice(Device device);

    List<Device> getAll();

    Device findDevice(Long id);

    List<Device> searchByLocation(String location);

}
