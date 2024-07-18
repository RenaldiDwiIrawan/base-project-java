package id.base_project.common.dto;


import lombok.*;

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
