package id.base_project.common.dto;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class JurusanDTO {

    @Getter @Setter
    String codeJurusan;

    @Getter @Setter
    String namaJurusan;

    @Getter @Setter
    String fakultas;

}
