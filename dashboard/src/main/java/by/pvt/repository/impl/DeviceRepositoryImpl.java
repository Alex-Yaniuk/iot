package by.pvt.repository.impl;

import by.pvt.pojo.Device;
import by.pvt.repository.DeviceDao;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DeviceRepositoryImpl implements DeviceDao {


    @Autowired
    private SessionFactory sessionFactory;

    public void addDevice(Device device) {
        sessionFactory.getCurrentSession().save(device);

    }

    public List<Device> findAll() {
        return sessionFactory.getCurrentSession()
                .createQuery("from Device", Device.class).list();
    }


    public Device findDeviceById(Long id) {
        return sessionFactory.getCurrentSession()
                .get(Device.class, id);
    }

    public List<Device> findDeviceByLocation(String location) {
        return sessionFactory.getCurrentSession()
                .createQuery("from Device where location like :location", Device.class)
                .setParameter("location", location + "%").list();
    }
}
