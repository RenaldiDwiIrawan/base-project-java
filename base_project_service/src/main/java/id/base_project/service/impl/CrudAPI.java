package id.base_project.service.impl;

import id.base_project.common.dto.JurusanDTO;
import id.base_project.common.dto.MahasiswaDTO;
import id.base_project.common.dto.MahasiswaJoinDTO;
import id.base_project.common.dto.MatkulDTO;
import id.base_project.common.response.Response;
import id.base_project.dao.entity.JurusanEntity;
import id.base_project.dao.entity.MahasiswaEntity;
import id.base_project.dao.entity.MatkulEntity;
import id.base_project.dao.repository.JurusanRepo;
import id.base_project.dao.repository.MahasiswaRepo;
import id.base_project.dao.repository.MatkulRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Component
public class CrudAPI implements IMahasiswa {

    @Autowired
    private MahasiswaRepo mahasiswaRepo;

    @Autowired
    private JurusanRepo jurusanRepo;

    @Autowired
    private MatkulRepo matkulRepo;

    static final String SUCCESS_ADD_MAHASISWA = " Add Mahasiswa Success";
    static final String SUCCESS_ADD_JURUSAN = " Add Jurusan Success";
    static final String SUCCESS_ADD_MATKUL = " Add Matkul Success";
    static final String SUCCESS = " Success";
    static final String DELETE_SUCCESS = " Delete Success";
    static final String DELETE_NOT_SUCCESS = "Delete Not Success";
    private Response response = new Response();


    @Override
    public Response addMahasiswa(MahasiswaDTO request) {
        MahasiswaJoinDTO filled = new MahasiswaJoinDTO();
        String codeJurusan = request.getJurusan();
        String codeMatkul = request.getMatkul();

        mapperCodeJurusan(codeJurusan);
        mapperCodeMatkul(codeMatkul);
        mapperMahasiswa(request);

        filled.setNim(mapperMahasiswa(request).getNim());
        filled.setNamaMahasiswa(mapperMahasiswa(request).getNamaMahasiswa());
        filled.setSemesterMahasiswa(mapperMahasiswa(request).getSemesterMahasiswa());
        filled.setActiveMahasiswa(mapperMahasiswa(request).getActiveMahasiswa());
        filled.setJurusan(mapperCodeJurusan(codeJurusan));
        filled.setMatkul(mapperCodeMatkul(codeMatkul));

        response.setData(filled);
        response.setPesan(SUCCESS_ADD_MAHASISWA);
        response.setStatus(HttpStatus.OK);

        return response;
    }

    @Override
    public Response addJurusan(JurusanDTO request) {
        response.setData(mapperJurusan(request));
        response.setPesan(SUCCESS_ADD_JURUSAN);
        response.setStatus(HttpStatus.OK);
        return response;
    }

    @Override
    public Response addMatkul(MatkulDTO request) {
        response.setData(mapperMatkul(request));
        response.setPesan(SUCCESS_ADD_MATKUL);
        response.setStatus(HttpStatus.OK);
        return response;
    }

    @Override
    public Response getAllMahasiswa() {
        response.setData(mahasiswaRepo.findAll());
        response.setPesan(SUCCESS);
        response.setStatus(HttpStatus.OK);
        return response;
    }

    @Override
    public Response getAllJurusan() {
        response.setData(jurusanRepo.findAll());
        response.setPesan(SUCCESS);
        response.setStatus(HttpStatus.OK);
        return response;
    }

    @Override
    public Response getAllMatkul() {
        response.setData(matkulRepo.findAll());
        response.setPesan(SUCCESS);
        response.setStatus(HttpStatus.OK);
        return response;
    }


    @Override
    public Response getAllMahasiswa2() {
        List<MahasiswaEntity> mahasiswaEntities = mahasiswaRepo.findAll();
        List<MahasiswaDTO> mahasiswaDTOList = mahasiswaEntities.stream().map(this::from).collect(Collectors.toList());

        response.setData(mahasiswaDTOList);
        response.setPesan(SUCCESS);
        response.setStatus(HttpStatus.OK);
        return response;
    }

    private MahasiswaDTO from(MahasiswaEntity mahasiswaEntity){
        MahasiswaDTO dto = new MahasiswaDTO();

            dto.setNim(mahasiswaEntity.getNim());
            dto.setNamaMahasiswa(mahasiswaEntity.getNamaMahasiswa());
            dto.setSemesterMahasiswa(mahasiswaEntity.getSemesterMahasiswa());
            dto.setMahasiswaActive(mahasiswaEntity.getActiveMahasiswa());
            dto.setJurusan(mahasiswaEntity.getJurusan());

            return dto;
    }

    @Override
    public Response getAllMahasiswa3(){
        List<MahasiswaEntity> mahasiswaEntities = mahasiswaRepo.findAll();
        List<MahasiswaDTO> mahasiswaDTOList = mahasiswaEntities.stream().map(mahasiswaEntity -> {

            MahasiswaDTO dto = new MahasiswaDTO();

            dto.setNim(mahasiswaEntity.getNim());
            dto.setNamaMahasiswa(mahasiswaEntity.getNamaMahasiswa());
            dto.setSemesterMahasiswa(mahasiswaEntity.getSemesterMahasiswa());
            dto.setMahasiswaActive(mahasiswaEntity.getActiveMahasiswa());
            dto.setJurusan(mahasiswaEntity.getJurusan());
            return dto;

        }).collect(Collectors.toList());

        response.setData(mahasiswaDTOList);
        response.setPesan(SUCCESS);
        response.setStatus(HttpStatus.OK);
        return response;
    }

