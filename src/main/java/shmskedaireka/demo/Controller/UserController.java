package shmskedaireka.demo.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import shmskedaireka.demo.Repository.UserRepository;
import shmskedaireka.demo.Models.User;

@RestController
@CrossOrigin(origins = "http://localhost:8080/")
@RequestMapping("/api")
public class UserController {

    @Autowired
    UserRepository userRepository;

    PasswordEncoder pass;

    @GetMapping("/users")
    public ResponseEntity<List<User>> GetAllUsers(@RequestParam(required = false) String username) {
        try {
            List<User> users = new ArrayList<User>();

            return new ResponseEntity<>(users, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.OK);
        }
    }

    @PostMapping("/register")
    public ResponseEntity registerUser(@RequestBody User user) {
        User n = new User();

        this.pass = new BCryptPasswordEncoder();
        String encodePass = this.pass.encode(user.getPassword());

        n.setFullname(user.getFullname());
        n.setUsername(user.getUsername());
        n.setPassword(encodePass);

        userRepository.save(n);

        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity loginUser(@RequestBody User user) {
        List<User> users = userRepository.findByUsername(user.getUsername());

        String role;
        if (!users.isEmpty()) {
            this.pass = new BCryptPasswordEncoder();
            Boolean decodePass = this.pass.matches(user.getPassword(), users.get(0).getPassword());

            if (users.get(0).getRole() == "adminc") {
                role = "admin customer";
            } else if (users.get(0).getRole() == "customer") {
                role = "customer";
            } else if (users.get(0).getRole() == "superadmin") {
                role = "superadmin";
            }

            if (decodePass) {
                return ResponseEntity.ok(users);
            } else {
                return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            }

        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getUsers")
    public ResponseEntity getUsers() {
        return new ResponseEntity<>(null, HttpStatus.OK);
    }
}
