package by.pvt.repository;

import by.pvt.pojo.Device;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.logging.Logger;

@Repository
public class DeviceRepository {

    private static final Logger log = Logger.getLogger("DeviceRepository");

    @Autowired
    private SessionFactory sessionFactory;

    public void addDevice(Device device) {
        sessionFactory.getCurrentSession().save(device);

    }

    public List<Device> findAll() {
        List<Device> devices = sessionFactory.getCurrentSession()
                .createQuery("from Device", Device.class).list();
        log.info("Devices " + devices);
        return devices;
    }


    public Device findDeviceById(Long id) {
        return sessionFactory.getCurrentSession()
                .get(Device.class, id);
    }
}
