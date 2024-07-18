package id.base_project.common.dto;


import id.base_project.dao.entity.JurusanEntity;
import id.base_project.dao.entity.MatkulEntity;

public class MahasiswaJoinDTO {
    String namaMahasiswa;
    String nim;
    Integer semesterMahasiswa;
    boolean activeMahasiswa;
    JurusanDTO Jurusan;

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

    public boolean isActiveMahasiswa() {
        return activeMahasiswa;
    }

    public void setActiveMahasiswa(boolean activeMahasiswa) {
        this.activeMahasiswa = activeMahasiswa;
    }

    public JurusanDTO getJurusan() {
        return Jurusan;
    }

    public void setJurusan(JurusanDTO jurusan) {
        Jurusan = jurusan;
    }

}
