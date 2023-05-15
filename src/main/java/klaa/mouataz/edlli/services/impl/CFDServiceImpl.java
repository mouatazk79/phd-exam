package klaa.mouataz.edlli.services.impl;

import klaa.mouataz.edlli.dto.StaffRequest;
import klaa.mouataz.edlli.model.CFD;
import klaa.mouataz.edlli.repos.CFDRepository;
import klaa.mouataz.edlli.services.CFDService;
import klaa.mouataz.edlli.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class CFDServiceImpl implements CFDService {
    private final CFDRepository cfdRepository;
    private final UserService userService;
    @Override
    public CFD getById(Integer id) {
        return cfdRepository.findCFDById(id);
    }

    @Override
    public List<CFD> getAll() {
        return cfdRepository.findAll();
    }

    @Override
    public CFD save(StaffRequest staffRequest) {
        userService.save(staffRequest.getUser());
        CFD cfd=CFD.builder()
                .firstName(staffRequest.getFirstName())
                .lastName(staffRequest.getLastName())
                .gender(staffRequest.getGender())
                .dob(staffRequest.getDob())
                .number(staffRequest.getNumber())
                .build();
        return cfdRepository.save(cfd);
    }

    @Override
    public void deleteById(Integer id) {
        cfdRepository.deleteById(id);
    }

    @Override
    public CFD updateCFD(CFD cfd) {
        return null;
    }
}
