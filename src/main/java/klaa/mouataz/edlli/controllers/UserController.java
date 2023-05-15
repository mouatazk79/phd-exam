package klaa.mouataz.edlli.controllers;

import klaa.mouataz.edlli.model.User;
import klaa.mouataz.edlli.repos.UserRepository;
import klaa.mouataz.edlli.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users")
public class UserController {
private final UserService userService;
@GetMapping("/all")
public List<User> getAllUsers(){
    return userService.getAll();
}
    @GetMapping("/{id}")
    private User getUser(@PathVariable("id") Integer id){
        return userService.getById(id);
    }
    @DeleteMapping("/delete/{id}")
private void deleteUser(@PathVariable("id") Integer id){
    userService.deleteById(id);
}
    @PutMapping("/{id}")
    public User updateUser(@PathVariable("id") Integer id, @RequestBody User user) {
        user.setId(id);
        return userService.updateUser(user);
    }
@PostMapping("/add")
private User addUser(@RequestBody User user){
   return userService.save(user);
}

}
