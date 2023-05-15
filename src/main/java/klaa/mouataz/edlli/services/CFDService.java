package klaa.mouataz.edlli.services;

import klaa.mouataz.edlli.dto.StaffRequest;
import klaa.mouataz.edlli.model.CFD;

import java.util.List;

public interface CFDService {
    CFD getById(Integer id);
    List<CFD> getAll();
    CFD save(StaffRequest staffRequest);
    void deleteById(Integer id);
    CFD updateCFD(CFD cfd);

}
