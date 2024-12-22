package klaa.mouataz.edlli.services;

import klaa.mouataz.edlli.dto.StaffRequest;
import klaa.mouataz.edlli.model.CFD;
import klaa.mouataz.edlli.repos.CFDRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class CFDService {
    private final CFDRepository cfdRepository;
    private final UserService userService;
    public CFD getById(Integer id) {
        return cfdRepository.findCFDById(id);
    }

    public List<CFD> getAll() {
        return cfdRepository.findAll();
    }

    public CFD save(StaffRequest staffRequest) {
        userService.save(staffRequest.getUser());
        CFD cfd=CFD.builder()
                .uid(staffRequest.getUser().getId())
                .firstName(staffRequest.getFirstName())
                .lastName(staffRequest.getLastName())
                .gender(staffRequest.getGender())
                .dob(staffRequest.getDob())
                .user(staffRequest.getUser())
                .number(staffRequest.getNumber())
                .build();
        return cfdRepository.save(cfd);
    }

    public void deleteById(Integer id) {
        cfdRepository.deleteById(id);
    }

    public CFD updateCFD(CFD cfd) {
        return cfdRepository.save(cfd);
    }
}
