package id.base_project.dao.repository;

import id.base_project.dao.entity.MatkulEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MatkulRepo extends JpaRepository<MatkulEntity, Long> {
    Optional<MatkulEntity> findByCodeMatkul(String codeMatkul);
}
