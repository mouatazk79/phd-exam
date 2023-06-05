package klaa.mouataz.edlli.controllers;

import klaa.mouataz.edlli.dto.StaffRequest;
import klaa.mouataz.edlli.model.Student;
import klaa.mouataz.edlli.model.VDoyen;
import klaa.mouataz.edlli.repos.VDoyenRepository;
import klaa.mouataz.edlli.services.VDoyenService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/VDoyen")
public class VDoyenController {
    private final VDoyenService vDoyenService;
    private final VDoyenRepository vDoyenRepository;
    @GetMapping
    public List<VDoyen> getVDoyens(){
        return vDoyenService.getAll();
    }
    @GetMapping("/{id}")
    public VDoyen getVDoyen(@PathVariable("id")Integer id){
        return vDoyenService.getById(id);
    }
    @PostMapping("/add")
    public VDoyen addVDoyen(@RequestBody StaffRequest staffRequest){
        return vDoyenService.save(staffRequest);
    }
    @DeleteMapping("/delete/{id}")
    public void deleteVDoyen(@PathVariable("id")Integer id){
        vDoyenService.deleteById(id);
    }
    @PutMapping("/{id}")
    public VDoyen updateVDoyen(@PathVariable("id") Integer id,@RequestBody VDoyen vDoyen){
        vDoyen.setId(id);
        return vDoyenService.updateVDoyen(vDoyen);
    }
    @GetMapping("/vdoyen/byuser/{id}")
    public VDoyen getVDoyenByUserid(@PathVariable("id")Integer id){
        return vDoyenRepository.findByUid(id);
    }
}
