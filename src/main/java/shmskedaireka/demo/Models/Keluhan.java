package shmskedaireka.demo.Models;

import javax.persistence.*;

@Entity
@Table(name = "KELUHAN")
public class Keluhan {
    private long id;

    @Column(name = "JUDUL_KELUHAN")
    private String judulKeluhan;

    @Column(name = "DESKRIPSI_KELUHAN")
    private String deskripsiKeluhan;

    @Column(name = "ID_JEMBATAN")
    private long idJembatan;

    @Column(name = "ID_USER")
    private long idUser;

    public Keluhan() {

    }

    public Keluhan(String judulKeluhan, String deskripsiKeluhan, long idJembatan, long idUser) {
        this.judulKeluhan = judulKeluhan;
        this.deskripsiKeluhan = deskripsiKeluhan;
        this.idJembatan = idJembatan;
        this.idUser = idUser;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getJudulKeluhan() {
        return judulKeluhan;
    }

    public void setJudulKeluhan(String judulKeluhan) {
        this.judulKeluhan = judulKeluhan;
    }

    public String getDeskripsiKeluhan() {
        return deskripsiKeluhan;
    }

    public void setDeskripsiKeluhan(String deskripsiKeluhan) {
        this.deskripsiKeluhan = deskripsiKeluhan;
    }

    public long getIdJembatan() {
        return idJembatan;
    }

    public void setIdJembatan(long idJembatan) {
        this.idJembatan = idJembatan;
    }

    public long getIdUser() {
        return idUser;
    }

    public void setIdUser(long idUser) {
        this.idUser = idUser;
    }

}
