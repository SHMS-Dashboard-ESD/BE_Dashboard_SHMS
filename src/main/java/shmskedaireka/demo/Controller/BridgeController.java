package shmskedaireka.demo.Controller;

import java.lang.StackWalker.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import shmskedaireka.demo.Models.Bridge;
import shmskedaireka.demo.Repository.BridgeRepository;

@RestController
@RequestMapping("/bridge")
@CrossOrigin(origins = "http://localhost:8080/")
public class BridgeController {
    @Autowired
    BridgeRepository bridgeRepository;

    @GetMapping("/getAllBridge")
    public ResponseEntity<List<Bridge>> getAllBridge() {
        try {
            var dataBridge = (List<Bridge>) bridgeRepository.findAll();

            return ResponseEntity.ok(dataBridge);
        } catch (Exception err) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/getBridgeById/{id}")
    public ResponseEntity<Optional<Bridge>> getBridgeById(@PathVariable("id") Long bridgeId) {
        try {
            Optional dataBridge = bridgeRepository.findById(bridgeId);

            return ResponseEntity.ok(dataBridge);
        } catch (Exception err) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/createBridge")
    public ResponseEntity createBridge(@RequestBody Bridge bridge) {
        Bridge b = new Bridge();

        b.setName(bridge.getName());
        b.setDetailAddress(bridge.getDetailAddress());
        b.setDescription(bridge.getDescription());
        b.setLangitude(bridge.getLangitude());
        b.setLatitude(bridge.getLatitude());
        b.setBridge_status(bridge.getBridge_status());
        b.setBridge_value(bridge.getBridge_value());

        // // System.out.println(b);
        bridgeRepository.save(b);

        return ResponseEntity.ok("bridge created");
    }

    @PostMapping("/assignBridge/{id}/{idAdminCust}")
    public ResponseEntity assignBridge(@PathVariable("id") Long bridgeId, @PathVariable("idAdminCust") Long custId) {
        try {
            Bridge dataBridge = bridgeRepository.findById(bridgeId).get();

            dataBridge.setBridgeAssigned(custId);

            bridgeRepository.save(dataBridge);

            return ResponseEntity.ok("Bridge Assigned");
        } catch (Exception err) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/getAssignedBridge/{custId}")
    public ResponseEntity getAssignedBridge(@PathVariable("custId") Long bridgeId) {
        try {
            List<Bridge> findByAssigned = bridgeRepository.findAllByBridgeAssigned(bridgeId);

            return ResponseEntity.ok(findByAssigned);
        } catch (Exception err) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/editBridges/{bridgeId}")
    public ResponseEntity editBridges(@PathVariable("bridgeId") Long bridgeId, @RequestBody Bridge bridge) {
        try {
            Bridge dataBridge = bridgeRepository.findById(bridgeId).get();

            dataBridge.setName(bridge.getName());
            dataBridge.setDetailAddress(bridge.getDetailAddress());
            dataBridge.setDescription(bridge.getDescription());
            dataBridge.setLangitude(bridge.getLangitude());
            dataBridge.setLatitude(bridge.getLatitude());
            dataBridge.setBridge_status(bridge.getBridge_status());
            dataBridge.setBridge_value(bridge.getBridge_value());

            bridgeRepository.save(dataBridge);

            return ResponseEntity.ok("Bridge Edited");
        } catch (Exception err) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
}
