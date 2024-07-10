package id.base_project.service.rest;


import id.base_project.common.dto.JurusanDTO;
import id.base_project.common.dto.MahasiswaDTO;
import id.base_project.common.dto.MahasiswaJoinDTO;
import id.base_project.common.dto.MatkulDTO;
import id.base_project.dao.entity.JurusanEntity;
import id.base_project.dao.entity.MahasiswaEntity;
import id.base_project.dao.entity.MatkulEntity;
import id.base_project.service.impl.IMahasiswa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("base-project/")
public class RestAPI  {

    @Autowired
    private IMahasiswa implMahasiswa;

    @GetMapping("testAPI")
    public String testAPI(){
        String hasil = "test api berhasil";
        return hasil;
    }

    @PostMapping("addMahasiswa")
    public MahasiswaDTO tambahMahasiswa(@RequestBody MahasiswaDTO request){
        return implMahasiswa.addMahasiswa(request);
    }

    @PostMapping("addJurusan")
    public JurusanDTO tambahJurusan(@RequestBody JurusanDTO request){
        return implMahasiswa.addJurusan(request);
    }

    @PostMapping("addMatkul")
    public MatkulDTO tambahMatkul(@RequestBody MatkulDTO request){
        return implMahasiswa.addMatkul(request);
    }

    @GetMapping("getAllMahasiswa")
    public List<MahasiswaEntity> getAllMahasiswa(){
     return implMahasiswa.getAllMahasiswa();
    }

    @GetMapping("getAllJurusan")
    public List<JurusanEntity> getAllJurusan(){
        return implMahasiswa.getAllJurusan();
    }

    @GetMapping("getAllMatkul")
    public List<MatkulEntity> getAllMatkul(){
        return implMahasiswa.getAllMatkul();
    }

    @GetMapping("getNimMahasiswa/{nim}")
    public MahasiswaJoinDTO getNim(@PathVariable ("nim") String nim){
        return implMahasiswa.getNim(nim);
    }

    @GetMapping("getMahasiswa/getByBody")
    public MahasiswaJoinDTO getMahasiswaByBody (@RequestBody MahasiswaJoinDTO request){
        return null;
    }
}
