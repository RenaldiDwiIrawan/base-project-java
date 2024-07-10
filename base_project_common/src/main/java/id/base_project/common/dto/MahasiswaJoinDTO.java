package id.base_project.common.dto;

public class MahasiswaJoinDTO {
    String namaMahasiswa;
    String NIM;
    String codeJurusan;
    String namaJurusan;
    String semesterMahasiswa;
    String codeMatkul;
    String namaMatkul;
    boolean mahasiswaActive;

    public String getNamaMahasiswa() {
        return namaMahasiswa;
    }

    public void setNamaMahasiswa(String namaMahasiswa) {
        this.namaMahasiswa = namaMahasiswa;
    }

    public String getNIM() {
        return NIM;
    }

    public void setNIM(String NIM) {
        this.NIM = NIM;
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

    public String getSemesterMahasiswa() {
        return semesterMahasiswa;
    }

    public void setSemesterMahasiswa(String semesterMahasiswa) {
        this.semesterMahasiswa = semesterMahasiswa;
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

    public boolean getMahasiswaActive() {
        return mahasiswaActive;
    }

    public void setMahasiswaActive(boolean mahasiswaActive) {
        this.mahasiswaActive = mahasiswaActive;
    }
}
