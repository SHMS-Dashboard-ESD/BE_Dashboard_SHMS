package shmskedaireka.demo.Models;

import javax.persistence.Embeddable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties
public class Sensors {
    private String amplitudos;
    private String displacement;
    private String frequencies;
    private Integer sensorId;

    public Sensors() {

    }

    public Sensors(String amplitudos, String displacement, String frequencies, Integer sensorId) {
        this.amplitudos = amplitudos;
        this.displacement = displacement;
        this.frequencies = frequencies;
        this.sensorId = sensorId;
    }

    public String getAmplitudos() {
        return amplitudos;
    }

    public void setAmplitudos(String amplitudos) {
        this.amplitudos = amplitudos;
    }

    public String getDisplacement() {
        return displacement;
    }

    public void setDisplacement(String displacement) {
        this.displacement = displacement;
    }

    public String getFrequencies() {
        return frequencies;
    }

    public void setFrequencies(String frequencies) {
        this.frequencies = frequencies;
    }

    public Integer getSensorId() {
        return sensorId;
    }

    public void setSensorId(Integer sensorId) {
        this.sensorId = sensorId;
    }

}
