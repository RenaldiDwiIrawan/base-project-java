package id.base_project.dao.entity;

import javax.persistence.*;

@Entity
@Table(name = "mahasiswa")
public class MahasiswaEntity {

    @Id
    @Column(name = "nim")
    private String nim;

    @Column(name = "nama_mahasiswa")
    private String namaMahasiswa;

//    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//    @JoinColumn(name = "code_jurusan", referencedColumnName = "code_jurusan")
//    private JurusanEntity codeJurusan;
//
//    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//    @JoinColumn(name = "code_matkul", referencedColumnName = "code_matkul")

    @Column(name = "semester_mahasiswa")
    private Integer semesterMahasiswa;

    @Column(name = "active_mahasiswa")
    private Boolean activeMahasiswa;

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

//    public JurusanEntity getCodeJurusan() {
//        return codeJurusan;
//    }
//
//    public void setCodeJurusan(JurusanEntity codeJurusan) {
//        this.codeJurusan = codeJurusan;
//    }

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