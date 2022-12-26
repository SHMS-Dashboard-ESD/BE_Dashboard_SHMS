package shmskedaireka.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import shmskedaireka.demo.Models.User;
import shmskedaireka.demo.Repository.UserRepository;

@RestController
@CrossOrigin(origins = "http://129.150.33.190:8081/")
@RequestMapping("/userPerusahaan")
public class UserPerusahaanController {
    @Autowired
    UserRepository userRepository;

    PasswordEncoder pass;

    @GetMapping("/listUser/{role}/{perusahaan}")
    public ResponseEntity<List<User>> getAllUserPerusahaan(@PathVariable("role") String role,
            @PathVariable("perusahaan") String perusahaan) {
        List<User> dataUser = userRepository.findByRoleAndPerusahaan(role, perusahaan);

        return new ResponseEntity<List<User>>(dataUser, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity createUserPerusahaan(@RequestBody User user) {
        User n = new User();

        this.pass = new BCryptPasswordEncoder();
        String encodePass = this.pass.encode(user.getPassword());

        n.setFullname(user.getFullname());
        n.setUsername(user.getUsername());
        n.setPassword(encodePass);
        n.setPerusahaan(user.getPerusahaan());
        n.setRole("userp");
        n.setIdPerusahaan(user.getIdPerusahaan());

        userRepository.save(n);

        return new ResponseEntity<>(null, HttpStatus.OK);
    }
}
