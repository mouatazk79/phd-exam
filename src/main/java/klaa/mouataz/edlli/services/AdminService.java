package klaa.mouataz.edlli.services;

import klaa.mouataz.edlli.dto.StaffRequest;
import klaa.mouataz.edlli.model.Admin;

import java.util.List;

public interface AdminService {
    Admin getById(Integer id);
    List<Admin> getAll();
    Admin save(StaffRequest staffRequest);
    void deleteById(Integer id);
    Admin updateAdmin(Admin admin);

}
