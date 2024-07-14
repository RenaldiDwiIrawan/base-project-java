package id.base_project.dao.entity;

import javafx.css.StyleableIntegerProperty;

import javax.persistence.*;

@Entity
@Table(name = "matkul")
public class MatkulEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_matkul")
    private Long idMatkul;

    @Column(name = "code_matkul")
    private String codeMatkul;

    @Column(name = "nama_matkul")
    private String namaMatkul;

    @Column(name = "semesterMatkul")
    private Integer semesterMatkul;

    @Column(name = "sks_matkul")
    private Integer sksMatkul;

    public Long getIdMatkul() {
        return idMatkul;
    }

    public void setIdMatkul(Long idMatkul) {
        this.idMatkul = idMatkul;
    }

    public String getCodeMatkul() {
        return codeMatkul;
    }

    public void setCodeMatkul(String codeMatkul) {
        this.codeMatkul = codeMatkul;
    }

    public String getNamaMatkul() {
        return namaMatkul;
    }

    public void setNamaMatkul(String namaMatkul) {
        this.namaMatkul = namaMatkul;
    }

    public Integer getSemesterMatkul() {
        return semesterMatkul;
    }

    public void setSemesterMatkul(Integer semesterMatkul) {
        this.semesterMatkul = semesterMatkul;
    }

    public Integer getSksMatkul() {
        return sksMatkul;
    }

    public void setSksMatkul(Integer sksMatkul) {
        this.sksMatkul = sksMatkul;
    }
}
