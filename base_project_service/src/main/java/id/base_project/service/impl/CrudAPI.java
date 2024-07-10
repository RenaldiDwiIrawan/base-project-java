package id.base_project.service.impl;

import id.base_project.common.dto.JurusanDTO;
import id.base_project.common.dto.MahasiswaDTO;
import id.base_project.common.dto.MahasiswaJoinDTO;
import id.base_project.common.dto.MatkulDTO;
import id.base_project.common.exception.FailedException;
import id.base_project.dao.entity.JurusanEntity;
import id.base_project.dao.entity.MahasiswaEntity;
import id.base_project.dao.entity.MatkulEntity;
import id.base_project.dao.repository.JurusanRepo;
import id.base_project.dao.repository.MahasiswaRepo;
import id.base_project.dao.repository.MatkulRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Component
public class CrudAPI implements IMahasiswa {

    @Autowired
    private MahasiswaRepo mahasiswaRepo;

    @Autowired
    private JurusanRepo jurusanRepo;

    @Autowired
    private MatkulRepo matkulRepo;

    @Override
    public MahasiswaDTO addMahasiswa(MahasiswaDTO request) {
        MahasiswaEntity mahasiswaEntity = new MahasiswaEntity();
        MahasiswaDTO response = new MahasiswaDTO();

        mahasiswaEntity.setNim(request.getNIM());
        mahasiswaEntity.setNamaMahasiswa(request.getNamaMahasiswa());
        mahasiswaEntity.setSemesterMahasiswa(request.getSemesterMahasiswa());
        mahasiswaEntity.setActiveMahasiswa(request.isMahasiswaActive());
        mahasiswaEntity = mahasiswaRepo.save(mahasiswaEntity);

        response.setNIM(mahasiswaEntity.getNim());
        response.setNamaMahasiswa(mahasiswaEntity.getNamaMahasiswa());
        response.setSemesterMahasiswa(mahasiswaEntity.getSemesterMahasiswa());
        response.setMahasiswaActive(mahasiswaEntity.getActiveMahasiswa());
        return response;
    }

    @Override
    public JurusanDTO addJurusan(JurusanDTO request) {
        JurusanEntity jurusanEntity = new JurusanEntity();
        JurusanDTO response = new JurusanDTO();

        jurusanEntity.setCodeJurusan(request.getCodeJurusan());
        jurusanEntity.setNamaJurusan(request.getNamaJurusan());
        jurusanEntity.setFakultas(request.getFakultas());
        jurusanEntity = jurusanRepo.save(jurusanEntity);

        response.setCodeJurusan(jurusanEntity.getCodeJurusan());
        response.setNamaJurusan(jurusanEntity.getNamaJurusan());
        response.setFakultas(jurusanEntity.getFakultas());

        return response;
    }

    @Override
    public MatkulDTO addMatkul(MatkulDTO request) {
        MatkulEntity matkulEntity = new MatkulEntity();
        MatkulDTO response = new MatkulDTO();

        matkulEntity.setCodeMatkul(request.getCodeMatkul());
        matkulEntity.setNamaMatkul(request.getNamaMatkul());
        matkulEntity.setSksMatkul(request.getSksMatkul());
        matkulEntity.setSemesterMatkul(request.getSemesterMatkul());
        matkulEntity = matkulRepo.save(matkulEntity);

        response.setCodeMatkul(matkulEntity.getCodeMatkul());
        response.setNamaMatkul(matkulEntity.getNamaMatkul());
        response.setSksMatkul(matkulEntity.getSksMatkul());
        response.setSemesterMatkul(matkulEntity.getSemesterMatkul());

        return response;
    }

    @Override
    public List<MahasiswaEntity> getAllMahasiswa() {
        return mahasiswaRepo.findAll();
    }

    @Override
    public List<JurusanEntity> getAllJurusan() {
        return jurusanRepo.findAll();
    }

    @Override
    public List<MatkulEntity> getAllMatkul() {
        return matkulRepo.findAll();
    }


    @Override
    public MahasiswaJoinDTO getNim(String request) {
        Optional<MahasiswaEntity> getNim = mahasiswaRepo.findById(request);
        if (!getNim.isPresent()){
            throw new FailedException("Data Tidak Ada");
        }

        MahasiswaJoinDTO response = new MahasiswaJoinDTO();
        response.setNIM(getNim.get().getNim());
        response.setNamaMahasiswa(getNim.get().getNamaMahasiswa());
        response.setMahasiswaActive(getNim.get().getActiveMahasiswa());
        return response;
    }

    @Override
    public MahasiswaJoinDTO getMahasiswaByBody(MahasiswaJoinDTO request) {
        return null;
    }


}
