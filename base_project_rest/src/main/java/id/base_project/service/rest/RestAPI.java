package id.base_project.service.rest;


import id.base_project.common.dto.JurusanDTO;
import id.base_project.common.dto.MahasiswaDTO;
import id.base_project.common.dto.MatkulDTO;
import id.base_project.common.response.Response;
import id.base_project.service.impl.IMahasiswa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("base-project/")
public class RestAPI  {

    @Autowired
    private IMahasiswa implMahasiswa;

    @GetMapping("testAPI")
    public String testAPI(){
        return "test api berhasil";
    }

    @PostMapping("addMahasiswa")
    public Response tambahMahasiswa(@RequestBody MahasiswaDTO request){
        return implMahasiswa.addMahasiswa(request);
    }

    @PostMapping("addJurusan")
    public Response tambahJurusan(@RequestBody JurusanDTO request){
        return implMahasiswa.addJurusan(request);
    }

    @PostMapping("addMatkul")
    public Response tambahMatkul(@RequestBody MatkulDTO request){
        return implMahasiswa.addMatkul(request);
    }

    @GetMapping("getAllMahasiswa")
    public Response getAllMahasiswa(){
     return implMahasiswa.getAllMahasiswa();
    }

    @GetMapping("getAllMahasiswa2")
    public Response getAllMahasiswa2(){
        return implMahasiswa.getAllMahasiswa2();
    }

    @GetMapping("getAllMahasiswa3")
    public Response getAllMahasiswa3() { return implMahasiswa.getAllMahasiswa3();}

    @GetMapping("getAllJurusan")
    public Response getAllJurusan(){
        return implMahasiswa.getAllJurusan();
    }

    @GetMapping("getAllMatkul")
    public Response getAllMatkul(){
        return implMahasiswa.getAllMatkul();
    }

    @GetMapping("getMahasiswaByNim/{nim}")
    public Response getMahasiswaByNim(@PathVariable ("nim") String nim){
        MahasiswaDTO data = new MahasiswaDTO();
        return implMahasiswa.getMahasiswaByNim(nim);
    }

    @DeleteMapping("deleteMahasiswaByNim/{nim}")
    public ResponseEntity<String> deleteMahasiswaByNim (@PathVariable ("nim") String nim){
            implMahasiswa.deleteMahasiswaByNim(nim);
            return ResponseEntity.ok().build();
    }
}
