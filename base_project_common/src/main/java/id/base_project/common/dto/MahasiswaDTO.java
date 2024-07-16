package id.base_project.common.dto;

public class MahasiswaDTO {
    String namaMahasiswa;
    String nim;
    Integer semesterMahasiswa;
    boolean mahasiswaActive;
    String jurusan;

    public String getNamaMahasiswa() {
        return namaMahasiswa;
    }

    public void setNamaMahasiswa(String namaMahasiswa) {
        this.namaMahasiswa = namaMahasiswa;
    }

    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public Integer getSemesterMahasiswa() {
        return semesterMahasiswa;
    }

    public void setSemesterMahasiswa(Integer semesterMahasiswa) {
        this.semesterMahasiswa = semesterMahasiswa;
    }

    public boolean isMahasiswaActive() {
        return mahasiswaActive;
    }

    public void setMahasiswaActive(boolean mahasiswaActive) {
        this.mahasiswaActive = mahasiswaActive;
    }

    public String getJurusan() {
        return jurusan;
    }

    public void setJurusan(String jurusan) {
        this.jurusan = jurusan;
    }

}
