package id.base_project.service.impl;

import id.base_project.common.dto.JurusanDTO;
import id.base_project.common.dto.MahasiswaDTO;
import id.base_project.common.dto.MahasiswaJoinDTO;
import id.base_project.common.dto.MatkulDTO;
import id.base_project.common.exception.FailedException;
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

import javax.transaction.Transactional;
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
        response.setPesan("Add Mahasiswa Success");
        response.setStatus(HttpStatus.OK);

        return response;
    }

    @Override
    public Response addJurusan(JurusanDTO request) {
        response.setData(mapperJurusan(request));
        response.setPesan("Add Jurusan Success");
        response.setStatus(HttpStatus.OK);
        return response;
    }

    @Override
    public Response addMatkul(MatkulDTO request) {
        response.setData(mapperMatkul(request));
        response.setPesan("Add Matkul Success");
        response.setStatus(HttpStatus.OK);
        return response;
    }

    @Override
    public Response getAllMahasiswa() {
        response.setData(mahasiswaRepo.findAll());
        response.setPesan("Success");
        response.setStatus(HttpStatus.OK);
        return response;
    }

    @Override
    public Response getAllJurusan() {
        response.setData(jurusanRepo.findAll());
        response.setPesan("Success");
        response.setStatus(HttpStatus.OK);
        return response;
    }

    @Override
    public Response getAllMatkul() {
        response.setData(matkulRepo.findAll());
        response.setPesan("Success");
        response.setStatus(HttpStatus.OK);
        return response;
    }


    @Override
    public Response getAllMahasiswa2() {
        List<MahasiswaEntity> mahasiswaEntities = mahasiswaRepo.findAll();
        List<MahasiswaDTO> mahasiswaDTOList = mahasiswaEntities.stream().map(this::from).collect(Collectors.toList());

        response.setData(mahasiswaDTOList);
        response.setPesan("Success");
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
        response.setPesan("Success");
        response.setStatus(HttpStatus.OK);
        return response;
    }

    @Override
    public Response getMahasiswaByNim(String request) {
        Optional<MahasiswaEntity> getNim = mahasiswaRepo.findByNim(request);

        response.setData(getNim);
        response.setPesan("Success");
        response.setStatus(HttpStatus.OK);
        return response;
    }

    @Override
    @Transactional
    public void deleteMahasiswaByNim(String nim) {
        Optional<MahasiswaEntity> getNim = mahasiswaRepo.findByNim(nim);
        if (getNim.isPresent()){
            System.out.println("Nim " + nim + " akan di hapus");
            mahasiswaRepo.deleteByNim(nim);
        } else {
            throw new FailedException("Nim : " +nim+" Tidak ada");
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
