package id.base_project.service.rest;


import id.base_project.common.dto.MahasiswaDTO;
import id.base_project.service.impl.IMahasiswa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("getNimMahasiswa/{nim}")
    public MahasiswaDTO getNim(@PathVariable ("nim") String nim){
        return implMahasiswa.getNim(nim);
    }

    @GetMapping("getMahasiswa/getByBody")
    public MahasiswaDTO getMahasiswaByBody (@RequestBody MahasiswaDTO request){
        return null;
    }
}
