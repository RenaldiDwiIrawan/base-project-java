package id.base_project.dao.entity;

import javax.persistence.*;

@Entity
@Table(name = "mahasiswa")
public class MahasiswaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_mahasiswa")
    private Long idMahasiswa;

    @Column(name = "nim")
    private String nim;

    @Column(name = "nama_mahasiswa")
    private String namaMahasiswa;

    @Column(name = "jurusan")
    private String jurusan;

    @Column(name = "semester_mahasiswa")
    private Integer semesterMahasiswa;

    @Column(name = "active_mahasiswa")
    private Boolean activeMahasiswa;

    public Long getIdMahasiswa() {
        return idMahasiswa;
    }

    public void setIdMahasiswa(Long idMahasiswa) {
        this.idMahasiswa = idMahasiswa;
    }

    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public String getNamaMahasiswa() {
        return namaMahasiswa;
    }

    public void setNamaMahasiswa(String namaMahasiswa) {
        this.namaMahasiswa = namaMahasiswa;
    }

    public String getJurusan() {
        return jurusan;
    }

    public void setJurusan(String jurusan) {
        this.jurusan = jurusan;
    }

    public Integer getSemesterMahasiswa() {
        return semesterMahasiswa;
    }

    public void setSemesterMahasiswa(Integer semesterMahasiswa) {
        this.semesterMahasiswa = semesterMahasiswa;
    }

    public Boolean getActiveMahasiswa() {
        return activeMahasiswa;
    }

    public void setActiveMahasiswa(Boolean activeMahasiswa) {
        this.activeMahasiswa = activeMahasiswa;
    }
}