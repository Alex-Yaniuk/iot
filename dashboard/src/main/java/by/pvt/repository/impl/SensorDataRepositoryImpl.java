package by.pvt.repository.impl;

import by.pvt.pojo.SensorData;
import by.pvt.repository.SensorDataDao;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SensorDataRepositoryImpl implements SensorDataDao {


    @Autowired
    private SessionFactory sessionFactory;

    public List<SensorData> findAll() {

        return sessionFactory.getCurrentSession()
                .createQuery("from SensorData", SensorData.class).list();
    }

    public List<SensorData> findSensorDataById(Long deviceId, Long sensorId) {
        return sessionFactory.getCurrentSession()
                .createQuery("from SensorData where device_id=:deviceId and sensor_id = :sensorId", SensorData.class)
                .setParameter("deviceId", deviceId)
                .setParameter("sensorId", sensorId)
                .list();
    }

    public List<SensorData> findSensorDataById(Long deviceId, Long sensorId, int i) {
        return sessionFactory.getCurrentSession()
                .createQuery("from SensorData where device_id=:deviceId and sensor_id = :sensorId order by id DESC", SensorData.class)
                .setParameter("deviceId", deviceId)
                .setParameter("sensorId", sensorId)
                .setMaxResults(i)
                .list();
    }
}
