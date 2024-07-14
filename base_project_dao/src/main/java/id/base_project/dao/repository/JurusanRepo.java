package id.base_project.dao.repository;

import id.base_project.dao.entity.JurusanEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface JurusanRepo extends JpaRepository<JurusanEntity, String> {
    Optional<JurusanEntity> findByCodeJurusan(String codeJurusan);
}
