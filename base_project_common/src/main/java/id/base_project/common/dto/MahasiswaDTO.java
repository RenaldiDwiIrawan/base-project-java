package id.base_project.common.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class MahasiswaDTO {

    @Getter
    @Setter
    String namaMahasiswa;

    @Getter @Setter
    String nim;

    @Getter @Setter
    Integer semesterMahasiswa;

    @Getter @Setter
    boolean mahasiswaActive;

    @Getter @Setter
    String jurusan;


}
