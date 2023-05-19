package klaa.mouataz.edlli.services.impl;

import klaa.mouataz.edlli.dto.StaffRequest;
import klaa.mouataz.edlli.model.VDoyen;
import klaa.mouataz.edlli.repos.VDoyenRepository;
import klaa.mouataz.edlli.services.UserService;
import klaa.mouataz.edlli.services.VDoyenService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class VDoyenServiceImpl implements VDoyenService {
    private final VDoyenRepository vDoyenRepository;
    private final UserService userService;

    @Override
    public VDoyen getById(Integer id) {
        return vDoyenRepository.findVDoyenById(id);
    }

    @Override
    public List<VDoyen> getAll() {
        return vDoyenRepository.findAll();
    }

    @Override
    public VDoyen save(StaffRequest staffRequest) {
        userService.save(staffRequest.getUser());
        VDoyen vDoyen=VDoyen.builder()
                .firstName(staffRequest.getFirstName())
                .lastName(staffRequest.getLastName())
                .gender(staffRequest.getGender())
                .dob(staffRequest.getDob())
                .number(staffRequest.getNumber())
                .build();

        return vDoyenRepository.save(vDoyen);
    }

    @Override
    public void deleteById(Integer id) {
       vDoyenRepository.deleteById(id);
    }

    @Override
    public VDoyen updateVDoyen(VDoyen vDoyen) {
        return vDoyenRepository.save(vDoyen);
    }
}
