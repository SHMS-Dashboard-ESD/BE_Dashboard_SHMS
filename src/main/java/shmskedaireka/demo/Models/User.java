package shmskedaireka.demo.Models;

import javax.persistence.*;

@Entity
@Table(name = "USERS")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "USERNAME")
    private String username;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "FULLNAME")
    private String fullname;

    @Column(name = "ROLE")
    private String role;

    @Column(name = "PERUSAHAAN")
    private String perusahaan;

    @Column(name = "ID_PERUSAHAAN")
    private String idPerusahaan;

    public User() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPerusahaan() {
        return perusahaan;
    }

    public void setPerusahaan(String perusahaan) {
        this.perusahaan = perusahaan;
    }

    public String getIdPerusahaan() {
        return idPerusahaan;
    }

    public void setIdPerusahaan(String idPerusahaan) {
        this.idPerusahaan = idPerusahaan;
    }

    public User(String username, String password, String fullname, String role, String perusahaan,
            String idPerusahaan) {
        this.username = username;
        this.password = password;
        this.fullname = fullname;
        this.role = role;
        this.perusahaan = perusahaan;
        this.idPerusahaan = idPerusahaan;
    }

    @Override
    public String toString() {
        return "User";
    }
}
