package id.base_project.service.impl;


import id.base_project.common.dto.JurusanDTO;
import id.base_project.common.dto.MahasiswaDTO;
import id.base_project.common.dto.MatkulDTO;
import id.base_project.common.response.Response;

import javax.transaction.Transactional;

public interface IMahasiswa {

    Response addMahasiswa(MahasiswaDTO mahasiswaDTO);
    Response addJurusan(JurusanDTO jurusanDTO);
    Response addMatkul(MatkulDTO matkulDTO);

    Response getAllJurusan();
    Response getAllMatkul();

    Response getAllMahasiswa();
    Response getAllMahasiswa2();
    Response getAllMahasiswa3();

    Response getMahasiswaByNim(String request);
    Response getJurusanByNamaJurusan(String namaJurusan);
    Response getMatkulByNamaMatkul(String namaMatkul);


    @Transactional
    Response deleteMahasiswaById(Long id);

    @Transactional
    Response deleteJurusanById(Long id);
    @Transactional
    Response deleteMatkulById(Long id);
}
