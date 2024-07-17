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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    Logger log = LoggerFactory.getLogger(CrudAPI.class);

    private static final String SUCCESS_ADD_MAHASISWA = " Add Mahasiswa Success";
    private static final String SUCCESS_ADD_JURUSAN = " Add Jurusan Success";
    private static final String SUCCESS_ADD_MATKUL = " Add Matkul Success";
    private static final String SUCCESS = " Success";
    private static final String SUCCESS_UPDATE_MAHASISWA = " Update Mahasiswa Success";
    private static final String SUCCESS_UPDATE_JURUSAN = " Update Jurusan Success";
    private static final String SUCCESS_UPDATE_MATKUL = " Update Matkul Success";
    private static final String DELETE_SUCCESS = " Delete Success";
    private static final String DELETE_NOT_SUCCESS = "Delete Not Success";
    private static final String ID_NOT_FOUND = "ID NOT FOUND";

    private Response response = new Response();


    @Override
    public Response addMahasiswa(MahasiswaDTO request) {
        MahasiswaJoinDTO filled = new MahasiswaJoinDTO();
        String codeJurusan = request.getJurusan();

        mapperCodeJurusan(codeJurusan);
        mapperMahasiswa(request);

        filled.setNim(mapperMahasiswa(request).getNim());
        filled.setNamaMahasiswa(mapperMahasiswa(request).getNamaMahasiswa());
        filled.setSemesterMahasiswa(mapperMahasiswa(request).getSemesterMahasiswa());
        filled.setActiveMahasiswa(mapperMahasiswa(request).getActiveMahasiswa());
        filled.setJurusan(mapperCodeJurusan(codeJurusan));

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
        log.info("get all mahasiswa success");
        return response;
    }

    @Override
    public Response getAllJurusan() {
        response.setData(jurusanRepo.findAll());
        response.setPesan(SUCCESS);
        response.setStatus(HttpStatus.OK);
        log.info("get all jurusan success");
        return response;
    }

    @Override
    public Response getAllMatkul() {
        response.setData(matkulRepo.findAll());
        response.setPesan(SUCCESS);
        response.setStatus(HttpStatus.OK);
        log.info("get all matkkul success");
        return response;
    }


    @Override
    public Response getAllMahasiswa2() {
        List<MahasiswaEntity> mahasiswaEntities = mahasiswaRepo.findAll();
        List<MahasiswaDTO> mahasiswaDTOList = mahasiswaEntities.stream().map(this::from).collect(Collectors.toList());

        response.setData(mahasiswaDTOList);
        response.setPesan(SUCCESS);
        response.setStatus(HttpStatus.OK);
        log.info("get all mahasiswa with java double collon success");
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
        log.info("get all mahasiswa with java stream map success");
        return response;
    }

    @Override
    public Response getMahasiswaByNim(String request) {
        Optional<MahasiswaEntity> getNim = mahasiswaRepo.findByNim(request);
        response.setData(getNim);
        response.setPesan(SUCCESS);
        response.setStatus(HttpStatus.OK);
        log.info("get mahasiswa by nim " + request);
        return response;
    }

    @Override
    public Response getJurusanByNamaJurusan(String namaJurusan) {
        Optional<JurusanEntity> getNamaJurusan = jurusanRepo.findByNamaJurusan(namaJurusan);
        response.setData(getNamaJurusan);
        response.setPesan(SUCCESS);
        response.setStatus(HttpStatus.OK);
        log.info("get jurusan by nama " + namaJurusan);
        return response;
    }

    @Override
    public Response getMatkulByNamaMatkul(String namaMatkul) {
        Optional<MatkulEntity> getNamaMatkul = matkulRepo.findByNamaMatkul(namaMatkul);
        response.setData(getNamaMatkul);
        response.setPesan(SUCCESS);
        response.setStatus(HttpStatus.OK);
        log.info("get matkul by nama " + namaMatkul);
        return response;
    }

    @Override
    public Response updateMahasiswaById(MahasiswaDTO request, Long idMahasiswa) {
        Optional<MahasiswaEntity> getIdMahasiswa = mahasiswaRepo.findById(idMahasiswa);

        if (!getIdMahasiswa.isPresent()){
            log.info("update mahasiswa by id failed");
            throw new FailedException(ID_NOT_FOUND);
        }

        response.setData(mapperUpdateMahasiswa(request, getIdMahasiswa));
        response.setPesan(SUCCESS_UPDATE_MAHASISWA);
        response.setStatus(HttpStatus.OK);
        return response;
    }

    @Override
    public Response updateJurusanById(JurusanDTO request, Long idJurusan) {
        Optional<JurusanEntity> getIdJurusan = jurusanRepo.findById(idJurusan);

        if (!getIdJurusan.isPresent()){
            log.info("update jurusan by id failed" + idJurusan);
            throw new FailedException(ID_NOT_FOUND);
        }
        response.setData(mapperUpdateJurusan(request,getIdJurusan));
        response.setPesan(SUCCESS);
        response.setStatus(HttpStatus.OK);
        return response;
    }

    @Override
    public Response updateMatkulById(MatkulDTO request, Long idMatkul) {
        Optional<MatkulEntity> getIdMatkul = matkulRepo.findById(idMatkul);

        if (!getIdMatkul.isPresent()){
            log.error("update matkul by id failed" + idMatkul);
            throw new FailedException(ID_NOT_FOUND);
        }
        response.setData(mapperUpdateMatkul(request, getIdMatkul));
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
            log.error("delete mahasiswa by id failed " + id);
            return response;
        } else {
            mahasiswaRepo.deleteById(id);
            response.setData(getNim);
            response.setPesan("Nim " + id + DELETE_SUCCESS);
            response.setStatus(HttpStatus.OK);
            log.info("delete mahasiswa by id success" + id);
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
            log.info("delete jurusan by id failed " + id);
            return response;
        } else {
            jurusanRepo.deleteById(id);
            response.setData(getJurusan);
            response.setPesan("ID " + id + " Berhasil di hapus");
            response.setStatus(HttpStatus.OK);
            log.info("delete jurusan success" + id);
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
            log.error("delete matkul by id failed " + id);
            return response;
        } else {
            matkulRepo.deleteById(id);
            response.setData(getMatkul);
            response.setPesan("ID " + id + " Berhasil di hapus");
            response.setStatus(HttpStatus.OK);
            log.info("delete matkul by id success" + id);
            return response;
        }
    }


    private JurusanDTO mapperCodeJurusan(String codeJurusan) {
        Optional<JurusanEntity> getJurusanEntity = jurusanRepo.findByCodeJurusan(codeJurusan);
        JurusanDTO jurusanDTO = new JurusanDTO();
        if (getJurusanEntity.isPresent()) {
            jurusanDTO.setCodeJurusan(getJurusanEntity.get().getCodeJurusan());
            jurusanDTO.setNamaJurusan(getJurusanEntity.get().getNamaJurusan());
            jurusanDTO.setFakultas(getJurusanEntity.get().getFakultas());
            log.info("mapper jurusan to mahasiswa");
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
        log.info("mahasiswa save success");
        return mahasiswaEntity;
    }

    private JurusanEntity mapperJurusan(JurusanDTO request) {
        JurusanEntity jurusanEntity = new JurusanEntity();

        jurusanEntity.setCodeJurusan(request.getCodeJurusan());
        jurusanEntity.setNamaJurusan(request.getNamaJurusan());
        jurusanEntity.setFakultas(request.getFakultas());
        jurusanEntity = jurusanRepo.save(jurusanEntity);
        log.info("jurusan save success");
        return jurusanEntity;
    }


    private MatkulEntity mapperMatkul(MatkulDTO request) {
        MatkulEntity matkulEntity = new MatkulEntity();
        matkulEntity.setCodeMatkul(request.getCodeMatkul());
        matkulEntity.setNamaMatkul(request.getNamaMatkul());
        matkulEntity.setSksMatkul(request.getSksMatkul());
        matkulEntity.setSemesterMatkul(request.getSemesterMatkul());
        matkulEntity = matkulRepo.save(matkulEntity);
        log.info("matkul save success");
        return matkulEntity;
    }

    private MahasiswaEntity mapperUpdateMahasiswa(MahasiswaDTO request, Optional<MahasiswaEntity> getIdMahasiswa) {
        MahasiswaEntity mahasiswa = getIdMahasiswa.get();
        mahasiswa.setNim(request.getNim());
        mahasiswa.setNamaMahasiswa(request.getNamaMahasiswa());
        mahasiswa.setSemesterMahasiswa(request.getSemesterMahasiswa());
        mahasiswa.setActiveMahasiswa(request.isMahasiswaActive());
        mahasiswa.setJurusan(request.getJurusan());
        mahasiswa = mahasiswaRepo.save(mahasiswa);
        log.info("mahasiswa update success");
        return mahasiswa;
    }

    private JurusanEntity mapperUpdateJurusan(JurusanDTO request, Optional<JurusanEntity> getIdJurusan) {
        JurusanEntity jurusan = getIdJurusan.get();
        jurusan.setCodeJurusan(request.getCodeJurusan());
        jurusan.setNamaJurusan(request.getNamaJurusan());
        jurusan.setFakultas(request.getFakultas());
        jurusan = jurusanRepo.save(jurusan);
        log.info("jurusan update success");
        return jurusan;
    }

    private MatkulEntity mapperUpdateMatkul(MatkulDTO request, Optional<MatkulEntity> getIdMatkul) {
        MatkulEntity matkul = getIdMatkul.get();
        matkul.setCodeMatkul(request.getCodeMatkul());
        matkul.setNamaMatkul(request.getNamaMatkul());
        matkul.setSemesterMatkul(request.getSemesterMatkul());
        matkul.setSksMatkul(request.getSksMatkul());
        matkul = matkulRepo.save(matkul);
        log.info("matkul update success");
        return matkul;
    }

}
