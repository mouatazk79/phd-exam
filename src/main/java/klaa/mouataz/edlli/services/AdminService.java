package klaa.mouataz.edlli.services;

import klaa.mouataz.edlli.dto.StaffRequest;
import klaa.mouataz.edlli.model.Admin;
import klaa.mouataz.edlli.repos.AdminRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class AdminService {
    private final AdminRepository adminRepository;
    private final UserService userService;

    public Admin getById(Integer id) {
        return adminRepository.findAdminById(id);
    }

    public List<Admin> getAll() {
        return adminRepository.findAll();
    }

    public Admin save(StaffRequest staffRequest) {
        userService.save(staffRequest.getUser());
        Admin newAdmin=Admin.builder()
                .uid(staffRequest.getUser().getId())
                .firstName(staffRequest.getFirstName())
                .lastName(staffRequest.getLastName())
                .gender(staffRequest.getGender())
                .dob(staffRequest.getDob())
                .number(staffRequest.getNumber())
                .build();


        return adminRepository.save(newAdmin);
    }

    public void deleteById(Integer id) {
         adminRepository.deleteById(id);
    }

    public Admin updateAdmin(Admin admin) {
        return adminRepository.save(admin);
    }
}
