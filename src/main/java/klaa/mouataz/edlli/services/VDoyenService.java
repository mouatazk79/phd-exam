package klaa.mouataz.edlli.services;

import klaa.mouataz.edlli.dto.StaffRequest;
import klaa.mouataz.edlli.model.VDoyen;

import java.util.List;

public interface VDoyenService {
    VDoyen getById(Integer id);
    List<VDoyen> getAll();
    VDoyen save(StaffRequest staffRequest);
    void deleteById(Integer id);
    VDoyen updateVDoyen(VDoyen vDoyen);
}
