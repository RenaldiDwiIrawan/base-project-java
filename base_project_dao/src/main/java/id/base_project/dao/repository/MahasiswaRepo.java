package id.base_project.dao.repository;

import id.base_project.dao.entity.MahasiswaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MahasiswaRepo extends JpaRepository<MahasiswaEntity, Long> {
    Optional<MahasiswaEntity> findByNim(String nim);
    void deleteByNim(String nim);
}
