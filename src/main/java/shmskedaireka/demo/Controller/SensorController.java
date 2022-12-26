package shmskedaireka.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import shmskedaireka.demo.Models.Bridge;
import shmskedaireka.demo.Models.Sensor;
import shmskedaireka.demo.Models.Sensors;
import shmskedaireka.demo.Repository.SensorRepository;
import shmskedaireka.demo.Repository.SensorsRepository;

@RestController
@RequestMapping("/sensor")
@CrossOrigin(origins = "http://129.150.33.190:8081/")
public class SensorController {
    @Autowired
    SensorRepository sensorRepository;
    SensorsRepository sensorsRepository;

    @PostMapping("/sendData")
    public ResponseEntity<Sensor> sendData(@RequestBody Sensor sensor) {
        Sensor newSensor = sensorRepository.save(sensor);

        return new ResponseEntity<>(newSensor, HttpStatus.CREATED);
    }

    @GetMapping("/getData")
    public ResponseEntity<List<Sensor>> getAllData() {
        try {
            List dataSensor = sensorRepository.findAll();

            return new ResponseEntity<List<Sensor>>(dataSensor, HttpStatus.CREATED);
        } catch (Exception err) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
}