package shmskedaireka.demo.Models;

import javax.persistence.*;

@Entity
@Table(name = "BRIDGES")
public class Bridge {
    private long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "DETAIL_ADDRESS")
    private String detailAddress;

    @Column(name = "LANGITUDE")
    private Integer langitude;

    @Column(name = "LATITUDE")
    private Integer latitude;

    @Column(name = "BRIDGE_STATUS")
    private String bridge_status;

    @Column(name = "BRIDGE_VALUE")
    private String bridge_value;

    @Column(name = "BRIDGE_ASSIGNED")
    private Long bridgeAssigned;

    public Bridge() {

    }

    public Bridge(String name, String description, String detailAddress, Integer langitude, Integer latitude,
            String bridge_status, String bridge_value, Long bridgeAssigned) {
        this.name = name;
        this.description = description;
        this.detailAddress = detailAddress;
        this.langitude = langitude;
        this.latitude = latitude;
        this.bridge_status = bridge_status;
        this.bridge_value = bridge_value;
        this.bridgeAssigned = bridgeAssigned;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDetailAddress() {
        return detailAddress;
    }

    public void setDetailAddress(String detailAddress) {
        this.detailAddress = detailAddress;
    }

    public Integer getLangitude() {
        return langitude;
    }

    public void setLangitude(Integer langitude) {
        this.langitude = langitude;
    }

    public Integer getLatitude() {
        return latitude;
    }

    public void setLatitude(Integer latitude) {
        this.latitude = latitude;
    }

    public String getBridge_status() {
        return bridge_status;
    }

    public void setBridge_status(String bridge_status) {
        this.bridge_status = bridge_status;
    }

    public String getBridge_value() {
        return bridge_value;
    }

    public void setBridge_value(String bridge_value) {
        this.bridge_value = bridge_value;
    }

    public Long getBridgeAssigned() {
        return bridgeAssigned;
    }

    public void setBridgeAssigned(Long bridgeAssigned) {
        this.bridgeAssigned = bridgeAssigned;
    }

}
