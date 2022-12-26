package shmskedaireka.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import shmskedaireka.demo.Models.Keluhan;
import shmskedaireka.demo.Repository.KeluhanRepository;

@RestController
@RequestMapping("/keluhan")
@CrossOrigin(origins = "*")
public class KeluhanController {
    @Autowired
    KeluhanRepository keluhanRepository;

    @PostMapping("/createKeluhan")
    public ResponseEntity createKeluhan(@RequestBody Keluhan keluhan) {
        Keluhan k = new Keluhan();

        keluhanRepository.save(keluhan);

        return ResponseEntity.ok("Keluhan Created");
    }
}
