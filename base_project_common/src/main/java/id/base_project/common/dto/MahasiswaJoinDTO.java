package id.base_project.common.dto;


import id.base_project.dao.entity.JurusanEntity;
import id.base_project.dao.entity.MatkulEntity;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class MahasiswaJoinDTO {

    @Getter @Setter
    String namaMahasiswa;

    @Getter @Setter
    String nim;

    @Getter @Setter
    Integer semesterMahasiswa;

    @Getter @Setter
    boolean activeMahasiswa;

    @Getter @Setter
    JurusanDTO Jurusan;

}
