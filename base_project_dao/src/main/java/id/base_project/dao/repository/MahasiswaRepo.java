package id.base_project.dao.repository;

import id.base_project.common.dto.MahasiswaDTO;
import id.base_project.common.dto.SemesterDTO;
import id.base_project.dao.entity.MahasiswaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MahasiswaRepo extends JpaRepository<MahasiswaEntity, Long> {
    Optional<MahasiswaEntity> findByNim(String nim);
    void deleteByNim(String nim);

    @Query(value = "SELECT * FROM MAHASISWA " +
            "WHERE NAMA_MAHASISWA=:namaMahasiswa " +
            "AND SEMESTER_MAHASISWA=:semesterMahasiswa ", nativeQuery = true)
    List<MahasiswaEntity> findNamaAndSemester(@Param("namaMahasiswa") String namaMahasiswa, @Param("semesterMahasiswa") Integer semesterMahasiswa);


    @Query(value = "SELECT * FROM MAHASISWA " +
            "WHERE SEMESTER_MAHASISWA=:semesterMahasiswa ", nativeQuery = true)
    List<MahasiswaEntity> findSemester(@Param("semesterMahasiswa") Integer semesterMahasiswa);

    @Query(value = "SELECT m.* " +
            "FROM MAHASISWA m " +
            "INNER JOIN JURUSAN j ON m.jurusan = j.code_jurusan " +
            "WHERE m.jurusan = :jurusan " +
            "AND j.CODE_JURUSAN=:codeJurusan", nativeQuery = true)
    List<MahasiswaEntity> findJoinNamaMahasiswaAndJurusan(@Param("jurusan") String jurusan, @Param("codeJurusan") String codeJurusan);

    @Query(value = "SELECT m.* " +
            "FROM MAHASISWA m " +
            "INNER JOIN MATKUL MAT ON m.semester_mahasiswa = mat.semester_matkul " +
            "WHERE m.semester_mahasiswa=:semesterMahasiswa " +
            "AND mat.semester_matkul=:semesterMatkul ", nativeQuery = true)
    List<MahasiswaEntity> findJoinNamaMahasiswaAndMatkul(Integer semesterMahasiswa, Integer semesterMatkul);
}
