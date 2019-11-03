package by.pvt.repository;

import by.pvt.pojo.SensorData;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.logging.Logger;

@Repository
public class SensorDataRepository {

    private static final Logger log = Logger.getLogger("SensorDataMvcRepository");

    @Autowired
    private SessionFactory sessionFactory;

    public List<SensorData> findAll() {

        List<SensorData> data = sessionFactory.getCurrentSession()
                .createQuery("from SensorData", SensorData.class).list();
        log.info("Read from base " + data);
        return data;
    }

    public List<SensorData> findSensorDataById(Long deviceId,Long sensorId) {
        List<SensorData> sensorData = sessionFactory.getCurrentSession()
                .createQuery("from SensorData where device_id=:deviceId and sensor_id = :sensorId", SensorData.class)
                .setParameter("deviceId", deviceId)
                .setParameter("sensorId",sensorId)
                .list();
        return sensorData;
    }

    public List<SensorData> findSensorDataById(Long deviceId, Long sensorId, int i) {
        List<SensorData> sensorData = sessionFactory.getCurrentSession()
                .createQuery("from SensorData where device_id=:deviceId and sensor_id = :sensorId order by id DESC", SensorData.class)
                .setParameter("deviceId", deviceId)
                .setParameter("sensorId",sensorId)
                .setMaxResults(i)
                .list();
        return sensorData;
    }
}
