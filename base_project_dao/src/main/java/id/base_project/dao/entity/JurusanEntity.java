package id.base_project.dao.entity;

import javax.persistence.*;

@Entity
@Table(name = "jurusan")
public class JurusanEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_jurusan")
    private Long idJurusan;

    @Column(name = "code_jurusan", updatable = false)
    private String codeJurusan;

    @Column(name = "nama_jurusan")
    private String namaJurusan;

    @Column(name = "fakultas")
    private String fakultas;

    public Long getIdJurusan() {
        return idJurusan;
    }

    public void setIdJurusan(Long idJurusan) {
        this.idJurusan = idJurusan;
    }

    public String getCodeJurusan() {
        return codeJurusan;
    }

    public void setCodeJurusan(String codeJurusan) {
        this.codeJurusan = codeJurusan;
    }

    public String getNamaJurusan() {
        return namaJurusan;
    }

    public void setNamaJurusan(String namaJurusan) {
        this.namaJurusan = namaJurusan;
    }

    public String getFakultas() {
        return fakultas;
    }

    public void setFakultas(String fakultas) {
        this.fakultas = fakultas;
    }
}