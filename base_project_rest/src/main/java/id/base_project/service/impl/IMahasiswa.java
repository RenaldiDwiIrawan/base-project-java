package id.base_project.service.impl;


import id.base_project.common.dto.JurusanDTO;
import id.base_project.common.dto.MahasiswaDTO;
import id.base_project.common.dto.MahasiswaJoinDTO;
import id.base_project.common.dto.MatkulDTO;
import id.base_project.dao.entity.JurusanEntity;
import id.base_project.dao.entity.MahasiswaEntity;
import id.base_project.dao.entity.MatkulEntity;

import java.util.List;

public interface IMahasiswa {

    public MahasiswaDTO addMahasiswa(MahasiswaDTO mahasiswaDTO);
    public JurusanDTO addJurusan(JurusanDTO jurusanDTO);
    public MatkulDTO addMatkul(MatkulDTO matkulDTO);

    public List<MahasiswaEntity> getAllMahasiswa();
    public List<JurusanEntity> getAllJurusan();
    public List<MatkulEntity> getAllMatkul();
    public MahasiswaJoinDTO getNim(String request);

    public MahasiswaJoinDTO getMahasiswaByBody(MahasiswaJoinDTO request);
}
