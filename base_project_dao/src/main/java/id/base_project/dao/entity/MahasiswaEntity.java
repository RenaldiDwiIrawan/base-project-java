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
//    @JoinColumn(name = "code_jurusan", referencedColumnName = "code")
//    private JurusanEntity codeJurusan;
//
//	@ManyToOne(fetch = FetchType.EAGER)
//	@JoinColumn(name = "code_matkul", referencedColumnName = "code_matkul")
//	private MatkulEntity codeMatkul;

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

    public Boolean getActiveMahasiswa() {
        return activeMahasiswa;
    }

    public void setActiveMahasiswa(Boolean activeMahasiswa) {
        this.activeMahasiswa = activeMahasiswa;
    }
}