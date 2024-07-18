package id.base_project.common.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class MatkulDTO {

    @Getter
    @Setter
    String codeMatkul;

    @Getter @Setter
    String namaMatkul;

    @Getter @Setter
    Integer sksMatkul;

    @Getter @Setter
    Integer semesterMatkul;
}
