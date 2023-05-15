package klaa.mouataz.edlli.controllers;

import klaa.mouataz.edlli.model.News;
import klaa.mouataz.edlli.services.InformationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/informations")
public class InformationController {
    private final InformationService informationService;

    @GetMapping
    public List<News> getInformations(){
        return informationService.getAll();
    }
    @GetMapping("/information/{id}")
    public News getInformation(@PathVariable("id")Integer id){
        return informationService.getById(id);
    }
    @PostMapping("/add")
    public News addInformation(@RequestBody News information){
        return informationService.save(information);
    }
    @DeleteMapping("/delete/{id}")
    public void deleteInformation(@PathVariable("id")Integer id){
        informationService.deleteById(id);
    }


}
