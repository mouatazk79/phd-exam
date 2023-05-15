package klaa.mouataz.edlli.services.impl;

import klaa.mouataz.edlli.dto.StaffRequest;
import klaa.mouataz.edlli.model.Admin;
import klaa.mouataz.edlli.repos.AdminRepository;
import klaa.mouataz.edlli.services.AdminService;
import klaa.mouataz.edlli.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService {
    private final AdminRepository adminRepository;
    private final UserService userService;

    @Override
    public Admin getById(Integer id) {
        return adminRepository.findAdminById(id);
    }

    @Override
    public List<Admin> getAll() {
        return adminRepository.findAll();
    }

    @Override
    public Admin save(StaffRequest staffRequest) {
        userService.save(staffRequest.getUser());
        Admin newAdmin=Admin.builder()
                .firstName(staffRequest.getFirstName())
                .lastName(staffRequest.getLastName())
                .gender(staffRequest.getGender())
                .dob(staffRequest.getDob())
                .number(staffRequest.getNumber())
                .build();


        return adminRepository.save(newAdmin);
    }

    @Override
    public void deleteById(Integer id) {
         adminRepository.deleteById(id);
    }

    @Override
    public Admin updateAdmin(Admin admin) {
        return null;
    }
}
