package klaa.mouataz.edlli.controllers;

import klaa.mouataz.edlli.model.Message;
import klaa.mouataz.edlli.services.EnseignantService;
import klaa.mouataz.edlli.services.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/messages")
public class MessageController {
    private final MessageService messageService;
    private final EnseignantService enseignantService;
    @GetMapping
    public List<Message> getMessages(){
        return messageService.getAll();
    }
    @GetMapping("/message/{id}")
    public Message getMessage(@PathVariable("id")Integer id){
        return messageService.getById(id);
    }
    @PostMapping("/add/{id}")
    public Message addMessage(@PathVariable("id")Integer id,@RequestBody Message message){
        message.setEnseignant(enseignantService.getById(id));
        return messageService.save(message);
    }
    @DeleteMapping("/delete/{id}")
    public void deleteSpeciality(@PathVariable("id")Integer id){
        messageService.deleteById(id);
    }

}
