package shmskedaireka.demo.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

import shmskedaireka.demo.Models.Bridge;

public interface BridgeRepository extends JpaRepository<Bridge, Long> {
    List<Bridge> findAllByBridgeAssigned(Long bridgeAssigned);
}
