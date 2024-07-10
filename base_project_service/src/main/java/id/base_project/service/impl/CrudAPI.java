package id.base_project.service.impl;

import id.base_project.common.dto.MahasiswaDTO;
import id.base_project.common.exception.FailedException;
import id.base_project.dao.entity.MahasiswaEntity;
import id.base_project.dao.repository.MahasiswaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Component
public class CrudAPI implements IMahasiswa {
    @Autowired
    private MahasiswaRepo mahasiswaRepo;

    @Override
    public MahasiswaDTO addMahasiswa(MahasiswaDTO mahasiswaDTO) {
        MahasiswaEntity mahasiswaEntity = new MahasiswaEntity();
        MahasiswaDTO response = new MahasiswaDTO();

        mahasiswaEntity.setNim(mahasiswaDTO.getNIM());
        mahasiswaEntity.setNamaMahasiswa(mahasiswaDTO.getNamaMahasiswa());
        mahasiswaEntity.setActiveMahasiswa(mahasiswaDTO.getMahasiswaActive());
        mahasiswaEntity = mahasiswaRepo.save(mahasiswaEntity);

        response.setNIM(mahasiswaEntity.getNim());
        response.setNamaMahasiswa(mahasiswaEntity.getNamaMahasiswa());
        response.setMahasiswaActive(mahasiswaEntity.getActiveMahasiswa());
        return response;
    }

    @Override
    public MahasiswaDTO getNim(String request) {
        Optional<MahasiswaEntity> getNim = mahasiswaRepo.findById(request);
        if (!getNim.isPresent()){
            throw new FailedException("Data Tidak Ada");
        }

        MahasiswaDTO response = new MahasiswaDTO();
        response.setNIM(getNim.get().getNim());
        response.setNamaMahasiswa(getNim.get().getNamaMahasiswa());
        response.setMahasiswaActive(getNim.get().getActiveMahasiswa());
        return response;
    }

    @Override
    public MahasiswaDTO getMahasiswaByBody(MahasiswaDTO request) {
        return null;
    }


}
