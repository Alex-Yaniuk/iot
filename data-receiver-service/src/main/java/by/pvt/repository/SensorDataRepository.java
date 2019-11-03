package by.pvt.repository;

import by.pvt.pojo.SensorData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

public interface SensorDataRepository extends JpaRepository<SensorData,Long> {

}
