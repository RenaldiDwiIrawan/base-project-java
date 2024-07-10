package id.base_project.service.impl;


import id.base_project.common.dto.MahasiswaDTO;

import java.util.Optional;

public interface IMahasiswa {

    public MahasiswaDTO addMahasiswa(MahasiswaDTO mahasiswaDTO);

    public MahasiswaDTO getNim(String request);

    public MahasiswaDTO getMahasiswaByBody(MahasiswaDTO request);
}
