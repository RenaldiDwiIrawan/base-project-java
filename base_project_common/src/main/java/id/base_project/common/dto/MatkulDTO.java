package id.base_project.common.dto;

public class MatkulDTO {
    String codeMatkul;
    String namaMatkul;
    Integer sksMatkul;
    Integer semesterMatkul;

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

    public Integer getSksMatkul() {
        return sksMatkul;
    }

    public void setSksMatkul(Integer sksMatkul) {
        this.sksMatkul = sksMatkul;
    }

    public Integer getSemesterMatkul() {
        return semesterMatkul;
    }

    public void setSemesterMatkul(Integer semesterMatkul) {
        this.semesterMatkul = semesterMatkul;
    }
}
