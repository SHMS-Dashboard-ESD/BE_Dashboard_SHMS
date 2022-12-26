package shmskedaireka.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import shmskedaireka.demo.Models.User;
import shmskedaireka.demo.Repository.UserRepository;

@RestController
@RequestMapping("/admin")
@CrossOrigin(origins = "*")
public class AdminController {
    @Autowired
    UserRepository userRepository;

    PasswordEncoder pass;

    @PostMapping("/createAdminCustomer")
    public ResponseEntity RegisterAdminCust(@RequestBody User user) {
        User n = new User();

        this.pass = new BCryptPasswordEncoder();
        String encodePass = this.pass.encode(user.getPassword());

        n.setFullname(user.getFullname());
        n.setUsername(user.getUsername());
        n.setPassword(encodePass);
        n.setPerusahaan(user.getPerusahaan());
        n.setRole("adminc");

        userRepository.save(n);

        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    @PostMapping("/createOperator")
    public ResponseEntity RegisterOperator(@RequestBody User user) {
        User n = new User();

        this.pass = new BCryptPasswordEncoder();
        String encodePass = this.pass.encode(user.getPassword());

        n.setFullname(user.getFullname());
        n.setUsername(user.getUsername());
        n.setPassword(encodePass);
        n.setPerusahaan("operator");
        n.setRole("operator");

        userRepository.save(n);

        return new ResponseEntity<>("Operator Created", HttpStatus.OK);
    }

    @GetMapping("/getAllOperator")
    public ResponseEntity<List<User>> getAllOperator() {
        try {
            List<User> dataOperator = userRepository.findByRole("operator");

            return new ResponseEntity<List<User>>(dataOperator, HttpStatus.OK);
        } catch (Exception err) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

}