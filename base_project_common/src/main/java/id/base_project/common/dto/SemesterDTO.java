package id.base_project.common.dto;

import lombok.*;

@Data
public class SemesterDTO {

    @Getter @Setter
    private MahasiswaDTO mahasiswaDTO;

    @Getter @Setter
    private MatkulDTO matkulDTO;
}
