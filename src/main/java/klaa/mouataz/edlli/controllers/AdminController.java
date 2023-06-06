package klaa.mouataz.edlli.controllers;

import klaa.mouataz.edlli.dto.StaffRequest;
import klaa.mouataz.edlli.model.Admin;
import klaa.mouataz.edlli.model.CFD;
import klaa.mouataz.edlli.services.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/admin")
public class AdminController {
    private final AdminService adminService;
    @GetMapping
    public List<Admin> getAdmins(){
        return adminService.getAll();
    }
    @GetMapping("/{id}")
    public Admin getAdmin(@PathVariable("id")Integer id){
        return adminService.getById(id);
    }
    @PostMapping("/add")
    public Admin addAdmin(@RequestBody StaffRequest staffRequest){
        return adminService.save(staffRequest);
    }
    @DeleteMapping("/delete/{id}")
    public void deleteAdmin(@PathVariable("id")Integer id){
        adminService.deleteById(id);
    }
    @PutMapping("/{id}")
    public Admin updateAdmin(@PathVariable("id") Integer id,@RequestBody Admin admin){
        admin.setId(id);
        return adminService.updateAdmin(admin);
    }
}
