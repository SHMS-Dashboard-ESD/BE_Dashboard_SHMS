package shmskedaireka.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

import shmskedaireka.demo.Models.Sensors;

@NoRepositoryBean
public interface SensorsRepository extends JpaRepository<Sensors, Long> {

}
