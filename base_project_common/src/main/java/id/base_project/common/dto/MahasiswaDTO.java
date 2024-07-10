package id.base_project.common.dto;

public class MahasiswaDTO {
    String namaMahasiswa;
    String NIM;
    Integer semesterMahasiswa;
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
}
