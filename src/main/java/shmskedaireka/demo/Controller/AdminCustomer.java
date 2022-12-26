package shmskedaireka.demo.Controller;

import java.util.List;
import java.util.Optional;

import shmskedaireka.Response.ResponseGetAdminCustomer;
import shmskedaireka.demo.Models.Bridge;
import shmskedaireka.demo.Models.User;

import org.apache.coyote.Response;
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

import shmskedaireka.demo.Repository.BridgeRepository;
import shmskedaireka.demo.Repository.UserRepository;

@RestController
@CrossOrigin(origins = "http://129.150.33.190:8081/")
@RequestMapping("/adminCustomer")
public class AdminCustomer {
    @Autowired
    UserRepository userRepository;

    @Autowired
    BridgeRepository bridgeRepository;

    PasswordEncoder pass;

    @GetMapping("/getAllCustomer")
    public ResponseEntity<List<User>> getAllCustomer() {
        List<User> dataUser = userRepository.findByRole("adminc");

        return new ResponseEntity<List<User>>(dataUser, HttpStatus.OK);
    }

    @PostMapping("/createCustomer")
    public ResponseEntity RegisterCustomer(@RequestBody User user) {
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

    @GetMapping("/getAdminCustomerById/{customerId}")
    public ResponseEntity<ResponseGetAdminCustomer> getAdminCustomerById(@PathVariable Long customerId) {

        ResponseGetAdminCustomer response = new ResponseGetAdminCustomer();

        Optional<User> dataUser = userRepository.findById(customerId);

        List<Bridge> dataBridge = bridgeRepository.findAllByBridgeAssigned(customerId);

        response.setUser(dataUser);

        response.setBridge(dataBridge);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
