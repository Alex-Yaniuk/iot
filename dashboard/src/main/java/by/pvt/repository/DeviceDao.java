package by.pvt.repository;

import by.pvt.pojo.Device;

import java.util.List;

public interface DeviceDao {

    void addDevice(Device device);

    List<Device> findAll();

    Device findDeviceById(Long id);

    List<Device> findDeviceByLocation(String location);

}
