package shmskedaireka.demo.Models;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.*;
import javax.transaction.Transactional;

import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.springframework.security.core.Transient;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.JsonNode;

@Entity
@Table(name = "SENSOR")
@JsonIgnoreProperties
public class Sensor implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "TIMERECEIVED")
    private String timereceived;

    @Column(name = "SENSORS")
    @Convert(converter = SensorsConverter.class)
    private List<Sensors> sensors;

    @Column(name = "LOC")
    private String location;

    public Sensor() {

    }

    public Sensor(String timereceived, List<Sensors> sensors, String location) {
        this.timereceived = timereceived;
        this.sensors = sensors;
        this.location = location;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTimereceived() {
        return timereceived;
    }

    public void setTimereceived(String timereceived) {
        this.timereceived = timereceived;
    }

    public List<Sensors> getSensors() {
        return sensors;
    }

    public void setSensors(List<Sensors> sensors) {
        this.sensors = sensors;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

}
