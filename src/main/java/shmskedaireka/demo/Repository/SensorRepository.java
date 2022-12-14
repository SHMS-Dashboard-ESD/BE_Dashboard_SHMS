package shmskedaireka.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import shmskedaireka.demo.Models.Sensor;

public interface SensorRepository extends JpaRepository<Sensor, Long> {

}
