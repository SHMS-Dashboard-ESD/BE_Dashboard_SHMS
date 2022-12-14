package shmskedaireka.demo.Repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import shmskedaireka.demo.Models.User;

public interface UserRepository extends CrudRepository<User, Long> {
    List<User> findByUsername(String username);

    List<User> findByRole(String role);

    List<User> findById(String customerid);

    List<User> findByRoleAndPerusahaan(String role, String perusahaan);

}
