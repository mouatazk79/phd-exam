package klaa.mouataz.edlli.controllers;

import klaa.mouataz.edlli.dto.StaffRequest;
import klaa.mouataz.edlli.model.CFD;
import klaa.mouataz.edlli.services.CFDService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/CFD")
public class CFDController {
    private final CFDService cfdService;
    @GetMapping
    public List<CFD> getCFDs(){
        return cfdService.getAll();
    }
    @GetMapping("/{id}")
    public CFD getCFD(@PathVariable("id")Integer id){
        return cfdService.getById(id);
    }
    @PostMapping("/add")
    public CFD addCFD(@RequestBody StaffRequest staffRequest){
        return cfdService.save(staffRequest);
    }
    @DeleteMapping("/delete/{id}")
    public void deleteCFD(@PathVariable("id")Integer id){
        cfdService.deleteById(id);
    }
    @PutMapping("/{id}")
    public CFD updateCFD(@PathVariable("id") Integer id,@RequestBody CFD cfd){
        cfd.setId(id);
        return cfdService.updateCFD(cfd);
    }
}
