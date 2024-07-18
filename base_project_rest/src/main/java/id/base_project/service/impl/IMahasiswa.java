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

    Response updateMahasiswaById(MahasiswaDTO request, Long idMahasiswa);
    Response updateJurusanById(JurusanDTO request, Long idJurusan);
    Response updateMatkulById(MatkulDTO request, Long idMatkul);

    @Transactional
    Response deleteMahasiswaById(Long id);
    @Transactional
    Response deleteJurusanById(Long id);
    @Transactional
    Response deleteMatkulById(Long id);

    Response getQueryNativeMahasiswa(String namaMahasiswa, Integer semesterMahasiswa);

    Response getQueryNativeSemesterMahasiswa(Integer semesterMahasiswa);

    Response getQueryNativeMahasiswaJurusan(String jurusan, String codeJurusan);

    Response getQueryNativeMahasiswaMatkul(Integer semesterMahasiswa, Integer semesterMatkul);
}
