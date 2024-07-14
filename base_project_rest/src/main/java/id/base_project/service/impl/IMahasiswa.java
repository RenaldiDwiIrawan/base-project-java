package id.base_project.service.impl;


import id.base_project.common.dto.JurusanDTO;
import id.base_project.common.dto.MahasiswaDTO;
import id.base_project.common.dto.MatkulDTO;
import id.base_project.common.response.Response;

public interface IMahasiswa {

    public Response addMahasiswa(MahasiswaDTO mahasiswaDTO);
    public Response addJurusan(JurusanDTO jurusanDTO);
    public Response addMatkul(MatkulDTO matkulDTO);

    public Response getAllJurusan();
    public Response getAllMatkul();

    public Response getAllMahasiswa();
    public Response getAllMahasiswa2();
    public Response getAllMahasiswa3();

    public Response getMahasiswaByNim(String request);

    public void deleteMahasiswaByNim (String nim);

}
