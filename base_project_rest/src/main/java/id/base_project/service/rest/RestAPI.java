package id.base_project.service.rest;

import id.base_project.common.dto.JurusanDTO;
import id.base_project.common.dto.MahasiswaDTO;
import id.base_project.common.dto.MatkulDTO;
import id.base_project.common.response.Response;
import id.base_project.service.impl.IMahasiswa;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("base-project/")
@Api(value = "Controller-Kampus", tags = {"Kampus"})
public class RestAPI  {

    Logger log = LoggerFactory.getLogger(RestAPI.class);

    @Autowired
    private IMahasiswa implMahasiswa;

    @GetMapping("testAPI")
    public String testAPI(){
        return "test api berhasil";
    }

    @PostMapping("addMahasiswa")
    public Response addMahasiswa(@RequestBody MahasiswaDTO request){
        log.info("addMahasiswa is running");
        return implMahasiswa.addMahasiswa(request);
    }

    @PostMapping("addJurusan")
    public Response addJurusan(@RequestBody JurusanDTO request){
        log.info("addJurusan is running");
        return implMahasiswa.addJurusan(request);
    }

    @PostMapping("addMatkul")
    public Response addMatkul(@RequestBody MatkulDTO request){
        log.info("addMatkul is running");
        return implMahasiswa.addMatkul(request);
    }

    @GetMapping("getAllMahasiswa")
    public Response getAllMahasiswa(){
        log.info("getAllMahasiswa is running");
     return implMahasiswa.getAllMahasiswa();
    }

    @GetMapping("getAllMahasiswa2")
    public Response getAllMahasiswa2(){
        log.info("getAllMahasiswa2 is running");
        return implMahasiswa.getAllMahasiswa2();
    }

    @GetMapping("getAllMahasiswa3")
    public Response getAllMahasiswa3() {
        log.info("getAllMahasiswa3 is running");
        return implMahasiswa.getAllMahasiswa3();
    }

    @GetMapping("getAllJurusan")
    public Response getAllJurusan(){
        log.info("getALlJurusan is running");
        return implMahasiswa.getAllJurusan();
    }

    @GetMapping("getAllMatkul")
    public Response getAllMatkul(){
        log.info("getAllMatkul is running");
        return implMahasiswa.getAllMatkul();
    }

    @GetMapping("getMahasiswaByNim/{nim}")
    public Response getMahasiswaByNim(@PathVariable ("nim") String nim){
        log.info("getMahasiswaByNim is running");
        return implMahasiswa.getMahasiswaByNim(nim);
    }

    @GetMapping("getJurusanByNamaJurusan/{namaJurusan}")
    public Response getJurusanByNamaJurusan (@PathVariable ("namaJurusan") String namaJurusan){
        log.info("getJurusanByNamaJurusan is running");
        return implMahasiswa.getJurusanByNamaJurusan(namaJurusan);
    }

    @GetMapping("getMatkulByNamaMatkul/{namaMatkul}")
    public Response getMatkulByNamaMatkul (@PathVariable ("namaMatkul") String namaMatkul){
        log.info("getMatkulByNamaMatkul is running");
        return implMahasiswa.getMatkulByNamaMatkul(namaMatkul);
    }

    @PutMapping("updateMahasiswaById/{idMahasiswa}")
    public Response updateMahasiswaById (@RequestBody MahasiswaDTO request, @PathVariable ("idMahasiswa") Long idMahasiswa){
        log.info("updateMahasiswaById is running");
        return implMahasiswa.updateMahasiswaById(request, idMahasiswa);
    }

    @PutMapping("updateJurusanById/{idJurusan}")
    public Response updateJurusanById(@RequestBody JurusanDTO request, @PathVariable ("idJurusan") Long idJurusan){
        log.info("updateJurusanById is running");
        return implMahasiswa.updateJurusanById(request, idJurusan);
    }

    @PutMapping("updateMatkulById/{idMatkul}")
    public Response updateMatkulById(@RequestBody MatkulDTO request, @PathVariable ("idMatkul") Long idMatkul){
        log.info("updateMatkulById is running");
        return implMahasiswa.updateMatkulById(request, idMatkul);
    }

    @DeleteMapping("deleteMahasiswaById/{id}")
    public Response deleteMahasiswaById (@PathVariable ("id") Long id){
        return  implMahasiswa.deleteMahasiswaById(id);
    }

    @DeleteMapping("deleteJurusanById/{id}")
    public Response deleteJurusanById (@PathVariable ("id") Long id){
        return  implMahasiswa.deleteJurusanById(id);
    }

    @DeleteMapping("deleteMatkulById/{id}")
    public Response deleteMatkulById (@PathVariable ("id") Long id){
        return  implMahasiswa.deleteMatkulById(id);
    }

    @GetMapping("getQueryNativeMahasiswa")
    public Response getQueryNativeMahasiswa (@RequestParam String namaMahasiswa, @RequestParam Integer semesterMahasiswa){
        return implMahasiswa.getQueryNativeMahasiswa(namaMahasiswa, semesterMahasiswa);
    }

    @GetMapping("getQueryNativeSemesterMahasiswa")
    public Response getQueryNativeSemesterMahasiswa (@RequestParam Integer semesterMahasiswa){
        return implMahasiswa.getQueryNativeSemesterMahasiswa(semesterMahasiswa);
    }

    @GetMapping("getQueryNativeMahasiswaJurusan")
    public Response getQueryNativeMahasiswaJurusan(@RequestParam String jurusan, @RequestParam String codeJurusan){
        return implMahasiswa.getQueryNativeMahasiswaJurusan(jurusan, codeJurusan);
    }

    @GetMapping("getQueryNativeMahasiswaMatkul")
    public Response getQueryNativeMahasiswaMatkul(@RequestParam Integer semesterMahasiswa, @RequestParam Integer semesterMatkul){
        return implMahasiswa.getQueryNativeMahasiswaMatkul(semesterMahasiswa, semesterMatkul);
    }
}
