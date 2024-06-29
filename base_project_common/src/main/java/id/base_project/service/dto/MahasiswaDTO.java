package id.base_project.service.dto;

public class MahasiswaDTO {
    String namaMahasiswa;
    Integer NIM;
    String namaJurusan;
    String semesterMahasiswa;
    String codeJurusan;
    boolean mahasiswaActive;

    public String getNamaMahasiswa() {
        return namaMahasiswa;
    }

    public void setNamaMahasiswa(String namaMahasiswa) {
        this.namaMahasiswa = namaMahasiswa;
    }

    public Integer getNIM() {
        return NIM;
    }

    public void setNIM(Integer NIM) {
        this.NIM = NIM;
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

    public String getCodeJurusan() {
        return codeJurusan;
    }

    public void setCodeJurusan(String codeJurusan) {
        this.codeJurusan = codeJurusan;
    }

    public boolean isMahasiswaActive() {
        return mahasiswaActive;
    }

    public void setMahasiswaActive(boolean mahasiswaActive) {
        this.mahasiswaActive = mahasiswaActive;
    }
}
