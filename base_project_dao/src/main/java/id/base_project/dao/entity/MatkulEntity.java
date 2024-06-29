package id.base_project.dao.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "matkul")
public class MatkulEntity {

    @Id
    @Column(name = "code_matkul")
    private String codeMatkul;

    @Column(name = "nama_matkul")
    private String namaMatkul;

    @Column(name = "sks_matkul")
    private String sksMatkul;

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

    public String getSksMatkul() {
        return sksMatkul;
    }

    public void setSksMatkul(String sksMatkul) {
        this.sksMatkul = sksMatkul;
    }
}