    @Override
    public Response getMahasiswaByNim(String request) {
        Optional<MahasiswaEntity> getNim = mahasiswaRepo.findByNim(request);
        response.setData(getNim);
        response.setPesan(SUCCESS);
        response.setStatus(HttpStatus.OK);
        return response;
    }

    @Override
    public Response getJurusanByNamaJurusan(String namaJurusan) {
        Optional<JurusanEntity> getNamaJurusan = jurusanRepo.findByNamaJurusan(namaJurusan);
        response.setData(getNamaJurusan);
        response.setPesan(SUCCESS);
        response.setStatus(HttpStatus.OK);
        return response;
    }

    @Override
    public Response getMatkulByNamaMatkul(String namaMatkul) {
        Optional<MatkulEntity> getNamaMatkul = matkulRepo.findByNamaMatkul(namaMatkul);
        response.setData(getNamaMatkul);
        response.setPesan(SUCCESS);
        response.setStatus(HttpStatus.OK);
        return response;
    }

    @Override
    public Response deleteMahasiswaById(Long id) {
        Optional<MahasiswaEntity> getNim = mahasiswaRepo.findById(id);

        if (!getNim.isPresent()) {
            response.setData(id);
            response.setPesan("Nim " + id + DELETE_NOT_SUCCESS);
            response.setStatus(HttpStatus.NOT_FOUND);
            return response;
        } else {
            mahasiswaRepo.deleteById(id);
            response.setData(getNim);
            response.setPesan("Nim " + id + DELETE_SUCCESS);
            response.setStatus(HttpStatus.OK);
            return response;
        }
    }


    @Override
    public Response deleteJurusanById(Long id) {
        Optional<JurusanEntity> getJurusan = jurusanRepo.findById(id);

        if (!getJurusan.isPresent()) {
            response.setData(id);
            response.setPesan("ID " + id + " Tidak tersedia");
            response.setStatus(HttpStatus.NOT_FOUND);
            return response;
        } else {
            jurusanRepo.deleteById(id);
            response.setData(getJurusan);
            response.setPesan("ID " + id + " Berhasil di hapus");
            response.setStatus(HttpStatus.OK);
            return response;
        }
    }

    @Override
    public Response deleteMatkulById(Long id) {
        Optional<MatkulEntity> getMatkul = matkulRepo.findById(id);

        if (!getMatkul.isPresent()) {
            response.setData(id);
            response.setPesan("ID " + id + " Tidak tersedia");
            response.setStatus(HttpStatus.NOT_FOUND);
            return response;
        } else {
            matkulRepo.deleteById(id);
            response.setData(getMatkul);
            response.setPesan("ID " + id + " Berhasil di hapus");
            response.setStatus(HttpStatus.OK);
            return response;
        }
    }

    private MatkulDTO mapperCodeMatkul(String codeMatkul) {
        Optional<MatkulEntity> getMatkulEntity = matkulRepo.findByCodeMatkul(codeMatkul);
        MatkulDTO matkulDTO = new MatkulDTO();
        if (getMatkulEntity.isPresent()){
            matkulDTO.setCodeMatkul(getMatkulEntity.get().getCodeMatkul());
            matkulDTO.setNamaMatkul(getMatkulEntity.get().getNamaMatkul());
            matkulDTO.setSemesterMatkul(getMatkulEntity.get().getSemesterMatkul());
            matkulDTO.setSksMatkul(getMatkulEntity.get().getSksMatkul());
        }
        return matkulDTO;
    }

    private JurusanDTO mapperCodeJurusan(String codeJurusan) {
        Optional<JurusanEntity> getJurusanEntity = jurusanRepo.findByCodeJurusan(codeJurusan);
        JurusanDTO jurusanDTO = new JurusanDTO();
        if (getJurusanEntity.isPresent()) {
            jurusanDTO.setCodeJurusan(getJurusanEntity.get().getCodeJurusan());
            jurusanDTO.setNamaJurusan(getJurusanEntity.get().getNamaJurusan());
            jurusanDTO.setFakultas(getJurusanEntity.get().getFakultas());
        }
        return jurusanDTO;
    }

    private MahasiswaEntity mapperMahasiswa(MahasiswaDTO request) {
        MahasiswaEntity mahasiswaEntity = new MahasiswaEntity();
        mahasiswaEntity.setNim(request.getNim());
        mahasiswaEntity.setNamaMahasiswa(request.getNamaMahasiswa());
        mahasiswaEntity.setSemesterMahasiswa(request.getSemesterMahasiswa());
        mahasiswaEntity.setActiveMahasiswa(request.isMahasiswaActive());
        mahasiswaEntity.setJurusan(request.getJurusan());
        mahasiswaEntity = mahasiswaRepo.save(mahasiswaEntity);
        return mahasiswaEntity;
    }

    private JurusanEntity mapperJurusan(JurusanDTO request) {
        JurusanEntity jurusanEntity = new JurusanEntity();

        jurusanEntity.setCodeJurusan(request.getCodeJurusan());
        jurusanEntity.setNamaJurusan(request.getNamaJurusan());
        jurusanEntity.setFakultas(request.getFakultas());
        jurusanEntity = jurusanRepo.save(jurusanEntity);
        return jurusanEntity;
    }


    private MatkulEntity mapperMatkul(MatkulDTO request) {
        MatkulEntity matkulEntity = new MatkulEntity();
        matkulEntity.setCodeMatkul(request.getCodeMatkul());
        matkulEntity.setNamaMatkul(request.getNamaMatkul());
        matkulEntity.setSksMatkul(request.getSksMatkul());
        matkulEntity.setSemesterMatkul(request.getSemesterMatkul());
        matkulEntity = matkulRepo.save(matkulEntity);

        return matkulEntity;
    }

}
