package shmskedaireka.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import shmskedaireka.demo.Models.Sensor;
import shmskedaireka.demo.Repository.SensorRepository;

@RestController
@RequestMapping("/sensor")
@CrossOrigin(origins = "http://localhost:8080/")
public class SensorController {
    @Autowired
    SensorRepository sensorRepository;

    @PostMapping("/sendData")
    public ResponseEntity<Sensor> sendData(@RequestBody Sensor sensor) {
        Sensor newSensor = sensorRepository.save(sensor);

        return new ResponseEntity<>(newSensor, HttpStatus.CREATED);
    }
}