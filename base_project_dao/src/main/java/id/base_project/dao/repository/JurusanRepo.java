package id.base_project.dao.repository;

import id.base_project.dao.entity.JurusanEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JurusanRepo extends JpaRepository<JurusanEntity, String> {
}
