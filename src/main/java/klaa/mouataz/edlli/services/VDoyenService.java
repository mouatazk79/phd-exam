package klaa.mouataz.edlli.services;

import klaa.mouataz.edlli.dto.StaffRequest;
import klaa.mouataz.edlli.model.VDoyen;
import klaa.mouataz.edlli.repos.VDoyenRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class VDoyenService {
    private final VDoyenRepository vDoyenRepository;
    private final UserService userService;

    public VDoyen getById(Integer id) {
        return vDoyenRepository.findVDoyenById(id);
    }

    public List<VDoyen> getAll() {
        return vDoyenRepository.findAll();
    }

    public VDoyen save(StaffRequest staffRequest) {
        userService.save(staffRequest.getUser());
        VDoyen vDoyen=VDoyen.builder()
                .uid(staffRequest.getUser().getId())
                .firstName(staffRequest.getFirstName())
                .lastName(staffRequest.getLastName())
                .gender(staffRequest.getGender())
                .dob(staffRequest.getDob())
                .number(staffRequest.getNumber())
                .build();

        return vDoyenRepository.save(vDoyen);
    }

    public void deleteById(Integer id) {
       vDoyenRepository.deleteById(id);
    }

    public VDoyen updateVDoyen(VDoyen vDoyen) {
        return vDoyenRepository.save(vDoyen);
    }
}
